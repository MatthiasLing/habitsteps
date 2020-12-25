<template>
  <div id="app">
    <Header />
    <router-view/>
  </div>
  
</template>

<script>
/* eslint-disable vue/no-unused-components */
import Header from "./components/header";

export default {
  name: "App",
  components: {
    Header
  }
};
</script>

<style>

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;

}
</style>
