package com.aye.commons.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author Aye
 * @since 2020-09-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DataProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品名称
     */
//    @TableId(value = )
    private String productName;

    /**
     * 商家sku
     */
    private String sku;

    /**
     * 图片
     */
    private String image;

    /**
     * 是否上架 1为上架 0为下架
     */
    private Boolean shelve;

    /**
     * 商品售价
     */
    private BigDecimal price;

    /**
     * 商品上架时间
     */
    private LocalDateTime shelveTime;

    /**
     * 数据创建时间
     */
    private LocalDateTime createTime;

    /**
     * 数据修改时间
     */
    private LocalDateTime modifiedTime;

    /**
     * 商品状态 1为可售 0 不可售
     */
    private Boolean status;


}
