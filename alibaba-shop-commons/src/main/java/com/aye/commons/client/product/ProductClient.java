package com.aye.commons.client.product;

import com.aye.commons.client.product.fallback.ProductFallBack;
import com.aye.commons.domain.DataProduct;
import com.aye.commons.dto.CR;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @ClassName ProductClient
 * @Description 暴露prodcut服务,使得能被其他微服务调用
 * @Author Aye
 * @Date 2020/9/4 15:35
 * @Version 1.0
 */
@FeignClient(value = "product-service" ,fallback = ProductFallBack.class,path = "cliProduct")
public interface ProductClient {
    @GetMapping(value = "/get/{sku}")
    List<DataProduct> getProductBySku(@PathVariable("sku") String sku);
}