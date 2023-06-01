import Vue from 'vue'
import App from './App.vue'
import router from './router'
//import axios from 'axios'


Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')

//const app = Vue(App)
//app.config.globalProperties.$axios = axios;  //전역변수로 설정 컴포넌트에서 this.$axios 호출할 수 있음
//app.config.globalProperties.$serverUrl = '//localhost:8087' //api server
//app.use(router).mount('#app')












