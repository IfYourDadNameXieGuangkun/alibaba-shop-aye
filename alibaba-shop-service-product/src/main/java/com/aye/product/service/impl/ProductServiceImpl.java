package com.aye.product.service.impl;

import com.aye.commons.domain.DataProduct;
import com.aye.commons.domain.Product;
import com.aye.commons.mapper.DataProductMapper;
import com.aye.commons.mapper.ProductMapper;
import com.aye.product.constant.ResponseEnum;
import com.aye.product.service.IProductService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Aye
 * @since 2020-12-17
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> selectProductWrapper(String sku) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.eq("c_sku", sku);
        List<Product> dataProducts = productMapper.selectList(wrapper);
        //断言判空
        ResponseEnum.PRODUCT_SKU_NOT_FOUND.assertNotEmpty(dataProducts);
        return dataProducts;
    }

}
