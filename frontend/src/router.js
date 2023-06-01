import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "./views/HomeView.vue";
import AboutView from "./views/AboutView.vue";
import BoardList from "./views/board/BoardList.vue";
import BoardRegister from "./views/board/BoardRegister.vue";
import MemberJoin from "./views/member/MemberJoin.vue";
import MemberLogin from "./views/member/MemberLogin.vue";
import BoardViewPost from "./views/board/BoardViewPost.vue";
import BoardUpdatePost from "./views/board/BoardUpdatePost.vue";

Vue.use(VueRouter);
const router = new VueRouter({
   // mode: "history",
    routes: [
        {path:"/", component: HomeView},
        {path:"/about", component: AboutView},
        {path:"/board/list", component: BoardList},
        {path:"/board/register", component: BoardRegister},
        {path:"/board/read", component: BoardViewPost},
        {path:"/board/update", name:'boardEdit', component: BoardUpdatePost},
        {path:"/member/join", component: MemberJoin},
        {path:"/member/login", component: MemberLogin}

    ]
});

export default router