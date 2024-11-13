<template>

    <div class="bg" :style="{backgroundImage: 'url(' + this.url + ')'}">

    </div>

<!--    <div class="bg" >-->

<!--    </div>-->
</template>

<script>
    export default {
        name: "bg",

        data(){
            return{
                 url : 'nv_wps.jpg'
                //url : 'http://121.41.122.156:1001/wp-content/uploads/2022/05/nv_wps.jpg'



            }
        },
        created(){

        },
        methods:{

        }
    }
</script>

<style scoped lang="less">

.bg {
    position: fixed;
    top: 0;
    height: 100%;
    width: 100%;
    overflow: hidden;
    background: no-repeat;
    background-size: cover;
    background-position-y: 100%;
    z-index: -1;
    /*filter: blur(5px);*/
}
</style>
