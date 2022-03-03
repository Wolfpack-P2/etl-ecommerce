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

async function login() {
  console.log('helloooo')
  let username = $("username").value
  let password = $("password").value
  let user = {
    "username": username,
    "password": password
  }

  const rawResponse = await fetch(url, {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(user)
  });
  
  const content = await rawResponse.json();

  if (content != null) {
    redirect: window.location.replace("http://localhost:8080/ETL-E-Commerce/dashboard.html")
  } else {
    alert("Invalid Credentials")
  }
}

let password = $("password")
let confirm_password = $("confirm-password")

function validatePassword(){
  if(password.value != confirm_password.value) {
    confirm_password.setCustomValidity("Passwords Don't Match");
  } else {
    confirm_password.setCustomValidity('');
  }
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;

async function register() {
  let firstName = $("first-name").value
  let lastName = $("name-name").value
  let username = $("username").value
  let password = $("password").value
  
}

