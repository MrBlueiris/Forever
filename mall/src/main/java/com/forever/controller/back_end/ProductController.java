package com.forever.controller.back_end;


import com.forever.common.Const;
import com.forever.pojo.Product;
import com.forever.service.impl.ProductServiceImpl;
import com.forever.util.Base64ToImageUtil;
import com.forever.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("back_end")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @RequestMapping("getProduct")
    public Map<String, Object>  getProduct(Integer page, Integer rows){
        Map<String, Object> map = new HashMap<>();
        map.put("total",productService.getCount());
        map.put("rows",productService.getProduct(page,rows));
        return map;
    }

    public void changeProduct(){

    }

    public void getProductDetail(Integer id){

    }
    @RequestMapping("addProduct")
    public int addProduct(Product product){
        String mainImage = product.getMainImage();
        int base64 = mainImage.indexOf("base64");
        String substring = mainImage.substring(base64 + 7);
        String mainImgName= UUID.randomUUID().toString()+".jpg";
        Base64ToImageUtil.generateImage(substring, Const.IMG_SRC+"\\"+mainImgName);
        String s = Base64ToImageUtil.base64ImgToFile(product.getDetail(), Const.IMG_SRC+"\\", Const.PRODUCT_IMGK_HOST);
        product.setMainImage(mainImgName);
        product.setSubImages(mainImgName);
        product.setDetail(s);
        product.setStatus(1);
        //System.out.println(product);
        return productService.addProduct(product);
    }
    @RequestMapping("getLook")
    public ProductVO getLook(Integer id){
        return  productService.getLook(id);
    }

}
