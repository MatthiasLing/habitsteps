<template>
  <div class="habit-btn">
    <button
      class="btn btn-secondary"
      @click= "toggleHover"
      style="width: 500px; height: 100px;"
    >
    <div v-if="!hover">
      <h3 style = "color:#FFDE59">{{ habit.title }}</h3>
      <h4>Target: {{ habit.target }}</h4>
      </div>
    </button>
  </div>
</template>

<script>
import axios from "axios";
import userStuff from "../../modules/user";

var { updateHabit } = userStuff();

var slideVal = 0;
export default {
  name: "AccountHabit",

  props: {
    habit: Object,
  },
  data() {
    return {
      tempStatus: this.habit.status,
      hover:false
    };
  },

  async setup() {
    console.log("I AM HJERE")
  },
  

  methods: {
  
    toggleHover(){
        console.log("FSEESF")
        this.hover = !this.hover;
    },

  },
};
</script>

<style>
.habit-btn {
  padding: 5px;
  text-align: center;
}

.is-complete {
  text-decoration: line-through;
  opacity: 0.6;
}
</style>