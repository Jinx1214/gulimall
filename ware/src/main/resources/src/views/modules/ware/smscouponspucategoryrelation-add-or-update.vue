<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="ÓÅ»ÝÈ¯id" prop="couponId">
      <el-input v-model="dataForm.couponId" placeholder="ÓÅ»ÝÈ¯id"></el-input>
    </el-form-item>
    <el-form-item label="²úÆ··ÖÀàid" prop="categoryId">
      <el-input v-model="dataForm.categoryId" placeholder="²úÆ··ÖÀàid"></el-input>
    </el-form-item>
    <el-form-item label="²úÆ··ÖÀàÃû³Æ" prop="categoryName">
      <el-input v-model="dataForm.categoryName" placeholder="²úÆ··ÖÀàÃû³Æ"></el-input>
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
          couponId: '',
          categoryId: '',
          categoryName: ''
        },
        dataRule: {
          couponId: [
            { required: true, message: 'ÓÅ»ÝÈ¯id不能为空', trigger: 'blur' }
          ],
          categoryId: [
            { required: true, message: '²úÆ··ÖÀàid不能为空', trigger: 'blur' }
          ],
          categoryName: [
            { required: true, message: '²úÆ··ÖÀàÃû³Æ不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/smscouponspucategoryrelation/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.couponId = data.smsCouponSpuCategoryRelation.couponId
                this.dataForm.categoryId = data.smsCouponSpuCategoryRelation.categoryId
                this.dataForm.categoryName = data.smsCouponSpuCategoryRelation.categoryName
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
              url: this.$http.adornUrl(`/ware/smscouponspucategoryrelation/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'couponId': this.dataForm.couponId,
                'categoryId': this.dataForm.categoryId,
                'categoryName': this.dataForm.categoryName
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
