<template>
  <div style = "margin-bottom:40px"
  
    v-bind:class="{ 
        'rectangleWeek': true, 
        'rectangleMonth': false 
        }"
  >
    <div class= {temp}>
      <h2>
        {{ tempStreak }}
      </h2>
      Log in streak
    </div>
  </div>
</template>

<script>
/* eslint-disable vue/no-unused-components */
import { ref, onErrorCaptured } from "vue";
import userStuff from "../modules/user";
import useFirebaseAuth from "../modules/firebaseauth";
var { loadUser, streak, lastLoggedIn, habits } = userStuff();
var { doLogout, user, authCheck } = useFirebaseAuth();

export default {
  name: "Progress",
  data() {
    return {
      tempStreak: streak,
      temp : "rectangleWeek"

    };
  },

  setup: () => {
    return {
    };
  },
};
</script>

<style>
.rectangleWeek{
  background-color: #f2e6ff;
  border: 5px solid #32c770;
  padding: 10px;
  width: 200px;
  margin: 0 auto;
  margin-top: 25px;
  border-radius: 25px;
}

.rectangleMonth{
  background-color: #f2e6ff;
  border: 5px solid green;
  padding: 10px;
  width: 200px;
  margin: 0 auto;
  margin-top: 25px;
  border-radius: 25px;
}
</style>
