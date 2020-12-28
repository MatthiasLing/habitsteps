import { reactive, toRefs } from "vue"
import axios from "axios"

var userState = reactive({
  error: null,
  user: null,
  email: null,
  day : null,
  score : 0,
  habits : null,
  loaded: false,
  loading: false
})

export default function loadUser() {


  const loadUser = async (email) => {
    console.log("loadUser called")
    if (!userState.loaded) {
      try {
        const response = await fetch(
          "http://localhost:8080/user/"+email
        );
        userState.user = await response.json()
        userState.habits = userState.user.habits;
        return 1;
      } catch (e) {
        console.log(e)
        userState.error = null;
        return 0;
      }
    }else{
      console.log("state already loaded, not fetching")
      return 2;
    }
  };
  return { 
    ...toRefs(userState), 
    loadUser };
}
