import { createWebHistory, createRouter } from 'vue-router';

import DayView from '../components/dayView.vue';
import AddHabit from '../components/addHabit.vue';
import Test from '../components/test.vue';

import App from '../App'

// const history = createWebHistory();
const routes = [
    { 
        path : '/',
        component: DayView
    },
    {
        path: '/day',
        component: Test
    }
]

const router = createRouter({
	history: createWebHistory(),
	routes,
});

export default router;