function $(x){
    return document.getElementById(x)
}

let url = "http://localhost:8080/ETL-E-Commerce/login"


let user = {}

function showRegister() {
    let registerCard = $("register-card")
    let loginCard = $("login-card")
    console.log(loginCard)
    loginCard.parentNode.replaceChild(registerCard, loginCard)
    registerCard.style.display = "block"
}

function login() {
  console.log("inside login method!")
    let username = $("username").value
    let password = $("password").value
    let user = {
      "username": username,
      "password": password
    }
    let response = fetch(url, {
                   method: 'post',
                   body: JSON.stringify(user)
                 }).then(function(response) {
                   return response.json();
                 })
    console.log(response)

}

