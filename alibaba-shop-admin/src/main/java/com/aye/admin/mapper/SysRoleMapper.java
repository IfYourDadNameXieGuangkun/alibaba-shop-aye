package com.aye.admin.mapper;

import com.aye.admin.model.domain.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author Aye
 * @since 2020-09-09
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> queryUserRole(String uid);
}
