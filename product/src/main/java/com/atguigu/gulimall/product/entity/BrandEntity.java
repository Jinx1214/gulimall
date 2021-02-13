package com.atguigu.gulimall.product.entity;

import com.atguigu.gulimall.product.vaild.Add;
import com.atguigu.gulimall.product.vaild.Listvals;
import com.atguigu.gulimall.product.vaild.Update;
import com.atguigu.gulimall.product.vaild.UpdateStatus;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.checkerframework.checker.regex.qual.Regex;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.pl.REGON;

import javax.annotation.RegEx;
import javax.validation.constraints.*;

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
	//在更新操作时 不能为空
	@NotNull(groups = {Update.class},message = "更新时ID不能为空")
	private Long brandId;
	/**
	 * Æ·ÅÆÃû
	 */
	//在添加操作时，不能为空
	//在更新操作时可以为空
	@Null(groups = {Update.class})
	@NotNull(groups = {Add.class})
	@NotBlank(message = "首字母校验失败")
	private String name;
	/**
	 * Æ·ÅÆlogoµØÖ·
	 */
	//必需要是合法的url地址
	@NotNull(groups = {Add.class},message = "logo地址不能为空")
	@URL(groups = {Add.class},message = "logo地址不合法")
	private String logo;
	/**
	 * ½éÉÜ
	 */

	private String descript;
	/**
	 * ÏÔÊ¾×´Ì¬[0-²»ÏÔÊ¾£»1-ÏÔÊ¾]
	 */
	//@NotNull(message = "不能为空")
	@Listvals(groups = {UpdateStatus.class},vals = {0,1},message = "更改状态出错")
	private Integer showStatus;
	/**
	 * ¼ìË÷Ê××ÖÄ¸
	 */
	@Pattern(regexp = "^[a-zA-z]$",message = "首字母不合法",groups = {Add.class,Update.class})
	@NotNull(groups = {Add.class,Update.class},message = "需要填写首字母")
	private String firstLetter;
	/**
	 * ÅÅÐò
	 */
	@Min(value = 0,message = "排序不能小于0")
	@NotNull
	private Integer sort;

}
