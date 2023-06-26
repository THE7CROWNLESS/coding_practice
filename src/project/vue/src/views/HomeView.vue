<template>
  <div class="home">
<!-- 3组件引入后，可以作为标签，整体显示。   <HelloWorld msg="Welcome to Your Vue.js App"/>   -->
    <Home></Home>
  </div>

</template>

<script>
// @ is an alias to /src
//2引入组件  import HelloWorld from '@/components/HelloWorld.vue'

import Home from "@/components/Home.vue";

export default {
  name: 'HomeView',
  components: {
    //1注册组件 HelloWorld
    Home
  }
}
</script>
