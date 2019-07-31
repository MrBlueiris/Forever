package com.forever.dao;

import com.forever.pojo.Category;
import com.forever.vo.CategoryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> getCategroy(@Param("page") Integer page,@Param("rows") Integer rows);

    Integer getCount();

    Integer categroyIsExist(Category category);

    List<CategoryVO> selectAllCategoryParent(@Param("parentId") Integer parentId);
}