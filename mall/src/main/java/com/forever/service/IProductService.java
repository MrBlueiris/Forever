package com.forever.service;

import com.forever.pojo.Product;
import com.forever.vo.ProductVO;

import java.util.List;

public interface IProductService {
    List<Product> getProduct(Integer page, Integer rows);
    Integer getCount();
    Integer addProduct(Product product);
    ProductVO getLook(Integer id);
}
