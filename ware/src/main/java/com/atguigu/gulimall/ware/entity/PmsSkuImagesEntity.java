package com.atguigu.gulimall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * skuÍ¼Æ¬
 * 
 * @author Jinx1214
 * @email Jinx1214@gmail.com
 * @date 2021-02-02 15:13:30
 */
@Data
@TableName("pms_sku_images")
public class PmsSkuImagesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * sku_id
	 */
	private Long skuId;
	/**
	 * Í¼Æ¬µØÖ·
	 */
	private String imgUrl;
	/**
	 * ÅÅÐò
	 */
	private Integer imgSort;
	/**
	 * Ä¬ÈÏÍ¼[0 - ²»ÊÇÄ¬ÈÏÍ¼£¬1 - ÊÇÄ¬ÈÏÍ¼]
	 */
	private Integer defaultImg;

}
