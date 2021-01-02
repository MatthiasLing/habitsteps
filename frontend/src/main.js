import{ Vue, createApp } from 'vue'

import App from './App.vue'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'

import router from './router/index'
import useFirebaseAuth from "./modules/firebaseauth"
import userStuff from "./modules/user"
import VueApexCharts from "vue3-apexcharts";

var {authCheck, auth, user, email} = useFirebaseAuth();
var {loadUser, day, habits, streak } = userStuff();

const app = createApp(App)
.use(router)

authCheck().then(()=>{
    app.use(VueApexCharts);

    if (email){
        loadUser(email.value).then(()=>{
            console.log(streak.value, "USER STREAK")
        app.use(router);
        })
    }else{
        app.use(router);
    }
    
    return router.isReady();
}).then(()=>{
    app.mount('#app')
})