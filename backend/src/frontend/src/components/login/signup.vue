<template>
<div>
   <h1 style ="margin-top:20px; margin-bottom:20px;">Sign Up</h1>
   <div class="form-col">

          <div class="col">
            <div>
            <input
            id ="in"
              type="text"
              class="form-control form-control-lg"
              v-model="credentials.username"
              name="email"
              placeholder="Email"
            />
            </div>
            <div>
            <input
            id ="in"
              type="password"
              class="form-control form-control-lg"
              v-model="credentials.password"
              name="password"
              placeholder="Password"
            />
            </div>
            <div>
            <input
            id ="in"
              type="password"
              class="form-control form-control-lg"
              v-model="credentials.password2"
              name="password2"
              placeholder="Confirm password"
            />
            </div>
          </div>
        <div v-if="credentials.err"
          style = "color:red; margin-top:10px"
        >
          {{credentials.err}}
        </div>
        
        <div class="form-col">
          <input
            type="submit"
            value="Sign up"
            class="btn btn-primary"
            @click="doSignUp"
            style="width: 250px; height: 60px; margin-top:10px"
          />
          <div style ="margin-top:15px">
        <router-link class = "link" to="/login">Already have an account?</router-link>
        </div>
        </div>
      </div>
</div>
</template>

<script>
import {useRoute, useRouter} from 'vue-router';
import { ref, onErrorCaptured } from "vue";
import router from '../../router/index'
import useFirebaseAuth from "../../modules/firebaseauth"
        const { signup } = useFirebaseAuth();


export default {
  name: "Signup",

  setup (){
      const credentials = ref({
      username: "",
      password: "",
      password2: "",
      err: "",
    });

      const check = function (){
        if (!credentials.value.username
            ||  !credentials.value.password
            || !credentials.value.password2
            ){
          credentials.value.err = "Please fill in all values"
          return false
        }
        
        if (credentials.value.password.length < 6){
          credentials.value.err = "Password must have length of 6 or more characters"
          return false;
        }

        if (credentials.value.password !== credentials.value.password2){
          credentials.value.err = "Passwords do not match"
          return false;
        }

        credentials.value.err = "";
        return true;

      }

      const doSignUp = async () =>{
        
        if (!check()){
          return;
        }
        credentials.value.err = "";
        await signup(credentials.value.username, credentials.value.password)
        
    }

      return {
          credentials,
          doSignUp
      }
  },
};
</script>

<style>
#form-col{
    text-align:center;
    
}
#in {
  width: 300px;
    margin:auto;
    margin-bottom: 10px;
}

</style>