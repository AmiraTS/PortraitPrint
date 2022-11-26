<template>
  <div class="app-container">

    <!-- 查询和其他操作 -->
    <div class="filter-container">

      <el-input v-model="listQuery.oriId" clearable class="filter-item" style="width: 160px;" placeholder="请输入图片ID" />
      <el-input v-model="listQuery.userId" clearable class="filter-item" style="width: 160px;" placeholder="请输入用户ID" />
      <el-button v-permission="['GET /admin/original/list']" class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
      <el-button v-permission="['POST /admin/original/create']" class="filter-item" type="primary" icon="el-icon-edit" @click="handleCreate">添加</el-button>
      <el-button :loading="downloadLoading" class="filter-item" type="primary" icon="el-icon-download" @click="handleDownload">导出</el-button>

    </div>

    <!-- 查询结果 -->
    <el-table v-loading="listLoading" :data="list" element-loading-text="正在查询中。。。" border fit highlight-current-row>

      <el-table-column align="center" label="图片ID" prop="oriId" />

      <el-table-column align="center" property="oriUrl" label="图片">
        <template slot-scope="scope">
          <el-image :src="thumbnail(scope.row.oriUrl)" :preview-src-list="toPreview(scope.row, scope.row.oriUrl)" style="width: 40px; height: 40px" />
        </template>
      </el-table-column>

      <el-table-column align="center" label="对应设计ID" prop="desId" />

      <el-table-column align="center" label="设计稿" prop="desUrl">
        <template slot-scope="scope">
          <el-image :src="thumbnail(scope.row.desUrl)" :preview-src-list="toPreview(scope.row, scope.row.desUrl)" style="width: 40px; height: 40px" />
        </template>
      </el-table-column>

      <el-table-column align="center" label="用户ID" prop="userId" />

      <el-table-column align="center" label="操作" width="200" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button v-permission="['POST /admin/original/update']" type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
          <el-button v-permission="['POST /admin/original/delete']" type="danger" size="mini" @click="handleDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>

    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="getList" />

    <!-- 添加或修改对话框 -->
    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
      <el-form ref="dataForm" :rules="rules" :model="dataForm" status-icon label-position="left" label-width="100px" style="width: 400px; margin-left:50px;">
        <el-form-item label="图片ID" prop="oriId">
          <el-input v-model="dataForm.oriId"  :disabled="idDisable"/>
        </el-form-item>
        <el-form-item label="图片" prop="oriUrl">
          <el-upload
            :headers="headers"
            :action="uploadPath"
            :show-file-list="false"
            :on-success="uploadOriUrl"
            class="avatar-uploader"
            accept=".jpg,.jpeg,.png,.gif"
          >
            <img v-if="dataForm.oriUrl" :src="dataForm.oriUrl" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon" />
          </el-upload>
        </el-form-item>
        <el-form-item label="设计ID" prop="desId">
          <el-input v-model="dataForm.desId" />
        </el-form-item>
        <el-form-item label="设计" prop="desUrl">
          <el-upload
            :headers="headers"
            :action="uploadPath"
            :show-file-list="false"
            :on-success="uploadDesUrl"
            class="avatar-uploader"
            accept=".jpg,.jpeg,.png,.gif"
          >
            <img v-if="dataForm.desUrl" :src="dataForm.desUrl" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon" />
          </el-upload>
        </el-form-item>
        <el-form-item label="用户ID" prop="userId">
          <el-input v-model="dataForm.userId" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button v-if="dialogStatus=='create'" type="primary" @click="createData">确定</el-button>
        <el-button v-else type="primary" @click="updateData">确定</el-button>
      </div>
    </el-dialog>

    <el-tooltip placement="top" content="返回顶部">
      <back-to-top :visibility-height="100" />
    </el-tooltip>

  </div>
</template>

<style>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #20a0ff;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 120px;
    height: 120px;
    line-height: 120px;
    text-align: center;
  }
  .table-expand {
    font-size: 0;
    padding-left: 60px;
  }
  .table-expand label {
    width: 100px;
    color: #99a9bf;
  }
  .table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
  }
</style>

<script>
import { listOriginal, createOriginal, deleteOriginal, editOriginal } from '@/api/original'
import { uploadPath } from '@/api/storage'
import { getToken } from '@/utils/auth'
import BackToTop from '@/components/BackToTop'
import Pagination from '@/components/Pagination' // Secondary package based on el-pagination
import { thumbnail, toPreview } from '@/utils/index'

export default {
  name: 'Original',
  components: { BackToTop, Pagination },
  data() {
    return {
      thumbnail,
      toPreview,
      uploadPath,
      list: [],
      total: 0,
      listLoading: true,
      listQuery: {
        page: 1,
        limit: 20,
        oriId: undefined,
        userId: undefined,
        sort: 'add_time',
        order: 'desc'
      },
      dataForm: {
        oriId: undefined,
        oriUrl: undefined,
        desId: undefined,
        desUrl: undefined,
        userId: undefined
      },
      dialogFormVisible: false,
      dialogStatus: '',
      textMap: {
        update: '编辑',
        create: '创建'
      },
      rules: {
        oriUrl: [
          { required: true, message: '图片不能为空', trigger: 'blur' }
        ]
      },
      downloadLoading: false,
      idDisable:false
    }
  },
  computed: {
    headers() {
      return {
        'X-Litemall-Admin-Token': getToken()
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    getList() {
      this.listLoading = true
      listOriginal(this.listQuery).then(response => {
        this.list = response.data.data.list
        this.total = response.data.data.total
        this.listLoading = false
      }).catch(() => {
        this.list = []
        this.total = 0
        this.listLoading = false
      })
    },
    handleFilter() {
      this.listQuery.page = 1
      this.getList()
    },
    resetForm() {
      this.dataForm = {
        oriId: undefined,
        oriUrl: undefined,
        desId: undefined,
        desUrl: undefined,
        userId: undefined
      }
    },
    handleCreate() {
      this.idDisable=false
      this.resetForm()
      this.dialogStatus = 'create'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    uploadOriUrl: function(response) {
      this.dataForm.oriUrl = response.data.url
    },
    uploadDesUrl: function(response) {
      this.dataForm.desUrl = response.data.url
    },
    createData() {
      this.$refs['dataForm'].validate(valid => {
        if (valid) {
          createOriginal(this.dataForm)
            .then(response => {
              this.list.unshift(response.data.data)
              this.dialogFormVisible = false
              this.$notify.success({
                title: '成功',
                message: '创建成功'
              })
            })
            .catch(response => {
              this.$notify.error({
                title: '失败',
                message: response.errmsg
              })
            })
        }
      })
    },
    handleUpdate(row) {
      this.idDisable=true
      this.dataForm = Object.assign({}, row)
      this.dialogStatus = 'update'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    updateData() {
      this.$refs['dataForm'].validate(valid => {
        console.log(this.dataForm.oriId)
        if (valid) {
          editOriginal(this.dataForm)
            .then(() => {
              // for (const v of this.list) {
              //   if (v.oriId === this.dataForm.oriId) {
              //     const index = this.list.indexOf(v)
              //     this.list.splice(index, 1, this.dataForm)
              //     break
              //   }
              // }
              this.dialogFormVisible = false
              this.getList()
              this.$notify.success({
                title: '成功',
                message: '更新成功'
              })
            })
            .catch(response => {
              this.$notify.error({
                title: '失败',
                message: response.errmsg
              })
            })
        }
      })
    },
    handleDelete(row) {
      console.log(row)
      deleteOriginal(row)
        .then(response => {
          this.$notify.success({
            title: '成功',
            message: '删除成功'
          })
          this.getList()
        })
        .catch(response => {
          this.$notify.error({
            title: '失败',
            message: response.errmsg
          })
        })
    },
    handleDownload() {
      this.downloadLoading = true
      import('@/vendor/Export2Excel').then(excel => {
        const tHeader = ['图片ID', '图片', '设计ID', '设计稿', '用户ID']
        const filterVal = ['oriId', 'oriUrl', 'desId', 'desUrl', 'userId']
        excel.export_json_to_excel2(tHeader, this.list, filterVal, '原图')
        this.downloadLoading = false
      })
    }
  }
}
</script>

