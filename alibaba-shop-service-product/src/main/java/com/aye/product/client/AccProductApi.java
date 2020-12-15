package com.aye.product.client;

import com.aye.commons.domain.DataProduct;
import com.aye.commons.dto.CR;
import com.aye.commons.dto.ResultDTO;
import com.aye.product.service.IDataProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName AccProductClient
 * @Description 暴露Feign服务,供其他服务调用
 * @Author Aye
 * @Date 2020/9/4 15:49
 * @Version 1.0
 */
@RestController
@RequestMapping("cliProduct")
public class AccProductApi {
    @Autowired
    private IDataProductService productService;

    @GetMapping(value = "/get/{sku}")
    public List<DataProduct> getProductBySku(@PathVariable("sku") String sku){
        System.out.println("进来了"+sku);
        return productService.selectProductWrapper(sku);
    }
}