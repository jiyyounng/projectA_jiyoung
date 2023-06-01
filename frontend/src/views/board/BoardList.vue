<template>
    <div class="list">
        <table class="box1">
            <thead>
                <th>No</th>
                <th>Title</th>
                <th>Date</th>
            </thead>
            <tbody>
            <tr v-for="(list,index) in boardList" :key="list.no">
                <td>{{ index + 1 }}</td>
                <td v-on:click="$router.push('/board/read?no=' + list.no)"> {{ list.title }}</td>
                <td>{{ list.date }}</td>
            </tr>
            </tbody>
        </table>
        <button class="post" v-on:click="$router.push('/board/register')">New Post</button>
    </div>
</template>

<script>
import axios from "axios";
export default {
    data() {
        return {
            boardList: [],
        }
    },
    created() {
        this.BoardList();
    },
    methods: {
        BoardList() {
            axios
                .get("/board/list" )
                .then((result) => {
                    console.log(result.data);
                    this.boardList=result.data;
                })
                .catch((error)=>{
                    console.log(error);
                })
                .finally(() => {
                    console.log("finally");
            })
        },
    }
}
</script>

<style>
.box1 {
    width: 50%;
    height: 50%;
    margin: auto;
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    border: 1px solid black;
}
.post {
    margin-top: 10%;
    margin-left: 45%;
}

</style>