<script>
import userStuff from "../../modules/user";

var { removeHabit, days } = userStuff();
export default {
  name: "modal",
  props: {
    habit: Object,
  },
  methods: {
    remove(){
        removeHabit(this.habit)
        this.$emit("close")
    },

    close() {
      this.$emit("close");
    },
  },
};
</script>
<template>
  <div class="modal-backdrop">
    <div class="panel">
      <div style="margin: 20px; padding: 10px;">
        <h1>Delete this habit?</h1>
        <h2
        style = "margin-bottom:20px;text-overflow: ellipsis;
  overflow: hidden; color:#8c52ff"
        >{{ habit.title }}</h2>
        <div>
          <button
          type="button"
          class="btn-green"
          @click="close"
          aria-label="Cancel"
        >
          Cancel
        </button>

          <button
          type="button"
          class="btn-delete"
          @click="remove"
          aria-label="Cancel"
        >
          Remove
        </button> 
        </div>
      </div>
    </div>
  </div>
</template>
<style>

.modal-backdrop {
  background-color: rgba(0, 0, 0, 0.7);
  display: flex;
  justify-content: center;
 
}
.panel {

  margin-top: 10%;
  text-align: center;
  background-color: white;
  width: 500px;
  height: 250px;

  display: flex;
  flex-direction: column;
}

.btn-delete {
    margin: 5px;
    width: 100px;
    height: 40px;
  color: white;
  background: red;
    border: 1px solid red;
  align-self: center;
  border-radius: 2px;
  align-self: center;
}

.btn-green {
        margin: 5px;

    width: 100px;
    height: 40px;
  color: white;
  background: #4aae9b;
  border: 1px solid #4aae9b;
  border-radius: 2px;
  align-self: center;
}
</style>