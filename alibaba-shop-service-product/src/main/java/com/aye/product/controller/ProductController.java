package com.aye.product.controller;

import com.aye.commons.domain.DataProduct;
import com.aye.commons.dto.CR;
import com.aye.commons.dto.ResultDTO;
import com.aye.product.service.IDataProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName ProductController
 * @Description TODO
 * @Author Aye
 * @Date 2020/8/29 17:03
 * @Version 1.0
 */
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IDataProductService productService;
    @GetMapping("list/products/{sku}")
    public CR<?> listProductsBySku(@PathVariable String sku){
        return ResultDTO.create(productService.selectProductWrapper(sku));
    }
}