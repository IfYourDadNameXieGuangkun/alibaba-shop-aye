package com.aye.commons.service.impl;


import com.aye.commons.mapper.TUserMapper;
import com.aye.commons.service.ITUserService;
import com.aye.commons.domain.user.TUser;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Aye
 * @since 2020-08-04
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {
    @Autowired
    private TUserMapper tUserMapper;

}
