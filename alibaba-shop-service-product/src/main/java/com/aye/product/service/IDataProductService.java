package com.aye.product.service;

import com.aye.commons.domain.DataProduct;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商家商品表 服务类
 * </p>
 *
 * @author Aye
 * @since 2020-08-29
 */
public interface IDataProductService extends IService<DataProduct> {

    List<DataProduct> selectProductWrapper(String sku);
}
