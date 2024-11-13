<template>
    <div class="content">
<!--        <div :style="{backgroundImage: 'url(http://localhost:8085/random/test)'}"></div>-->
        <div class="style">
            <h2>更改文章背景图风格</h2>
            <el-radio v-model="op" :label="0">动漫</el-radio>
            <el-radio v-model="op" :label="1">风景</el-radio>
            <el-button type="primary" @click="save">保存</el-button>
        </div>
        <h2>更改用户背景图片</h2>
        <el-upload
                class="upload-demo"
                :action="uploadAdd"
                :on-remove="handleRemove"
                :on-success="successload"
                :http-request="upLoad"
                list-type="picture">
            <el-button size="small" type="primary">点击上传</el-button>
        </el-upload>
    </div>
</template>

<script>
    export default {
        name: "PersonalSetting",
        data(){
            return{
                formdata:{
                    token: '',
                    file: '',
                },
                key: '',
                uploadAdd: 'http://upload.qiniup.com/',
                op: '1'
            }
        },
        methods:{
            handleRemove(file, fileList) {

            },
            async getToken(){
                const {data: res} = await this.$http.get('getToken')
                this.formdata.token = res.data
            },
            async upLoad(req){
                 // console.log("haha")
                this.formdata.file = req.file
                 let data = new FormData()
                 data.append("token",this.formdata.token)
                 data.append("file",this.formdata.file)
                 const {data: res} = await this.$http.post(this.uploadAdd, data).catch(()=>{
                     this.$message.error("添加失败")
                 })

                 this.key = res.key
                 this.$message.success("添加成功")
                 this.updateUser()       //更新用户的背景图片地址
            },
            async updateUser(){
                const {data: res} =await this.$http.get('updateUserBackground',{
                    params:{
                        userbackground: "http://img1.shenmafuyun.xyz/" + this.key,
                        id: 0
                    }
                })
                // console.log(res)
            },
            async successload(){


            },
            async getUser(){
                const {data: res } = await this.$http.get('getUserById',{
                    params:{
                        id: 0
                    }
                })
                // console.log(res)
                this.op = res.data.userstyle
            },
            async save(){

                const {data: res} = await this.$http.get('updateUserStyle',{
                    params:{
                        id: 0,
                        userstyle: this.op
                    }
                })
                if(res.statu === 200){
                    this.$message.success("更新成功")
                }
            }



        },
        created(){
            this.getToken()
            this.getUser()
        }
    }
</script>

<style scoped lang="less">
.content{
    margin-top: 0px;
    margin-left: 40px;
    .style{

        h2{
            margin-bottom: 10px;
            .el-radio{
                font-size: 20px !important;
            }
        }
    }
    h2{
        margin-top: 20px;
    }
    .upload-demo{
        /*margin-top: 20px;*/
        margin-top: 20px;
        width: 30%;
    }
}
</style>