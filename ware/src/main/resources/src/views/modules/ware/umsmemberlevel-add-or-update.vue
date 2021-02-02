<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="µÈ¼¶Ãû³Æ" prop="name">
      <el-input v-model="dataForm.name" placeholder="µÈ¼¶Ãû³Æ"></el-input>
    </el-form-item>
    <el-form-item label="µÈ¼¶ÐèÒªµÄ³É³¤Öµ" prop="growthPoint">
      <el-input v-model="dataForm.growthPoint" placeholder="µÈ¼¶ÐèÒªµÄ³É³¤Öµ"></el-input>
    </el-form-item>
    <el-form-item label="ÊÇ·ñÎªÄ¬ÈÏµÈ¼¶[0->²»ÊÇ£»1->ÊÇ]" prop="defaultStatus">
      <el-input v-model="dataForm.defaultStatus" placeholder="ÊÇ·ñÎªÄ¬ÈÏµÈ¼¶[0->²»ÊÇ£»1->ÊÇ]"></el-input>
    </el-form-item>
    <el-form-item label="ÃâÔË·Ñ±ê×¼" prop="freeFreightPoint">
      <el-input v-model="dataForm.freeFreightPoint" placeholder="ÃâÔË·Ñ±ê×¼"></el-input>
    </el-form-item>
    <el-form-item label="Ã¿´ÎÆÀ¼Û»ñÈ¡µÄ³É³¤Öµ" prop="commentGrowthPoint">
      <el-input v-model="dataForm.commentGrowthPoint" placeholder="Ã¿´ÎÆÀ¼Û»ñÈ¡µÄ³É³¤Öµ"></el-input>
    </el-form-item>
    <el-form-item label="ÊÇ·ñÓÐÃâÓÊÌØÈ¨" prop="priviledgeFreeFreight">
      <el-input v-model="dataForm.priviledgeFreeFreight" placeholder="ÊÇ·ñÓÐÃâÓÊÌØÈ¨"></el-input>
    </el-form-item>
    <el-form-item label="ÊÇ·ñÓÐ»áÔ±¼Û¸ñÌØÈ¨" prop="priviledgeMemberPrice">
      <el-input v-model="dataForm.priviledgeMemberPrice" placeholder="ÊÇ·ñÓÐ»áÔ±¼Û¸ñÌØÈ¨"></el-input>
    </el-form-item>
    <el-form-item label="ÊÇ·ñÓÐÉúÈÕÌØÈ¨" prop="priviledgeBirthday">
      <el-input v-model="dataForm.priviledgeBirthday" placeholder="ÊÇ·ñÓÐÉúÈÕÌØÈ¨"></el-input>
    </el-form-item>
    <el-form-item label="±¸×¢" prop="note">
      <el-input v-model="dataForm.note" placeholder="±¸×¢"></el-input>
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
          name: '',
          growthPoint: '',
          defaultStatus: '',
          freeFreightPoint: '',
          commentGrowthPoint: '',
          priviledgeFreeFreight: '',
          priviledgeMemberPrice: '',
          priviledgeBirthday: '',
          note: ''
        },
        dataRule: {
          name: [
            { required: true, message: 'µÈ¼¶Ãû³Æ不能为空', trigger: 'blur' }
          ],
          growthPoint: [
            { required: true, message: 'µÈ¼¶ÐèÒªµÄ³É³¤Öµ不能为空', trigger: 'blur' }
          ],
          defaultStatus: [
            { required: true, message: 'ÊÇ·ñÎªÄ¬ÈÏµÈ¼¶[0->²»ÊÇ£»1->ÊÇ]不能为空', trigger: 'blur' }
          ],
          freeFreightPoint: [
            { required: true, message: 'ÃâÔË·Ñ±ê×¼不能为空', trigger: 'blur' }
          ],
          commentGrowthPoint: [
            { required: true, message: 'Ã¿´ÎÆÀ¼Û»ñÈ¡µÄ³É³¤Öµ不能为空', trigger: 'blur' }
          ],
          priviledgeFreeFreight: [
            { required: true, message: 'ÊÇ·ñÓÐÃâÓÊÌØÈ¨不能为空', trigger: 'blur' }
          ],
          priviledgeMemberPrice: [
            { required: true, message: 'ÊÇ·ñÓÐ»áÔ±¼Û¸ñÌØÈ¨不能为空', trigger: 'blur' }
          ],
          priviledgeBirthday: [
            { required: true, message: 'ÊÇ·ñÓÐÉúÈÕÌØÈ¨不能为空', trigger: 'blur' }
          ],
          note: [
            { required: true, message: '±¸×¢不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/umsmemberlevel/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.umsMemberLevel.name
                this.dataForm.growthPoint = data.umsMemberLevel.growthPoint
                this.dataForm.defaultStatus = data.umsMemberLevel.defaultStatus
                this.dataForm.freeFreightPoint = data.umsMemberLevel.freeFreightPoint
                this.dataForm.commentGrowthPoint = data.umsMemberLevel.commentGrowthPoint
                this.dataForm.priviledgeFreeFreight = data.umsMemberLevel.priviledgeFreeFreight
                this.dataForm.priviledgeMemberPrice = data.umsMemberLevel.priviledgeMemberPrice
                this.dataForm.priviledgeBirthday = data.umsMemberLevel.priviledgeBirthday
                this.dataForm.note = data.umsMemberLevel.note
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
              url: this.$http.adornUrl(`/ware/umsmemberlevel/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'growthPoint': this.dataForm.growthPoint,
                'defaultStatus': this.dataForm.defaultStatus,
                'freeFreightPoint': this.dataForm.freeFreightPoint,
                'commentGrowthPoint': this.dataForm.commentGrowthPoint,
                'priviledgeFreeFreight': this.dataForm.priviledgeFreeFreight,
                'priviledgeMemberPrice': this.dataForm.priviledgeMemberPrice,
                'priviledgeBirthday': this.dataForm.priviledgeBirthday,
                'note': this.dataForm.note
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
