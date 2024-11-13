<template>
    <div class="content">
        <h2>撰写新文章</h2>
        <div class="input">
            <div class="input-left">
                <el-input
                        placeholder="请输入标题"
                        v-model="article.title"
                        clearable>
                </el-input>

                <el-input
                        placeholder="请输入标签，用逗号分割"
                        v-model="article.tags"
                        clearable>
                </el-input>
            </div>


            <div class="input-right">
                <el-select v-model="article.classify" placeholder="请选择分类">
                    <el-option
                            :key="item.name"
                            v-for="item in classify"
                            :label="item.name"
                            :value="item.name"
                    >
                    </el-option>
                </el-select>
                <p class="addclass" @click="addC">
                    <a>+添加分类</a>
                </p>
                <el-input class="addClassify" v-if="showAdd"
                          placeholder="分类名称"
                          v-model="article.classify"
                          clearable
                          @keyup.enter.native="successAddC" >
                </el-input>
            </div>
            <el-button type="primary" @click="send">发布</el-button>





        </div>
        <div class="edit">
            <mavon-editor v-model="article.content" :ishljs='true' :subfield='true' ></mavon-editor>
        </div>



<!--        <mavon-editor ref="md" :ishljs='false' codeStyle='atom-one-dark' v-model="test" :subfield='false' :editable='false' :toolbarsFlag='false'  defaultOpen="preview" :navigation='true'/>-->

    </div>
</template>

<script>
    export default {
        name: "writeArticle",
        data(){
            return{
                showAdd: false,
                // theClassifyName: '',
                classify: [],
                article:{
                    title: '',
                    tags: '',
                    classify: '',
                    content: ''
                },


            }
        },
        methods:{
            addC(){
                this.showAdd = true
            },
            successAddC(){

            },

            async send(){
                const {data: res} = await this.$http.post('addArticle',this.article)

                if(res.statu === 200) {
                    this.$message.success("成功添加文章")
                    // this.$router.push('/backend/allArticle')
                    this.article = {}
                }
                else this.$message.error("添加文章失败")
            },
            async getAllClassify(){
                const {data: res} = await this.$http.get('getAllClassify')
                this.classify = res.data
            },
        },
        created() {
            this.getAllClassify()
        }
    }
</script>

<style scoped lang="less">
.content{
    height: 100%;
    overflow-y: auto;
    h2{

        margin-left: 30px;
        margin-bottom: 10px;
        font-size: 30px;
    }
    .el-input{
        width: 500px;
        margin: 5px 30px;
        border-radius: 10px;
    }
    .el-select{
        margin-left: 20px;
    }
    .addclass{
        /*margin-left: 600px;*/
        font-size: 12px;
        color: blue;
        font-weight: bold;
        cursor: pointer;
        margin-left: 10px;
        /*margin-top: 5px;*/
    }

    .input{
        display: flex;
        flex-direction: row;
        /*background-color: black;*/
        width: 80%;

        .input-left{
            width: 50%;
            /*background-color: red;*/
            display: flex;
            flex-direction: column;
            padding-right: 20px;
            .el-input{
                margin-bottom: 10px;
                width: 90%;
            }
        }
        .input-right{
            width: 20%;
            display: flex;
            /*background-color: yellow;*/
            flex-direction: column;
            /*background-color: black;*/

            .el-select{
                margin-left: 0;
            }
            .addClassify{
                margin-left: 0;
                width: 100%;
            }
        }
        .el-button{
            width: 10%;
            height: 10%;
            margin-left: 50px;
        }
    }

}
    .edit{
        width: 90%;
        margin-left: 30px;
        margin-top: 20px;
    }
    .el-pagination{
        margin-bottom: 20px;
    }
</style>