<template>
  <div class="habitList">
    <div v-if="error">{{ error }}</div>
    <AsyncHabit
    
      v-else
      v-for="habit in habits"
      :key="habit.id"
      :habit="habit"
    />
  </div>
</template>

<script>
import { defineAsyncComponent } from "vue";
// import Loading from "./Loading.vue";
import useHabits from "../modules/habits";

const AsyncHabit = defineAsyncComponent({
  loader: () => import("./Habit" /* webpackChunkName: "habit" */),
  // loadingComponent: Loading,
  delay: 100,
  suspensible: false,
});

export default {
  name: "Habits",

  async setup() {
    var { habits, error, load } = useHabits();
    await load();
    console.log(habits)

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
  methods:{
  
  }
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