<template>
  <div id="app">

    <transition name="fade" mode="out-in">
        <keep-alive include="backend">
      <router-view></router-view>
        </keep-alive>
    </transition>
  </div>
</template>


<script>
   export default {
       name: 'app',

   }
</script>
<style lang="less">
/*@import url("/common/css/index.css");*/
    #app{
        height: 100%;

    }
.fade-leave-to{
    opacity:0.1;
}

.fade-leave-active{
    transition: 0.3s all ease;
}
</style>
