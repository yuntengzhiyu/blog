<template>
    <div class="tags">
        <h2>标签</h2>
        <div class="line"></div>

<!--        <div class="tagList" v-for="(item,index) in obj" :style="{backgroundColor: color[index]}">-->
<!--            {{item.name}} ( {{item.number}} )-->
<!--        </div>-->
        <div class="box">
        <div tag="div" class="tagList" v-for="(item,index) in obj" :key="index" :style="{backgroundColor: color[index]}" @click="toTagList(item.name)" >
            {{item.name}} ( {{item.count}} )
        </div>
        </div>
    </div>
</template>

<script>
    import {rainbowColor} from '../../common/js/util'
    export default {
        name: "tags",
        data(){
            return{
                color: [],
                obj: [

                ]
            }
        },
        created() {

            this.getTagData()

        },
        methods:{
            async getTagData(){
                const {data: res} = await this.$http.get('getTagData')
                // console.log(res)
                this.obj = res.data
                this.color = rainbowColor(this.obj.length, 50, 255)
            },
            toTagList(name){
                this.$router.push('/taglist?tagname=' + name).catch(()=>{})
            }
        },

    }
</script>

<style scoped lang="less">
.tags{
    width: 85%;
    height: auto;
    background: white;
    margin: 30px auto;
    border-radius: 20px;
    text-align: center;
    padding-top: 10px;
    /*display: flex;*/
    /*flex-direction: row;*/
    /*flex-wrap: wrap;*/
    /*padding-left: 20px;*/
    .line{
        width: 85%;
        margin: 10px auto;
        height: 0px;
        border-top: 3px solid black;
    }
    .box{
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        padding-left: 20px;
    }
    .tagList{
        background: black;
        display: inline-block;
        padding: 5px;
        margin: 5px;
        font-size: 20px;
        border: 1px solid #eeeeee;
        opacity: 0.8;
        /*box-shadow: 5px 5px 5px #eee;*/

    }
    .tagList:hover{
        opacity: 1;
        /*opacity: revert;*/
        cursor: pointer;
        box-shadow: 5px 5px 5px black;
    }
}

</style>