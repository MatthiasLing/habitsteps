import { reactive, toRefs } from "vue"
import axios from "axios"

var userState = reactive({
  error: null,
  user: null,
  email: null,
  day: null,
  streak: 0,
  lastLoggedIn: null,
  score: 0,
  habits: null,
  loaded: false,
  loading: false
})

export default function loadUser() {

  const addNewHabit = async (newHabit) => {
    console.log(JSON.stringify(newHabit))
    axios.post("/api/addHabit/" + userState.user.email,
      newHabit).then(() => {
        userState.habits.push(newHabit)
        console.log("should be done")
      }).catch((err)=>{
        console.log(err)
      })
  }

  const updateHabit = async(habit) => {
    console.log(JSON.stringify(habit))
    axios.post("/api/updateHabit/" + userState.user.email,
      habit).then(() => {
        console.log("should be done")
      }).catch((err)=>{
        console.log(err)
      })
  }

  const initializeUser = async (email) => {
    console.log("init user called")
    console.log(email)

    // latest update with streaks
    await axios.post("/api/addUser/", {
      name: email,
      email: email,
      habits: [],
      days: [],
      streak: 0,
    }).then(() => {
      console.log("new user created")
    })
  }

  function sameDay(date1){
    var curr = new Date(date1);
    var now = new Date();
    return (now.getFullYear() == curr.getFullYear() && now.getMonth() == curr.getMonth() && now.getDate() == curr.getDate())
     
  }


  const loadUser = async (email) => {
    console.log("loadUser called")
    if (!userState.loaded) {
      try {
        const response = await fetch(
          "/api/user/" + email
        );
        userState.user = await response.json()

        for (var i=0;i<userState.user.days.length;i++){
          var now = Date.now();
          
          if (sameDay(userState.user.days[i].date)){
            userState.habits = userState.user.days[i].habits
            break;
          }
        }
        if (userState.habits == null){
          userState.habits = []
        }


        // something here for the streak
        userState.streak = userState.user.streak;

        return 1;
      } catch (e) {
        console.log(e)
        userState.error = null;
        return 0;
      }
    } else {
      console.log("state already loaded, not fetching")
      return 2;
    }
  };
  return {
    ...toRefs(userState),
    loadUser,
    initializeUser,
    addNewHabit,
    updateHabit,
  };
}
