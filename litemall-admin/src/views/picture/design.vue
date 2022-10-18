<template>
  <div class="app-container">

    <!-- 查询和其他操作 -->
    <div class="filter-container">
      <!-- <el-input v-model="listQuery.goodsId" clearable class="filter-item" style="width: 160px;" placeholder="请输入商品ID" />
      <el-input v-model="listQuery.goodsSn" clearable class="filter-item" style="width: 160px;" placeholder="请输入商品编号" />
      <el-input v-model="listQuery.name" clearable class="filter-item" style="width: 160px;" placeholder="请输入商品名称" />
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查找</el-button>
      <el-button class="filter-item" type="primary" icon="el-icon-edit" @click="handleCreate">添加</el-button>
      <el-button :loading="downloadLoading" class="filter-item" type="primary" icon="el-icon-download" @click="handleDownload">导出</el-button> -->

      <el-input class="filter-item" style="width: 160px;" placeholder="请输入设计稿ID" />
      <el-input class="filter-item" style="width: 160px;" placeholder="请输入用户ID" />
      <el-input class="filter-item" style="width: 160px;" placeholder="请输入日期" />
      <el-button class="filter-item" type="primary" icon="el-icon-search">查找</el-button>
      <el-button class="filter-item" type="primary" icon="el-icon-edit">添加</el-button>
      <el-button :loading="downloadLoading" class="filter-item" type="primary" icon="el-icon-download">导出</el-button>
    </div>

    <!-- 查询结果 -->
    <el-table v-loading="listLoading" :data="list" element-loading-text="正在查询中。。。" border fit highlight-current-row>

      <el-table-column type="expand" />

      <el-table-column align="center" label="设计稿ID" prop="id" />

      <el-table-column align="center" property="iconUrl" label="设计稿">
        <!-- <template slot-scope="scope">
          <el-image :src="thumbnail(scope.row.picUrl)" :preview-src-list="toPreview(scope.row, scope.row.picUrl)" style="width: 40px; height: 40px" />
        </template> -->
      </el-table-column>

      <el-table-column align="center" label="对应图片ID" prop="" />

      <el-table-column align="center" property="iconUrl" label="图片">
        <!-- <template slot-scope="scope">
          <el-image :src="thumbnail(scope.row.picUrl)" :preview-src-list="toPreview(scope.row, scope.row.picUrl)" style="width: 40px; height: 40px" />
        </template> -->
      </el-table-column>

      <el-table-column align="center" label="用户id" prop="" />

      <el-table-column align="center" label="用户昵称" prop="" />

      <el-table-column align="center" label="状态" prop="" />

      <el-table-column align="center" label="操作" width="200" class-name="small-padding fixed-width">
        <!-- <template slot-scope="scope"> -->
        <el-button type="primary" size="mini">编辑</el-button>
        <el-button type="danger" size="mini">删除</el-button>
        <!-- </template> -->
      </el-table-column>

    </el-table>

  </div>
</template>

<style>
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
  /* .gallery {
    width: 80px;
    margin-right: 10px;
  }
  .goods-detail-box img {
    width: 100%;
  } */
</style>

<script>

</script>
