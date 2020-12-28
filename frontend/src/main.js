import{ Vue, createApp } from 'vue'

import App from './App.vue'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'

import router from './router/index'
import useFirebaseAuth from "./modules/firebaseauth"
import userStuff from "./modules/user"

var {authCheck, auth, user, email} = useFirebaseAuth();
var {loadUser, day, habits, score } = userStuff();

const app = createApp(App)
.use(router)

authCheck().then(()=>{
    if (email){
        loadUser(email.value).then(()=>{
        app.use(router);
        })
    }else{
        app.use(router);
    }
    
    return router.isReady();
}).then(()=>{
    app.mount('#app')
})