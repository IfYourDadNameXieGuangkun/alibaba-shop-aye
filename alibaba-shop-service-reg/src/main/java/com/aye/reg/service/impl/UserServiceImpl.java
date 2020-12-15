package com.aye.reg.service.impl;


import com.aye.commons.client.product.ProductClient;
import com.aye.commons.domain.DataProduct;
import com.aye.commons.domain.User;
import com.aye.commons.ex.assertion.Assert;
import com.aye.commons.mapper.UserMapper;
import com.aye.reg.constants.ResponseEnum;
import com.aye.reg.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Aye
 * @since 2020-09-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProductClient productClient;

    @Override
    public List<DataProduct> listProductsByUserName(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", username);
//        List<User> users = userMapper.selectList(wrapper);
//        ResponseEnum.PRODUCT_SKU_NOT_FOUND.assertNotEmpty(users);
//        List<DataProduct> products = productClient.getProductBySku(users.get(0).getAddr());

        List<DataProduct> products = productClient.getProductBySku("123");
        return products ;
    }
}
