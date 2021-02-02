<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="member_id" prop="memberId">
      <el-input v-model="dataForm.memberId" placeholder="member_id"></el-input>
    </el-form-item>
    <el-form-item label="ÊÕ»õÈËÐÕÃû" prop="name">
      <el-input v-model="dataForm.name" placeholder="ÊÕ»õÈËÐÕÃû"></el-input>
    </el-form-item>
    <el-form-item label="µç»°" prop="phone">
      <el-input v-model="dataForm.phone" placeholder="µç»°"></el-input>
    </el-form-item>
    <el-form-item label="ÓÊÕþ±àÂë" prop="postCode">
      <el-input v-model="dataForm.postCode" placeholder="ÓÊÕþ±àÂë"></el-input>
    </el-form-item>
    <el-form-item label="Ê¡·Ý/Ö±Ï½ÊÐ" prop="province">
      <el-input v-model="dataForm.province" placeholder="Ê¡·Ý/Ö±Ï½ÊÐ"></el-input>
    </el-form-item>
    <el-form-item label="³ÇÊÐ" prop="city">
      <el-input v-model="dataForm.city" placeholder="³ÇÊÐ"></el-input>
    </el-form-item>
    <el-form-item label="Çø" prop="region">
      <el-input v-model="dataForm.region" placeholder="Çø"></el-input>
    </el-form-item>
    <el-form-item label="ÏêÏ¸µØÖ·(½ÖµÀ)" prop="detailAddress">
      <el-input v-model="dataForm.detailAddress" placeholder="ÏêÏ¸µØÖ·(½ÖµÀ)"></el-input>
    </el-form-item>
    <el-form-item label="Ê¡ÊÐÇø´úÂë" prop="areacode">
      <el-input v-model="dataForm.areacode" placeholder="Ê¡ÊÐÇø´úÂë"></el-input>
    </el-form-item>
    <el-form-item label="ÊÇ·ñÄ¬ÈÏ" prop="defaultStatus">
      <el-input v-model="dataForm.defaultStatus" placeholder="ÊÇ·ñÄ¬ÈÏ"></el-input>
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
          name: '',
          phone: '',
          postCode: '',
          province: '',
          city: '',
          region: '',
          detailAddress: '',
          areacode: '',
          defaultStatus: ''
        },
        dataRule: {
          memberId: [
            { required: true, message: 'member_id不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: 'ÊÕ»õÈËÐÕÃû不能为空', trigger: 'blur' }
          ],
          phone: [
            { required: true, message: 'µç»°不能为空', trigger: 'blur' }
          ],
          postCode: [
            { required: true, message: 'ÓÊÕþ±àÂë不能为空', trigger: 'blur' }
          ],
          province: [
            { required: true, message: 'Ê¡·Ý/Ö±Ï½ÊÐ不能为空', trigger: 'blur' }
          ],
          city: [
            { required: true, message: '³ÇÊÐ不能为空', trigger: 'blur' }
          ],
          region: [
            { required: true, message: 'Çø不能为空', trigger: 'blur' }
          ],
          detailAddress: [
            { required: true, message: 'ÏêÏ¸µØÖ·(½ÖµÀ)不能为空', trigger: 'blur' }
          ],
          areacode: [
            { required: true, message: 'Ê¡ÊÐÇø´úÂë不能为空', trigger: 'blur' }
          ],
          defaultStatus: [
            { required: true, message: 'ÊÇ·ñÄ¬ÈÏ不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/umsmemberreceiveaddress/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memberId = data.umsMemberReceiveAddress.memberId
                this.dataForm.name = data.umsMemberReceiveAddress.name
                this.dataForm.phone = data.umsMemberReceiveAddress.phone
                this.dataForm.postCode = data.umsMemberReceiveAddress.postCode
                this.dataForm.province = data.umsMemberReceiveAddress.province
                this.dataForm.city = data.umsMemberReceiveAddress.city
                this.dataForm.region = data.umsMemberReceiveAddress.region
                this.dataForm.detailAddress = data.umsMemberReceiveAddress.detailAddress
                this.dataForm.areacode = data.umsMemberReceiveAddress.areacode
                this.dataForm.defaultStatus = data.umsMemberReceiveAddress.defaultStatus
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
              url: this.$http.adornUrl(`/ware/umsmemberreceiveaddress/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memberId': this.dataForm.memberId,
                'name': this.dataForm.name,
                'phone': this.dataForm.phone,
                'postCode': this.dataForm.postCode,
                'province': this.dataForm.province,
                'city': this.dataForm.city,
                'region': this.dataForm.region,
                'detailAddress': this.dataForm.detailAddress,
                'areacode': this.dataForm.areacode,
                'defaultStatus': this.dataForm.defaultStatus
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
