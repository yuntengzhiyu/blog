<template>
    <div class="content">
        <div class="top">
            <h2>My friend</h2>
            <el-button type="primary" @click="addFriendone">添加友链</el-button>
        </div>



        <el-table
                :data="friend" border stripe
                style="width: 90%">
            <el-table-column
                    type="index"
                    label="id"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="博客名称"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="url"
                    label="博客地址">
            </el-table-column>
            <el-table-column
                    prop="time"
                    label="添加时间">
            </el-table-column>
            <el-table-column

                    label="操作">
                <template slot-scope="scope">
                    <el-button type="primary" @click="updatethis(scope.row)">编辑</el-button>
                    <el-button type="danger" @click="deletethis(scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>


        <el-dialog title="友链" :visible.sync="dialogFormVisible">

            <el-form  label-width="80px" :model="form">
                <el-form-item label="博客名称">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="博客地址">
                    <el-input v-model="form.url"></el-input>
                </el-form-item>
                <el-form-item label="添加时间" >
                    <el-input v-model="form.time" :disabled="true"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="updateFriend">确 定</el-button>
            </div>
        </el-dialog>


        <el-dialog title="添加友链" :visible.sync="addVisible">

            <el-form  label-width="80px" :model="addFriend">
                <el-form-item label="博客名称">
                    <el-input v-model="addFriend.name"></el-input>
                </el-form-item>
                <el-form-item label="博客地址">
                    <el-input v-model="addFriend.url"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="addVisible = false">取 消</el-button>
                <el-button type="primary" @click="addFriendtwo">确 定</el-button>
            </div>
        </el-dialog>


        <el-dialog
                title="删除"
                :visible.sync="deletedialogVisible"
                width="30%">
            <span>确定删除么</span>
            <span slot="footer" class="dialog-footer">
    <el-button @click="deletedialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="deleteFriend">确 定</el-button>
  </span>
        </el-dialog>
    </div>


</template>

<script>
    export default {
        name: "friend",

        data(){
            return{
                deletedialogVisible: false,
                friend:[

                ],
                id: -1,
                dialogFormVisible: false,
                form:{
                    name: '',
                    url: '',
                    time: ''
                },
                addVisible: false,
                addFriend:{
                    name: '',
                    url: ''
                }
            }
        },
        methods:{
            async getfriend(){
                const {data: res} = await this.$http.get('getFriend')
                // console.log(this.res)
                this.friend = res.data
            },
            updatethis(config){
                this.dialogFormVisible = true
                this.form.name=config.name
                this.form.url = config.url
                this.form.time = config.time
                this.id = config.id
            },
            async deleteFriend(){
                const {data: res} = await this.$http.get('deleteFriend',{
                    params:{
                        id : this.id
                    }
                })
                if(res.statu == 200){
                    this.$message.success("删除成功")
                    this.getfriend()
                }else this.$message.error("删除失败")
                this.deletedialogVisible= false

            },
            async deletethis(config){
                this.id = config.id
                this.deletedialogVisible = true
            },
            async updateFriend(){
                const {data: res} = await this.$http.post('updateFriend',{
                    id: this.id,
                    name: this.form.name,
                    url: this.form.url
                })
                // console.log(res)
                if(res.statu === 200){
                    this.$message.success("更新友链成功")
                    this.getfriend()
                }
                else this.$message.error("更新友链失败")
                this.dialogFormVisible= false
            },
            addFriendone(){
                this.addVisible = true
            },
            async addFriendtwo(){
                const {data: res} = await this.$http.post('addFriend',{
                    name: this.addFriend.name,
                    url :this.addFriend.url
                })

                if(res.statu === 200){
                    this.$message.success("添加成功")
                }
                else this.$message.error("添加失败")
                this.addVisible =false
                this.addFriend.name = ''
                this.addFriend.url = ''
                this.getfriend()
            }

        },
        created() {
            this.getfriend()
        }
    }
</script>

<style scoped lang="less">
.content{
    /*background-color: black;*/

    h2{
        margin-left: 30px;
        margin-top: 10px;
    }
    .el-table{
        margin-left: 30px;
        margin-top: 20px;
    }
}
.top{
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    /*h2{*/
    /*    float: left;*/
    /*}*/
    /*.el-button{*/
    /*    float: right;*/
    /*}*/
    .el-button{
        margin-right: 100px;
    }
}
</style>