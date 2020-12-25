<template>
<div>
   <h1>Login</h1>
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
            @click="doLogin"
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
  name: "Login",

  setup (){

      const { login } = useFirebaseAuth();
      const credentials = ref({
      username: "",
      password: "",
    });
      const doLogin = async () =>{
        await login(credentials.value.username, credentials.value.password)
        router.replace({path : "/"});
      }

      return {
          credentials,
          doLogin
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