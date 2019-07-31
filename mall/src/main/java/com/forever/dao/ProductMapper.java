package com.forever.dao;

import com.forever.pojo.Product;
import com.forever.vo.ProductVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> getProduct(@Param("page") Integer page, @Param("rows") Integer rows);

    Integer getCount();

    ProductVO getLook(Integer id);
}