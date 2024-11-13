<template>
    <div class="content"  >
        <bg></bg>
        <navigator></navigator>
        <theader></theader>
        <mainContent></mainContent>
    </div>
</template>

<script>
    import bg from "../bg/bg";
    import navigator from "../navigator/navigator";
    import theader from "../theader/theader";
    import mainContent from '../main-content/main-content'
    export default {
        name: "blogindex",
        data(){
            return{
                // url: '',

            }
        },
        components:{
           bg, navigator,theader,mainContent
        },
        methods:{

        },
        created() {
            // this.url = 'http://shenmafuyun.xyz/wp-content/uploads/2020/09/v2-ebc6cb55874d5136c86ff3e63432175a_1440w.jpg'
        }
    }
</script>

<style scoped lang="less">
    .content{
        height: 100%;
        /*background: black;*/
    }


</style>
