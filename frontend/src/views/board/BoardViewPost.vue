<template>
  <div>
      <h3>게시글 상세보기</h3>
      제목 : <span>{{ read.title }}</span> <br/>
      <input type="hidden" v-model="read.title">
      내용 : <span>{{ read.content }}</span> <br/>
      <input type="hidden" v-model="read.content">

      <button v-on:click="$router.push('/board/list')">목록으로</button>
      <button @click="updatePost">수정하기</button>
      <button @click="deletePost">삭제하기</button>

  </div>
</template>
<script>
import axios from "axios";

export default {
    data() {
        return {
            read: {
                no: '',
                title: '',
                content: '',
                date: ''
            }
        }
    },
    created(){
        this.boardRead()
    },
    methods: {
        boardRead() {
            axios
                .get("/board/read", { params: { no:this.$route.query.no }})
                .then((response) => {
                    this.read=response.data;
                    console.log(response.data);
                })
                .catch((error)=>{
                    console.log(error);
                })
                .finally(() => {
                    console.log("finally");
                })
        },
        updatePost: function(){
            this.$router.push({
                name: 'boardEdit',
                params: {no: this.read.no,
                        title: this.read.title,
                        content: this.read.content,
                        date: this.read.date
                }
            })
        },
        deletePost: function(){
            if( !confirm("삭제 하시겠습니까?")){
                return false;
            }
            axios
                .delete("/board/delete" , { params: { no:this.$route.query.no }})
                .then((response) => {
                    console.log(response);
                    this.read= response.data;
                    alert("삭제 완료!!");
                    this.$router.push("/board/list" );
                })
                .catch((error)=>{
                    console.log(error);
                    alert("삭제 실패 ㅠ ㅠ");
                })
                .finally(() => {
                    console.log("finally");
                })
        }
    }
}
</script>