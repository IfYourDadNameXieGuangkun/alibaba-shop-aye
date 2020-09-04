package com.aye.commons.client.product.fallback;

import com.aye.commons.client.product.ProductClient;
import com.aye.commons.domain.DataProduct;
import com.aye.commons.dto.CR;
import com.aye.commons.dto.ResultDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName ProductFallBack
 * @Description 熔断处理逻辑
 * @Author Aye
 * @Date 2020/9/4 15:34
 * @Version 1.0
 */
@Component
public class ProductFallBack implements ProductClient {
    @Override
    public List<DataProduct> getProductBySku(String sku) {
        System.out.println("熔断了");
        return null;
    }
}