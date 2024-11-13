<template>
    <div class="content">

        <svg class="icon" aria-hidden="true" @click="back">
            <use xlink:href="#icon-faquan"></use>
        </svg>
        <div class="left">
            <el-button v-for="(item,index) in month" @click="getArticleByMonth(item)" type="primary" :key="index" :style="{backgroundColor: item==select?'bisque':'skyblue'}">
                {{item}}
            </el-button>
        </div>
        <div class="right">

<!--            <router-view></router-view>-->

        <el-timeline :reverse="false" v-if="show">
<!--            <transition-group name="f">-->
            <transition-group name="slide">
            <el-timeline-item
                    v-for="(item, index) in article"
                    :key="index"
                    :timestamp="item.time" placement="top">
               <el-card>
                   {{item.title}}
                   <el-button @click="toarticle(item.id)" type="primary">-></el-button>
               </el-card>
            </el-timeline-item>
            </transition-group>


<!--            </transition-group>-->
        </el-timeline>

        </div>
    </div>
</template>

<script>
    export default {
        name: "classify",
        data(){
            return{
                show: false,
                month:[

                ],
                article:[

                ],
                select: ''
            }
        },
        methods:{
            toarticle(id){

                this.$router.push({path: '/blogview', query:{id: id}})
            },
            async getMonth(){
                const{data: res} = await this.$http.get('getMonth')
                this.month = res.data
                console.log(this.month)
            },
            async getArticleByMonth(name){
                this.select = name
                window.sessionStorage.setItem("month",name)
                this.show = true
                const{data: res} = await this.$http.get('getArticleByMonth',{
                    params:{
                        month: name
                    }
                })
                this.article = res.data
            },
            // toRight(name){
            //     this.$router.push({
            //         path: '/classifyRight',
            //         query:{name: name}
            //     })
            // },
            back(){
                window.sessionStorage.removeItem("month")
                this.$router.push('/blogindex')
            }
        },
        created() {
            this.getMonth()
            if(window.sessionStorage.getItem("month") != null ){
                this.getArticleByMonth(window.sessionStorage.getItem("month"))
                this.select = window.sessionStorage.getItem("month")
            }

        }


    }
</script>

<style scoped lang="less">

.content{
    /*position: relative;*/
    margin-top: 20px;
    /*background-color: white;*/
    border-radius: 30px;
    /*height: 1000px;*/
    /*min-height: 100%;*/

    .left{
        /*background: red;*/
        width: 35%;
        /*height: 100%;*/
        padding-top: 20px;
        margin-top: 60px;



        padding-bottom: 30px;
        /*display: flex;*/
        /*flex-wrap: wrap;*/
        /*flex: 1;*/
        .el-button{
            margin-left: 10%;
            /*margin-right: 1px;*/
            width: 80%;
            margin-top: 10px;
            background-color: skyblue;
            border-radius: 40px;
            color: black;
        }
        .el-button:hover{
            background-color: bisque;
        }
    }
    .right{
        /*background: red;*/
        width: 50%;
        margin-top: 20px;
        margin-left: 30px;
    }
    .el-timeline{
        /*height: 0;*/
        /*overflow: hidden;*/

        margin-top: 50px;

        .el-timeline-item{

            height: 100px;

            .el-card{
                border-radius: 30px;
                background: #eeeeee;
                height: 60px;
                font-weight: bold;
                width: 90%;
                .el-button{
                    float: right;
                    background-color: #eeeeee;
                    width: 40px;
                    height: 30px;
                    font-size: 15px;
                    line-height: 5px;
                    color: black;
                }


            }
            .el-card:hover{
                    background: skyblue;
            }
        }

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

    .slide-enter, .slide-leave-to{
        transform: translateY(60px);
    }
    .slide-enter-active, .slide-leave-active {
        transition: all 0.5s;
    }
</style>