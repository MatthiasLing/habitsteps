<template>
  <div id="account">
    <h1 class="title">Progress Dashboard</h1>
    <Suspense>
      <template #default>
        <div class="row">
          <AreaChart />
          <AccountHabits />
        </div>
      </template>
      <template #fallback>
        <div>Loading your habits ...</div>
      </template>
    </Suspense>
    <Badges />
  </div>
</template>

<script>
/* eslint-disable vue/no-unused-components */
import axios from "axios";
import router from "../../router/index";
import useFirebaseAuth from "../../modules/firebaseauth";
import userStuff from "../../modules/user";
import { ref, onErrorCaptured, defineAsyncComponent } from "vue";
import AreaChart from "./AreaChart";
import AccountHabits from "./AccountHabits";

import Badges from "./Badges";

var { authCheck, auth, user, email, logout } = useFirebaseAuth();
var { loadUser, habits, streak, error } = userStuff();

const AsyncHabit = defineAsyncComponent({
  loader: () => import("../Habit" /* webpackChunkName: "habit" */),
  loadingComponent: <div>Loading Habits</div>,
  delay: 100,
  suspensible: true,
});

export default {
  name: "Account",
  components: {
    AreaChart,
    AsyncHabit,
    AccountHabits,
    Badges,
  },
  methods: {
    async logout() {
      await logout();
      router.replace({ name: "Login" });
    },
  },

  setup() {
    return { habits, error };
  },
};
</script>

<style>
.title {
  padding: 20px;
}
#account {
}
</style>
