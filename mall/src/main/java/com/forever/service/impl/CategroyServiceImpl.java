package com.forever.service.impl;

import com.forever.dao.CategoryMapper;
import com.forever.pojo.Category;
import com.forever.service.ICategoryService;
import com.forever.vo.CategoryVO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategroyServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> getCategroy(Integer page,Integer rows) {
        PageHelper.startPage(page, rows);
        return categoryMapper.getCategroy(page, rows);
    }

    @Override
    public Integer getCount() {
        return categoryMapper.getCount();
    }

    @Override
    public boolean categroyIsExist(Category category) {
        boolean log=false;
        if(categoryMapper.categroyIsExist(category)>0)log=true;
        return log;
    }

    @Override
    public Integer changeCategroy(Category category) {
        if (category.getId() == null) {
            return categoryMapper.insertSelective(category);
        }else {
            return categoryMapper.updateByPrimaryKeySelective(category);
        }


    }

    @Override
    public List<CategoryVO> selectAllCategoryParent(Integer parentId) {
        return categoryMapper.selectAllCategoryParent(parentId);
    }
}
