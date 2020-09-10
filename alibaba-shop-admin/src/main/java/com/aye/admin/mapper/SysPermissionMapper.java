package com.aye.admin.mapper;


import com.aye.admin.model.domain.SysPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author Aye
 * @since 2020-09-09
 */
@Repository
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    List<SysPermission> queryRoleId(String rolid);

    List<SysPermission> listSysPermissions();

    List<SysPermission> findByAdminUserId(String userid);
}
