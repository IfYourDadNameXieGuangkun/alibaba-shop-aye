package com.aye.admin.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author Aye
 * @since 2020-09-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_sys_permission")
public class SysPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限描述
     */
    private String descripion;

    /**
     * 授权链接
     */
    private String url;

    /**
     * 是否跳转 0 不跳转 1跳转
     */
    private Integer isBlank;

    /**
     * 父节点id
     */
    private String pid;

    /**
     * 权限标识
     */
    private String perms;

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private Integer type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 是否可见
     */
    private Integer visible;


    @TableField(exist = false)
    private int childCount;


}
