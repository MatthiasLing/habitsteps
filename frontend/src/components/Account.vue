<template>
  <div id="account">
    <h1>Hey there, Matthias</h1>
              <button class="btn btn-primary" @click="logout">Logout</button>

  </div>
</template>

<script>
/* eslint-disable vue/no-unused-components */

import axios from "axios";
import router from "../router/index";
import useFirebaseAuth from "../modules/firebaseauth";
import userStuff from "../modules/user";
import { ref, onErrorCaptured, defineAsyncComponent } from "vue";
var { authCheck, auth, user, email, logout } = useFirebaseAuth();
var { loadUser, habits } = userStuff();

export default {
  name: "Account",
  components: {
 
  },
  methods : {
      async logout() {
      await logout();
      router.replace({name: "Login"})
    },
  },

  setup() {

    const fun = () => {
     
    };

    return {
      fun
    };
  },
};
</script>

<style>
    #account{

    }
</style>
