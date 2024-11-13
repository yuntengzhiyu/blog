<template>
    <div class="content">
        <h2>仪表盘</h2>
        <ul class="pic">
            <li style="background-color: skyblue">
                <svg class="icon" aria-hidden="true">
                    <use xlink:href="#icon-suoyouwenzhang"></use>
                </svg>
                <div>
                    <span>发表了</span>
                    <span>{{articlenum}}</span>
                    <span>篇文章</span>
                </div>
            </li>
            <li style="background-color: purple">
                <svg class="icon" aria-hidden="true">
                    <use xlink:href="#icon-pengyou"></use>
                </svg>
                <div>
                    <span>一共有</span>
                    <span>{{friendnum}}</span>
                    <span>个朋友</span>
                </div>
            </li>
            <li style="background-color: green">
                <svg class="icon" aria-hidden="true">
                    <use xlink:href="#icon-biaoqianyong"></use>
                </svg>
                <div>
                    <span>添加了</span>
                    <span>{{classifynum}}</span>
                    <span>个分类</span>
                </div>
            </li>
        </ul>
    </div>
</template>

<script>
    export default {
        name: "welcome",
        data(){
            return{
                articlenum: 0,
                friendnum: 0,
                classifynum: 0
            }
        },
        methods:{
            async getData(){
                const{data: res} = await this.$http.get('getData')

                this.articlenum = res.data[0]
                this.friendnum = res.data[1]
                this.classifynum = res.data[2]
            }
        },
        created() {
            this.getData()
        }
    }
</script>

<style scoped lang="less">
.content{


    /*background: red;*/
    overflow: hidden;
    h2{
        margin-top: 10px;
        margin-lefT: 10px;
    }
}
    .pic{
        display: flex;
        flex-direction: row;

        li{
            width: 280px;
            height: 140px;
            border-radius: 40px;
            /*background: blue;*/
            margin-left: 20px;
            margin-top: 20px;
            margin-right: 20px;
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            box-shadow: 0px 5px 5px #eeeeee;
            align-items: center;
            .icon{
                font-size: 60px;
                margin-left: 20px;
            }
            div{
                display: flex;
                flex-direction: column;
                margin-right: 20px;
                color: white;
                font-size: 20px;
                span:nth-of-type(2){
                    font-size: 30px;
                    color: yellow;
                }
            }
        }
    }
</style>
