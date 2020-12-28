<template>
<div>
   <h1>Login</h1>
   <div class="form-col">

          <!-- <div class="col"> -->
            <input
              id = "in"
              type="text"
              class="form-control form-control-lg"
              v-model="credentials.username"
              name="email"
              placeholder="Email"
              style = "width: 300px"
            />
            <input
              id = "in"
              type="password"
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
import userStuff from "../../modules/user"


export default {
  name: "Login",

  setup (){
      var {loadUser, day, habits, score } = userStuff();

      const { login , auth, user} = useFirebaseAuth();
      const credentials = ref({
      username: "",
      password: "",
    });
      const doLogin = async () =>{
        login(credentials.value.username, credentials.value.password).then(()=>{
          loadUser(credentials.value.username).then(()=>{
            router.replace({name:'Home'})
          })
        })
      }

      return {
          credentials,
          doLogin
      }
  },
};
</script>

<style>
#in{
  width: 300px;
}
 
</style>