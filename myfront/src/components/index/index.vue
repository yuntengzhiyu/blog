<template>
    <div class="content">
<!--        头像-->
        <div class="bg" >
            <!--<img :src="this.userbackground" alt="">-->
            <img src="timg1.jpg" alt="">
        </div>
        <div class="box">

            <!--        名言-->
            <router-link tag="div" class="img" :to="{path: '/blogindex'}">

            </router-link>

            <div class="moto">
                一花一世界， 一树一菩提
            </div>
            <!--        经常去的网站-->
            <div class="website">
                <ul>
                    <li>
                        <a href="https://music.163.com/">
                            <svg class="icon" aria-hidden="true">
                                <use xlink:href="#icon-netease-cloud-music-fill"></use>
                            </svg>
                        </a>

                    </li>
                    <li>
                        <a href="https://twitter.com/">
                        <svg class="icon" aria-hidden="true">
                            <use xlink:href="#icon-twitter"></use>
                        </svg>
                        </a>

                    </li>
                    <li>
                        <a href="https://www.youtube.com/">
                        <svg class="icon" aria-hidden="true">
                            <use xlink:href="#icon-youtube"></use>
                        </svg>
                        </a>

                    </li>
                    <li>
                        <a href="https://weibo.com/">
                        <svg class="icon" aria-hidden="true">
                            <use xlink:href="#icon-xinlangweibo"></use>
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
        name: "index",
        data(){
            return{
                userbackground: ''
            }
        },
        methods:{
            async getUser(){
                const {data: res} = await this.$http.get('getUserById',{
                    params:{
                        id: 0
                    }
                })

                this.userbackground = res.data.userbackground
            }
        },
        created() {
            this.getUser()
        }
    }
</script>

<style scoped lang="less">
    @keyframes jump {
        0%{
            top: 40%;
            opacity: 0;
        }

        100%{
            top: 55%;
            opacity: 1;
        }
    }
.content{
    height: 100%;
}
.bg{

    /*background: url("http://localhost:8080/getImage");*/
    /*background: url("https://luckyclover.top/myapi/blog/getImage");*/
    height: 100%;

    filter: blur(4px);
    img{
        width: 100%;
        height: 100%;
    }

}
.box{
    position: absolute;
    top: 55%;
    left: 50%;
    /*margin: 100p auto;*/
    transform: translate(-50%, -50%);
    width: 510px;
    height: 400px;
    /*background: black;*/
    overflow: hidden;
    animation-name: jump;
    animation-duration: 3s;

    .img{
        cursor:pointer;
        margin: 0 auto;
        width: 130px;
        height: 130px;
        border: 2px solid #eeeeee;
        background: url("../../common/touxiang.png") no-repeat center center;
        background-size: 100%;
        transition: transform 0.8s;
        border-radius: 50%;

    }
    .img:hover{
        transform:  rotate(360deg);
    }
    .moto{
        margin: 20px auto;
        width: 500px;
        height: 60px;
        background: yellow;
        text-align: center;
        padding-top: 15px;
        font-size: 20px;
        border-radius: 30px;
    }
    .website{
        width: 300px;
        margin: 20px auto;

        ul{
            display: flex;
            flex-direction: row;
            justify-content: space-between;

        }
    }
}
</style>
