<template>
    <div class="blog-content">
        <div class="blog">
               <blogbox :index="item.id" v-for="item in article" :key="item.id"></blogbox>
        </div>
    </div>
</template>

<script>
    import blogbox from "../blogbox/blogbox";
    export default {
        name: "searchBlog",
        data(){
            return{
                article: []
            }
        },
        methods:{
            async getArticle(searchthis){
                const {data: res} = await this.$http.post('getArticleByContent',{
                    content: searchthis
                })
                // console.log(res)
                this.article = res.data
            }
        },
        created() {
           this.getArticle(this.$route.query.searchtext)
        },
        components:{
            blogbox
        }
    }
</script>

<style scoped lang="less">
    .blog-content{
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
</style>