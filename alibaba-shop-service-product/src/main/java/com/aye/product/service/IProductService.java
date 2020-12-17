package com.aye.product.service;

import com.aye.commons.domain.DataProduct;
import com.aye.commons.domain.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Aye
 * @since 2020-12-17
 */
public interface IProductService extends IService<Product> {
    List<Product> selectProductWrapper(String sku);
}
