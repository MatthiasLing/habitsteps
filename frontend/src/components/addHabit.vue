<template>
<div style="margin: 20px">
    <h1>Tuesday, Jan. 14</h1>
  <form>
    <div class="form-col">
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
        <!-- <div  style = "padding: 20px">
      
    </div> -->
      </div>
      <div class="form-row">
        <div class="col">
          <select name="type" id="type" v-model="type" placeholder="Bool">
            <option value="bool">Bool</option>
            <option value="count">Count</option>
            <option value="slide">Slider</option>
          </select>
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
              style = "width:200px"
            />
          </div>
    </div>
    
  </form>
  <!-- <div class="col">
    <div class="row">
      <input
        type="text"
        class = "form-control form-control-lg"
        v-model="title"
        name="title"
        placeholder="Habit Title"
      />
      <select name="type" id="type" v-model="type" placeholder="Bool">
        <option value="bool">Bool</option>
        <option value="count">Count</option>
        <option value="slide">Slider</option>
      </select>
    </div>
    <div class="row">
      <legend class="col-form-label col-sm-2 pt-0">Modifier</legend>
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
          <label class="form-check-label" for="gridRadios1"> Positive </label>
        </div>
        <div class="form-check" @change="updateModifier(`Neg`)">
          <input
            class="form-check-input"
            type="radio"
            name="gridRadios"
            id="gridRadios2"
            value="Neg"
          />
          <label class="form-check-label" for="gridRadios2"> Negative </label>
        </div>
      </div>
    </div>
    <textarea name="Text1" cols="40" rows="5"></textarea>
    <input
      type="submit"
      value="Submit"
      class="btn btn-primary"
      @click="addHabit"
    />
  </div> -->
  </div>
</template>

<script>
import useHabits from "../modules/habits";
import axios from "axios";
var { habits, error, load, reload, addToHabits } = useHabits();

export default {
  name: "AddHabit",
  data() {
    return {
      title: "",
      type: "bool",
      modifier: "Pos",
    };
  },
  async setup() {
    // await load();
    console.log(habits);

    return { habits, error };
  },
  methods: {
    updateModifier(key) {
      this.modifier = key;
      console.log(this.modifier);
    },
    async addHabit(e) {
      e.preventDefault();
      console.log(this.type);
      const newHabit = {
        id: "649fd00c-3fd0-439e-b661-59c3667246b2",
        title: this.title,
        type: this.type + this.modifier,
        status: 1,
        notes: "some placeholder text",
      };
      addToHabits(newHabit);

      this.title = "";
      // this.$forceUpdate();
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
  align-items: flex-start;
}
</style>