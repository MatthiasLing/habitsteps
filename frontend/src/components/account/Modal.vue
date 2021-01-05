<script>
export default {
  name: "modal",
  methods: {
    close() {
      console.log("closing");
      this.$emit("close");
    },
  },
};
</script>
<template>
    <div class="modal-backdrop">
      <!-- <div
        class="modal"
      >
          <h1>Are you sure you want to delete?</h1>

      <div>
        <footer class="modal-footer">
          <slot name="footer">
            <button
              type="button"
              class="btn-green"
              @click="close"
              aria-label="Cancel"
            >
              Cancel
            </button>
          </slot>
        </footer>
      </div>
      </div> -->
      <div class="panel">HELP</div>
    </div>
</template>
<style>
.modal-backdrop {
  background-color: rgba(0, 0, 0, 0.7);
display: flex;
  justify-content: center;
    position: fixed;
  bottom: 50%;
  right: 50%;
}
.panel{
  /* background: #FFFFFF; */
  /* position: fixed;
  bottom: 50%;
  right: 50%; */
  margin-top: 10%;
  text-align: center;
  background-color: lightblue;
  width: 500px;
  height: 300px;

  display: flex;
  /* flex-direction: column; */

}
.modal {
  /* background: #FFFFFF; */
  position: fixed;
  bottom: 50%;
  right: 50%;
  text-align: center;
  background-color: lightblue;
  width: 500px;
  height: 300px;

  display: flex;
  /* flex-direction: column; */
}

.modal-header,
.modal-footer {
  padding: 15px;
  display: flex;
}

.modal-footer {
  border-top: 1px solid #eeeeee;
  justify-content: flex-end;
}

.modal-body {
  position: relative;
  padding: 20px 10px;
}

.btn-close {
  border: none;
  font-size: 20px;
  padding: 20px;
  cursor: pointer;
  font-weight: bold;
  color: #4aae9b;
  background: transparent;
}

.btn-green {
  color: white;
  background: #4aae9b;
  border: 1px solid #4aae9b;
  border-radius: 2px;
}
</style>