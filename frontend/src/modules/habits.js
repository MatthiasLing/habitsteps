import { reactive, toRefs } from "vue"
import axios from "axios"
var state = reactive({
  error: null,
  habits: null,
  loaded: false,
  loading: false
})

export default function useHabits() {

  var reload = async () =>{
    const response = await fetch(
      "http://localhost:8080/api/habits"
    );
    state.habits = await response.json()
    console.log("reloaded")
  }

  function addToHabits(newHabit){
    console.log("Adding a new habit")
    axios
    .post("http://localhost:8080/api/addHabit", 
      newHabit
      )
    .then((res) => 
    state.habits.push(newHabit)
    // load()
    // console.log("done")
    )
    .catch((err) => console.log(err));
    
    console.log(newHabit.title + "added")

  }

  function updateHabit(habit){
    console.log("updating " + `${habit.title}`)
    axios
    .put("http://localhost:8080/api/updateHabit", 
      habit
      )
    .then((res) => 
    // load()
    console.log("done")
    )
    .catch((err) => console.log(err));
    
    console.log(habit.title + "updated")

  }

  var load = async () => {
    console.log("load called")
    if (!state.loaded) {
      console.log("state not loaded")
      try {
        const response = await fetch(
          "http://localhost:8080/api/habits"
        );
        state.habits = await response.json()
      } catch (e) {
        console.log("error")
        state.error = e;
      }
    }else{
      console.log("state already loaded, not fetching")
    }
  };
  return { ...toRefs(state), load, reload, addToHabits, updateHabit};
}
