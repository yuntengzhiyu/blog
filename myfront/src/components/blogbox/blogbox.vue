<template>
    <div class="blog-box" @click="toBlog">
<!--        <div class="pic" :style="{backgroundImage: 'url(https://random.52ecy.cn/randbg.php/' + index + ')' }">-->

<!--        </div>-->
<!--        <div class="pic"></div>-->
<!--        <div class="pic" :style="{backgroundImage: 'url(https://www.rrll.cc/tuceng/ecy.php' + index + ')' }">-->

<!--        </div>-->

        <div class="pic" >
        </div>

        <div class="title" >
            <h2>{{blog.title}}</h2>
        </div>
        <div class="mask"></div>

        <div class="bottom">
            <div class="line"></div>
            <div class="time">
                <svg class="icon" aria-hidden="true">
                    <use xlink:href="#icon-shijian"></use>
                </svg>
                <span>{{blog.time}}</span>
            </div>
            <div class="data">
<!--                <ul>-->
<!--                    <li>-->
<!--                        <svg class="icon" aria-hidden="true">-->
<!--                            <use xlink:href="#icon-liulan"></use>-->
<!--                        </svg>-->
<!--                        <span>{{blog.view}}</span>-->
<!--                    </li>-->
<!--                    <li>-->
<!--                        <svg class="icon" aria-hidden="true">-->
<!--                            <use xlink:href="#icon-pinglun-active"></use>-->
<!--                        </svg>-->
<!--                        <span>{{blog.comments}}</span>-->
<!--                    </li>-->
<!--                    <li>-->
<!--                        <svg class="icon" aria-hidden="true">-->
<!--                            <use xlink:href="#icon-xihuan"></use>-->
<!--                        </svg>-->
<!--                        <span>{{blog.like}}</span>-->
<!--                    </li>-->
<!--                </ul>-->
            </div>
        </div>
    </div>
</template>

<script>

    export default {
        name: "blogbox",
        props:{
           index:{
               type:Number
           }
        },
        data() {
            return{
                blog: {},
                style: 0,
                url: '',
                wordColor: 'white'

            }
        },
        methods:{
            async getArticle(){
                const {data: res} = await this.$http.get('getArticleVOById',{
                    params:{
                        id: this.index
                    }
                })

                this.blog = res.data
                console.log(this.blog)
            },
            toBlog(){
                this.$router.push('/blogview?id=' + this.index)
            },
            // async getUser(){
            //     const {data: res} = await this.$http.get('getUserById',{
            //         params:{
            //             id: 0
            //         }
            //     })
            //     if(res.data.userstyle == 0){
            //
            //         this.url = 'url(' + this.$http.defaults.baseURL + 'getImage/0?t='
            //         // this.url = 'url(http://localhost:8080/getImage/0?t='
            //         this.wordColor = 'white'
            //     }
            //     else{
            //         // this.url = 'url(http://localhost:8080/getImage/1?t='
            //         this.url = 'url(' + this.$http.defaults.baseURL + 'getImage/1?t='
            //         this.wordColor = 'white'
            //     }
            //
            // }
        },
        created() {
            this.getArticle()
            // this.getUser()
        }

    }
</script>

<style scoped lang="less">
.blog-box{
    position: relative;
    width: 48%;
    height: 200px;
    background: rgba(0,0,0,0.2);
    margin-bottom: 20px;
    border-radius: 30px;
    overflow: hidden;
    cursor: pointer;
    /*transition: all 0.5s;*/
}
    .pic{
        width: 100%;
        height: 100%;
        background-size: cover;
        border-radius: 30px;
        opacity: 0.8;
        transition: all 0.5s;
    }
    .title{
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        color: white;
        font-size: 25px;
        font-weight: bold;
        transition: all 0.5s;
    }
    .mask {
        position: absolute;
        top: 0;
        width: 100%;
        height: 100%;
        transition: background-color 0.6s ease;
        background: rgba(#000000, 0.15);
        opacity: 1;
        border-radius: 30px;
    }
    /*}*/
.bottom{
    opacity: 0;
    transition: all 0.5s;
}
    .line{
        position: absolute;
        height: 0px;
        width: 100%;
        background: black;
        border: 1px solid #eeeeee;
        left: 0;
        bottom: 30px;
    }

    .time{

        position: absolute;

        /*left: 5px;*/
        bottom: 0;
        left: 50%;
        transform: translate(-50%);
        white-space: nowrap;
        display: flex;
        align-items: center;
        font-size: 20px;
        font-weight: bold;
        color: white;
        span{
            margin-left: 10px;
        }
        /*align-content: center;*/
    }
    .data{
        position: absolute;
        right: 10px;
        bottom: 0;
        float: right;
        font-size: 20px;
        font-weight: bold;
        ul{
            display: flex;
            /*flex-direction: row;*/

            li{
                display: flex;
                align-items: center;
                margin-left: 10px;

                span{
                    margin-left: 5px;
                }
            }
        }
    }
    .icon{
        font-size: 30px;
    }
    .blog-box:hover{

        .bottom{
            opacity: 1;
        }
        .title{
            top: 40%;
        }
        .pic{
            transform: scale(1.2);
            filter: blur(2px);
        }
    }
</style>