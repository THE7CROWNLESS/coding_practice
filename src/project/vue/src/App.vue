<template>
  <div id="app">
<!--页面上的链接，链接到某一页面中（vue文件）
          <router-link to="/">Home</router-link> |
          <router-link to="/about">saa</router-link>-->

<!-- router-view 当你的(index.js文件中)路由path 与访问的地址相符时，会将指定的组件替换该 router-view-->
    <router-view/>
  </div>
</template>
