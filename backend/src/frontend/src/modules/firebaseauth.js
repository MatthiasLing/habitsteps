import { toRefs, reactive } from "vue";
import firebase from 'firebase'
// import 'firebase/auth'
import router from '../router/index'
import userStuff from './user'

const {loadUser, initializeUser,habits} = userStuff();

// firebase init - add your own config here
const firebaseConfig = {
    apiKey: "AIzaSyCODloH7CKFPc9AqlaoY1kQ8lHbn5CF8FU",
    authDomain: "habitsteps.firebaseapp.com",
    // databaseURL: "https://habitsteps-default-rtdb.firebaseio.com",
    projectId: "habitsteps",
    storageBucket: "habitsteps.appspot.com",
    messagingSenderId: "464719596520",
    appId: "1:464719596520:web:ec57c0d826cd840f95b25d",
    measurementId: "G-C67XDDFJJ1"
}
firebase.initializeApp(firebaseConfig)

const auth = reactive({
    user: null,
    email: null,
    initialized: false,
    error: null
});

// export utils/refs
export default function authCheck() {

    const login = (email, password) => {
        
        return new Promise((resolve, reject) => {
            firebase
            .auth()
            .signInWithEmailAndPassword(email, password)
            .then((user) => {
                auth.user = user;
                auth.email = user.email;
                loadUser(auth.email).then(()=>{
                    auth.error = null;
                    resolve(true);
                })
            }, error => {
                auth.error = error
                throw error
            })
        });

        
    }

    const logout = () => {
        return firebase
            .auth()
            .signOut()
            .then(() => {
                auth.user = null;
                auth.email = null;
            })
    }

    const signup = (email, password) => {

        return new Promise((resolve, reject) => {
            firebase
            .auth()
            .createUserWithEmailAndPassword(email, password)
            .then((user) => {
                auth.user = user;
                auth.email = user.email;
                auth.error = null;
                initializeUser(email).then(()=>{
                    loadUser(auth.email).then(()=>{
                        auth.error = null;
                        resolve(true);
                    })
                })
            }, error => {
                auth.error = error
                throw error
            })
        });
    }

    // Run @ start
    const authCheck = () => {
        return new Promise((resolve, reject) => {
            !auth.initialized &&
                firebase.auth().onAuthStateChanged(async (_user) => {
                    if (_user) {
                        auth.user = _user;
                        auth.email = _user.email.toString();
                        router.replace({name:'Home'})
                    } else {
                        auth.user = null;
                    }
                    auth.initialized = true;
                    resolve(true);
                })
        });
    }

    return {

        ...toRefs(auth),
        login,
        logout,
        signup,
        authCheck
    }


}