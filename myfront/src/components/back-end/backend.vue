<template>
    <el-container class="content">

        <el-header class="header">

            <div class="header-left">

                <svg  aria-hidden="true" class="icon back" @click="toblogindex">
                    <use xlink:href="#icon-faquan"></use>
                </svg>
<!--                <svg class="icon" aria-hidden="true">-->
<!--                    <use xlink:href="#icon-twitter"></use>-->
<!--                </svg>-->
                <h2 class="blog">博客管理</h2>
            </div>
            <div class="header-right">
                <el-button type="primary" @click="logout">退出</el-button>
            </div>
          </el-header>
        <el-container>
            <el-aside width="200px" class="aside">


                <el-menu router background-color="#545c64"
                         text-color="#fff"
                        :default-active="activePath"
                        class="el-menu-vertical-demo">
                    <el-menu-item index="/backend/welcome" @click="savePath1">
                        <i class="el-icon-menu"></i>
                        <span slot="title">仪表盘</span>
                    </el-menu-item>


                    <el-submenu index="2">
                        <template slot="title">
                            <i class="el-icon-location"></i>
                            <span>文章管理</span>
                        </template>

                        <el-menu-item index="/backend/allArticle"  @click="savePath2">
                            <i class="el-icon-menu"></i>
                            <span slot="title">查看文章</span>
                        </el-menu-item>
<!--                        <el-menu-item index="/backend/update" @click="savePath3">-->
<!--                            <i class="el-icon-menu"></i>-->
<!--                            <span slot="title">修改文章</span>-->
<!--                        </el-menu-item>-->
                        <el-menu-item index="/backend/write" @click="savePath4">
                            <i class="el-icon-menu"></i>
                            <span slot="title">增加文章</span>
                        </el-menu-item>
                    </el-submenu>
                    <el-menu-item index="/backend/friend" @click="savePath5">
                        <i class="el-icon-menu"></i>
                        <span slot="title">友链管理</span>
                    </el-menu-item>

<!--                    <el-menu-item index="/backend/setting" @click="savePath6">-->
<!--                        <i class="el-icon-menu"></i>-->
<!--                        <span slot="title">个人设置</span>-->
<!--                    </el-menu-item>-->

                </el-menu>






            </el-aside>
            <el-main class="main">

                <transition name="fade" mode="out-in">

                    <router-view ></router-view>

                </transition>

            </el-main>
        </el-container>
    </el-container>
</template>

<script>
    export default {
        name: "backend",
        data(){
            return{
                activePath: '/backend/welcome',
            }
        },
        methods:{
            savePath1(){
                sessionStorage.setItem("activePath","/backend/welcome")
                this.activePath = "/backend/welcome"
            },
            savePath2(){
                sessionStorage.setItem("activePath","/backend/allArticle")
                this.activePath = "/backend/allArticle"
            },
            savePath3(){
                sessionStorage.setItem("activePath","/backend/update")
                this.activePath = "/backend/update"
            },
            savePath4(){
                sessionStorage.setItem("activePath","/backend/write")
                this.activePath = "/backend/write"
            },
            savePath5(){
                sessionStorage.setItem("activePath","/backend/friend")
                this.activePath = "/backend/friend"
            },
            savePath6(){
                sessionStorage.setItem("activePath","/backend/setting")
                this.activePath = "/backend/setting"
            },
            logout(){
                sessionStorage.clear()
                this.$router.push('/blogindex')
            },

            toblogindex(){
                this.$router.push('/blogindex')
            }
        },
        created() {
            // console.log(this.$route.query.id)
            this.activePath = sessionStorage.getItem("activePath")
            // console.log(this.$route.path)
            this.activePath = this.$route.path

        },
        watch:{
            // "this.$route.path"(old){
            //     console.log(old)
            // }
        }
    }
</script>

<style scoped lang="less">
    .content{
        height: 100%;

    }
    .back{
        font-size: 40px !important;
        /*background-color: red;*/
        cursor: pointer;
        color: red;
        transition: all 0.5s;
        margin-right: 10px;
    }
    .back:hover{
        transform: rotate(360deg);
    }
.el-header{
    height: 80px !important;
    background: white;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    svg{
        font-size: 70px;
    }
    .header-left{
        display: flex;
        flex-direction: row;
        align-items: center;
        h2{
            margin-left: 10px;
            font-size: 30px;
        }
    }
    .header-right{
        display: flex;
        align-items: center;
        .el-button{
            margin-right: 20px;
        }
    }
}
    .aside{
        height: 100%;
        /*background: red;*/
        width: 200px !important;

    }
    .el-main{
        padding: 0 !important;
        /*background-color: black;*/
    }

    .fade-leave-to{
        opacity:0.1;
    }

    .fade-leave-active{
        transition: .5s all ease;
    }

    .el-menu{
        border-right: 0px;
    }
.blog{
    text-shadow:#FF0000 0 0 10px;
    color:white;
    font-size:60px
}

</style>
