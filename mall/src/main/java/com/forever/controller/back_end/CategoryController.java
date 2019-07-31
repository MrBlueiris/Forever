package com.forever.controller.back_end;

import com.forever.pojo.Category;
import com.forever.service.impl.CategroyServiceImpl;
import com.forever.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("back_end")
public class CategoryController {
    @Autowired
    private CategroyServiceImpl categroyService;

    @RequestMapping("getCategroy")
    public Map<String, Object> getCategroy(Integer page,Integer rows){
        Map<String, Object> map = new HashMap<>();
        map.put("total",categroyService.getCount());
        map.put("rows",categroyService.getCategroy(page, rows));
        return map;
    }

    @RequestMapping("changeCategory")
    public String changeCategory(Category category){
        System.out.println(category);
        if(categroyService.categroyIsExist(category)){
            return "Exist";
        }else {
            return categroyService.changeCategroy(category).toString();
        }
    }
    @RequestMapping("selectAllCategoryParent")
    public List<CategoryVO> selectAllCategoryParent(Integer parentId){
        return categroyService.selectAllCategoryParent(parentId);
    }
}
