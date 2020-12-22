<template>
  <div id="app">
    <!-- <test/> -->
    <!-- <router-link to="/day" class = "DayView">Home</router-link> -->
        <!-- <Header /> -->
    <!-- <DayView v-bind:habits="habits" v-on:toggleComplete="toggleComplete" /> -->
    <!-- <AddHabit v-on:addHabit="addHabit" /> -->
    <!-- <router-view /> -->
    
<Header />
    <div v-if="error">Parent: {{ error }}</div>
    <Suspense>
      <template #default>
        <div>
          
          <div class= "row">
          <Habits/>
          <AddHabit/>
            </div>
          
          
        </div>
        
        
      </template>
      <template #fallback>
        <div>Retrieving your amazing vuesers...</div>
      </template>
    </Suspense>
    <!-- <Secondary /> -->
  </div>
</template>

<script>
/* eslint-disable vue/no-unused-components */
import Habits from "./components/Habits";
import AddHabit from "./components/addHabit";
import Secondary from "./components/Secondary";
import DayView from "./components/dayView";
import Header from "./components/header";
import axios from "axios";
import Test from "./components/test"

import { ref, onErrorCaptured } from "vue";

export default {
  name: "App",
  setup() {
    var error = ref(null);

    onErrorCaptured(e => {
      error.value = e;
    });
    return { error };
  },
  components: {
    Header,
    Habits,
    Secondary,
    AddHabit,
    DayView
  }
};
// import DayView from "./components/dayView";
// import Header from "./components/header";
// import AddHabit from "./components/addHabit";
// import axios from "axios";
// import Test from "./components/test"
// import { ref, onErrorCaptured } from "vue";

// import Habits from "./components/habits";
// import Secondary from "./components/secondary.vue";


// export default {
//   name: "App",
//   setup() {
//     const error = ref(null);

//     onErrorCaptured(e => {
//       error.value = e;
//     });

//     return { error };
//   },
//   components: {
    
//     Habits,
//     Secondary,


//     DayView,
//     Header,
//     AddHabit,
//     Test
//   },
//   data() {
//     return {
//       habits: []
//     };
//   },
//   methods: {
//     toggleComplete(id) {
//       for (var i = 0; i < this.habits.length; i++) {
//         if (this.habits[i].id == id) {
//           this.habits[i].completed = !this.habits[i].completed;
//         }
//       }
//       console.log(this.habits);
//     },

//     addHabit(habit) {
//       this.habits = [...this.habits, habit];
//       var params = {
//         id: "5209fa5e-3600-482c-99a1-8027e0891220",
//         title: habit.title,
//         type: habit.type,
//         status: habit.status,
//         notes: habit.notes
//       }
//       console.log(params);
//       console.log(JSON.stringify(params));

//       axios
//         .post("http://localhost:8080/api/addHabit", 
//           params
//           )
//         .then((res) => console.log(res))
//         .catch((err) => console.log(err));
//     },
//   },

//   created() {
//     // axios
//     //   .get("http://localhost:8080/api/habits")
//     //   .then((res)=> {
//     //     this.habits = res.data;
//     //     console.log(this.habits)
//     //     })
//     //   .catch((err) => console.log(err));
      
//   },
// };
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
