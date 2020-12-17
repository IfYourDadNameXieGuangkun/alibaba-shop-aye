package com.aye.product.controller;

import com.aye.commons.domain.Product;
import com.aye.commons.dto.CR;
import com.aye.commons.dto.ResultDTO;
import com.aye.product.service.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * @ClassName ProductController
 * @Description 商品接口
 * @Author Aye
 * @Date 2020/8/29 17:03
 * @Version 1.0
 */
@RestController
@RequestMapping("product")
@Api(tags = "商品管理")
public class ProductController {

    //    @Autowired
//    private IDataProductService productService;
    @Autowired
    private IProductService productService;


    @ApiOperation(value = "根据sku查询商品", notes = "路径参数SKU")
    @GetMapping("{sku}")
    public CR<?> getBySku(@PathVariable String sku) {
//        return ResultDTO.create(productService.selectProductWrapper(sku));
        return ResultDTO.create(productService.selectProductWrapper(sku));
    }

    @ApiOperation(value = "商品列表查询")
    @GetMapping
    public CR<?> list() {
        return ResultDTO.create(productService.list());
    }

    @ApiOperation(value = "新增商品", notes = "传入Product信息", response = CR.class)
    @PostMapping
    public CR<?> save(@Valid @RequestBody Product product) {
        return ResultDTO.create(productService.save(product));
    }

}