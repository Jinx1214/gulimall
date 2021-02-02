<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="order_id" prop="orderId">
      <el-input v-model="dataForm.orderId" placeholder="order_id"></el-input>
    </el-form-item>
    <el-form-item label="ÍË»õÉÌÆ·id" prop="skuId">
      <el-input v-model="dataForm.skuId" placeholder="ÍË»õÉÌÆ·id"></el-input>
    </el-form-item>
    <el-form-item label="¶©µ¥±àºÅ" prop="orderSn">
      <el-input v-model="dataForm.orderSn" placeholder="¶©µ¥±àºÅ"></el-input>
    </el-form-item>
    <el-form-item label="ÉêÇëÊ±¼ä" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="ÉêÇëÊ±¼ä"></el-input>
    </el-form-item>
    <el-form-item label="»áÔ±ÓÃ»§Ãû" prop="memberUsername">
      <el-input v-model="dataForm.memberUsername" placeholder="»áÔ±ÓÃ»§Ãû"></el-input>
    </el-form-item>
    <el-form-item label="ÍË¿î½ð¶î" prop="returnAmount">
      <el-input v-model="dataForm.returnAmount" placeholder="ÍË¿î½ð¶î"></el-input>
    </el-form-item>
    <el-form-item label="ÍË»õÈËÐÕÃû" prop="returnName">
      <el-input v-model="dataForm.returnName" placeholder="ÍË»õÈËÐÕÃû"></el-input>
    </el-form-item>
    <el-form-item label="ÍË»õÈËµç»°" prop="returnPhone">
      <el-input v-model="dataForm.returnPhone" placeholder="ÍË»õÈËµç»°"></el-input>
    </el-form-item>
    <el-form-item label="ÉêÇë×´Ì¬[0->´ý´¦Àí£»1->ÍË»õÖÐ£»2->ÒÑÍê³É£»3->ÒÑ¾Ü¾ø]" prop="status">
      <el-input v-model="dataForm.status" placeholder="ÉêÇë×´Ì¬[0->´ý´¦Àí£»1->ÍË»õÖÐ£»2->ÒÑÍê³É£»3->ÒÑ¾Ü¾ø]"></el-input>
    </el-form-item>
    <el-form-item label="´¦ÀíÊ±¼ä" prop="handleTime">
      <el-input v-model="dataForm.handleTime" placeholder="´¦ÀíÊ±¼ä"></el-input>
    </el-form-item>
    <el-form-item label="ÉÌÆ·Í¼Æ¬" prop="skuImg">
      <el-input v-model="dataForm.skuImg" placeholder="ÉÌÆ·Í¼Æ¬"></el-input>
    </el-form-item>
    <el-form-item label="ÉÌÆ·Ãû³Æ" prop="skuName">
      <el-input v-model="dataForm.skuName" placeholder="ÉÌÆ·Ãû³Æ"></el-input>
    </el-form-item>
    <el-form-item label="ÉÌÆ·Æ·ÅÆ" prop="skuBrand">
      <el-input v-model="dataForm.skuBrand" placeholder="ÉÌÆ·Æ·ÅÆ"></el-input>
    </el-form-item>
    <el-form-item label="ÉÌÆ·ÏúÊÛÊôÐÔ(JSON)" prop="skuAttrsVals">
      <el-input v-model="dataForm.skuAttrsVals" placeholder="ÉÌÆ·ÏúÊÛÊôÐÔ(JSON)"></el-input>
    </el-form-item>
    <el-form-item label="ÍË»õÊýÁ¿" prop="skuCount">
      <el-input v-model="dataForm.skuCount" placeholder="ÍË»õÊýÁ¿"></el-input>
    </el-form-item>
    <el-form-item label="ÉÌÆ·µ¥¼Û" prop="skuPrice">
      <el-input v-model="dataForm.skuPrice" placeholder="ÉÌÆ·µ¥¼Û"></el-input>
    </el-form-item>
    <el-form-item label="ÉÌÆ·Êµ¼ÊÖ§¸¶µ¥¼Û" prop="skuRealPrice">
      <el-input v-model="dataForm.skuRealPrice" placeholder="ÉÌÆ·Êµ¼ÊÖ§¸¶µ¥¼Û"></el-input>
    </el-form-item>
    <el-form-item label="Ô­Òò" prop="reason">
      <el-input v-model="dataForm.reason" placeholder="Ô­Òò"></el-input>
    </el-form-item>
    <el-form-item label="ÃèÊö" prop="descriptionêö">
      <el-input v-model="dataForm.descriptionêö" placeholder="ÃèÊö"></el-input>
    </el-form-item>
    <el-form-item label="Æ¾Ö¤Í¼Æ¬£¬ÒÔ¶ººÅ¸ô¿ª" prop="descPics">
      <el-input v-model="dataForm.descPics" placeholder="Æ¾Ö¤Í¼Æ¬£¬ÒÔ¶ººÅ¸ô¿ª"></el-input>
    </el-form-item>
    <el-form-item label="´¦Àí±¸×¢" prop="handleNote">
      <el-input v-model="dataForm.handleNote" placeholder="´¦Àí±¸×¢"></el-input>
    </el-form-item>
    <el-form-item label="´¦ÀíÈËÔ±" prop="handleMan">
      <el-input v-model="dataForm.handleMan" placeholder="´¦ÀíÈËÔ±"></el-input>
    </el-form-item>
    <el-form-item label="ÊÕ»õÈË" prop="receiveMan">
      <el-input v-model="dataForm.receiveMan" placeholder="ÊÕ»õÈË"></el-input>
    </el-form-item>
    <el-form-item label="ÊÕ»õÊ±¼ä" prop="receiveTime">
      <el-input v-model="dataForm.receiveTime" placeholder="ÊÕ»õÊ±¼ä"></el-input>
    </el-form-item>
    <el-form-item label="ÊÕ»õ±¸×¢" prop="receiveNote">
      <el-input v-model="dataForm.receiveNote" placeholder="ÊÕ»õ±¸×¢"></el-input>
    </el-form-item>
    <el-form-item label="ÊÕ»õµç»°" prop="receivePhone">
      <el-input v-model="dataForm.receivePhone" placeholder="ÊÕ»õµç»°"></el-input>
    </el-form-item>
    <el-form-item label="¹«Ë¾ÊÕ»õµØÖ·" prop="companyAddress">
      <el-input v-model="dataForm.companyAddress" placeholder="¹«Ë¾ÊÕ»õµØÖ·"></el-input>
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
          orderId: '',
          skuId: '',
          orderSn: '',
          createTime: '',
          memberUsername: '',
          returnAmount: '',
          returnName: '',
          returnPhone: '',
          status: '',
          handleTime: '',
          skuImg: '',
          skuName: '',
          skuBrand: '',
          skuAttrsVals: '',
          skuCount: '',
          skuPrice: '',
          skuRealPrice: '',
          reason: '',
          descriptionêö: '',
          descPics: '',
          handleNote: '',
          handleMan: '',
          receiveMan: '',
          receiveTime: '',
          receiveNote: '',
          receivePhone: '',
          companyAddress: ''
        },
        dataRule: {
          orderId: [
            { required: true, message: 'order_id不能为空', trigger: 'blur' }
          ],
          skuId: [
            { required: true, message: 'ÍË»õÉÌÆ·id不能为空', trigger: 'blur' }
          ],
          orderSn: [
            { required: true, message: '¶©µ¥±àºÅ不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: 'ÉêÇëÊ±¼ä不能为空', trigger: 'blur' }
          ],
          memberUsername: [
            { required: true, message: '»áÔ±ÓÃ»§Ãû不能为空', trigger: 'blur' }
          ],
          returnAmount: [
            { required: true, message: 'ÍË¿î½ð¶î不能为空', trigger: 'blur' }
          ],
          returnName: [
            { required: true, message: 'ÍË»õÈËÐÕÃû不能为空', trigger: 'blur' }
          ],
          returnPhone: [
            { required: true, message: 'ÍË»õÈËµç»°不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: 'ÉêÇë×´Ì¬[0->´ý´¦Àí£»1->ÍË»õÖÐ£»2->ÒÑÍê³É£»3->ÒÑ¾Ü¾ø]不能为空', trigger: 'blur' }
          ],
          handleTime: [
            { required: true, message: '´¦ÀíÊ±¼ä不能为空', trigger: 'blur' }
          ],
          skuImg: [
            { required: true, message: 'ÉÌÆ·Í¼Æ¬不能为空', trigger: 'blur' }
          ],
          skuName: [
            { required: true, message: 'ÉÌÆ·Ãû³Æ不能为空', trigger: 'blur' }
          ],
          skuBrand: [
            { required: true, message: 'ÉÌÆ·Æ·ÅÆ不能为空', trigger: 'blur' }
          ],
          skuAttrsVals: [
            { required: true, message: 'ÉÌÆ·ÏúÊÛÊôÐÔ(JSON)不能为空', trigger: 'blur' }
          ],
          skuCount: [
            { required: true, message: 'ÍË»õÊýÁ¿不能为空', trigger: 'blur' }
          ],
          skuPrice: [
            { required: true, message: 'ÉÌÆ·µ¥¼Û不能为空', trigger: 'blur' }
          ],
          skuRealPrice: [
            { required: true, message: 'ÉÌÆ·Êµ¼ÊÖ§¸¶µ¥¼Û不能为空', trigger: 'blur' }
          ],
          reason: [
            { required: true, message: 'Ô­Òò不能为空', trigger: 'blur' }
          ],
          descriptionêö: [
            { required: true, message: 'ÃèÊö不能为空', trigger: 'blur' }
          ],
          descPics: [
            { required: true, message: 'Æ¾Ö¤Í¼Æ¬£¬ÒÔ¶ººÅ¸ô¿ª不能为空', trigger: 'blur' }
          ],
          handleNote: [
            { required: true, message: '´¦Àí±¸×¢不能为空', trigger: 'blur' }
          ],
          handleMan: [
            { required: true, message: '´¦ÀíÈËÔ±不能为空', trigger: 'blur' }
          ],
          receiveMan: [
            { required: true, message: 'ÊÕ»õÈË不能为空', trigger: 'blur' }
          ],
          receiveTime: [
            { required: true, message: 'ÊÕ»õÊ±¼ä不能为空', trigger: 'blur' }
          ],
          receiveNote: [
            { required: true, message: 'ÊÕ»õ±¸×¢不能为空', trigger: 'blur' }
          ],
          receivePhone: [
            { required: true, message: 'ÊÕ»õµç»°不能为空', trigger: 'blur' }
          ],
          companyAddress: [
            { required: true, message: '¹«Ë¾ÊÕ»õµØÖ·不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/omsorderreturnapply/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.orderId = data.omsOrderReturnApply.orderId
                this.dataForm.skuId = data.omsOrderReturnApply.skuId
                this.dataForm.orderSn = data.omsOrderReturnApply.orderSn
                this.dataForm.createTime = data.omsOrderReturnApply.createTime
                this.dataForm.memberUsername = data.omsOrderReturnApply.memberUsername
                this.dataForm.returnAmount = data.omsOrderReturnApply.returnAmount
                this.dataForm.returnName = data.omsOrderReturnApply.returnName
                this.dataForm.returnPhone = data.omsOrderReturnApply.returnPhone
                this.dataForm.status = data.omsOrderReturnApply.status
                this.dataForm.handleTime = data.omsOrderReturnApply.handleTime
                this.dataForm.skuImg = data.omsOrderReturnApply.skuImg
                this.dataForm.skuName = data.omsOrderReturnApply.skuName
                this.dataForm.skuBrand = data.omsOrderReturnApply.skuBrand
                this.dataForm.skuAttrsVals = data.omsOrderReturnApply.skuAttrsVals
                this.dataForm.skuCount = data.omsOrderReturnApply.skuCount
                this.dataForm.skuPrice = data.omsOrderReturnApply.skuPrice
                this.dataForm.skuRealPrice = data.omsOrderReturnApply.skuRealPrice
                this.dataForm.reason = data.omsOrderReturnApply.reason
                this.dataForm.descriptionêö = data.omsOrderReturnApply.descriptionêö
                this.dataForm.descPics = data.omsOrderReturnApply.descPics
                this.dataForm.handleNote = data.omsOrderReturnApply.handleNote
                this.dataForm.handleMan = data.omsOrderReturnApply.handleMan
                this.dataForm.receiveMan = data.omsOrderReturnApply.receiveMan
                this.dataForm.receiveTime = data.omsOrderReturnApply.receiveTime
                this.dataForm.receiveNote = data.omsOrderReturnApply.receiveNote
                this.dataForm.receivePhone = data.omsOrderReturnApply.receivePhone
                this.dataForm.companyAddress = data.omsOrderReturnApply.companyAddress
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
              url: this.$http.adornUrl(`/ware/omsorderreturnapply/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'orderId': this.dataForm.orderId,
                'skuId': this.dataForm.skuId,
                'orderSn': this.dataForm.orderSn,
                'createTime': this.dataForm.createTime,
                'memberUsername': this.dataForm.memberUsername,
                'returnAmount': this.dataForm.returnAmount,
                'returnName': this.dataForm.returnName,
                'returnPhone': this.dataForm.returnPhone,
                'status': this.dataForm.status,
                'handleTime': this.dataForm.handleTime,
                'skuImg': this.dataForm.skuImg,
                'skuName': this.dataForm.skuName,
                'skuBrand': this.dataForm.skuBrand,
                'skuAttrsVals': this.dataForm.skuAttrsVals,
                'skuCount': this.dataForm.skuCount,
                'skuPrice': this.dataForm.skuPrice,
                'skuRealPrice': this.dataForm.skuRealPrice,
                'reason': this.dataForm.reason,
                'descriptionêö': this.dataForm.descriptionêö,
                'descPics': this.dataForm.descPics,
                'handleNote': this.dataForm.handleNote,
                'handleMan': this.dataForm.handleMan,
                'receiveMan': this.dataForm.receiveMan,
                'receiveTime': this.dataForm.receiveTime,
                'receiveNote': this.dataForm.receiveNote,
                'receivePhone': this.dataForm.receivePhone,
                'companyAddress': this.dataForm.companyAddress
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
