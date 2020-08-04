package com.aye.code.user.service.impl;

import com.aye.code.user.entity.TUser;
import com.aye.code.user.mapper.TUserMapper;
import com.aye.code.user.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
