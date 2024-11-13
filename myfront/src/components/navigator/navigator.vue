<template>
    <div class="navigator">
        <svg class="icon lefttop" aria-hidden="true" @click="back">
            <use xlink:href="#icon-faquan"></use>
        </svg>
        <ul>
            <li>
                <svg class="icon" aria-hidden="true">
                    <use xlink:href="#icon-ziyuan"></use>
                </svg>
                <router-link tag="span" to="/blogindex" style="cursor: pointer" class="index">首页</router-link>
            </li>
            <li>

                <svg class="icon" aria-hidden="true">
                    <use xlink:href="#icon-quanbufenlei"></use>
                </svg>
                <router-link tag="span" to="/classify" style="cursor: pointer" class="classify">归档</router-link>


            </li>
            <li>

                <svg class="icon" aria-hidden="true">
                    <use xlink:href="#icon-quanbufenlei"></use>
                </svg>
                <router-link tag="span" to="/liuyan" style="cursor: pointer" class="classify">留言板</router-link>


            </li>
<!--            <li>-->

<!--                <svg class="icon" aria-hidden="true">-->
<!--                    <use xlink:href="#icon-guanyu"></use>-->
<!--                </svg>-->
<!--                <router-link tag="span" to="about" style="cursor: pointer" class="about">关于</router-link>-->
<!--            </li>-->
<!--            <li>-->

<!--                <svg class="icon" aria-hidden="true">-->
<!--                    <use xlink:href="#icon-lianjie1"></use>-->
<!--                </svg>-->
<!--                <router-link tag="span" to="friendList" style="cursor: pointer">友链</router-link>-->
<!--            </li>-->
        </ul>

    </div>
</template>

<script>
    export default {
        name: "navigator",
        data(){
            return{

            }
        },
        methods:{
            back(){
                this.$router.push('/')
            }
        }
    }
</script>

<style scoped lang="less">
    .navigator{
        position: relative;
        width: 100%;

        height: 60px;
        background: rgba(255,255,255,0.3);
        overflow: hidden;
        ul{
            display: flex;
            flex-direction: row;

            width: 80%;
            height: 60px;
            margin: 10px auto;
            li{
                display: flex;
                flex-direction: row;
                align-items: center;
                margin-right: 80px;
                /*background: black;*/
                height: 40px;

                span{

                    font-size: 20px;
                    color: black;
                    /*background-color: #eeeeee;*/
                    font-weight: bold;
                    margin-left: 10px;
                    /*background: red;*/

                }
            }
        }
    }
    .about:hover{
        /*font-color: skyblue;*/
        background: skyblue;

    }
    .index:hover{
        background: skyblue;

    }
    .classify:hover{
        background: skyblue;

    }
    .lefttop{
        position: absolute;
        left: 40px;
        top: 10px;
        color: red;
        transition: all 0.5s;
        cursor: pointer;
        /*background: black;*/
    }
    .lefttop:hover{
        transform: rotate(360deg);
    }
</style>
