package com.forever.ctrl;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.multipart.MultipartFile;


import com.forever.util.Base64ToImageUtil;




@Controller
public class FileUpCtrl {

	
	@RequestMapping("fileup")
	@ResponseBody
	public String fileUp(@RequestParam("file") MultipartFile file ,HttpServletRequest request){
		//获取文件上传的路径
		String path=request.getSession().getServletContext().getRealPath("fileup");
		//获取文件上传名称
		String fileName = file.getOriginalFilename();
		File targetFile = new File(path, fileName);
		System.out.println(targetFile.toString());
		if(!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
			//transferTo()是spring封装的方法，用于文件上传时把内存中文件写入磁盘
			file.transferTo(targetFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
		
	}
	
	@RequestMapping("imgup")
	@ResponseBody
	public String imgUpBase64(String imgStr ,HttpServletRequest request) {
		if(imgStr==null) {
			return "error";
		}
		//System.out.println(img);
		String path=request.getSession().getServletContext().getRealPath("fileup");
		//String imgStr=img.getImgStr();
		String imgName = UUID.randomUUID().toString()+".jpg";
		//System.out.println(imgStr);
		int indexOf = imgStr.indexOf("base64,");
		//System.out.println(indexOf);
		imgStr = imgStr.substring(indexOf+7,imgStr.length());
		//System.out.println(imgStr);
		boolean generateImage = Base64ToImageUtil.generateImage(imgStr, path+"\\"+imgName);
		if(generateImage) {
			return "success";
		}else {
			return "fail";
		}
		
		
	}
}


