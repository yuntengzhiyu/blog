<template>
    <div class="left-content">
        <userInfo></userInfo>
        <tags></tags>
        <friendList></friendList>
    </div>
</template>

<script>
    import userInfo from "../user-info/userInfo";
    import tags from "../tags/tags";
    import friendList from "../friendList/friendList";
    export default {
        name: "left-content",
        data(){
            return{

            }
        },
        components:{
            userInfo, tags,friendList
        }
    }
</script>

<style scoped lang="less">
.left-content{
    position: relative;
    width: 32%;
    height: 100%;
    /*border: 1px solid #eeeeee;*/
    /*background-color: black;*/
    margin-left: 0;
}
</style>