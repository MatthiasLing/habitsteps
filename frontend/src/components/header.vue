<template>
  <header class="header">
    
      <h1>HabitStep</h1>
      <router-link to="/">HOME</router-link>
      <router-link to="/day">HERE</router-link>
  
  </header>
</template>

<script>
export default {
  name: "Header",
};
</script>

<style scoped>

.row{
  align-items: center;
  padding: 5px;
  text-align: center;
}
.header {
  margin: 0 auto;
  background: black;
  color: white;
  text-align: center;
  padding: 5pt;
}

.header a {
  color: white;
  padding-right: 5px;
}
</style>