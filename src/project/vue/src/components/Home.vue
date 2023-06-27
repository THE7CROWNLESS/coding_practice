<script>
import {defineComponent} from 'vue'


export default defineComponent({
  name: "Home",
  data() {
    const item = {
      date: '2016-05-02',
      name: '王小虎',
      address: '上海市普陀区金沙江路 1518 弄'
    };
    return {
      tableData: Array(10).fill(item),
      collapseBtnClass: 'el-icon-s-fold',
      isCollaspe: false,
      sideWidth: 200
    }
  },
  methods: {
    collapse() {
      this.isCollaspe = !this.isCollaspe
      if (this.isCollaspe) {
        this.collapseBtnClass = 'el-icon-s-fold'
        this.sideWidth = 80
      } else {
        this.collapseBtnClass = 'el-icon-s-unfold'
        this.sideWidth = 200
      }
    }
  }
})
</script>

<!--页面代码-->
<template>
  <el-container style="height: 100vh">
    <el-aside :width="sideWidth + 'px'" style="background-color: rgb(48,65,86)">
      <div style="height: 40px; text-align: center;line-height: 40px; color: white;">
        <img src="../assets/logo.png" alt="" style="width: 20px;margin-right: 5px;position: relative; top: 5px">
        <b v-show=!isCollaspe>管理系统</b>
      </div>
      <el-menu :default-openeds="['1', '3']"
               style="min-height: 100%; overflow-x: hidden"
               background-color="rgb(48,65,86)"
               text-color="#fff"
               :collapse-transition="false"
               :collapse="isCollaspe"
      >
        <el-submenu index="1">
          <template slot="title"><i class="el-icon-message"></i>
            <span slot="tittle">导航一</span>
          </template>
          <el-menu-item-group>
            <template slot="title">分组一</template>
            <el-menu-item index="1-1">选项1</el-menu-item>
            <el-menu-item index="1-2">选项2</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group title="分组2">
            <el-menu-item index="1-3">选项3</el-menu-item>
          </el-menu-item-group>
          <el-submenu index="1-4">
            <template slot="title">选项4</template>
            <el-menu-item index="1-4-1">选项4-1</el-menu-item>
          </el-submenu>
        </el-submenu>
        <el-submenu index="2">
          <template slot="title"><i class="el-icon-menu"></i>
            <span slot="tittle">导航二</span>
          </template>
          <el-menu-item-group>
            <template slot="title">分组一</template>
            <el-menu-item index="2-1">选项1</el-menu-item>
            <el-menu-item index="2-2">选项2</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group title="分组2">
            <el-menu-item index="2-3">选项3</el-menu-item>
          </el-menu-item-group>
          <el-submenu index="2-4">
            <template slot="title">选项4</template>
            <el-menu-item index="2-4-1">选项4-1</el-menu-item>
          </el-submenu>
        </el-submenu>
        <el-submenu index="3">
          <template slot="title"><i class="el-icon-setting"></i>
            <span slot="title">导航三</span>
          </template>
          <el-menu-item-group>
            <template slot="title">分组一</template>
            <el-menu-item index="3-1">选项1</el-menu-item>
            <el-menu-item index="3-2">选项2</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group title="分组2">
            <el-menu-item index="3-3">选项3</el-menu-item>
          </el-menu-item-group>
          <el-submenu index="3-4">
            <template slot="title">选项4</template>
            <el-menu-item index="3-4-1">选项4-1</el-menu-item>
          </el-submenu>
        </el-submenu>
      </el-menu>
    </el-aside>

    <el-container>
      <el-header height="40px" style=" font-size: 12px;display: flex">
        <div style="flex: 1;font-size: 18px">
          <span :class="collapseBtnClass" style="cursor: pointer" @click="collapse"></span>
        </div>

        <el-dropdown style="width: 80px; cursor:pointer">
          <span>王小虎</span><i style="margin-left: 5px" class="el-icon-arrow-down"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>个人信息</el-dropdown-item>
            <el-dropdown-item>退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>

      </el-header>

      <el-main>
        <div>
          <el-breadcrumb separator="/">
            <el-breadcrumb-item><a href="/">首页</a></el-breadcrumb-item>
            <el-breadcrumb-item>活动列表</el-breadcrumb-item>
            <el-breadcrumb-item>活动详情</el-breadcrumb-item>
          </el-breadcrumb>
        </div>


        <!--        搜索框-->
        <div class="demo-input-suffix" style="display: flex;margin-top: 5px">
          <el-input
              style="width: 200px"
              placeholder="请输入日期"
              prefix-icon="el-icon-search"
              v-model="input1">
          </el-input>

          <el-input
              style="width: 200px;margin-left: 5px"
              placeholder="请输入姓名"
              prefix-icon="el-icon-search"
              v-model="input2">
          </el-input>

          <el-input
              style="width: 200px;margin-left: 5px"
              placeholder="请输入地址"
              prefix-icon="el-icon-search"
              v-model="input2">
          </el-input>

          <el-button style="margin-left: 5px;background-color: dodgerblue;color: whitesmoke;">搜索</el-button>

        </div>
        <!--        按钮操作-->
        <div style="margin-top: 10px">
          <el-button class="el-icon-plus" >新增</el-button>
          <el-button class="el-icon-minus" >删除</el-button>
          <el-button class="el-icon-edit" >修改</el-button>
          <el-button class="el-icon-edit-outline" >编辑</el-button>
        </div>
        <el-table :data="tableData">
          <el-table-column prop="date" label="日期" width="140">
          </el-table-column>
          <el-table-column prop="name" label="姓名" width="120">
          </el-table-column>
          <el-table-column prop="address" label="地址">
          </el-table-column>
          <el-table-column prop="operation" label="操作">
            <el-button type="warning">编辑 <i class="el-icon-edit-outline"></i></el-button>
            <el-button type="danger">删除 <i class="el-icon-delete"></i></el-button>
          </el-table-column>
        </el-table>

        <div class="block">
          <el-pagination

              :page-sizes="[5, 10, 15, 20]"
              :page-size="10"
              layout="total, sizes, prev, pager, next, jumper"
              :total="400">
          </el-pagination>
        </div>
      </el-main>

    </el-container>
  </el-container>

</template>


<style>
.el-header {
  background-color: whitesmoke;
  color: #333;
  line-height: 40px;

}

.el-menu {
  border: none !important;
}


</style>