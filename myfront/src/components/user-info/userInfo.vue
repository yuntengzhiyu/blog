<template>
    <div class="user-info">
        <div class="card">
            <img src="timg1.jpg" alt="">
            <div class="head_outer">
                <router-link tag="img" class="head" src="touxiang.png"
                 to="/backend"></router-link>
<!--                <img class="head" src="http://shenmafuyun.xyz/wp-content/uploads/2020/09/hdImg_2372b132f59549666ba295a217ee0e0316011113644.jpg" alt="">-->

            </div>
<!--            div.username-->
            <div class="username">
                <h3>{{user.username}}</h3>
            </div>
            <div class="data">
                <ul>
                    <li>
                        <h4>文章</h4>
                        <h4>{{article}}</h4>
                    </li>
                </ul>
                <ul>
                    <li>
                        <h4>友链</h4>
                        <h4>{{friend}}</h4>
                    </li>
                </ul>
                <ul>
                    <li>
                        <h4>分类</h4>
                        <h4>{{classify}}</h4>
                    </li>
                </ul>
            </div>


            <div class="contact">
                <ul>
                    <li>
                        <a href="tencent://Message/?Uin=1264278219&amp;websiteName=q-zone.qq.com&amp;Menu=yes">
                        <svg class="icon" aria-hidden="true">
                            <use xlink:href="#icon-QQ1"></use>
                        </svg>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <svg class="icon" aria-hidden="true">
                                <use xlink:href="#icon-telegram"></use>
                            </svg>
                        </a>
                    </li>
                    <li>
                        <a href="https://github.com/">
                            <svg class="icon" aria-hidden="true">
                                <use xlink:href="#icon-githubb"></use>
                            </svg>
                        </a>
                    </li>
                    <li>
                        <a href="https://www.zhihu.com/signin?next=%2F">
                            <svg class="icon" aria-hidden="true">
                                <use xlink:href="#icon-zhihu"></use>
                            </svg>
                        </a>
                    </li>
                    <li>
                        <a href="https://www.bilibili.com/">
                            <svg class="icon" aria-hidden="true">
                                <use xlink:href="#icon-Bilibili"></use>
                            </svg>
                        </a>
                    </li>
                </ul>
            </div>


        </div>

    </div>
</template>

<script>
    export default {
        name: "userInfo",
        data(){
            return{
                user: {},
                article: 0,
                friend: 0,
                classify: 0
            }
        },
        methods:{
             async getUserInfo(){
                const {data: res} = await this.$http.get('getUserInfo',{
                    params:{
                        id: 0
                    }
                })

                this.article = res.data.articlenum
                this.friend = res.data.friendnum
                this.classify = res.data.classifynum
                this.user = res.data.user
            },
            async getdata(){
                const{data: res} = await this.$http.get('getData')

                this.article = res.data[0]
                this.friend= res.data[1]
                this.classify = res.data[2]
            }
        },
        created() {
            this.getdata()
            this.getUserInfo()
        }
    }
</script>

<style scoped lang="less">
.user-info{

}
    .card{
        position: relative;
        width: 85%;
        text-align: center;
        /*height: 200px;*/
        margin: 20px auto;
        background: white;
        border-radius: 40px;
        img:nth-child(1){
            height: 100px;
            width: 100%;

            border-radius: 40px 40px 20px 20px;
        }
        .head_outer{
            position: relative;
            .head{
                cursor: pointer;
                display: flex;
                flex-direction: column;
                position: absolute;
                width: 100px;
                height: 100px;
                /*top: 50%;*/
                /*left: 50%;*/
                /*transform: translateY(-50%,-50%);*/
                left: 50%;
                border-radius: 50%;
                transform: translate(-50%,-50%);
                border: 1px solid #eeeeee;
                transition: all 0.5s;

            }
            .head:hover{
                transform: translate(-50%,-50%) rotate(360deg);
            }

        }
        .username{
            margin: 60px auto 10px;
        }
    }
    .data{
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        /*background: black;*/
        width: 80%;
        margin: 0 auto;

        ul{

            li{
                h4{
                    margin-top: 5px;
                }
            }
        }
    }
    .contact{

        /*background: black;*/
        width: 90%;
        margin: 20px auto;
        ul{
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            li{
                margin-bottom: 20px;
            }
        }
    }
</style>
