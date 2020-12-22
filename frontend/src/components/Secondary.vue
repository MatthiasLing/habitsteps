<template>
  <div v-if="error">{{ error }}</div>
  <div v-else-if="habits">
    <h2>Loaded the following users IDs</h2>
    <ul>
      <li v-for="habit in habits" :key="habit.id">
        <code>{{ habit.title }}</code>
      </li>
    </ul>
  </div>
</template>

<script>
import useHabits from "../modules/habits";

export default {
  name: "Habits",

  setup() {
    const { habits, error } = useHabits();
    console.log(habits.data)
    return { habits, error };
  }
};
</script>

<style scoped>
ul {
  list-style: none;
}
</style>