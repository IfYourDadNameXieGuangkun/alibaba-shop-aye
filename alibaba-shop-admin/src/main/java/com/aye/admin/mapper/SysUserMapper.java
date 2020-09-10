package com.aye.admin.mapper;

import com.aye.admin.model.domain.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Aye
 * @since 2020-09-09
 */
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser queryUserName(String username);
}
