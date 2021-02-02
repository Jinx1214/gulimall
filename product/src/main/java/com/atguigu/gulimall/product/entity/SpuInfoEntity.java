package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * spuÐÅÏ¢
 * 
 * @author Jinx1214
 * @email Jinx1214@gmail.com
 * @date 2021-02-02 14:11:42
 */
@Data
@TableName("pms_spu_info")
public class SpuInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ÉÌÆ·id
	 */
	@TableId
	private Long id;
	/**
	 * ÉÌÆ·Ãû³Æ
	 */
	private String spuName;
	/**
	 * ÉÌÆ·ÃèÊö
	 */
	private String spuDescription;
	/**
	 * ËùÊô·ÖÀàid
	 */
	private Long catalogId;
	/**
	 * Æ·ÅÆid
	 */
	private Long brandId;
	/**
	 * 
	 */
	private BigDecimal weight;
	/**
	 * ÉÏ¼Ü×´Ì¬[0 - ÏÂ¼Ü£¬1 - ÉÏ¼Ü]
	 */
	private Integer publishStatus;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Date updateTime;

}
