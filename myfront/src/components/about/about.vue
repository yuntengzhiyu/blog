<template>
    <div class="content">
        <svg class="icon" aria-hidden="true" @click="back">
            <use xlink:href="#icon-faquan"></use>
        </svg>
        <span>关于作者</span>
    </div>
</template>

<script>
    export default {
        name: "about",
        data(){
            return{

            }
        },
        methods:{
            back(){
                this.$router.push('/blogindex')
            }
        }
    }
</script>

<style scoped lang="less">
.content{
    margin-top: 20px;
    background: white;
    height: 900px;
    border-radius: 30px;
    position: relative;
    span{
        position: absolute;
        left: 50%;
        transform: translate(-50%);
        margin-top: 40px;
        font-size: 30px;
    }
}
.icon{
    position: absolute;
    left: 40px;
    top: 40px;
    color: red;
    transition: all 0.5s;
    cursor: pointer;
}
.icon:hover{
    transform: rotate(360deg);
}
</style>