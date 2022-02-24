function $(x){
    return document.getElementById(x)
}




function showRegister() {
    let registerCard = $("register-card")
    let loginCard = $("login-card")
    console.log(loginCard)
    loginCard.parentNode.replaceChild(registerCard, loginCard)
    registerCard.style.display = "block"
}

/* function showLogin() {
    let registerCard = $("register-card")
    let loginCard = $("login-card")
    console.log(loginCard)
    registerCard.parentNode.replaceChild(loginCard, registerCard)
} */

