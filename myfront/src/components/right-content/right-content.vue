<template>
    <div class="right-content">

        <div class="blog">
            <blogbox :index="item.id" v-for="item in article" :key="item.id"></blogbox>

        </div>
        <el-pagination
                @current-change="handleCurrentChange"
                :current-page.sync="query.Pagenum"
                :page-size="query.Pagesize"
                :total="total"
                layout="prev, pager, next"
                >
        </el-pagination>
    </div>
</template>

<script>
    import blogbox from "../blogbox/blogbox";
    export default {
        name: "right-content",
        data(){
            return{
                article: [],
                total: 0,
                query:{
                    Pagenum: 1,            //第几页
                    Pagesize: 10,         //一次访问几条数据
                }
            }
        },
        methods:{
            handleSizeChange(){

            },
            handleCurrentChange(pagenum){
                this.query.Pagenum = pagenum
                this.getArticle()
            },
            async getArticle(){
                const {data: res} = await this.$http.get('getArticleByPageNumRightContent',{
                    params:{
                        pagenum: this.query.Pagenum,
                        pagesize: this.query.Pagesize
                    }
                })
                this.article = res.data.article
                this.total = res.data.total
                console.log(res.data)
            },
        },
        components:{
            blogbox
        },
        created() {
            this.getArticle()
        }

    }
</script>

<style scoped lang="less">
.right-content{
    position: relative;
    /*border: 2px solid black;*/
    width: 68%;
    height: 100%;
    padding: 20px 15px;

    /*background-color: red;*/

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
