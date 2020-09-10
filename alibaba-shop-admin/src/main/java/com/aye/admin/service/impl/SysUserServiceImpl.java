package com.aye.admin.service.impl;

import com.aye.admin.mapper.SysUserMapper;
import com.aye.admin.model.domain.SysUser;
import com.aye.admin.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Aye
 * @since 2020-09-09
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
