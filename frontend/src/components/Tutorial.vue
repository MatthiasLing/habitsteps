<script>
export default {
  name: "Tutorial",
  props: {},
  methods: {
    close() {
      this.$emit("close");
    },
  },
};
</script>
<template>
  <div class="modal-backdrop">
    <div class="panel">
      <div style="margin: 20px; padding: 10px">
        <h1 style="margin-bottom: 15px">Adding Habits</h1>
        <p style="font-size: 24px">
          <span class="binary">Binary</span><br />
          A habit that's done <span class="bold">once</span> per day (making the
          bed, for example) <br /><br />
          <span class="count">Count</span><br />A
          <span class="bold">defined number</span> of occurences per day (like
          drinking 8 glasses of water) <br /><br />
          <span class="slider">Slider</span><br /><span class="bold"
            >Qualitative</span
          >
          but trackable observations (how relaxed am I when meditating?)
          <br /><br />
          All habits need a title to be created and stored!
        </p>

        <div>
          <button
            type="button"
            class="btn-green"
            @click="close"
            aria-label="cancel"
          >
            Close
          </button>
        </div>
      </div>
    </div>
  </div>
</template>
<style>
.bold {
  font-weight: bold;
}
.binary,
.slider {
  color: #8c52ff;
  font-weight: bold;
  white-space: nowrap;
}

.count {
  color: #012049;
  font-weight: bold;

  white-space: nowrap;
}

.modal-backdrop {
  background-color: rgba(0, 0, 0, 0.2);
  display: flex;
  justify-content: center;
}
.panel {
  margin-top: 10%;
  text-align: center;
  background-color: white;
  width: 700px;
  height: 500px;
  overflow: scroll;
  display: flex;
  flex-direction: column;
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