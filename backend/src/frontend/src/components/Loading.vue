<template>
  <div id="Loading">
   <semipolar-spinner
  :animation-duration="2000"
  :size="100"
  color="#ff1d5e"
/>
  </div>
</template>

<script>
/* eslint-disable vue/no-unused-components */

import { ref, onErrorCaptured } from "vue";
import { useRouter } from 'vue-router';
import { SemipolarSpinner  } from 'epic-spinners'

export default {
  name: "Loading",
};
</script>

<style>

</style>
