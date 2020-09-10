package com.aye.admin.service;

import com.aye.admin.model.BootstrapTree;
import com.aye.admin.model.domain.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author Aye
 * @since 2020-09-09
 */
public interface ISysPermissionService extends IService<SysPermission> {

    BootstrapTree getBootBootstrapTreePerm(String userId);
}
