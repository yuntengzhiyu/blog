<template>
    <div class="header">
        <div class="search">
            <input type="text" placeholder="Search" @click="click" @keyup.enter="blur" v-model="searchthis">
        </div>
        <div class="box">
<!--        <svg class="icon pos" aria-hidden="true">-->
<!--            <use xlink:href="#icon-yun"></use>-->
<!--        </svg>-->
        </div>
    </div>
</template>

<script>
    export default {
        name: "theader",
        data(){
            return{
                searchthis: '',

            }
        },
        methods:{
            click(){

            },
            async blur(){
                if(this.searchthis === ''){
                    this.$router.push('/blogindex').catch(()=>{})
                }
                else {
                    this.$router.push({
                        name: 'searchBlog',
                        query: {
                            searchtext: this.searchthis
                        }

                    }).catch(() => {
                    })
                }
                // const {data: res} = await this.$http.post('getArticleByContent',{
                //     content: this.searchthis
                // })
                // console.log(res)
                // this.$router.push({path: '/searchblog', query:{article: res.data}}).catch(()=>{})
            }
        }

    }
</script>

<style scoped lang="less">
.header{
    position: relative;
    width: 100%;
    height: 200px;
    /*background: red;*/
    /*border: 1px solid #eeeeee;*/
}
    .search input{

        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        width: 280px;
        height: 52px;
        background: rgba(255,255,255,0.3);
        outline: none;
        border: rgba(255,255,255,0.3) 1px solid;
        font-size: 20px;
        border-radius: 26px;
        text-align: center;
        transition: all 0.5s;
    }
    input::placeholder{
        color: white;
    }
    input:hover{
        width: 400px;
        background: rgba(255,255,255,0.8);

    }
    .box{
        position: absolute;
        left: 31%;
        top: 83%;
        font-size: 50px;
        transition: all 0.5s;
        /*background-color: black;*/
        cursor: pointer;
    }
    .box:hover{
        cursor: pointer;
        /*transform: rotate(359deg);*/
    }
</style>
