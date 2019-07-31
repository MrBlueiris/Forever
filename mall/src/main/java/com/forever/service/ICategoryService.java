package com.forever.service;

import com.forever.pojo.Category;
import com.forever.vo.CategoryVO;

import java.util.List;

public interface ICategoryService {
    List<Category> getCategroy(Integer page,Integer rows);
    Integer getCount();
    boolean categroyIsExist(Category category);
    Integer changeCategroy(Category category);

    List<CategoryVO> selectAllCategoryParent(Integer parentId);
}
