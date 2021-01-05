<template>
  <div id="account">
    <button class="btn btn-primary" @click="logout">Logout</button>
  </div>
</template>

<script>
/* eslint-disable vue/no-unused-components */

/*
Badge ideas

- complete a day
- 7 day streak
- 30 day streak 
- 100 day streak
- all three types of habits
- 5 daily habits
- 10 daily habits

- 7 days complete streak
- 14 days complete streak
- 1 mo complete streak
*/



import router from "../../router/index";
import useFirebaseAuth from "../../modules/firebaseauth";


var { authCheck, auth, user, email, logout } = useFirebaseAuth();

export default {
  name: "Badges",
  components: {},
  methods: {
    async logout() {
      await logout();
      router.replace({ name: "Login" });
    },
  },

  setup() {
    return {};
  },
};
</script>

<style>
.title {
  padding: 20px;
}

.earned {
}

.toEarn {
  opacity: 0.5;
}
</style>
