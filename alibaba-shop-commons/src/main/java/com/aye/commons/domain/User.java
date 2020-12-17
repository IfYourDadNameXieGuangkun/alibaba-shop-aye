package com.aye.commons.domain;

import com.aye.commons.utils.RegexpUtils;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "user")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
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
    @NotNull(message = "用户名不可为空")
    @Length(min = 5, max = 20, message = "用户名长度必须介于 5 和 20 之间")
    private String userName;

    /**
     * 密码
     */
    @JsonIgnore
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
    private Integer sex;

    /**
     * 电话
     */
    @TableField(value = "c_tel")
    @NotNull
    @Pattern(regexp = RegexpUtils.PHONE, message = "手机号格式不正确")
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
    private Integer married;

    /**
     * 薪水
     */
    private BigDecimal salary;

    /**
     * 数据创建时间
     */
    @TableField(value = "d_create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 数据修改时间
     */
    @TableField(value = "d_modified_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifiedTime;


    /**
     * 链式创建对象
     */
//    public static Builder builder() {
//        return new Builder();
//    }
//
//    public static class Builder {
//
//
//        private String userName;
//
//        private String password;
//
//        private String email;
//
//        private Integer age;
//
//        private Integer sex;
//
//        private String tel;
//
//        private String addr;
//
//        private String card;
//
//        private Integer married;
//
//        private BigDecimal salary;
//
//
//        public Builder userName(String userName) {
//            this.userName = userName;
//            return this;
//        }
//
//        public Builder password(String password) {
//            this.password = password;
//            return this;
//        }
//
//        public Builder email(String email) {
//            this.email = email;
//            return this;
//        }
//
//        public Builder age(int age) {
//            this.age = age;
//            return this;
//        }
//
//        public Builder sex(int sex) {
//            this.sex = sex;
//            return this;
//        }
//
//        public Builder tel(String tel) {
//            this.tel = tel;
//            return this;
//        }
//
//        public Builder addr(String addr) {
//            this.addr = addr;
//            return this;
//        }
//
//        public Builder card(String card) {
//            this.card = card;
//            return this;
//        }
//
//        public Builder married(int married) {
//            this.married = married;
//            return this;
//        }
//
//        public Builder salary(BigDecimal salary) {
//            this.salary = salary;
//            return this;
//        }
//
//        public User build() {
//            User user = new User();
//            user.setUserName(userName);
//            user.setPassword(password);
//            user.setEmail(email);
//            user.setAge(age);
//            user.setSex(sex);
//            user.setTel(tel);
//            user.setAddr(addr);
//            user.setCard(card);
//            user.setMarried(married);
//            user.setSalary(salary);
//            return user;
//        }
//    }
}
