package com.aye.commons.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 商家商品表
 * </p>
 *
 * @author Aye
 * @since 2020-08-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DataProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    private Long iProductid;

    /**
     * 商品名称
     */
//    @NotNull(message = "商品名称不能为空")
    private String cProductname;

    /**
     * 商家sku
     */
//    @NotNull(message = "商品sku不能为空")
    private String cSku;

    /**
     * 商品分类id
     */
    private String cThirdProCode;

    /**
     * 商品规格
     */
    private String cUnit;

    /**
     * 商品重量
     */
    private BigDecimal fWeight;

    /**
     * 品牌ID
     */
    private String cBrandid;

    /**
     * 商品简介
     */
    private String cDesname;

    /**
     * 图片
     */
    private String cImage;

    /**
     * 是否上架 1为上架 0为下架
     */
    private Boolean iShelve;

    /**
     * 商品售价
     */
//    @NotNull(message = "商品价格不能为空")
//    @Min(value = 0,message = "价格不能小于0")
    private BigDecimal fPrice;

    /**
     * 活动价
     */
    private BigDecimal fActivityPrice;

    /**
     * 成本价
     */
    private BigDecimal fCostPrice;

    /**
     * 销量
     */
    private Integer iSales;

    /**
     * 版本
     */
    private Integer iVersion;

    /**
     * 商品上架时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dShelveTime;

    /**
     * 数据创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dCreatetime;

    /**
     * 数据修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dModifiedtime;

    /**
     * 商品状态 1为可售 0 不可售
     */
    private Boolean iStatus;

    /**
     * 商品上传标识 1为已上传 0为未上传
     */
    private Boolean iUpload;

    /**
     * 产地
     */
    private String cMadein;

    /**
     * 商家店内分类id
     */
    private String shopCategoryId;

    /**
     * 商家店内分类名称
     */
    private String shopCategoryName;


}
