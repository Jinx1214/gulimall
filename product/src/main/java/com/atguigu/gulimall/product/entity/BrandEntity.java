package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Æ·ÅÆ
 * 
 * @author Jinx1214
 * @email Jinx1214@gmail.com
 * @date 2021-02-02 14:11:42
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Æ·ÅÆid
	 */
	@TableId
	private Long brandId;
	/**
	 * Æ·ÅÆÃû
	 */
	@NotNull
	@NotBlank(message = "首字母校验失败")
	private String name;
	/**
	 * Æ·ÅÆlogoµØÖ·
	 */
	private String logo;
	/**
	 * ½éÉÜ
	 */

	private String descript;
	/**
	 * ÏÔÊ¾×´Ì¬[0-²»ÏÔÊ¾£»1-ÏÔÊ¾]
	 */
	@NotNull(message = "不能为空")
	private Integer showStatus;
	/**
	 * ¼ìË÷Ê××ÖÄ¸
	 */
	@NotNull
	private String firstLetter;
	/**
	 * ÅÅÐò
	 */
	@Min(value = 0,message = "排序不能小于0")
	@NotNull
	private Integer sort;

}
