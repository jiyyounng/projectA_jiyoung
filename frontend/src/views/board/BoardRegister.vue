<template>
  <div>
      <form class="" v-on:submit.prevent>
          <table id="formBox">
              <tr>
                  <td>제목</td>
                  <td><input type="text" name="title" v-model="post.title" ></td>
              </tr>
              <tr>
                  <td>내용</td>
                  <td><textarea name="content" v-model="post.content"></textarea></td>
              </tr>
          </table>
          <button class="postButton"  @click="save" >POST</button>
      </form>
  </div>
</template>
<script>
import axios from "axios";
export default {
    data() {
        return {
            post: {
                no: '',
                title: '',
                content: '',
                date: ''
            },
        }
    },
    methods: {
        save : function() {
            if(!this.post.title || !this.post.content) {
                alert("내용을 모두 입력하세요");
                return true;
            }
            axios
                .post("/board/save", this.post)
                .then((result) => {
                    alert("게시글이 등록 되었습니다!");
                    console.log(result.data);
                    this.save=result.data;
                    this.$router.push("/board/list");
                })
                .catch((error)=>{
                    console.log(error);
                })
                .finally(()=>{
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
  .postButton{
      margin-top: 20px;
  }
</style>