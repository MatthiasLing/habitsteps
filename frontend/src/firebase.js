import * as firebase from 'firebase/app'
import 'firebase/auth'

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

// utils
const auth = firebase.auth()
export default auth

// export utils/refs
export {
    auth
}