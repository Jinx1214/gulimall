<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="member_id" prop="memberId">
      <el-input v-model="dataForm.memberId" placeholder="member_id"></el-input>
    </el-form-item>
    <el-form-item label="¶©µ¥ºÅ" prop="orderSn">
      <el-input v-model="dataForm.orderSn" placeholder="¶©µ¥ºÅ"></el-input>
    </el-form-item>
    <el-form-item label="Ê¹ÓÃµÄÓÅ»ÝÈ¯" prop="couponId">
      <el-input v-model="dataForm.couponId" placeholder="Ê¹ÓÃµÄÓÅ»ÝÈ¯"></el-input>
    </el-form-item>
    <el-form-item label="create_time" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="create_time"></el-input>
    </el-form-item>
    <el-form-item label="ÓÃ»§Ãû" prop="memberUsername">
      <el-input v-model="dataForm.memberUsername" placeholder="ÓÃ»§Ãû"></el-input>
    </el-form-item>
    <el-form-item label="¶©µ¥×Ü¶î" prop="totalAmount">
      <el-input v-model="dataForm.totalAmount" placeholder="¶©µ¥×Ü¶î"></el-input>
    </el-form-item>
    <el-form-item label="Ó¦¸¶×Ü¶î" prop="payAmount">
      <el-input v-model="dataForm.payAmount" placeholder="Ó¦¸¶×Ü¶î"></el-input>
    </el-form-item>
    <el-form-item label="ÔË·Ñ½ð¶î" prop="freightAmount">
      <el-input v-model="dataForm.freightAmount" placeholder="ÔË·Ñ½ð¶î"></el-input>
    </el-form-item>
    <el-form-item label="´ÙÏúÓÅ»¯½ð¶î£¨´ÙÏú¼Û¡¢Âú¼õ¡¢½×ÌÝ¼Û£©" prop="promotionAmount">
      <el-input v-model="dataForm.promotionAmount" placeholder="´ÙÏúÓÅ»¯½ð¶î£¨´ÙÏú¼Û¡¢Âú¼õ¡¢½×ÌÝ¼Û£©"></el-input>
    </el-form-item>
    <el-form-item label="»ý·ÖµÖ¿Û½ð¶î" prop="integrationAmount">
      <el-input v-model="dataForm.integrationAmount" placeholder="»ý·ÖµÖ¿Û½ð¶î"></el-input>
    </el-form-item>
    <el-form-item label="ÓÅ»ÝÈ¯µÖ¿Û½ð¶î" prop="couponAmount">
      <el-input v-model="dataForm.couponAmount" placeholder="ÓÅ»ÝÈ¯µÖ¿Û½ð¶î"></el-input>
    </el-form-item>
    <el-form-item label="ºóÌ¨µ÷Õû¶©µ¥Ê¹ÓÃµÄÕÛ¿Û½ð¶î" prop="discountAmount">
      <el-input v-model="dataForm.discountAmount" placeholder="ºóÌ¨µ÷Õû¶©µ¥Ê¹ÓÃµÄÕÛ¿Û½ð¶î"></el-input>
    </el-form-item>
    <el-form-item label="Ö§¸¶·½Ê½¡¾1->Ö§¸¶±¦£»2->Î¢ÐÅ£»3->ÒøÁª£» 4->»õµ½¸¶¿î£»¡¿" prop="payType">
      <el-input v-model="dataForm.payType" placeholder="Ö§¸¶·½Ê½¡¾1->Ö§¸¶±¦£»2->Î¢ÐÅ£»3->ÒøÁª£» 4->»õµ½¸¶¿î£»¡¿"></el-input>
    </el-form-item>
    <el-form-item label="¶©µ¥À´Ô´[0->PC¶©µ¥£»1->app¶©µ¥]" prop="sourceType">
      <el-input v-model="dataForm.sourceType" placeholder="¶©µ¥À´Ô´[0->PC¶©µ¥£»1->app¶©µ¥]"></el-input>
    </el-form-item>
    <el-form-item label="¶©µ¥×´Ì¬¡¾0->´ý¸¶¿î£»1->´ý·¢»õ£»2->ÒÑ·¢»õ£»3->ÒÑÍê³É£»4->ÒÑ¹Ø±Õ£»5->ÎÞÐ§¶©µ¥¡¿" prop="status">
      <el-input v-model="dataForm.status" placeholder="¶©µ¥×´Ì¬¡¾0->´ý¸¶¿î£»1->´ý·¢»õ£»2->ÒÑ·¢»õ£»3->ÒÑÍê³É£»4->ÒÑ¹Ø±Õ£»5->ÎÞÐ§¶©µ¥¡¿"></el-input>
    </el-form-item>
    <el-form-item label="ÎïÁ÷¹«Ë¾(ÅäËÍ·½Ê½)" prop="deliveryCompany">
      <el-input v-model="dataForm.deliveryCompany" placeholder="ÎïÁ÷¹«Ë¾(ÅäËÍ·½Ê½)"></el-input>
    </el-form-item>
    <el-form-item label="ÎïÁ÷µ¥ºÅ" prop="deliverySn">
      <el-input v-model="dataForm.deliverySn" placeholder="ÎïÁ÷µ¥ºÅ"></el-input>
    </el-form-item>
    <el-form-item label="×Ô¶¯È·ÈÏÊ±¼ä£¨Ìì£©" prop="autoConfirmDay">
      <el-input v-model="dataForm.autoConfirmDay" placeholder="×Ô¶¯È·ÈÏÊ±¼ä£¨Ìì£©"></el-input>
    </el-form-item>
    <el-form-item label="¿ÉÒÔ»ñµÃµÄ»ý·Ö" prop="integration">
      <el-input v-model="dataForm.integration" placeholder="¿ÉÒÔ»ñµÃµÄ»ý·Ö"></el-input>
    </el-form-item>
    <el-form-item label="¿ÉÒÔ»ñµÃµÄ³É³¤Öµ" prop="growth">
      <el-input v-model="dataForm.growth" placeholder="¿ÉÒÔ»ñµÃµÄ³É³¤Öµ"></el-input>
    </el-form-item>
    <el-form-item label="·¢Æ±ÀàÐÍ[0->²»¿ª·¢Æ±£»1->µç×Ó·¢Æ±£»2->Ö½ÖÊ·¢Æ±]" prop="billType">
      <el-input v-model="dataForm.billType" placeholder="·¢Æ±ÀàÐÍ[0->²»¿ª·¢Æ±£»1->µç×Ó·¢Æ±£»2->Ö½ÖÊ·¢Æ±]"></el-input>
    </el-form-item>
    <el-form-item label="·¢Æ±Ì§Í·" prop="billHeader">
      <el-input v-model="dataForm.billHeader" placeholder="·¢Æ±Ì§Í·"></el-input>
    </el-form-item>
    <el-form-item label="·¢Æ±ÄÚÈÝ" prop="billContent">
      <el-input v-model="dataForm.billContent" placeholder="·¢Æ±ÄÚÈÝ"></el-input>
    </el-form-item>
    <el-form-item label="ÊÕÆ±ÈËµç»°" prop="billReceiverPhone">
      <el-input v-model="dataForm.billReceiverPhone" placeholder="ÊÕÆ±ÈËµç»°"></el-input>
    </el-form-item>
    <el-form-item label="ÊÕÆ±ÈËÓÊÏä" prop="billReceiverEmail">
      <el-input v-model="dataForm.billReceiverEmail" placeholder="ÊÕÆ±ÈËÓÊÏä"></el-input>
    </el-form-item>
    <el-form-item label="ÊÕ»õÈËÐÕÃû" prop="receiverName">
      <el-input v-model="dataForm.receiverName" placeholder="ÊÕ»õÈËÐÕÃû"></el-input>
    </el-form-item>
    <el-form-item label="ÊÕ»õÈËµç»°" prop="receiverPhone">
      <el-input v-model="dataForm.receiverPhone" placeholder="ÊÕ»õÈËµç»°"></el-input>
    </el-form-item>
    <el-form-item label="ÊÕ»õÈËÓÊ±à" prop="receiverPostCode">
      <el-input v-model="dataForm.receiverPostCode" placeholder="ÊÕ»õÈËÓÊ±à"></el-input>
    </el-form-item>
    <el-form-item label="Ê¡·Ý/Ö±Ï½ÊÐ" prop="receiverProvince">
      <el-input v-model="dataForm.receiverProvince" placeholder="Ê¡·Ý/Ö±Ï½ÊÐ"></el-input>
    </el-form-item>
    <el-form-item label="³ÇÊÐ" prop="receiverCity">
      <el-input v-model="dataForm.receiverCity" placeholder="³ÇÊÐ"></el-input>
    </el-form-item>
    <el-form-item label="Çø" prop="receiverRegion">
      <el-input v-model="dataForm.receiverRegion" placeholder="Çø"></el-input>
    </el-form-item>
    <el-form-item label="ÏêÏ¸µØÖ·" prop="receiverDetailAddress">
      <el-input v-model="dataForm.receiverDetailAddress" placeholder="ÏêÏ¸µØÖ·"></el-input>
    </el-form-item>
    <el-form-item label="¶©µ¥±¸×¢" prop="note">
      <el-input v-model="dataForm.note" placeholder="¶©µ¥±¸×¢"></el-input>
    </el-form-item>
    <el-form-item label="È·ÈÏÊÕ»õ×´Ì¬[0->Î´È·ÈÏ£»1->ÒÑÈ·ÈÏ]" prop="confirmStatus">
      <el-input v-model="dataForm.confirmStatus" placeholder="È·ÈÏÊÕ»õ×´Ì¬[0->Î´È·ÈÏ£»1->ÒÑÈ·ÈÏ]"></el-input>
    </el-form-item>
    <el-form-item label="É¾³ý×´Ì¬¡¾0->Î´É¾³ý£»1->ÒÑÉ¾³ý¡¿" prop="deleteStatus">
      <el-input v-model="dataForm.deleteStatus" placeholder="É¾³ý×´Ì¬¡¾0->Î´É¾³ý£»1->ÒÑÉ¾³ý¡¿"></el-input>
    </el-form-item>
    <el-form-item label="ÏÂµ¥Ê±Ê¹ÓÃµÄ»ý·Ö" prop="useIntegration">
      <el-input v-model="dataForm.useIntegration" placeholder="ÏÂµ¥Ê±Ê¹ÓÃµÄ»ý·Ö"></el-input>
    </el-form-item>
    <el-form-item label="Ö§¸¶Ê±¼ä" prop="paymentTime">
      <el-input v-model="dataForm.paymentTime" placeholder="Ö§¸¶Ê±¼ä"></el-input>
    </el-form-item>
    <el-form-item label="·¢»õÊ±¼ä" prop="deliveryTime">
      <el-input v-model="dataForm.deliveryTime" placeholder="·¢»õÊ±¼ä"></el-input>
    </el-form-item>
    <el-form-item label="È·ÈÏÊÕ»õÊ±¼ä" prop="receiveTime">
      <el-input v-model="dataForm.receiveTime" placeholder="È·ÈÏÊÕ»õÊ±¼ä"></el-input>
    </el-form-item>
    <el-form-item label="ÆÀ¼ÛÊ±¼ä" prop="commentTime">
      <el-input v-model="dataForm.commentTime" placeholder="ÆÀ¼ÛÊ±¼ä"></el-input>
    </el-form-item>
    <el-form-item label="ÐÞ¸ÄÊ±¼ä" prop="modifyTime">
      <el-input v-model="dataForm.modifyTime" placeholder="ÐÞ¸ÄÊ±¼ä"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          memberId: '',
          orderSn: '',
          couponId: '',
          createTime: '',
          memberUsername: '',
          totalAmount: '',
          payAmount: '',
          freightAmount: '',
          promotionAmount: '',
          integrationAmount: '',
          couponAmount: '',
          discountAmount: '',
          payType: '',
          sourceType: '',
          status: '',
          deliveryCompany: '',
          deliverySn: '',
          autoConfirmDay: '',
          integration: '',
          growth: '',
          billType: '',
          billHeader: '',
          billContent: '',
          billReceiverPhone: '',
          billReceiverEmail: '',
          receiverName: '',
          receiverPhone: '',
          receiverPostCode: '',
          receiverProvince: '',
          receiverCity: '',
          receiverRegion: '',
          receiverDetailAddress: '',
          note: '',
          confirmStatus: '',
          deleteStatus: '',
          useIntegration: '',
          paymentTime: '',
          deliveryTime: '',
          receiveTime: '',
          commentTime: '',
          modifyTime: ''
        },
        dataRule: {
          memberId: [
            { required: true, message: 'member_id不能为空', trigger: 'blur' }
          ],
          orderSn: [
            { required: true, message: '¶©µ¥ºÅ不能为空', trigger: 'blur' }
          ],
          couponId: [
            { required: true, message: 'Ê¹ÓÃµÄÓÅ»ÝÈ¯不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: 'create_time不能为空', trigger: 'blur' }
          ],
          memberUsername: [
            { required: true, message: 'ÓÃ»§Ãû不能为空', trigger: 'blur' }
          ],
          totalAmount: [
            { required: true, message: '¶©µ¥×Ü¶î不能为空', trigger: 'blur' }
          ],
          payAmount: [
            { required: true, message: 'Ó¦¸¶×Ü¶î不能为空', trigger: 'blur' }
          ],
          freightAmount: [
            { required: true, message: 'ÔË·Ñ½ð¶î不能为空', trigger: 'blur' }
          ],
          promotionAmount: [
            { required: true, message: '´ÙÏúÓÅ»¯½ð¶î£¨´ÙÏú¼Û¡¢Âú¼õ¡¢½×ÌÝ¼Û£©不能为空', trigger: 'blur' }
          ],
          integrationAmount: [
            { required: true, message: '»ý·ÖµÖ¿Û½ð¶î不能为空', trigger: 'blur' }
          ],
          couponAmount: [
            { required: true, message: 'ÓÅ»ÝÈ¯µÖ¿Û½ð¶î不能为空', trigger: 'blur' }
          ],
          discountAmount: [
            { required: true, message: 'ºóÌ¨µ÷Õû¶©µ¥Ê¹ÓÃµÄÕÛ¿Û½ð¶î不能为空', trigger: 'blur' }
          ],
          payType: [
            { required: true, message: 'Ö§¸¶·½Ê½¡¾1->Ö§¸¶±¦£»2->Î¢ÐÅ£»3->ÒøÁª£» 4->»õµ½¸¶¿î£»¡¿不能为空', trigger: 'blur' }
          ],
          sourceType: [
            { required: true, message: '¶©µ¥À´Ô´[0->PC¶©µ¥£»1->app¶©µ¥]不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '¶©µ¥×´Ì¬¡¾0->´ý¸¶¿î£»1->´ý·¢»õ£»2->ÒÑ·¢»õ£»3->ÒÑÍê³É£»4->ÒÑ¹Ø±Õ£»5->ÎÞÐ§¶©µ¥¡¿不能为空', trigger: 'blur' }
          ],
          deliveryCompany: [
            { required: true, message: 'ÎïÁ÷¹«Ë¾(ÅäËÍ·½Ê½)不能为空', trigger: 'blur' }
          ],
          deliverySn: [
            { required: true, message: 'ÎïÁ÷µ¥ºÅ不能为空', trigger: 'blur' }
          ],
          autoConfirmDay: [
            { required: true, message: '×Ô¶¯È·ÈÏÊ±¼ä£¨Ìì£©不能为空', trigger: 'blur' }
          ],
          integration: [
            { required: true, message: '¿ÉÒÔ»ñµÃµÄ»ý·Ö不能为空', trigger: 'blur' }
          ],
          growth: [
            { required: true, message: '¿ÉÒÔ»ñµÃµÄ³É³¤Öµ不能为空', trigger: 'blur' }
          ],
          billType: [
            { required: true, message: '·¢Æ±ÀàÐÍ[0->²»¿ª·¢Æ±£»1->µç×Ó·¢Æ±£»2->Ö½ÖÊ·¢Æ±]不能为空', trigger: 'blur' }
          ],
          billHeader: [
            { required: true, message: '·¢Æ±Ì§Í·不能为空', trigger: 'blur' }
          ],
          billContent: [
            { required: true, message: '·¢Æ±ÄÚÈÝ不能为空', trigger: 'blur' }
          ],
          billReceiverPhone: [
            { required: true, message: 'ÊÕÆ±ÈËµç»°不能为空', trigger: 'blur' }
          ],
          billReceiverEmail: [
            { required: true, message: 'ÊÕÆ±ÈËÓÊÏä不能为空', trigger: 'blur' }
          ],
          receiverName: [
            { required: true, message: 'ÊÕ»õÈËÐÕÃû不能为空', trigger: 'blur' }
          ],
          receiverPhone: [
            { required: true, message: 'ÊÕ»õÈËµç»°不能为空', trigger: 'blur' }
          ],
          receiverPostCode: [
            { required: true, message: 'ÊÕ»õÈËÓÊ±à不能为空', trigger: 'blur' }
          ],
          receiverProvince: [
            { required: true, message: 'Ê¡·Ý/Ö±Ï½ÊÐ不能为空', trigger: 'blur' }
          ],
          receiverCity: [
            { required: true, message: '³ÇÊÐ不能为空', trigger: 'blur' }
          ],
          receiverRegion: [
            { required: true, message: 'Çø不能为空', trigger: 'blur' }
          ],
          receiverDetailAddress: [
            { required: true, message: 'ÏêÏ¸µØÖ·不能为空', trigger: 'blur' }
          ],
          note: [
            { required: true, message: '¶©µ¥±¸×¢不能为空', trigger: 'blur' }
          ],
          confirmStatus: [
            { required: true, message: 'È·ÈÏÊÕ»õ×´Ì¬[0->Î´È·ÈÏ£»1->ÒÑÈ·ÈÏ]不能为空', trigger: 'blur' }
          ],
          deleteStatus: [
            { required: true, message: 'É¾³ý×´Ì¬¡¾0->Î´É¾³ý£»1->ÒÑÉ¾³ý¡¿不能为空', trigger: 'blur' }
          ],
          useIntegration: [
            { required: true, message: 'ÏÂµ¥Ê±Ê¹ÓÃµÄ»ý·Ö不能为空', trigger: 'blur' }
          ],
          paymentTime: [
            { required: true, message: 'Ö§¸¶Ê±¼ä不能为空', trigger: 'blur' }
          ],
          deliveryTime: [
            { required: true, message: '·¢»õÊ±¼ä不能为空', trigger: 'blur' }
          ],
          receiveTime: [
            { required: true, message: 'È·ÈÏÊÕ»õÊ±¼ä不能为空', trigger: 'blur' }
          ],
          commentTime: [
            { required: true, message: 'ÆÀ¼ÛÊ±¼ä不能为空', trigger: 'blur' }
          ],
          modifyTime: [
            { required: true, message: 'ÐÞ¸ÄÊ±¼ä不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/ware/omsorder/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memberId = data.omsOrder.memberId
                this.dataForm.orderSn = data.omsOrder.orderSn
                this.dataForm.couponId = data.omsOrder.couponId
                this.dataForm.createTime = data.omsOrder.createTime
                this.dataForm.memberUsername = data.omsOrder.memberUsername
                this.dataForm.totalAmount = data.omsOrder.totalAmount
                this.dataForm.payAmount = data.omsOrder.payAmount
                this.dataForm.freightAmount = data.omsOrder.freightAmount
                this.dataForm.promotionAmount = data.omsOrder.promotionAmount
                this.dataForm.integrationAmount = data.omsOrder.integrationAmount
                this.dataForm.couponAmount = data.omsOrder.couponAmount
                this.dataForm.discountAmount = data.omsOrder.discountAmount
                this.dataForm.payType = data.omsOrder.payType
                this.dataForm.sourceType = data.omsOrder.sourceType
                this.dataForm.status = data.omsOrder.status
                this.dataForm.deliveryCompany = data.omsOrder.deliveryCompany
                this.dataForm.deliverySn = data.omsOrder.deliverySn
                this.dataForm.autoConfirmDay = data.omsOrder.autoConfirmDay
                this.dataForm.integration = data.omsOrder.integration
                this.dataForm.growth = data.omsOrder.growth
                this.dataForm.billType = data.omsOrder.billType
                this.dataForm.billHeader = data.omsOrder.billHeader
                this.dataForm.billContent = data.omsOrder.billContent
                this.dataForm.billReceiverPhone = data.omsOrder.billReceiverPhone
                this.dataForm.billReceiverEmail = data.omsOrder.billReceiverEmail
                this.dataForm.receiverName = data.omsOrder.receiverName
                this.dataForm.receiverPhone = data.omsOrder.receiverPhone
                this.dataForm.receiverPostCode = data.omsOrder.receiverPostCode
                this.dataForm.receiverProvince = data.omsOrder.receiverProvince
                this.dataForm.receiverCity = data.omsOrder.receiverCity
                this.dataForm.receiverRegion = data.omsOrder.receiverRegion
                this.dataForm.receiverDetailAddress = data.omsOrder.receiverDetailAddress
                this.dataForm.note = data.omsOrder.note
                this.dataForm.confirmStatus = data.omsOrder.confirmStatus
                this.dataForm.deleteStatus = data.omsOrder.deleteStatus
                this.dataForm.useIntegration = data.omsOrder.useIntegration
                this.dataForm.paymentTime = data.omsOrder.paymentTime
                this.dataForm.deliveryTime = data.omsOrder.deliveryTime
                this.dataForm.receiveTime = data.omsOrder.receiveTime
                this.dataForm.commentTime = data.omsOrder.commentTime
                this.dataForm.modifyTime = data.omsOrder.modifyTime
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/ware/omsorder/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memberId': this.dataForm.memberId,
                'orderSn': this.dataForm.orderSn,
                'couponId': this.dataForm.couponId,
                'createTime': this.dataForm.createTime,
                'memberUsername': this.dataForm.memberUsername,
                'totalAmount': this.dataForm.totalAmount,
                'payAmount': this.dataForm.payAmount,
                'freightAmount': this.dataForm.freightAmount,
                'promotionAmount': this.dataForm.promotionAmount,
                'integrationAmount': this.dataForm.integrationAmount,
                'couponAmount': this.dataForm.couponAmount,
                'discountAmount': this.dataForm.discountAmount,
                'payType': this.dataForm.payType,
                'sourceType': this.dataForm.sourceType,
                'status': this.dataForm.status,
                'deliveryCompany': this.dataForm.deliveryCompany,
                'deliverySn': this.dataForm.deliverySn,
                'autoConfirmDay': this.dataForm.autoConfirmDay,
                'integration': this.dataForm.integration,
                'growth': this.dataForm.growth,
                'billType': this.dataForm.billType,
                'billHeader': this.dataForm.billHeader,
                'billContent': this.dataForm.billContent,
                'billReceiverPhone': this.dataForm.billReceiverPhone,
                'billReceiverEmail': this.dataForm.billReceiverEmail,
                'receiverName': this.dataForm.receiverName,
                'receiverPhone': this.dataForm.receiverPhone,
                'receiverPostCode': this.dataForm.receiverPostCode,
                'receiverProvince': this.dataForm.receiverProvince,
                'receiverCity': this.dataForm.receiverCity,
                'receiverRegion': this.dataForm.receiverRegion,
                'receiverDetailAddress': this.dataForm.receiverDetailAddress,
                'note': this.dataForm.note,
                'confirmStatus': this.dataForm.confirmStatus,
                'deleteStatus': this.dataForm.deleteStatus,
                'useIntegration': this.dataForm.useIntegration,
                'paymentTime': this.dataForm.paymentTime,
                'deliveryTime': this.dataForm.deliveryTime,
                'receiveTime': this.dataForm.receiveTime,
                'commentTime': this.dataForm.commentTime,
                'modifyTime': this.dataForm.modifyTime
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
