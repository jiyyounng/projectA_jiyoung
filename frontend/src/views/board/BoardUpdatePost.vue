<template>
    <form class="" v-on:submit.prevent>
        <table id="formBox">
            <tr>
                <td>제목</td>
                <td><input type="text" name="title" v-model="update.title" ></td>
            </tr>
            <tr>
                <td>내용</td>
                <td><textarea name="content" v-model="update.content"></textarea></td>
            </tr>
        </table>
        <button v-on:click="$router.go(-1)">취소</button>
        <button class="updateButton"  @click="goUpdate" >수정하기</button>
    </form>
</template>
<script>
import axios from "axios";

export default {
    name: 'boardEdit',
    data() {
        return {
            update: {
                no: '',
                title: this.$route.params.title,
                content: this.$route.params.content,
                date: ''
            }
        }
    },
    methods: {
        goUpdate: function() {
            if( !confirm("수정 하시겠습니까?")){
                return false;
            }
            axios
                .post("/board/update"  ,this.update, { params: { no:this.$route.params.no }} )
                .then((result) => {
                    this.goUpdate=result.data;
                    console.log(result.data);
                    alert("수정 완료!");
                    this.$router.push("/board/read?no="+ result.data );
                })
                .catch((error)=>{
                    console.log(error);
                    alert("수정 실패 ㅠ ㅠ");
                })
                .finally(() => {
                    console.log("finally");
                })
        }
    }
}
</script>
<style>
#formBox{
    width: 400px;
    height: 100px;
    margin: auto;
    border: 1px solid black;
    border-collapse: collapse;
}
input{
    border:none;
    width: 90%;
}
textarea{
    border:none;
    width: 90%;
}
.updateButton{
    margin-top: 20px;
}
</style>