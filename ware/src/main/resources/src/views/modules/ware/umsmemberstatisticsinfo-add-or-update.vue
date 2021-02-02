<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="»áÔ±id" prop="memberId">
      <el-input v-model="dataForm.memberId" placeholder="»áÔ±id"></el-input>
    </el-form-item>
    <el-form-item label="ÀÛ¼ÆÏû·Ñ½ð¶î" prop="consumeAmount">
      <el-input v-model="dataForm.consumeAmount" placeholder="ÀÛ¼ÆÏû·Ñ½ð¶î"></el-input>
    </el-form-item>
    <el-form-item label="ÀÛ¼ÆÓÅ»Ý½ð¶î" prop="couponAmount">
      <el-input v-model="dataForm.couponAmount" placeholder="ÀÛ¼ÆÓÅ»Ý½ð¶î"></el-input>
    </el-form-item>
    <el-form-item label="¶©µ¥ÊýÁ¿" prop="orderCount">
      <el-input v-model="dataForm.orderCount" placeholder="¶©µ¥ÊýÁ¿"></el-input>
    </el-form-item>
    <el-form-item label="ÓÅ»ÝÈ¯ÊýÁ¿" prop="couponCount">
      <el-input v-model="dataForm.couponCount" placeholder="ÓÅ»ÝÈ¯ÊýÁ¿"></el-input>
    </el-form-item>
    <el-form-item label="ÆÀ¼ÛÊý" prop="commentCount">
      <el-input v-model="dataForm.commentCount" placeholder="ÆÀ¼ÛÊý"></el-input>
    </el-form-item>
    <el-form-item label="ÍË»õÊýÁ¿" prop="returnOrderCount">
      <el-input v-model="dataForm.returnOrderCount" placeholder="ÍË»õÊýÁ¿"></el-input>
    </el-form-item>
    <el-form-item label="µÇÂ¼´ÎÊý" prop="loginCount">
      <el-input v-model="dataForm.loginCount" placeholder="µÇÂ¼´ÎÊý"></el-input>
    </el-form-item>
    <el-form-item label="¹Ø×¢ÊýÁ¿" prop="attendCount">
      <el-input v-model="dataForm.attendCount" placeholder="¹Ø×¢ÊýÁ¿"></el-input>
    </el-form-item>
    <el-form-item label="·ÛË¿ÊýÁ¿" prop="fansCount">
      <el-input v-model="dataForm.fansCount" placeholder="·ÛË¿ÊýÁ¿"></el-input>
    </el-form-item>
    <el-form-item label="ÊÕ²ØµÄÉÌÆ·ÊýÁ¿" prop="collectProductCount">
      <el-input v-model="dataForm.collectProductCount" placeholder="ÊÕ²ØµÄÉÌÆ·ÊýÁ¿"></el-input>
    </el-form-item>
    <el-form-item label="ÊÕ²ØµÄ×¨Ìâ»î¶¯ÊýÁ¿" prop="collectSubjectCount">
      <el-input v-model="dataForm.collectSubjectCount" placeholder="ÊÕ²ØµÄ×¨Ìâ»î¶¯ÊýÁ¿"></el-input>
    </el-form-item>
    <el-form-item label="ÊÕ²ØµÄÆÀÂÛÊýÁ¿" prop="collectCommentCount">
      <el-input v-model="dataForm.collectCommentCount" placeholder="ÊÕ²ØµÄÆÀÂÛÊýÁ¿"></el-input>
    </el-form-item>
    <el-form-item label="ÑûÇëµÄÅóÓÑÊýÁ¿" prop="inviteFriendCount">
      <el-input v-model="dataForm.inviteFriendCount" placeholder="ÑûÇëµÄÅóÓÑÊýÁ¿"></el-input>
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
          consumeAmount: '',
          couponAmount: '',
          orderCount: '',
          couponCount: '',
          commentCount: '',
          returnOrderCount: '',
          loginCount: '',
          attendCount: '',
          fansCount: '',
          collectProductCount: '',
          collectSubjectCount: '',
          collectCommentCount: '',
          inviteFriendCount: ''
        },
        dataRule: {
          memberId: [
            { required: true, message: '»áÔ±id不能为空', trigger: 'blur' }
          ],
          consumeAmount: [
            { required: true, message: 'ÀÛ¼ÆÏû·Ñ½ð¶î不能为空', trigger: 'blur' }
          ],
          couponAmount: [
            { required: true, message: 'ÀÛ¼ÆÓÅ»Ý½ð¶î不能为空', trigger: 'blur' }
          ],
          orderCount: [
            { required: true, message: '¶©µ¥ÊýÁ¿不能为空', trigger: 'blur' }
          ],
          couponCount: [
            { required: true, message: 'ÓÅ»ÝÈ¯ÊýÁ¿不能为空', trigger: 'blur' }
          ],
          commentCount: [
            { required: true, message: 'ÆÀ¼ÛÊý不能为空', trigger: 'blur' }
          ],
          returnOrderCount: [
            { required: true, message: 'ÍË»õÊýÁ¿不能为空', trigger: 'blur' }
          ],
          loginCount: [
            { required: true, message: 'µÇÂ¼´ÎÊý不能为空', trigger: 'blur' }
          ],
          attendCount: [
            { required: true, message: '¹Ø×¢ÊýÁ¿不能为空', trigger: 'blur' }
          ],
          fansCount: [
            { required: true, message: '·ÛË¿ÊýÁ¿不能为空', trigger: 'blur' }
          ],
          collectProductCount: [
            { required: true, message: 'ÊÕ²ØµÄÉÌÆ·ÊýÁ¿不能为空', trigger: 'blur' }
          ],
          collectSubjectCount: [
            { required: true, message: 'ÊÕ²ØµÄ×¨Ìâ»î¶¯ÊýÁ¿不能为空', trigger: 'blur' }
          ],
          collectCommentCount: [
            { required: true, message: 'ÊÕ²ØµÄÆÀÂÛÊýÁ¿不能为空', trigger: 'blur' }
          ],
          inviteFriendCount: [
            { required: true, message: 'ÑûÇëµÄÅóÓÑÊýÁ¿不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/umsmemberstatisticsinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memberId = data.umsMemberStatisticsInfo.memberId
                this.dataForm.consumeAmount = data.umsMemberStatisticsInfo.consumeAmount
                this.dataForm.couponAmount = data.umsMemberStatisticsInfo.couponAmount
                this.dataForm.orderCount = data.umsMemberStatisticsInfo.orderCount
                this.dataForm.couponCount = data.umsMemberStatisticsInfo.couponCount
                this.dataForm.commentCount = data.umsMemberStatisticsInfo.commentCount
                this.dataForm.returnOrderCount = data.umsMemberStatisticsInfo.returnOrderCount
                this.dataForm.loginCount = data.umsMemberStatisticsInfo.loginCount
                this.dataForm.attendCount = data.umsMemberStatisticsInfo.attendCount
                this.dataForm.fansCount = data.umsMemberStatisticsInfo.fansCount
                this.dataForm.collectProductCount = data.umsMemberStatisticsInfo.collectProductCount
                this.dataForm.collectSubjectCount = data.umsMemberStatisticsInfo.collectSubjectCount
                this.dataForm.collectCommentCount = data.umsMemberStatisticsInfo.collectCommentCount
                this.dataForm.inviteFriendCount = data.umsMemberStatisticsInfo.inviteFriendCount
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
              url: this.$http.adornUrl(`/ware/umsmemberstatisticsinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memberId': this.dataForm.memberId,
                'consumeAmount': this.dataForm.consumeAmount,
                'couponAmount': this.dataForm.couponAmount,
                'orderCount': this.dataForm.orderCount,
                'couponCount': this.dataForm.couponCount,
                'commentCount': this.dataForm.commentCount,
                'returnOrderCount': this.dataForm.returnOrderCount,
                'loginCount': this.dataForm.loginCount,
                'attendCount': this.dataForm.attendCount,
                'fansCount': this.dataForm.fansCount,
                'collectProductCount': this.dataForm.collectProductCount,
                'collectSubjectCount': this.dataForm.collectSubjectCount,
                'collectCommentCount': this.dataForm.collectCommentCount,
                'inviteFriendCount': this.dataForm.inviteFriendCount
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
