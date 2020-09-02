package com.aye.product.service.impl;

import com.aye.commons.domain.DataProduct;
import com.aye.commons.ex.enums.CommonErrorEnum;
import com.aye.commons.ex.exception.BizException;
import com.aye.commons.mapper.DataProductMapper;
import com.aye.product.constant.ResponseEnum;
import com.aye.product.service.IDataProductService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * <p>
 * 商家商品表 服务实现类
 * </p>
 *
 * @author Aye
 * @since 2020-08-29
 */
@Service
public class DataProductServiceImpl extends ServiceImpl<DataProductMapper, DataProduct> implements IDataProductService {

    @Autowired
    DataProductMapper dataProductMapper;

    @Override
    public List<DataProduct> selectProductWrapper(String sku) throws BizException {
        QueryWrapper<DataProduct> wrapper = new QueryWrapper<>();
        wrapper.eq("c_sku", sku);
        List<DataProduct> dataProducts = dataProductMapper.selectList(wrapper);
        //断言判空
        ResponseEnum.PRODUCT_SKU_NOT_FOUND.assertNotEmpty(dataProducts);
        return dataProducts;
    }
}
