<template>
  <div class="dayView">
    <h1>Today's Habits</h1>
        <div class="col-8">
      <draggable
        :componentData="componentData"
        :list="habits"
        :animation="200"
        @start="dragging = true"
        @end="dragging = false"
        item-key="id"
        ghost-class="ghost"
        :move="checkMove"
      >
        <template #item="{ habit }">
          <div class="list-group-item" :class="{ 'not-draggable': !enabled }">
           <div>{{habit.title}}</div>
          </div>
        </template>

        <template #footer>
          <div
            class="btn-group list-group-item"
            role="group"
            aria-label="Basic example"
            key="footer"
          >
            <button class="btn btn-secondary" @click="add">Add</button>
            <button class="btn btn-secondary" @click="replace">Replace</button>
          </div>
        </template>
      </draggable>
      </div>
  </div>
</template>

<script>
/* eslint-disable vue/no-unused-components */
import HabitItem from "./habitItem";
import Draggable from "vuedraggable";
import useHabits from '../modules/habits'

export default {
  name: "DayView",

  async setup(){
    const {habits, error, load} = useHabits();
    // await load().then(console.log(habits))
  },

  components: {
    HabitItem,
    Draggable,
  },
   data() {
    return {
      dragging: false,
      componentData: {
        type: "transition",
        name: "flip-list"
      }
    };
  },
  computed: {
    draggingInfo() {
      return this.dragging ? "under drag" : "";
    }
  },
  methods: {
    add: function() {
      console.log(this.habits);
    },
        checkMove: function(e) {
      window.console.log("Future index: " + e.draggedContext.futureIndex);
    }
  },
  
};
</script>

<style scoped>
.btn btn-primary{
  color: red;
  width: 1px;
}
#dayView {
  margin: 0 auto;
}

#habitContainer {
  margin: 0 auto;
}

.flip-list-move {
  transition: transform 0.5s;
}
.no-move {
  transition: transform 0s;
}
</style>