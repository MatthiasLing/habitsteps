<template>
   <div class = "habit-btn" v-bind:class="{'is-complete':habit.status != 0
    }">

    <button class="btn btn-secondary" @click="update(habit)" style="width:500px">
       
        <input type="range" class="form-control-range" v-if="habit.type == `slideNeg`"
        id="slide" min="0" max="100" v-model="tempStatus">
        <input type="number" id="count" v-if="habit.type == `countPos`"
       min="0" max="100" placeholder="tempStatus" v-model="tempStatus">
        <!-- <input type = "checkbox" v-if="habit.type == `boolPos`" @change="$emit('toggleComplete', habit.id)"/>  -->
        <h3>{{habit.title}}</h3>
        <h4>{{tempStatus}}</h4>
        <p>{{habit.id}}</p>
        
    </button>
    </div> 
</template>

<script>
import axios from 'axios'
import useHabits from "../modules/habits";
var { habits, error, load, updateHabit } = useHabits();

var slideVal = 0
export default {
  name: "Habit",
  props: {
    habit: Object
  },
  data(){
    return {
      tempStatus:this.habit.status
    } 
    },

  async setup() {
  },
  

  methods: {

    toggleSlide: function(event){
      console.log(status)
    },
    
    update: function(habit){
      console.log(habit.type)

      if (habit.type == "boolPos"){
        
        if (habit.status === 0 ){
          habit.status = 1
          this.tempStatus = 1
        }else{
          habit.status = 0
          this.tempStatus = 0
      }
      }else if (habit.type == "slideNeg"){
        habit.status = this.tempStatus
        console.log(habit.status)
      }else if (habit.type == "countPos"){
        habit.status = this.tempStatus
        console.log(habit.status)
      }
      updateHabit(habit)
      
    },
    add: function() {
      console.log(this.habits);
    },
  },
};
</script>

<style>
 .habit-btn{
        padding: 5px;
        text-align: center;
    }

    .is-complete {
        text-decoration: line-through;
        opacity: 0.6;
    }
  
</style>