import { toRefs, reactive } from "vue";
import firebase from 'firebase'
// import 'firebase/auth'
import router from '../router/index'

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
    initialized: false,
    error: null
});

// export utils/refs
export default function () {

    const login = (email, password) => {
        console.log("login initiated")
        return firebase
            .auth()
            .signInWithEmailAndPassword(email, password)
            .then((user) => {
                auth.user = user;
                auth.error = null;
                return user;
            }, error => {
                console.log("login error")
                auth.error = error
                throw error
            })
    }

    const logout = () => {
        return firebase
            .auth()
            .signOut()
            .then(() => {
                auth.user = null;
                console.log("user logged out");
            })
    }

    const signup = (email, password) => {
        console.log("signup initiated")
        // console.log(email,password)
        if (!email || !password) {
            console.log("null signup")
            return null
        }
        return firebase
            .auth()
            .createUserWithEmailAndPassword(email, password)
            .then((user) => {
                auth.user = user;
                auth.error = null;
                console.log("successful signup");
                return user;
            }, error => {
                console.log("signup error")
                auth.error = error
                throw error
            })
    }

    // Run @ start
    const authCheck = () => {
        console.log("auth check initialized");
        return new Promise((resolve, reject) => {
            !auth.initialized &&
                firebase.auth().onAuthStateChanged(async (_user) => {
                    if (_user) {
                        auth.user = _user;
                        console.log("local user found")
                        router.replace({name:'Home'})
                    } else {
                        auth.user = null;
                        console.log("no user found")
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