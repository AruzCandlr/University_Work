/*
require to have this in html
    
    (bootstrap)

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

    ***also require this after the header 
     <div id="navInit"></div>
     <script src="nav.js"></script>


*/

let Home = '../home'
let Search = '../advance_search'
let Login = '../login_page'
var isLogin = '' // true if already login

if(window.localStorage.getItem('loginStatus') == null){
    isLogin = false;
} else{
    isLogin = true;
} 

let Product = '../product'

let Team = '../team'
let Account = '../account'

let nav = `
<style>
    #navIcon {
        
        background-color: #E5F9FF;
        width: 5%;
        position: absolute;
        top: 7px;
        right: 16px;
        font-size: 18px;
    }

    @media screen and (max-width: 767px) {

        #navIcon {

            width: 50px;
        }

    }
</style>

<nav class="navbar  fixed-top">

<div class="container-fluid">
    <a class="navbar-brand" href="#">
        <!--logo-->
        
        </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas"
        data-bs-target="#offcanvasNavbar" style="outline: none; box-shadow: none">
        <!--button to toggle app-->
        <span>
            <img src="/nav.png" class="img-fluid circular rounded-circle" id="navIcon">
        </span>
    </button>
    <div class="offcanvas offcanvas-end" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
        <div class="offcanvas-background">
            <img src="/logo.png" class="img-fluid" style="width:40%">
        </div>
        <div class="offcanvas-header">
            <h5 class="offcanvas-title display-6" id="offcanvasNavbarLabel">PoggoTOY</h5>
            <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <div class="offcanvas-body p-2">
            <ul class="navbar-nav justify-content-end flex-grow-2 display-6">
                <li class="nav-item">
                    <a class="nav-link" href="${Home}">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${Search}">Search</a>
                </li>
               
                <li class="nav-item">

                    <div id='login'></div>

                </li>
                
                <li class="nav-item">
                    <a class="nav-link" href="${Product}">Product</a>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link" href="${Team}">Team</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id='Account' href="${Account}">Account</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
`

document.getElementById('navInit').innerHTML = nav

if (isLogin) {
  document.getElementById('login').innerHTML = `<a class="nav-link" id="logout" onclick="logoff()">Logout</a>`
  if(sessionStorage.getItem('admin_id')===null){
   
  }else{
    document.getElementById('Account').innerHTML = '';
  }
} else {
  document.getElementById('login').innerHTML = `<a class="nav-link" href="${Login}">Login</a>`
  document.getElementById('Account').innerHTML = `<a class="nav-link" href="${Login}">Account</a>`
}

function logoff(){
    localStorage.clear();
    sessionStorage.clear();
    window.location.href='/logout';
}
