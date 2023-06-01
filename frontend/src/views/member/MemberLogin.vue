<template>
    <div>
        <form v-on:submit.prevent>
            <table class="loginBox">
                <tr>
                    <td>아이디</td>
                    <td><input type="text" placeholder="아이디" name="id" v-model="logininfo.id"></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="text" placeholder="비밀번호" name="password" v-model="logininfo.password"></td>
                </tr>
            </table>
            <button @click="goLogin">로그인</button>
            <button>회원가입</button>
        </form>
    </div>
</template>
<script>
import axios from 'axios';
export default {
    name:'loginMember',
    data() {
        return {
            logininfo: {
                id: '',
                password:''
            },
            userInfo: JSON.parse(localStorage.getItem("data")) || "",
        }
    },
    methods : {
        goLogin : function() {
            axios
                .post("/member/loginMember", this.logininfo)
                .then((result) => {
                    console.log(result.data);
                    this.goLogin=result.data;
                    localStorage.setItem('data', JSON.stringify(result.data));
                    alert("로그인 성공");
                    window.location.href="http://localhost:8087/"
                })
                .catch((error)=>{
                    console.log(error);
                    alert("로그인 실패");
                })
                .finally(() => {
                    console.log("finally");
                })

        }
    }
}
</script>
<style>
.loginBox{
    width: 300px;
    margin: auto;
    border: 1px solid black;
    border-collapse: collapse;
}
</style>