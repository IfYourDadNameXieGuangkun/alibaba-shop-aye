package com.aye.commons.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Aye
 * @since 2020-12-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_product")
@Builder
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品名称
     */
    @TableField(value ="c_product_name" )
    private String productName;

    /**
     * 商家sku
     */
    @TableField(value = "c_sku")
    @NotNull(message = "商品sku不能为空")
    private String sku;

    /**
     * 图片
     */
    @TableField(value = "c_image")
    private String image;

    /**
     * 是否上架 1为上架 0为下架
     */
    @TableField(value = "i_shelve")
    private Integer shelve;

    /**
     * 商品售价
     */
    @TableField(value = "f_price")
    @Min(value = 1,message = "商品价格不能小于1")
    private BigDecimal price;

    /**
     * 商品上架时间
     */
    @TableField(value = "d_shelve_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime shelveTime;

    /**
     * 数据创建时间
     */
    @TableField(value = "d_create_time" , fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 数据修改时间
     */
    @TableField(value = "d_modified_time" ,fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedTime;

    /**
     * 商品状态 1为可售 0 不可售
     */
    @TableField(value = "i_status")
    private Integer status;


}
