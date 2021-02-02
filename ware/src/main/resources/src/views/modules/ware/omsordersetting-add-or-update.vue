<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="ÃëÉ±¶©µ¥³¬Ê±¹Ø±ÕÊ±¼ä(·Ö)" prop="flashOrderOvertime">
      <el-input v-model="dataForm.flashOrderOvertime" placeholder="ÃëÉ±¶©µ¥³¬Ê±¹Ø±ÕÊ±¼ä(·Ö)"></el-input>
    </el-form-item>
    <el-form-item label="Õý³£¶©µ¥³¬Ê±Ê±¼ä(·Ö)" prop="normalOrderOvertime">
      <el-input v-model="dataForm.normalOrderOvertime" placeholder="Õý³£¶©µ¥³¬Ê±Ê±¼ä(·Ö)"></el-input>
    </el-form-item>
    <el-form-item label="·¢»õºó×Ô¶¯È·ÈÏÊÕ»õÊ±¼ä£¨Ìì£©" prop="confirmOvertime">
      <el-input v-model="dataForm.confirmOvertime" placeholder="·¢»õºó×Ô¶¯È·ÈÏÊÕ»õÊ±¼ä£¨Ìì£©"></el-input>
    </el-form-item>
    <el-form-item label="×Ô¶¯Íê³É½»Ò×Ê±¼ä£¬²»ÄÜÉêÇëÍË»õ£¨Ìì£©" prop="finishOvertime">
      <el-input v-model="dataForm.finishOvertime" placeholder="×Ô¶¯Íê³É½»Ò×Ê±¼ä£¬²»ÄÜÉêÇëÍË»õ£¨Ìì£©"></el-input>
    </el-form-item>
    <el-form-item label="¶©µ¥Íê³Éºó×Ô¶¯ºÃÆÀÊ±¼ä£¨Ìì£©" prop="commentOvertime">
      <el-input v-model="dataForm.commentOvertime" placeholder="¶©µ¥Íê³Éºó×Ô¶¯ºÃÆÀÊ±¼ä£¨Ìì£©"></el-input>
    </el-form-item>
    <el-form-item label="»áÔ±µÈ¼¶¡¾0-²»ÏÞ»áÔ±µÈ¼¶£¬È«²¿Í¨ÓÃ£»ÆäËû-¶ÔÓ¦µÄÆäËû»áÔ±µÈ¼¶¡¿" prop="memberLevel">
      <el-input v-model="dataForm.memberLevel" placeholder="»áÔ±µÈ¼¶¡¾0-²»ÏÞ»áÔ±µÈ¼¶£¬È«²¿Í¨ÓÃ£»ÆäËû-¶ÔÓ¦µÄÆäËû»áÔ±µÈ¼¶¡¿"></el-input>
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
          flashOrderOvertime: '',
          normalOrderOvertime: '',
          confirmOvertime: '',
          finishOvertime: '',
          commentOvertime: '',
          memberLevel: ''
        },
        dataRule: {
          flashOrderOvertime: [
            { required: true, message: 'ÃëÉ±¶©µ¥³¬Ê±¹Ø±ÕÊ±¼ä(·Ö)不能为空', trigger: 'blur' }
          ],
          normalOrderOvertime: [
            { required: true, message: 'Õý³£¶©µ¥³¬Ê±Ê±¼ä(·Ö)不能为空', trigger: 'blur' }
          ],
          confirmOvertime: [
            { required: true, message: '·¢»õºó×Ô¶¯È·ÈÏÊÕ»õÊ±¼ä£¨Ìì£©不能为空', trigger: 'blur' }
          ],
          finishOvertime: [
            { required: true, message: '×Ô¶¯Íê³É½»Ò×Ê±¼ä£¬²»ÄÜÉêÇëÍË»õ£¨Ìì£©不能为空', trigger: 'blur' }
          ],
          commentOvertime: [
            { required: true, message: '¶©µ¥Íê³Éºó×Ô¶¯ºÃÆÀÊ±¼ä£¨Ìì£©不能为空', trigger: 'blur' }
          ],
          memberLevel: [
            { required: true, message: '»áÔ±µÈ¼¶¡¾0-²»ÏÞ»áÔ±µÈ¼¶£¬È«²¿Í¨ÓÃ£»ÆäËû-¶ÔÓ¦µÄÆäËû»áÔ±µÈ¼¶¡¿不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/omsordersetting/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.flashOrderOvertime = data.omsOrderSetting.flashOrderOvertime
                this.dataForm.normalOrderOvertime = data.omsOrderSetting.normalOrderOvertime
                this.dataForm.confirmOvertime = data.omsOrderSetting.confirmOvertime
                this.dataForm.finishOvertime = data.omsOrderSetting.finishOvertime
                this.dataForm.commentOvertime = data.omsOrderSetting.commentOvertime
                this.dataForm.memberLevel = data.omsOrderSetting.memberLevel
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
              url: this.$http.adornUrl(`/ware/omsordersetting/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'flashOrderOvertime': this.dataForm.flashOrderOvertime,
                'normalOrderOvertime': this.dataForm.normalOrderOvertime,
                'confirmOvertime': this.dataForm.confirmOvertime,
                'finishOvertime': this.dataForm.finishOvertime,
                'commentOvertime': this.dataForm.commentOvertime,
                'memberLevel': this.dataForm.memberLevel
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
