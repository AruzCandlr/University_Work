const express = require('express');
const path = require('path');
const jwt = require("jsonwebtoken");
const dotenv = require("dotenv");
const cp = require('cookie-parser')
const port = 8025;

const app = express();

dotenv.config();

const router = express.Router();
app.use(router);
router.use(cp())
router.use(express.json());
router.use(express.urlencoded({ extended: true }));

//=====================================================================================================================================================
//authen route

router.get('/login', function (req, res){
    const username =  req.body.username;
    const user = { name: username}
    const accessToken = jwt.sign(user, process.env.ACCESS_TOKEN_SECRET)
    res.cookie('token',accessToken)
    res.redirect('/admin_account')
});

router.get('/logout', function (req, res){
    res.clearCookie('token');
    res.redirect('/home')
});


async function AuthenticationToken(req, res, next){
    // console.log(req.cookie)
    var token = req.cookies['token'];
    // console.log(token)
    try{
        const user = jwt.verify(token, process.env.ACCESS_TOKEN_SECRET);
        req.user = user;
        // console.log('pass')
        next()
    }catch{
        res.clearCookie('token')
        return res.sendStatus(403);
    }
    
        
   
    
}

//=====================================================================================================================================================
//get team image
router.get('/teamImg/:member', function(req, res) {
    let memberName = req.params.member;
    res.status(200).sendFile(path.join(__dirname + '/src/img/'+memberName+'.png'));
});

//=====================================================================================================================================================
//get css
router.get('/:id'+'.css', function(req, res) {
    let pageName = req.params.id;
    res.status(200).sendFile(path.join(`${__dirname}/src/css/`+pageName+`.css`))
});

//=====================================================================================================================================================
//get javascript
router.get('/:id'+'.js', function(req, res) {
    let pageName = req.params.id;
    res.status(200).sendFile(path.join(`${__dirname}/src/js/`+pageName+`.js`))
});

//=====================================================================================================================================================
//get icon
router.get('/:id'+'.png', function(req, res) {
    let pageName = req.params.id;
    res.status(200).sendFile(path.join(`${__dirname}/src/icon/`+pageName+`.png`))
});

//=====================================================================================================================================================
//get admin page
router.get('/admin_account', AuthenticationToken,(req,res) =>{
    res.status(200).sendFile(path.join(`${__dirname}/src/html/admin_account.html`))
})

router.get('/ca_manage', AuthenticationToken,(req,res) =>{
    res.status(200).sendFile(path.join(`${__dirname}/src/html/ca_manage.html`))
})

router.get('/ca_edit', AuthenticationToken,(req,res) =>{
    res.status(200).sendFile(path.join(`${__dirname}/src/html/ca_edit.html`))
})

router.get('/add_ca', AuthenticationToken,(req,res) =>{
    res.status(200).sendFile(path.join(`${__dirname}/src/html/add_ca.html`))
})

router.get('/item_manage', AuthenticationToken,(req,res) =>{
    res.status(200).sendFile(path.join(`${__dirname}/src/html/item_manage.html`))
})

router.get('/item_edit', AuthenticationToken,(req,res) =>{
    res.status(200).sendFile(path.join(`${__dirname}/src/html/item_edit.html`))
})

router.get('/add_item', AuthenticationToken,(req,res) =>{
    res.status(200).sendFile(path.join(`${__dirname}/src/html/add_item.html`))
})

//=====================================================================================================================================================
//get html page
router.get('/', (req,res) =>{
    res.status(200).sendFile(path.join(`${__dirname}/src/html/home.html`))
})

router.get('/:id', (req,res) =>{
    let pageName = req.params.id;
    if(require('fs').existsSync(path.join(`${__dirname}/src/html/`+pageName+`.html`))){
    console.log("Request at "+ req.url);
    res.status(200).sendFile(path.join(`${__dirname}/src/html/`+pageName+`.html`))}
    else{
        console.log("404: Invalid accessed");
	    res.status(404).sendFile(path.join(`${__dirname}/src/html/404_page.html`));
    }
})

// router.get('/:id', (req,res) =>{
//     let pageName = req.params.id;
//     res.status(200).sendFile(path.join(`${__dirname}/src/html/`+pageName+`.html`))
// })

//=====================================================================================================================================================
//get custom product html page
router.get('/product/:id', (req,res) =>{
    let product = req.params.id;
    console.log("Request at "+ req.url);
    res.status(200).sendFile(path.join(`${__dirname}/src/html/poduct_info.html`))
})

//=====================================================================================================================================================
// get search result for seach bar
router.post('/searchProduct', (req,res) =>{
    console.log("Request at "+ req.url);
    res.status(200).sendFile(path.join(`${__dirname}/src/html/search_result.html`))
})


//=====================================================================================================================================================
// error page

router.use((req, res, next) => {
	console.log("404: Invalid accessed");
	res.status(404).sendFile(path.join(`${__dirname}/src/html/404_page.html`));
});


app.listen(port, () =>{
    console.log(`Server listening on port: ${port}`)
})