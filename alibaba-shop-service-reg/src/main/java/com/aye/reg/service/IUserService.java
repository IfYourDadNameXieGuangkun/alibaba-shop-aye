package com.aye.reg.service;

import com.aye.commons.domain.DataProduct;
import com.aye.commons.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Aye
 * @since 2020-09-04
 */
public interface IUserService extends IService<User> {

    List<DataProduct> listProductsByUserName(String username);
}
