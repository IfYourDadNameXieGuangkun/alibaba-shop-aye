package com.aye.product.service.impl;

import com.aye.commons.domain.DataProduct;
import com.aye.commons.exception.BizException;
import com.aye.commons.mapper.DataProductMapper;
import com.aye.product.service.IDataProductService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired DataProductMapper dataProductMapper;

    @Override
    public List<DataProduct> selectProductWrapper(String sku) throws BizException {
        DataProduct dataProduct = new DataProduct();
        dataProduct.setCSku("ZH110");
        QueryWrapper<DataProduct> qryWrapper = new QueryWrapper<>();
        qryWrapper.lambda().eq(DataProduct::getCSku,dataProduct.getCSku());
        System.out.println(qryWrapper.getSqlSelect());
        return null;
    }
}
