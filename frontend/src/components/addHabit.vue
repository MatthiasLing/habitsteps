<template>
  <div style="margin: 20px; width: 400px">
    <Progress />

    <h2 style="margin-top: 20px">New Habit</h2>
    <form>
      <Tutorial v-show="isModalVisible" @close="closeModal" />
      <div class="form-col" style="margin: 10px; width: 400px">
        <div class="form-row">
          <div class="col">
            <input
              type="text"
              class="form-control form-control-lg"
              v-model="title"
              name="title"
              placeholder='Habit Title (ex: "make the bed")'
            />
          </div>
        </div>
        <div class="form-row">
          <div class="col">
            <div>
              <select
                name="type"
                id="type"
                v-model="type"
                placeholder="Bool"
                style="height: 30px"
              >
                <option value="bool">Binary</option>
                <option value="count">Count</option>
                <option value="slide">Slider</option>
              </select>
              <label
                class="form-check-label"
                for="type"
                style="margin-left: 5px"
                >Type</label
              >
            </div>
          </div>
          <div class="col" v-if="type != `bool`">
            <div v-if="type == `count`">
              <input
                type="number"
                id="count"
                min="0"
                max="100"
                placeholder="0"
                v-model="target"
              /><label
                class="form-check-label"
                for="count"
                style="margin-left: 5px"
                >Target</label
              >
            </div>
            <div v-if="type == `slide`">
              <input
                type="range"
                class="form-control-range"
                id="slide"
                min="0"
                max="100"
                v-model="target"
              />
              <label
                class="form-check-label"
                for="count"
                style="margin-left: 5px"
                >Target</label
              >
            </div>
          </div>
        </div>
        <div class="form-row" style="margin-top: 10px">
          <div class="row" style="margin: auto">
            <input
              type="submit"
              value="Add new habit"
              class="btn btn-primary"
              @click="addHabit"
              style="width: 200px; height: 50px"
            />
            <div
              @click="question"
              style="
                vertical-align: baseline;
                padding: 5px;
                margin-left: 10px;
                cursor: pointer;
                font-size: 30px;
                color: #8c53ff;
                font-weight: bold;
              "
            >
              ?
            </div>
          </div>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import useFirebaseAuth from "../modules/firebaseauth";
import userStuff from "../modules/user";
import { v4 as uuidv4 } from "uuid";
import Tutorial from "./Tutorial";
import Progress from "./Progress";
var { authCheck, auth, user, email, logout } = useFirebaseAuth();
var { addNewHabit } = userStuff();

export default {
  name: "AddHabit",
  components: {
    Progress,
    Tutorial,
  },
  data() {
    return {
      title: "",
      type: "bool",
      modifier: "Pos",
      target: 1,
      isModalVisible: false,
    };
  },
  setup() {
    return {};
  },
  methods: {
    closeModal() {
      this.isModalVisible = false;
    },
    question() {
      this.isModalVisible = true;
    },
    updateModifier(key) {
      this.modifier = key;
    },
    async logout() {
      await logout();
    },
    async addHabit(e) {
      if (!this.title || !this.title.trim()) {
        return;
      }
      e.preventDefault();
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