<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="member_id" prop="memberId">
      <el-input v-model="dataForm.memberId" placeholder="member_id"></el-input>
    </el-form-item>
    <el-form-item label="sku_id" prop="skuId">
      <el-input v-model="dataForm.skuId" placeholder="sku_id"></el-input>
    </el-form-item>
    <el-form-item label="»î¶¯³¡´Îid" prop="sessionId">
      <el-input v-model="dataForm.sessionId" placeholder="»î¶¯³¡´Îid"></el-input>
    </el-form-item>
    <el-form-item label="¶©ÔÄÊ±¼ä" prop="subcribeTime">
      <el-input v-model="dataForm.subcribeTime" placeholder="¶©ÔÄÊ±¼ä"></el-input>
    </el-form-item>
    <el-form-item label="·¢ËÍÊ±¼ä" prop="sendTime">
      <el-input v-model="dataForm.sendTime" placeholder="·¢ËÍÊ±¼ä"></el-input>
    </el-form-item>
    <el-form-item label="Í¨Öª·½Ê½[0-¶ÌÐÅ£¬1-ÓÊ¼þ]" prop="noticeType">
      <el-input v-model="dataForm.noticeType" placeholder="Í¨Öª·½Ê½[0-¶ÌÐÅ£¬1-ÓÊ¼þ]"></el-input>
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
          skuId: '',
          sessionId: '',
          subcribeTime: '',
          sendTime: '',
          noticeType: ''
        },
        dataRule: {
          memberId: [
            { required: true, message: 'member_id不能为空', trigger: 'blur' }
          ],
          skuId: [
            { required: true, message: 'sku_id不能为空', trigger: 'blur' }
          ],
          sessionId: [
            { required: true, message: '»î¶¯³¡´Îid不能为空', trigger: 'blur' }
          ],
          subcribeTime: [
            { required: true, message: '¶©ÔÄÊ±¼ä不能为空', trigger: 'blur' }
          ],
          sendTime: [
            { required: true, message: '·¢ËÍÊ±¼ä不能为空', trigger: 'blur' }
          ],
          noticeType: [
            { required: true, message: 'Í¨Öª·½Ê½[0-¶ÌÐÅ£¬1-ÓÊ¼þ]不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/smsseckillskunotice/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memberId = data.smsSeckillSkuNotice.memberId
                this.dataForm.skuId = data.smsSeckillSkuNotice.skuId
                this.dataForm.sessionId = data.smsSeckillSkuNotice.sessionId
                this.dataForm.subcribeTime = data.smsSeckillSkuNotice.subcribeTime
                this.dataForm.sendTime = data.smsSeckillSkuNotice.sendTime
                this.dataForm.noticeType = data.smsSeckillSkuNotice.noticeType
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
              url: this.$http.adornUrl(`/ware/smsseckillskunotice/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memberId': this.dataForm.memberId,
                'skuId': this.dataForm.skuId,
                'sessionId': this.dataForm.sessionId,
                'subcribeTime': this.dataForm.subcribeTime,
                'sendTime': this.dataForm.sendTime,
                'noticeType': this.dataForm.noticeType
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
