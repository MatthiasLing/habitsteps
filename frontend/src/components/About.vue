<template>

  <div>
      <h1 class="title">About</h1>
  <div class="row">
  <div class="columnL">
    <div class="textCol">
        <div>
          <span class="habitSteps">HabitSteps</span> started as a winter break project
          created by <span class="name">Matthias Ling</span>. It originates from
          a desire to track growth through daily habits, and hopefully will
          become a tool that many will come to use and love. 
          <!-- <br /><br /> -->
          <br /><br />

          Self improvement shouldn't come with a price, and for that reason
          <span class="habitSteps">HabitSteps</span> is free to use - with no paid or
        features or membership. Because it was created in the span of several weeks,
          there are definitely areas for improvement. Please send any
          comments or suggestions to <span class="habitSteps" >habitsteps@gmail.com</span>. <br /><br />
          In the meantime, check me out on
          <a
            style="white-space: nowrap"
            href="https://www.linkedin.com/in/matthiasling/"
            >LinkedIn</a
          >
          and
          <a style="white-space: nowrap" href="https://github.com/MatthiasLing"
            >GitHub</a
          >!
        </div>
        
      </div>
  </div>
  <div class="columnR">
    <!-- <img src="../assets/dancing.png" style="width: 300px" /> -->
    <img src="../assets/dancing.png" style="width: 300px" />
    <div class="textColR">
    <span class="habitSteps2">HabitSteps</span> came from the
          belief that through cultivating good habits, we can become more
          productive, engaged, and successful people - one step at a time.
          </div>

              

  </div>

</div>
</div>
</template>

<script>
export default {
  name: "About",

  setup() {
    return {};
  },
};
</script>

<style>

* {
  box-sizing: border-box;
}

/* Create three equal columns that floats next to each other */
.columnL {
  float: left;
  width: 50%;
  padding: 10px;
  padding-left: 30px;
  height: 300px; /* Should be removed. Only for demonstration */
}
.columnR {
  float: left;
  width: 45%;
  /* padding: 10px; */
  /* padding-left: 10px; */
  height: 300px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/*  */
.title {
  padding: 20px;
}
.row {
  display: flex;
  justify-content: space-between;
}
.name {
  font-weight: bold;
}
.habitSteps {
  color: #8c52ff;
  white-space: nowrap;
}

.habitSteps2 {
  color: #cb6ce6;
  white-space: nowrap;
}
.textCol {
  margin: 10px;
  padding: 10px;
  padding-left: 45px;
  width: 500px;
  font-size: 20px;

  text-align: left;
}

.textColR {
  margin: 10px;
  padding: 10px;
  padding-left: 10px;
  width: 500px;
  font-size: 30px;

  text-align: left;
}
</style>