package com.atguigu.gulimall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ÉÌÆ·Âú¼õÐÅÏ¢
 * 
 * @author Jinx1214
 * @email Jinx1214@gmail.com
 * @date 2021-02-02 15:13:30
 */
@Data
@TableName("sms_sku_full_reduction")
public class SmsSkuFullReductionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * spu_id
	 */
	private Long skuId;
	/**
	 * Âú¶àÉÙ
	 */
	private BigDecimal fullPrice;
	/**
	 * ¼õ¶àÉÙ
	 */
	private BigDecimal reducePrice;
	/**
	 * ÊÇ·ñ²ÎÓëÆäËûÓÅ»Ý
	 */
	private Integer addOther;

}
