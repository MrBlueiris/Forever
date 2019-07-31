package com.forever.service.impl;

import com.forever.dao.ProductMapper;
import com.forever.pojo.Product;
import com.forever.service.IProductService;
import com.forever.vo.ProductVO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getProduct(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return productMapper.getProduct(page, rows);
    }

    @Override
    public Integer getCount() {
        return productMapper.getCount();
    }

    @Override
    public Integer addProduct(Product product) {
        return productMapper.insertSelective(product);
    }

    @Override
    public ProductVO getLook(Integer id) {
        return productMapper.getLook(id);
    }
}
