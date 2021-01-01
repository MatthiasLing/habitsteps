<template>
  <div id="home">
    <div v-if="error">Parent: {{ error }}</div>
    <Suspense>
      <template #default>
        <div class="row">
          <Habits  />
          <AddHabit />
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
import router from "../router/index";
import useFirebaseAuth from "../modules/firebaseauth";
import userStuff from "../modules/user";

import { ref, onErrorCaptured, defineAsyncComponent } from "vue";
import { useRouter } from "vue-router";
import Loading from "./Loading.vue";
var { loadUser, habits } = userStuff();

export default {
  name: "Home",
  components: {
    Habits,
    Secondary,
    AddHabit,
    Loading,
  },

  setup() {
    
    var { doLogout, user, authCheck } = useFirebaseAuth();
    const { router } = useRouter();

    var error = ref(null);

    onErrorCaptured((e) => {
      error.value = e;
    });

    const dologout = async () => {
      await doLogout();
      router.replace({ path: "/Login" });
    };

    return {
      error,
      dologout,
      router: useRouter(),
    };
  },
};
</script>

<style>
.row{
  /* align-self: start; */
  /* align-content: center; */
  /* align-items: center; */

}
#home {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /* text-align: center; */
  color: #2c3e50;
  display: flex;
  align-items: center;
  margin-left: 20px;
}
</style>
