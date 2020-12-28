import { createWebHistory, createRouter } from 'vue-router';

import Home from '../components/Home';
import Signup from '../components/login/signup';
import Login from '../components/login/login';

import TestApi from '../components/test';

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
        path: '/test',
        name: 'TestApi',
        component: TestApi
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
        next({ name: 'Signup' })
    }
    else {
        console.log("route 2: other")
        next()
    }
  })

export default router;