<template>
    <div class="content">
        <leftContent></leftContent>
<!--        <transition name="fade" mode="out-in">-->
            <keep-alive include="classify">
           <router-view :key="key"></router-view>
            </keep-alive>
<!--        </transition>-->
<!--        <rightContent></rightContent>-->
    </div>
</template>

<script>
    import leftContent from '../left-content/left-content'
    import rightContent from '../right-content/right-content'
    export default {
        name: "main-content",
        data(){
            return{

            }
        },
        methods:{

        },
        components:{
            leftContent,rightContent
        },
        computed:{
            key(){
                return this.$route.path + Math.random()
            }
        }
    }
</script>

<style scoped lang="less">
.content{
    position: relative;
    display: flex;
    flex: 1;
    align-items: flex-start;
    height: 100%;
    width: 90%;
    /*background: red;*/
    margin: 0 auto;
}
.fade-enter-active, .fade-leave-active {
    transition: opacity 0.5s;
}
.fade-enter, .fade-leave-to {
    opacity: 0.3;
}
</style>