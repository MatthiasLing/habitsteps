<template>
  <div style="margin: 20px; width: 400px">
    <h1>{{ currDate }}</h1>
    <form>
      <div class="form-col" style="margin: 20px; width: 400px">
        <div class="form-row">
          <div class="col">
            <input
              type="text"
              class="form-control form-control-lg"
              v-model="title"
              name="title"
              placeholder="Habit Title"
            />
          </div>
        </div>
        <div class="form-row">
          <div class="col">
            <div>
              <select name="type" id="type" v-model="type" placeholder="Bool">
                <option value="bool">Bool</option>
                <option value="count">Count</option>
                <option value="slide">Slider</option>
              </select>
              <label class="form-check-label" for="type" style = "margin-left:5px">Type</label>
            </div>
            <div style="margin-top: 10px;" v-if="type == `count`">
              <input
                type="number"
                id="count"
                
                min="0"
                max="100"
                placeholder="0"
                v-model="target"
              /><label class="form-check-label" for="count" style = "margin-left:5px">Target</label>
            </div>
            <div style="margin-top: 10px;" v-if="type == `slide`">
              <input
        type="range"
        class="form-control-range"
        id="slide"
        min="0"
        max="100"
        v-model="target"
      />
              <label class="form-check-label" for="count" style = "margin-left:5px">Target</label>
            </div>
          </div>
          <div class="col">
            <div class="col-sm-10">
              <div class="form-check" @change="updateModifier(`Pos`)">
                <input
                  class="form-check-input"
                  type="radio"
                  name="gridRadios"
                  id="gridRadios1"
                  value="Pos"
                  checked
                />
                <label class="form-check-label" for="gridRadios1">
                  Positive
                </label>
              </div>
              <div class="form-check" @change="updateModifier(`Neg`)">
                <input
                  class="form-check-input"
                  type="radio"
                  name="gridRadios"
                  id="gridRadios2"
                  value="Neg"
                />
                <label class="form-check-label" for="gridRadios2">
                  Negative
                </label>
              </div>
            </div>
          </div>
        </div>
        <div class="form-col">
          <input
            type="submit"
            value="Submit"
            class="btn btn-primary"
            @click="addHabit"
            style="width: 200px"
          />
          
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import axios from "axios";

import useFirebaseAuth from "../modules/firebaseauth";
import userStuff from "../modules/user";
import { v4 as uuidv4 } from "uuid";

import moment from "moment";

var { authCheck, auth, user, email, logout } = useFirebaseAuth();
var { addNewHabit } = userStuff();

export default {
  name: "AddHabit",
  data() {
    return {
      title: "",
      type: "bool",
      modifier: "Pos",
      target: 1,
      currDate: moment().format("dddd, MMM Do"),
    };
  },
  setup() {
    return {};
  },
  methods: {
    updateModifier(key) {
      this.modifier = key;
      console.log(this.modifier);
    },
    async logout() {
      await logout();
    },
    tempCheck(){
console.log(this.target)
    },
    async addHabit(e) {
      
      e.preventDefault();
      console.log(this.type);
      const newHabit = {
        id: uuidv4(),
        title: this.title,
        type: this.type + this.modifier,
        status: 0,
        target: this.target,
        notes: "some placeholder text",
      };
      addNewHabit(newHabit);

      this.title = "";
    },
  },
};
</script>

<style scoped>
form {
  display: flex;
}

.col {
  margin: 10px;
  align-content: flex-start;
  align-items: flex-start;
  align-self: flex-start;
}
</style>