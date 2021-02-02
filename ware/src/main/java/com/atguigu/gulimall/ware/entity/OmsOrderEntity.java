package com.atguigu.gulimall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ¶©µ¥
 * 
 * @author Jinx1214
 * @email Jinx1214@gmail.com
 * @date 2021-02-02 15:13:30
 */
@Data
@TableName("oms_order")
public class OmsOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * member_id
	 */
	private Long memberId;
	/**
	 * ¶©µ¥ºÅ
	 */
	private String orderSn;
	/**
	 * Ê¹ÓÃµÄÓÅ»ÝÈ¯
	 */
	private Long couponId;
	/**
	 * create_time
	 */
	private Date createTime;
	/**
	 * ÓÃ»§Ãû
	 */
	private String memberUsername;
	/**
	 * ¶©µ¥×Ü¶î
	 */
	private BigDecimal totalAmount;
	/**
	 * Ó¦¸¶×Ü¶î
	 */
	private BigDecimal payAmount;
	/**
	 * ÔË·Ñ½ð¶î
	 */
	private BigDecimal freightAmount;
	/**
	 * ´ÙÏúÓÅ»¯½ð¶î£¨´ÙÏú¼Û¡¢Âú¼õ¡¢½×ÌÝ¼Û£©
	 */
	private BigDecimal promotionAmount;
	/**
	 * »ý·ÖµÖ¿Û½ð¶î
	 */
	private BigDecimal integrationAmount;
	/**
	 * ÓÅ»ÝÈ¯µÖ¿Û½ð¶î
	 */
	private BigDecimal couponAmount;
	/**
	 * ºóÌ¨µ÷Õû¶©µ¥Ê¹ÓÃµÄÕÛ¿Û½ð¶î
	 */
	private BigDecimal discountAmount;
	/**
	 * Ö§¸¶·½Ê½¡¾1->Ö§¸¶±¦£»2->Î¢ÐÅ£»3->ÒøÁª£» 4->»õµ½¸¶¿î£»¡¿
	 */
	private Integer payType;
	/**
	 * ¶©µ¥À´Ô´[0->PC¶©µ¥£»1->app¶©µ¥]
	 */
	private Integer sourceType;
	/**
	 * ¶©µ¥×´Ì¬¡¾0->´ý¸¶¿î£»1->´ý·¢»õ£»2->ÒÑ·¢»õ£»3->ÒÑÍê³É£»4->ÒÑ¹Ø±Õ£»5->ÎÞÐ§¶©µ¥¡¿
	 */
	private Integer status;
	/**
	 * ÎïÁ÷¹«Ë¾(ÅäËÍ·½Ê½)
	 */
	private String deliveryCompany;
	/**
	 * ÎïÁ÷µ¥ºÅ
	 */
	private String deliverySn;
	/**
	 * ×Ô¶¯È·ÈÏÊ±¼ä£¨Ìì£©
	 */
	private Integer autoConfirmDay;
	/**
	 * ¿ÉÒÔ»ñµÃµÄ»ý·Ö
	 */
	private Integer integration;
	/**
	 * ¿ÉÒÔ»ñµÃµÄ³É³¤Öµ
	 */
	private Integer growth;
	/**
	 * ·¢Æ±ÀàÐÍ[0->²»¿ª·¢Æ±£»1->µç×Ó·¢Æ±£»2->Ö½ÖÊ·¢Æ±]
	 */
	private Integer billType;
	/**
	 * ·¢Æ±Ì§Í·
	 */
	private String billHeader;
	/**
	 * ·¢Æ±ÄÚÈÝ
	 */
	private String billContent;
	/**
	 * ÊÕÆ±ÈËµç»°
	 */
	private String billReceiverPhone;
	/**
	 * ÊÕÆ±ÈËÓÊÏä
	 */
	private String billReceiverEmail;
	/**
	 * ÊÕ»õÈËÐÕÃû
	 */
	private String receiverName;
	/**
	 * ÊÕ»õÈËµç»°
	 */
	private String receiverPhone;
	/**
	 * ÊÕ»õÈËÓÊ±à
	 */
	private String receiverPostCode;
	/**
	 * Ê¡·Ý/Ö±Ï½ÊÐ
	 */
	private String receiverProvince;
	/**
	 * ³ÇÊÐ
	 */
	private String receiverCity;
	/**
	 * Çø
	 */
	private String receiverRegion;
	/**
	 * ÏêÏ¸µØÖ·
	 */
	private String receiverDetailAddress;
	/**
	 * ¶©µ¥±¸×¢
	 */
	private String note;
	/**
	 * È·ÈÏÊÕ»õ×´Ì¬[0->Î´È·ÈÏ£»1->ÒÑÈ·ÈÏ]
	 */
	private Integer confirmStatus;
	/**
	 * É¾³ý×´Ì¬¡¾0->Î´É¾³ý£»1->ÒÑÉ¾³ý¡¿
	 */
	private Integer deleteStatus;
	/**
	 * ÏÂµ¥Ê±Ê¹ÓÃµÄ»ý·Ö
	 */
	private Integer useIntegration;
	/**
	 * Ö§¸¶Ê±¼ä
	 */
	private Date paymentTime;
	/**
	 * ·¢»õÊ±¼ä
	 */
	private Date deliveryTime;
	/**
	 * È·ÈÏÊÕ»õÊ±¼ä
	 */
	private Date receiveTime;
	/**
	 * ÆÀ¼ÛÊ±¼ä
	 */
	private Date commentTime;
	/**
	 * ÐÞ¸ÄÊ±¼ä
	 */
	private Date modifyTime;

}
