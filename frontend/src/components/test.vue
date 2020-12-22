<template>
  <div class="Test">{{habits}}</div>
</template>

<script>
import { defineAsyncComponent } from "vue";
import useHabits from "../modules/habits";

export default {
  name: "Test",
  async setup() {
    const { habits, error, load } = useHabits();
    await load().then(()=>console.log(habits))
    return { habits, error };
  },
  components: {
  
  }
};
</script>

<style>
</style>