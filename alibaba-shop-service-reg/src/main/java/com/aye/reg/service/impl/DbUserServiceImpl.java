package com.aye.reg.service.impl;


import com.aye.commons.domain.DbUser;
import com.aye.commons.mapper.DbUserMapper;
import com.aye.reg.service.IDbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Aye
 * @since 2020-12-16
 */
@Service
public class DbUserServiceImpl extends ServiceImpl<DbUserMapper, DbUser> implements IDbUserService {

}
