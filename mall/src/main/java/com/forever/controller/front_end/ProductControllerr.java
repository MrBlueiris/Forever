package com.forever.controller.front_end;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductControllerr {
    @RequestMapping("list.do")
    public void list(@RequestParam(value = "keyword",required = false)String keyword,
                     @RequestParam(value = "categoryId",required = false)Integer categoryId,
                     @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                     @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                     @RequestParam(value = "orderBy",defaultValue = "") String orderBy){



    }
}
