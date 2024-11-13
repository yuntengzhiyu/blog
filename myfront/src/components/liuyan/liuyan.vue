<template>
    <div class="liuyan">
        <el-card class="el-card-d" shadow="always">
            <div class="infinite-list-wrapper" style="overflow:auto;">
                <el-timeline
                        infinite-scroll-disabled="disabled">
                    <div v-if="liuyan.length>0">
                        <el-timeline-item v-for="(item,index) in liuyan"  :key="index" :timestamp='item.time' placement="top">
                            <el-card class="el-card-m" style="height:120px">
                                <h4>{{item.username}}：</h4>
                                <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{item.content}}</p>
                            </el-card>
                        </el-timeline-item>
                    </div>
                    <div v-else>
                        <el-timeline-item placement="top">
                            <el-card class="el-card-m" style="height:120px">
                                <h4>shenmafuyun：</h4>
                                <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 说点什么吧😁</p>
                            </el-card>
                        </el-timeline-item>
                    </div>
                </el-timeline>
            </div>
            <div class="el-card-messages">

                <el-input type="textarea" :rows="5" placeholder="输入留言" maxlength="200" v-model="content"></el-input>
                <el-input type="textarea" :rows="1" placeholder="输入用户名" maxlength="200" v-model="username"></el-input>
                <el-button type="info" round class="submit-message" @click="addLiuyan">留言</el-button>
            </div>
        </el-card>


    </div>
</template>

<script>
    export default {
        name: "liuyan",
        data(){
            return{
                liuyan: [],
                content: '',
                username: 'fuyun'

            }
        },
        methods:{

            async getLiuyan(){
                const {data: res} = await  this.$http.get("getLiuyan")

                this.liuyan = res.data
                console.log(this.liuyan)
            },
            async addLiuyan(){
                const {data: res} = await this.$http.post('addLiuyan',{
                    username: this.username,
                    content: this.content
                })
                this.getLiuyan()
            }
        },
        created() {
            this.getLiuyan()
        }
    }
</script>

<style scoped>
    .liuyan{
        margin-top: 20px;
        /*background-color: white;*/
        border-radius: 30px;
        background: white;
        height: auto;
        width: 65%;
    }
    .infinite-list-wrapper{
        width: 100%;

    }
    .submit-message{
        width: 100%;
        background: rgb(235, 245, 247);
        color: cadetblue;
        letter-spacing:20px;
    }

</style>
