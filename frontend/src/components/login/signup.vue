<template>
<div>
   <h1>Signup</h1>
   <div class="form-col">

          <!-- <div class="col"> -->
            <input
              type="text"
              class="form-control form-control-lg"
              v-model="credentials.username"
              name="username"
              placeholder="Username"
            />
            <input
              type="text"
              class="form-control form-control-lg"
              v-model="credentials.password"
              name="password"
              placeholder="Password"
            />
          <!-- </div> -->

        
        <div class="form-col">
          <input
            type="submit"
            value="Submit"
            class="btn btn-primary"
            @click="doSignUp"
            style="width: 200px"
          />
        </div>
      </div>
</div>
</template>

<script>
import {useRoute, useRouter} from 'vue-router';
import { ref, onErrorCaptured } from "vue";
import router from '../../router/index'
import useFirebaseAuth from "../../modules/firebaseauth"


export default {
  name: "Signup",

  setup (){
      const credentials = ref({
      username: "",
      password: "",
    });
      const doSignUp = async () =>{
        //   console.log(credentials.value.username)
        await signup(credentials.value.username, credentials.value.password)
        router.replace({path : "/login"});
    }
        const { signup } = useFirebaseAuth();

      return {
          credentials,
          doSignUp
      }
  },
};
</script>

<style>
 .habit-btn{
        padding: 5px;
        text-align: center;
    }

    .is-complete {
        text-decoration: line-through;
        opacity: 0.6;
    }
  
</style>