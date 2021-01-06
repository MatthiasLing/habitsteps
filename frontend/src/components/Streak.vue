<template>
  <div class="streaks">
      <div>
      <span
        class="dot"
        v-if="this.hoverArr[100]"
        @mouseenter="toggleHover(true, 100)"
        @mouseleave="toggleHover(false, 100)"
        >100-day streak</span
      >

      <img
        v-if="!this.hoverArr[100]"
        src="../assets/streak/100.png"
        v-bind:class="{
          imageLocked: tempStreak < 100,
          image: tempStreak >= 100,
        }"
        @mouseenter="toggleHover(true, 100)"
        @mouseleave="toggleHover(false, 100)"
        class="image"
      />
    </div>
      <div>
      <span
        class="dot"
        v-if="this.hoverArr[60]"
        @mouseenter="toggleHover(true, 60)"
        @mouseleave="toggleHover(false, 60)"
        >60-day streak</span
      >

      <img
        v-if="!this.hoverArr[60]"
        src="../assets/streak/60.png"
        v-bind:class="{
          imageLocked: tempStreak < 60,
          image: tempStreak >= 60,
        }"
        @mouseenter="toggleHover(true, 60)"
        @mouseleave="toggleHover(false, 60)"
        class="image"
      />
    </div>
      <div>
      <span
        class="dot"
        v-if="this.hoverArr[30]"
        @mouseenter="toggleHover(true, 30)"
        @mouseleave="toggleHover(false, 30)"
        >30-day streak</span
      >

      <img
        v-if="!this.hoverArr[30]"
        src="../assets/streak/30.png"
        v-bind:class="{
          imageLocked: tempStreak < 30,
          image: tempStreak >= 30,
        }"
        @mouseenter="toggleHover(true, 30)"
        @mouseleave="toggleHover(false, 30)"
        class="image"
      />
    </div>
    <div>
      <span
        class="dot"
        v-if="this.hoverArr[7]"
        @mouseenter="toggleHover(true, 7)"
        @mouseleave="toggleHover(false, 7)"
        >7-day streak</span
      >

      <img
        v-if="!this.hoverArr[7]"
        src="../assets/streak/7.png"
        v-bind:class="{
          imageLocked: tempStreak < 7,
          image: tempStreak >= 7,
        }"
        @mouseenter="toggleHover(true, 7)"
        @mouseleave="toggleHover(false, 7)"
        class="image"
      />
    </div>

    <div>
      <span
        class="dot"
        v-if="this.hoverArr[1]"
        @mouseenter="toggleHover(true, 1)"
        @mouseleave="toggleHover(false, 1)"
        >1-day streak</span
      >

      <img
        v-if="!this.hoverArr[1]"
        src="../assets/streak/1.png"
        v-bind:class="{
          imageLocked: tempStreak < 1,
          image: tempStreak >= 1,
        }"
        @mouseenter="toggleHover(true, 1)"
        @mouseleave="toggleHover(false, 1)"
        class="image"
      />
    </div>
  </div>
</template>

<script>
/* eslint-disable vue/no-unused-components */
import userStuff from "../modules/user";
import { ref, onErrorCaptured, defineAsyncComponent } from "vue";
import Vue from "vue";
import VTooltip from "v-tooltip";

var { loadUser, habits, streak, error } = userStuff();

export default {
  name: "Streak",
  data() {
    return {
      hoverArr: {
        1: false,
        7: false,
        30: false,
        60: false,
        100: false,
      },
      tempStreak: streak,
    };
  },
  components: {},
  methods: {
    toggleHover(val, key) {
      this.hoverArr[key] = val;
    },
    valid(num) {
      if (streak.value >= num) {
        return true;
      }
      return false;
    },
  },

  setup() {
    return { habits, error };
  },
};
</script>

<style>
.imageLocked {
  margin: 8px;
  height: 75px;
  width: 75px;
  opacity: 0.25;
}
.image {
  margin: 8px;
  height:75px;
  width: 75px;
}
.streaks {
  margin-top: 40px;
  width: 200px;
}
.dot {
  margin: 8px;

  height: 75px;
  width: 75px;
  background-color: #FFDE59;
  border-radius: 50%;
  display: inline-block;
  padding-top: 18px;
  text-align: center;
}
</style>
