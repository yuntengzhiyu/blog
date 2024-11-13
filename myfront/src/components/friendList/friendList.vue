<template>
    <div class="box">
        <h2>友链</h2>
        <div class="line"></div>
        <div class="friend" v-for="item in list">
            <a :href="item.url">
                {{item.name}}
            </a>
        </div>
    </div>
</template>

<script>
    export default {
        name: "friendList",

        data(){
            return{
                list:[

                ]
            }
        },
        methods:{
            async getFriend(){
                const {data: res} = await this.$http.get('getFriend')

                this.list = res.data
            }
        },
        created() {
            this.getFriend()
        }
    }
</script>

<style scoped lang="less">
.box{
    position: relative;
    width: 85%;
    text-align: center;
    /*height: 200px;*/
    margin: 20px auto;
    background: white;
    border-radius: 40px;
    padding-top: 1px;
    h2{
        margin-top: 15px !important;
    }
    .line{
        width: 85%;
        margin: 10px auto;
        height: 0px;
        border-top: 3px solid black;
    }
    .friend{
        /*background: black;*/
        display: inline-block;
        padding: 5px;
        margin: 5px;
        font-size: 20px;
        /*border: 1px solid #eeeeee;*/
        opacity: 0.8;
        border: 1px solid black;
        /*box-shadow: 5px 5px 5px #eee;*/

    }
    .friend:hover{
        background-color: yellow;

    }
}
</style>