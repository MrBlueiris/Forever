package com.forever.controller.back_end;

import com.forever.auth.entity.UserInfo;
import com.forever.auth.utils.CookieUtils;
import com.forever.auth.utils.JwtUtils;
import com.forever.auth.utils.RsaUtils;
import com.forever.common.Const;
import com.forever.common.ServerResponse;
import com.forever.pojo.User;
import com.forever.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("back_end")
@CrossOrigin
public class ManagerUserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("login")
    public ServerResponse<Object> login(User user, HttpServletRequest request, HttpServletResponse response){
        //System.out.println(user);
        User login = userService.login(user);
        //System.out.println(login);
        if (login != null) {
            if (login.getRole() == 1) {
                String token = "";
                try {
                    token = JwtUtils.generateToken(new UserInfo(login.getId().longValue(),login.getUsername()), RsaUtils.getPrivateKey(Const.PrivateKey), 30);
                    CookieUtils.newBuilder(response).httpOnly().maxAge(60).request(request).build("utoken", token);
                    System.out.println(token);
                    return ServerResponse.createBySuccessMessage("登录成功");
                } catch (Exception e) {
                    return ServerResponse.createByErrorMessage("用户名密码错误");
                }
            }else{
                return ServerResponse.createByLoginErrorMessage("您不是管理员");
            }
        }else {
            return ServerResponse.createByErrorMessage("用户名密码错误");
        }
    }
    @RequestMapping("getUser")
    public ServerResponse<Object> getUser(@CookieValue("utoken") String token, HttpServletRequest request, HttpServletResponse response){
        UserInfo userInfo=null;
        try {
            userInfo = JwtUtils.getUserInfo(RsaUtils.getPublicKey(Const.PublicKey), token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (userInfo != null) {
            CookieUtils.newBuilder(response).httpOnly().maxAge(60).request(request).build("utoken", token);
            return ServerResponse.createBySuccess(userInfo);
        }else {
            return ServerResponse.createByErrorMessage("过期");
        }
    }

    @RequestMapping("loginOut")
    public ServerResponse<Object> loginOut( HttpServletRequest request, HttpServletResponse response){
        CookieUtils.newBuilder(response).httpOnly().maxAge(0).request(request).build("utoken", "1");
        return ServerResponse.createBySuccessMessage("退出");
    }
}
