<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="sku_id" prop="skuId">
      <el-input v-model="dataForm.skuId" placeholder="sku_id"></el-input>
    </el-form-item>
    <el-form-item label="attr_id" prop="attrId">
      <el-input v-model="dataForm.attrId" placeholder="attr_id"></el-input>
    </el-form-item>
    <el-form-item label="ÏúÊÛÊôÐÔÃû" prop="attrName">
      <el-input v-model="dataForm.attrName" placeholder="ÏúÊÛÊôÐÔÃû"></el-input>
    </el-form-item>
    <el-form-item label="ÏúÊÛÊôÐÔÖµ" prop="attrValue">
      <el-input v-model="dataForm.attrValue" placeholder="ÏúÊÛÊôÐÔÖµ"></el-input>
    </el-form-item>
    <el-form-item label="Ë³Ðò" prop="attrSort">
      <el-input v-model="dataForm.attrSort" placeholder="Ë³Ðò"></el-input>
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
          skuId: '',
          attrId: '',
          attrName: '',
          attrValue: '',
          attrSort: ''
        },
        dataRule: {
          skuId: [
            { required: true, message: 'sku_id不能为空', trigger: 'blur' }
          ],
          attrId: [
            { required: true, message: 'attr_id不能为空', trigger: 'blur' }
          ],
          attrName: [
            { required: true, message: 'ÏúÊÛÊôÐÔÃû不能为空', trigger: 'blur' }
          ],
          attrValue: [
            { required: true, message: 'ÏúÊÛÊôÐÔÖµ不能为空', trigger: 'blur' }
          ],
          attrSort: [
            { required: true, message: 'Ë³Ðò不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/pmsskusaleattrvalue/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.skuId = data.pmsSkuSaleAttrValue.skuId
                this.dataForm.attrId = data.pmsSkuSaleAttrValue.attrId
                this.dataForm.attrName = data.pmsSkuSaleAttrValue.attrName
                this.dataForm.attrValue = data.pmsSkuSaleAttrValue.attrValue
                this.dataForm.attrSort = data.pmsSkuSaleAttrValue.attrSort
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
              url: this.$http.adornUrl(`/ware/pmsskusaleattrvalue/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'skuId': this.dataForm.skuId,
                'attrId': this.dataForm.attrId,
                'attrName': this.dataForm.attrName,
                'attrValue': this.dataForm.attrValue,
                'attrSort': this.dataForm.attrSort
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
