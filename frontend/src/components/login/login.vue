<template>
  <div class="login-col">
     <h1 style ="margin-top:20px; margin-bottom:20px;">Log In</h1>
    <div class="form-col" >
      <!-- <div class="col"> -->
      <input
        id="in"
        type="text"
        class="form-control form-control-lg"
        v-model="credentials.username"
        name="email"
        placeholder="Email"       
      />
      <input
        id="in"
        type="password"
        class="form-control form-control-lg"
        v-model="credentials.password"
        name="password"
        placeholder="Password"
      />
      <!-- </div> -->

      <div id="form-col">
          <input
            type="submit"
            value="Log in"
            class="btn btn-primary"
            @click="doLogin"
            style="width: 250px; height: 60px; margin-top:10px"
          />
        <div style ="margin-top:15px">
        <router-link class = "link" to="/signup">Need to create an account?</router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { useRoute, useRouter } from "vue-router";
import { ref, onErrorCaptured } from "vue";
import router from "../../router/index";
import useFirebaseAuth from "../../modules/firebaseauth";
import userStuff from "../../modules/user";

export default {
  name: "Login",

  setup() {
    var { loadUser, day, habits, score } = userStuff();

    const { login, auth, user } = useFirebaseAuth();
    const credentials = ref({
      username: "",
      password: "",
    });
    const doLogin = async () => {
      login(credentials.value.username, credentials.value.password).then(() => {
        loadUser(credentials.value.username).then(() => {
          router.replace({ name: "Home" });
        });
      });
    };

    return {
      credentials,
      doLogin,
    };
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

#login-col {
  align-content: center;
  width: 200px;

}
</style>