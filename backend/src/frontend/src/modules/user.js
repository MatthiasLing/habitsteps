import { reactive, toRefs } from "vue"
import axios from "axios"

var userState = reactive({
  error: null,
  user: null,
  email: null,
  day: null,
  days : [],
  streak: 0,
  lastLoggedIn: null,
  score: 0,
  habits: null,
  loaded: false,
  loading: false
})

export default function loadUser() {

  const addNewHabit = async (newHabit) => {
    axios.post("/api/addHabit/" + userState.user.email,
      newHabit).then(() => {
        userState.habits.push(newHabit)
      }).catch((err)=>{
        console.log(err)
      })
  }

  const removeHabit = async(habit)=>{
    axios.post("/api/removeHabit/"+userState.user.email, habit).then(()=>{
      var index = userState.habits.indexOf(habit);

      if (index > -1){
        userState.habits.splice(index, 1);
      }
    })
  }

  const updateHabit = async(habit) => {
    axios.post("/api/updateHabit/" + userState.user.email,
      habit).then(() => {
      }).catch((err)=>{
        console.log(err)
      })
  }

  const initializeUser = async (email) => {

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
        userState.days = userState.user.days;
        return 1;
      } catch (e) {
        console.log(e)
        userState.error = null;
        return 0;
      }
    } else {
      return 2;
    }
  };
  return {
    ...toRefs(userState),
    loadUser,
    initializeUser,
    addNewHabit,
    updateHabit,
    removeHabit
  };
}
