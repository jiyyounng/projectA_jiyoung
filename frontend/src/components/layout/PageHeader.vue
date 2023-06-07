<template>
   <div>
       <div v-if="userInfo === '' " id="member">
           <router-link to="/member/login">Login</router-link>  <span></span> |
           <router-link to="/member/join">Join</router-link>
       </div>
       <div v-else>
           <h4>{{userInfo.id}}님 환영합니다</h4>
           <button @click="goLogout">로그아웃</button>
       </div>
       <header>
           <div id="nav">
                   <router-link to="/">Home</router-link> |
                   <router-link to="/about">About</router-link> |
                   <router-link to="/board/list">Board</router-link>
           </div>
       </header>

       <hr />
   </div>
</template>
<script>
export default {
  name: "PageHeader",
    data(){
      return {
          userInfo: JSON.parse(localStorage.getItem("data")) || "",
      }
    },
    methods: {
      goLogout: function(){
          if( !confirm("로그아웃 하시겠습니까?")){
              return false;
          }
          localStorage.clear();
          alert("로그아웃 성공");
          window.location.href="http://localhost:8087/"
      }
    }

}
</script>