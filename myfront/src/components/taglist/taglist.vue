<template>
    <div class="right-content">
        <div class="blog">
            <blogbox :index="item.id" v-for="item in article" :key="item.id"></blogbox>

        </div>

    </div>
</template>

<script>
    import blogbox from "../blogbox/blogbox";
    export default {
        name: "taglist",
        data(){
            return{
                tagname: '',
                article: []
            }
        },
        methods:{
            async getArticle(){
                const {data: res} = await this.$http.post('getArticleByTag',{
                    tagname: this.tagname
                })
                this.article = res.data

            }
        },
        components:{
            blogbox
        },
        created() {

            this.tagname = this.$route.query.tagname
            this.getArticle()
        },


    }
</script>

<style scoped lang="less">
    .right-content{
        position: relative;
        /*border: 2px solid black;*/
        width: 68%;
        height: 100%;
        padding: 20px 15px;

        /*align-content: flex-start;*/
    }
    .blog{
        display: flex;
        flex-direction: row;
        justify-content: space-around;
        flex-wrap: wrap;
    }
    .el-pagination{
        margin-bottom: 300px ;
        margin-top: 50px;
        /*background: black;*/
        text-align: center;
        /*font-size: 20px !important;*/

    }
</style>
