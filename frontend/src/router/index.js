import { createWebHistory, createRouter } from 'vue-router';

import Home from '../components/Home';
import Signup from '../components/login/signup';
import Login from '../components/login/login';
import About from '../components/About';
import Account from '../components/account/Account';

import useFirebaseAuth from '../modules/firebaseauth';

const auth = useFirebaseAuth();

const history = createWebHistory(process.env.BASE_URL);
const routes = [
    { 
        path : '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/signup',
        name: 'Signup',
        component: Signup
    },
    {
        path: '/login',
        name: 'Login',
        component: Login
    },
    {
        path: '/about',
        name: 'About',
        component: About
    },
    {
        path: '/account',
        name: 'Account',
        component: Account
    }

]

const router = createRouter({
	history,
	routes,
});

router.beforeEach((to, from, next) => {
    // console.log(to.fullPath, from.fullPath)
    if (to.name!=='Signup' && to.name!=='Login' && !auth.user.value){
        console.log("route 1: must sign in")
        next({ name: 'Login' })
    }
    else {
        console.log("route 2: other")
        next()
    }
  })

export default router;