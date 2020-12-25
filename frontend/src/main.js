import{ Vue, createApp } from 'vue'

import App from './App.vue'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'

import router from './router/index'
import useFirebaseAuth from "./modules/firebaseauth"

const {authCheck} = useFirebaseAuth();

const app = createApp(App)
.use(router)
authCheck().then(()=>{
    app.use(router);
    return router.isReady();
}).then(()=>{
    app.mount('#app')
})



// createApp(App).use(router).mount('#app')
