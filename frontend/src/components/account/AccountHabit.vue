<template>
  <div class="habit-btn">
        <Modal
      v-show="isModalVisible"
      @close="closeModal"
    />

    

    <button
      class="btn btn-secondary"
      @click= "toggleHover"
      @mouseenter="toggleHover(false)"
      @mouseleave="toggleHover(true)"
      style="width: 500px; height: 100px;"
    >
    <div v-if="hover">
      <h3 class ="label">{{ habit.title }}</h3>
      <h4>Target: {{ habit.target }}</h4>
      </div>
      <div v-if="!hover">
      <h3 style = "color:#FFDE59">{{ percentage }}</h3>
      <button
      style ="background-color: red; color: white"
      type="button"
      class="btn"
      @click="showModal"
    >
      Delete
    </button>


      <!-- <h4>Target: {{ habit.target }}</h4> -->
      </div>
    </button>
  </div>
</template>

<script>
import axios from "axios";
import userStuff from "../../modules/user";
import Modal from "./Modal";
var { updateHabit, days } = userStuff();

var slideVal = 0;
export default {
  name: "AccountHabit",
  components:{
    Modal,
  },
    data() {
    return {
      tempStatus: this.habit.status,
      percentage: this.getPercent(this.habit),
      hover:true,
      isModalVisible: false
    };
  },
  props: {
    habit: Object,
  },


  async setup() {

  },
  
  

  methods: {
              showModal() {
                
        this.isModalVisible = true;
      },
      closeModal() {
        this.isModalVisible = false;
      },

    getPercent(habit){

        var curr = 0;
        var total = 0;

        for (var i=0;i<days.value.length;i++){
            for (var j=0;j<days.value[i].habits.length;j++){

                if (days.value[i].habits[j].id == habit.id){
                    total += 1;
                    if (days.value[i].habits[j].status >= habit.target){
                        curr += 1;
                    }
                }
            }
                    

        }
        return `${curr}/${total} this past month`
    },
  
    toggleHover(b){
        this.hover = b;
    },

  },
};
</script>

<style>

.habit-btn {
  padding: 5px;
/* white-space: nowrap; */

  text-align: center;
}

.label {
  padding: 5px;
  margin-bottom: 10px;
  color:#FFDE59;
text-overflow: ellipsis;
  overflow: hidden; 
  text-align: center;
}

.is-complete {
  text-decoration: line-through;
  opacity: 0.6;
}
</style>