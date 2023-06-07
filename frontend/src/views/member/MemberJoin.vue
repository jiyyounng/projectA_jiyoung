<template>
    <div>
        <h3>회원가입</h3>
        <form class="" v-on:submit.prevent>
            <table id="formBox">
                <tr>
                    <td>아이디</td>
                    <td><input type="text" name="id" id="id" v-model="join.id" ></td>
                    <button @click="idCheck">중복확인</button>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="text" name="password" id="id" v-model="join.password"></td>
                </tr>
                <tr>
                    <td>비밀번호 중복확인</td>
                    <td><input type="text" name="password2" id="id" ></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><input type="text" name="email" id="id" v-model="join.email"></td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td><input type="text" name="name" id="id" v-model="join.name"></td>
                </tr>
                <tr>
                    <td>생년월일</td>
                    <td>
                            <input type="text" name="birth" id="id" v-model="join.birth">
                     <!--
                        <select name="birth" id="id2" v-model="join.birth">
                                <option value="">월</option>
                                <option value="1월">1월</option>
                                <option value="2월">2월</option>
                                <option value="3월">3월</option>
                                <option value="4월">4월</option>
                                <option value="5월">5월</option>
                                <option value="6월">6월</option>
                                <option value="7월">7월</option>
                                <option value="8월">8월</option>
                                <option value="9월">9월</option>
                                <option value="10월">10월</option>
                                <option value="11월">11월</option>
                                <option value="12월">12월</option>
                            </select>
                            <input type="number" placeholder="일" name="birth" id="id2" v-model="join.birth">
                            -->
                    </td>
                </tr>
                <tr>
                    <td>성별</td>
                    <td>
                        <input type="radio" value="남자" name="gender" id="id3" v-model="join.gender">남자
                        <input type="radio" value="여자" name="gender" id="id3" v-model="join.gender">여자
                    </td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td><input type="text" name="phone" id="id" v-model="join.phone"></td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td><input type="text" name="addr" id="id" v-model="join.addr"></td>
                </tr>
            </table>
            <button v-on:click="$router.push('/')">돌아가기</button>
            <button class="joinButton" @click="joinMember">회원가입</button>
        </form>
    </div>
</template>
<script>
import axios from "axios";
export default{
    data() {
        return {
            join: {
                id: '',
                password: '',
                email: '',
                name: '',
                birth:'',
                gender:'',
                phone: '',
                addr: ''
            }
        }
    },
    methods: {
        idCheck: function() {
            axios
                .get("/member/check", {params: { id:this.join.id}})
                .then((result) => {

                    if (result.data === true ) {
                        alert("이미 사용중인 아이디 입니다.");
                       // document.getElementById('id').value = '';
                        this.join.id='';
                    }else {
                        alert("사용 가능한 아이디 입니다.");
                       // document.getElementById('id').value= (this.join.id);
                    }

                })
                .catch((error)=>{
                    console.log(error);
                })
                .finally(()=>{
                    console.log("finally");
                })
        },
        joinMember: function(){
            if(!this.join.id  || !this.join.password || !this.join.email ||
                !this.join.name || !this.join.birth || !this.join.gender ||
                !this.join.phone || !this.join.addr) {
                alert("정보를 모두 입력해주세요");
                return true;
            }
            if( !confirm("계속 진행 하시겠습니까?")){
                return false;
            }
            axios
                .post("/member/joinMember", this.join)
                .then((result) => {
                    alert("회원가입이 완료 되었습니다.");
                    console.log(result.data);
                    this.joinMember=result.data;
                    this.$router.push("/member/login");
                })
                .catch((error)=>{
                    console.log(error);
                })
                .finally(()=>{
                    console.log("finally");
                })

            },

    }
}
</script>
<style>
#formBox{
    width: 500px;
    height: 100px;
    margin: auto;
    border: 1px solid black;
    border-collapse: collapse;
}
#id{
    border:none;
    width: 90%;
}
#id3{
    margin-right: 0;
    width:5%;
}
.joinButton{
    margin-top: 20px;
}
</style>
