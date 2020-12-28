<template>
<div>
   <h1>Login</h1>
   <div>
     <textarea v-model = "this.stuff"/>
   </div>
   <div>
     <button class = "btn btn-primary" @click = "get">GET</button>
   </div>
</div>
</template>

<script>
import {useRoute, useRouter} from 'vue-router';
import { ref, onErrorCaptured } from "vue";
import axios from "axios"

export default {
  name: "TestApi",
  data(){
    return {
      stuff :"",
      username : "matthiasling@uchicago.edu"
    }
  },
  
  methods : {
    async get () {
         console.log("Getting the user")
    axios
    .get("http://localhost:8080/user/"+this.username)
    .then((res) => {
      console.log("donion rings")
      console.log(res)
      this.stuff = res.data.email
    })
    .catch((err) => console.log(err));
  

    }
  },
};
</script>

<style>
#in{
  width: 300px;
}
 
</style>