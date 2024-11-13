<template>
    <div class="content">
<!--        <el-breadcrumb separator-class="el-icon-arrow-right">-->
<!--            <el-breadcrumb-item>文章管理</el-breadcrumb-item>-->
<!--            <el-breadcrumb-item>文章列表</el-breadcrumb-item>-->

<!--        </el-breadcrumb>-->

        <div class="search">
            <span>分类查询</span>
            <el-input @keyup.enter.native="getArticleByClassifyEnter(1)"
                      clearable
                    placeholder="请输入内容"
                    v-model="searchText">
                <i slot="prefix" class="el-input__icon el-icon-search"></i>
            </el-input>
            <el-button type="primary" @click="getArticleByClassify(1)">查询</el-button>
        </div>



        <el-table
                :data="article" stripe border
                style="width: 90%">
            <el-table-column type="expand">
                <template slot-scope="scope">
                    <ul class="expand">
                        <li v-for="(item,index) in scope.row.tag" :style="{backgroundColor: color[index]}">{{item}}</li>
                    </ul>
                </template>
            </el-table-column>

            <el-table-column
                    prop="title"
                    label="标题"
              >
            </el-table-column>
            <el-table-column
                    prop="classify"
                    label="分类"
                 >
            </el-table-column>
            <el-table-column
                    prop="time"
                    label="时间"
                  >
            </el-table-column>
            <el-table-column
                    prop="author"
                    label="作者"
                    >
            </el-table-column>
            <el-table-column

                    label="操作">
                <template slot-scope="scope">
                    <el-button type="primary" icon="el-icon-edit" @click="toupdate(scope.row)">编辑</el-button>
                    <el-button type="danger" icon="el-icon-delete" @click="Delete(scope.row)">删除</el-button>
                </template>
            </el-table-column>


        </el-table>




        <el-dialog
                title="删除"
                :visible.sync="dialogVisible"
                width="30%">
            <span>确定删除么</span>
            <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="DeleteArticle">确 定</el-button>
  </span>
        </el-dialog>




        <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="query.pagenum"
                :page-sizes="[5,10,15,20]"
                :page-size="query.pagesize"
                layout="total, sizes, prev, pager, next, jumper"
                :total="total">
        </el-pagination>
    </div>
</template>

<script>
    import {rainbowColor} from "../../common/js/util";

    export default {
        name: "all-article",

        data(){
            return{
                dialogVisible: false,
                searchText: '',
                articleString: '',
                article: [],
                id: 0,
                deleteId: -1,
                query:{
                    pagenum: 1,
                    pagesize: 10
                },
                total: 0,
                color: [],
                form: 0


            }
        },
        methods:{
            Delete(config){
                this.deleteId = config.id

                this.dialogVisible = true

            },
            handleSizeChange(pagesize){
                this.query.pagesize = pagesize

                if(this.form == 1)
                    this.getAllArticle(2)
                else if(this.form == 2)
                    this.getArticleByClassify(2)

            },
            handleCurrentChange(pagenum){
                this.query.pagenum = pagenum
                if(this.form == 1)
                    this.getAllArticle(2)
                else if(this.form == 2)
                    this.getArticleByClassify(2)
            },
            toupdate(config){

                this.$router.push('/backend/update?id=' + config.id)
            },
            async getAllArticle(number){
                if(number == 1) this.query.pagenum = 1

                const {data: res} = await this.$http.get('getArticleByPageNumRightContent',{
                    params:{
                        pagenum: this.query.pagenum,
                        pagesize: this.query.pagesize
                    }
                })

                this.article = res.data.article
                this.total = res.data.total
                this.color = rainbowColor(30, 200, 250)
                this.form = 1
            },

            async getArticleByClassify(number){
                if(number == 1) this.query.pagenum = 1

                if(this.searchText == ''){
                    this.getAllArticle()
                    this.form = 1
                }
                else {
                    const {data: res} = await this.$http.post('getArticleByClassify', {
                        classify: this.searchText,
                        pagenum: this.query.pagenum,
                        pagesize: this.query.pagesize
                    })

                    this.article = res.data.article
                    this.total = res.data.total
                    this.form = 2

                }

            },
            async getArticleByClassifyEnter(number){
                if(number == 1) this.query.pagenum = 1
                if(this.searchText == ''){
                    this.getAllArticle()
                    this.form = 1
                }
                else {

                    const {data: res} = await this.$http.post('getArticleByClassify', {
                        classify: this.searchText,
                        pagenum: this.query.pagenum,
                        pagesize: this.query.pagesize
                    })

                    this.article = res.data.article
                    this.total = res.data.total
                    this.form = 2
                }
            },
            async DeleteArticle(){
                const {data: res} = await this.$http.get('deleteArticle',{
                    params:{
                        id: this.deleteId
                    }
                })
                if(res.statu == 200){
                    this.$message.success("成功删除")
                }
                else this.$message.error("删除失败")
                this.dialogVisible = false
                this.getAllArticle()
            }

        },
        created() {
            this.getAllArticle()

        }
    }
</script>

<style scoped lang="less">
.content{
    overflow-y: auto;
    /*background-color: black;*/
    .el-breadcrumb{
        font-size: 18px;
        margin-left: 10px;
        margin-top: 10px;
    }
}
    .search{
        margin: 10px 40px;
        display: flex;
        flex-direction: row;
        align-items: center;
        span{
            font-size: 18px;
            margin-right: 10px;
        }
        .el-input{
            width: 300px;
        }
        .el-button{
            margin-left: 10px;
        }
    }
    .el-table{
        margin: 30px 40px;
    }
    .expand{
        display: flex;
        flex-direction: row;

        li{
            display: inline-block;
            height: 30px;
            background-color: skyblue;
            margin: 5px;
            text-align: center;
            padding-left: 10px;
            padding-right: 10px;
            padding-top: 5px;
            padding-bottom: 5px;
            border-radius: 15px;
        }
    }
    .el-pagination{
        margin-left: 40px;
        margin-bottom: 40px;
    }
</style>