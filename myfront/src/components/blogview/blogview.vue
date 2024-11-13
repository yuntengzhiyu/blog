<template>
    <div class="content">
        <svg class="icon" aria-hidden="true" @click="back">
            <use xlink:href="#icon-faquan"></use>
        </svg>
        <div class="head">
            <h2>{{title}}</h2>
            <h3>{{time}}</h3>
            <span v-for="item in tag">{{item}}</span>
        </div>

            <div class="edit">
            <mavon-editor ref="md" :ishljs='true' codeStyle='atom-one-dark' v-model="content" :subfield='false' :editable='false' :toolbarsFlag='false'  defaultOpen="preview" :navigation='false'/>
            </div>


    </div>
</template>

<script>
    export default {
        name: "blogview",
        data(){
            return {
                content: '',
                author: '',
                tag: [],
                time: '',
                title: ''
            }
        },
        methods:{
            async getArticle(id){
                const{data: res} = await this.$http.get('getArticleById',{
                    params:{
                        id: id
                    }
                })

                this.content = res.data.content
                this.author = res.data.author
                this.tag = res.data.tag
                this.time = res.data.time
                this.title = res.data.title
            },
            back(){
                this.$router.go(-1)
            }
        },
        created() {
            this.getArticle(this.$route.query.id)
        }
    }
</script>

<style scoped lang="less">
.content{
    position: relative;
    margin-top: 20px;
    border-radius: 50px;
    margin-bottom: 100px;
    display: flex;
    flex-direction: column;
    background: white;
    height: auto;
    padding-bottom: 50px;
    /*width: 100%;*/
    width: 100px;
    .head{
        margin-top: 50px;
        text-align: center;
        /*background: black;*/
        width: 100%;

        h2{
            font-size: 40px;
        }
        h3{
            margin-top: 10px;
            font-size: 25px;
            color: blue;
            margin-bottom: 10px;
        }
        span{
            background: skyblue;
            margin-left: 20px;
            font-size: 20px;
            border-radius: 10px;
            padding: 2px;
            opacity: 0.8;
        }
        span:hover{
            opacity: 1;
            box-shadow: 5px 5px 5px #eeeeee;
            cursor: pointer;
        }
    }

    .edit{
        margin-top: 20px;
        width: 100%;

    }
}
    .icon{
        position: absolute;
        left: 40px;
        top: 40px;
        color: red;
        transition: all 0.5s;
        cursor: pointer;
    }
    .icon:hover{
        transform: rotate(360deg);
    }
</style>