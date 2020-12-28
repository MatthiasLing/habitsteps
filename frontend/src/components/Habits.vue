<template>
  <div class="habitList">
    <div
          v-if = "!error && habits != null"
>
 <AsyncHabit
      v-for="habit in tempHabits"
      :key="habit.id"
      :habit="habit"
    />
    </div>
        <div v-else>No habits on record - try adding one!</div>

    
    </div>
</template>

<script>
import { defineAsyncComponent } from "vue";
import Loading from "./Loading.vue";
import userStuff from "../modules/user";
import useFirebaseAuth from "../modules/firebaseauth"
    var { loadUser, habits, error} = userStuff();


const AsyncHabit = defineAsyncComponent({
  loader: () => import("./Habit" /* webpackChunkName: "habit" */),
  loadingComponent: <div>Loading Habits</div>,
  delay: 100,
  suspensible: true,
});

export default {
  name: "Habits",
  data() {
    return {
      tempHabits : habits
    };
  },

   setup() {
    var {authCheck, user} = useFirebaseAuth();

    function toggleHabit(){
      habits.forEach(element => {
        console.log(element)
      });
    }

    return { habits, error };
  },
  components: {
    AsyncHabit,
  },

};
</script>

<style>
.habitList{
  padding: 20px;
  height: 500px;
  width: 800px;
  overflow: scroll;
  margin: 10px;
}
</style>