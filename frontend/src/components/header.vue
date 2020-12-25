<template>
  <header class="header">
    
      <h1>HabitStep</h1>
      <router-link to="/">HOME</router-link>
      <router-link to="/signup"> SignUp</router-link>
      <router-link to="/login"> LogIn</router-link>
  
  </header>
</template>

<script>
export default {
  name: "Header",
};
</script>

<style scoped>

.header {
  margin: 0 auto;
  background: black;
  color: white;
  text-align: center;
  padding: 5pt;
}
</style>