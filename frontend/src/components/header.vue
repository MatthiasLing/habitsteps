<template>
  <header class="header">
    <img class= "logo"
    src="../assets/habitsteps.png" @click="home"/>

    <div class= "row">
      <router-link class = "link" to="/about">About</router-link>
      <button type="button" class="btn btn-outline-warning" @click="acct">Account</button>
    </div>
  </header>
</template>

<script>
import router from "../router/index";

export default {
  name: "Header",
  methods: {
  home : function (){
      router.replace({ path: "/" });
  },

  acct : function (){
    router.replace({name: "Account"})
  }
}
};
</script>

<style scoped>

.logo{
  cursor: pointer;
  height: 70px;
  padding-top: 10px
}

.row{
  width: 250px;
  display: flex;
        justify-content: space-between;
    padding-right: 30px;
    margin: 10px;
}

.link{
  color: #CB6CE6;
  font-size: 20px;
    padding-top: 10px;
    font-size: 25px;
}

.header {
    display: flex;
    /* position: fixed; */
  justify-content: space-between;
  /* margin: 0 auto; */
  background: #012049;
  color: white;
  text-align: center;
  padding: 10pt;
  padding-left: 30px;
  padding-right: 20px;
  width: 100%;
}
</style>