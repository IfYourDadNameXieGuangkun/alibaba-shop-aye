package com.aye.commons.user.domain;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Aye
 * @since 2020-12-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DbUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String userName;

    private String password;

    private String email;

    private Integer age;

    private Integer sex;

    private String tel;

    private String addr;

    private String card;

    private Integer married;

    private BigDecimal salary;

    private LocalDateTime createTime;

    private LocalDateTime modifiedTime;


}
