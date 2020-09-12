package com.aye.admin.service.impl;

import com.aye.admin.mapper.SysPermissionMapper;
import com.aye.admin.model.BootstrapTree;
import com.aye.admin.model.domain.SysPermission;
import com.aye.admin.service.ISysPermissionService;
import com.aye.admin.utils.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author Aye
 * @since 2020-09-09
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public BootstrapTree getBootBootstrapTreePerm(String userId) {
        List<BootstrapTree> treeList = new ArrayList<>();
        List<SysPermission> menuList =  getAll(userId);
        treeList = getbooBootstrapTreePerm(menuList,"0");
        if(treeList!=null&&treeList.size()==1) {
            return treeList.get(0);
        }
        return new BootstrapTree("菜单", "fa fa-home", "", "-1","###",0,treeList,"",0);
    }
    /**
     * 根据用户id获取用户角色如果用户为null 获取所有权限
     * @return
     */
    public List<SysPermission> getAll(String userid){
        if(StringUtils.isEmpty(userid)) {
            return  sysPermissionMapper.listSysPermissions();
        }
        return  sysPermissionMapper.findByAdminUserId(userid);
    }

    private static List<BootstrapTree> getbooBootstrapTreePerm(List<SysPermission> menuList, String parentId){
        List<BootstrapTree> treeList = new ArrayList<>();
        List<BootstrapTree> childList = null;
        for(SysPermission p : menuList) {
            p.setPid(p.getPid()==null||p.getPid().trim().equals("")?"0":p.getPid());
            if(p.getPid().trim().equals(parentId)) {
                if(p.getChildCount()>0) {
                    childList = getbooBootstrapTreePerm(menuList, String.valueOf(p.getId()));
                }
                BootstrapTree bootstrapTree = new BootstrapTree(p.getName(), p.getIcon(), "", String.valueOf(p.getId()), p.getUrl(),p.getIsBlank(),childList,p.getPerms(),p.getVisible());
                treeList.add(bootstrapTree);
                childList = null;
            }
        }
        return treeList.size() >0 ? treeList : null;
    }

}
