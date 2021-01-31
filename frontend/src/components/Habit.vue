<template>
  <div class="habit-btn" v-bind:class="{ 'is-complete': habit.status >= habit.target }">
    <button
      class="btn btn-secondary"
      @click="update(habit)"
      style="width: 500px"
    >
      <input
        type="range"
        class="form-control-range"
        v-if="habit.type == `slidePos` || habit.type == `slideNeg`"
        id="slide"
        min="0"
        max="100"
        @change="update(habit)"
        v-model="tempStatus"
      />
      <input
        type="number"
        onkeydown="return false"
        id="count"
        v-if="habit.type == `countPos` || habit.type == `countNeg`"
        min="0"
        max="1000"
        placeholder="tempStatus"
        v-model="tempStatus"
        @change="update(habit)"
      />
      <h3 class ="label">{{ habit.title }}</h3>
      <h4 v-if="habit.status < habit.target">{{ tempStatus }}/{{habit.target}}</h4>
    </button>
  </div>
</template>

<script>
import axios from "axios";
import userStuff from "../modules/user";

var { updateHabit } = userStuff();

var slideVal = 0;
export default {
  name: "Habit",

  props: {
    habit: Object,
  },
  data() {
    return {
      tempStatus: this.habit.status,
    };
  },

  async setup() {
  },
  

  methods: {
    update: function (habit) {
      if (habit.type == "boolPos" || habit.type == "boolNeg") {
        if (habit.status === 0) {
          habit.status = 1;
          this.tempStatus = 1;
        } else {
          habit.status = 0;
          this.tempStatus = 0;
        }
      } else if (habit.type == "slideNeg" || habit.type == "slidePos") {
        if (habit.status == this.tempStatus){
          return 
        }
        habit.status = this.tempStatus;
      } else if (habit.type == "countPos" || habit.type == "countNeg") {
        if (habit.status == this.tempStatus){
          return 
        }
        habit.status = this.tempStatus;
      }
      updateHabit(habit);
    },
  },
};
</script>

<style>
.habit-btn {
  padding: 5px;
  text-align: center;
}

.label {
  padding: 5px;
  color:#F4CFFF;
white-space: nowrap;
text-overflow: ellipsis;
  overflow: hidden; 
  text-align: center;
}

.is-complete {
  text-decoration: line-through;
  opacity: 0.6;
}
</style>