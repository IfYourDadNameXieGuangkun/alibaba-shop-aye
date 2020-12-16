package com.aye.commons.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Aye
 * @since 2020-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    @TableField(value = "c_email")
    private String email;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别 0女,1男,2未知
     */
    private Boolean sex;

    /**
     * 电话
     */
    @TableField(value = "c_tel")
    private String tel;

    /**
     * 地址
     */
    @TableField(value = "c_addr")
    private String addr;

    /**
     * 身份证号
     */
    private String card;

    /**
     * 0代表未结婚，1代表已结婚
     */
    private Boolean married;

    /**
     * 薪水
     */
    private Float salary;

    /**
     * 数据创建时间
     */
    @TableField(value = " ",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 数据修改时间
     */
    @TableField(value = "d_modified_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifiedTime;


}
