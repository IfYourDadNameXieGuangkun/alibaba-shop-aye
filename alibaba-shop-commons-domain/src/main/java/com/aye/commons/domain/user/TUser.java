package com.aye.commons.domain.user;

import com.aye.commons.dto.AbstractBaseDomain;
import com.aye.commons.utils.RegexpUtils;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * <p>
 *
 * </p>
 *
 * @author Aye
 * @since 2020-08-04
 */
@Table(name = "tb_user")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class TUser{

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @NotNull(message = "用户名不可为空")
    @Length(min = 5, max = 20, message = "用户名长度必须介于 5 和 20 之间")
    private String userName;

    @JsonIgnore
    private String password;

    @NotNull
    @Pattern(regexp = RegexpUtils.PHONE, message ="手机号格式不正确")
    private String phone;


}
