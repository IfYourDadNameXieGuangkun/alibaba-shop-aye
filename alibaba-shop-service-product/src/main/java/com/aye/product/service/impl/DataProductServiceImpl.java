package com.aye.product.service.impl;



import com.aye.commons.domain.DataProduct;
import com.aye.commons.mapper.DataProductMapper;
import com.aye.product.constant.ResponseEnum;
import com.aye.product.service.IDataProductService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author Aye
 * @since 2020-09-03
 */
@Service
public class DataProductServiceImpl extends ServiceImpl<DataProductMapper, DataProduct> implements IDataProductService {

    @Autowired
    private DataProductMapper dataProductMapper;
    @Override
    public List<DataProduct> selectProductWrapper(String sku) {
        QueryWrapper<DataProduct> wrapper = new QueryWrapper<>();
        wrapper.eq("c_sku", sku);
        List<DataProduct> dataProducts = dataProductMapper.selectList(wrapper);
        //断言判空
        ResponseEnum.PRODUCT_SKU_NOT_FOUND.assertNotEmpty(dataProducts);
        return dataProducts;
    }
}
