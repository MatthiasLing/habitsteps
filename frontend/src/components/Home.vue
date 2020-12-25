<template>
  <div id="home">
    <div v-if="error">Parent: {{ error }}</div>
    <Suspense>
      <template #default>
        <div>       
          <div class= "row">
          <Habits/>
          <AddHabit/>
            </div>
        </div>
      </template>
      <template #fallback>
        <div>Loading your habits ...</div>
      </template>
    </Suspense>
    <!-- <Secondary /> -->
  </div>
</template>

<script>
/* eslint-disable vue/no-unused-components */
import Habits from "./Habits";
import AddHabit from "./addHabit";
import Secondary from "./Secondary";
import axios from "axios";
import router from '../router/index'
import useFirebaseAuth from "../modules/firebaseauth"

import { ref, onErrorCaptured } from "vue";
import { useRouter } from 'vue-router';

export default {
  name: "Home",
  setup() {
    console.log("Home loaded")
    var error = ref(null);

    const { doLogout } = useFirebaseAuth();
    const {router} = useRouter();
    onErrorCaptured(e => {
      error.value = e;
    });

    const dologout = async () => {
      await doLogout()
      router.replace({path:'/Login'})
    }


    return { 
      error, 
      dologout,
      router: useRouter()
      };
  },
  components: {
    Habits,
    Secondary,
    AddHabit,
  }
};
</script>

<style>

#home {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;

}
</style>
