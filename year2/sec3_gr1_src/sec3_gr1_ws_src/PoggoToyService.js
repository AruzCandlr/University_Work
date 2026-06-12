const express = require('express');
const path = require('path');
const dotenv = require("dotenv");
const mysql = require('mysql2');
const cors = require('cors');
const jwt = require("jsonwebtoken");
const cp = require('cookie-parser')
const port = 8125;

const app = express();

/* Import and use Environmental Variable */
dotenv.config();

//Connect with frontend with cors
let corsOptions = {
    origin: 'http://localhost:8025',
    methods: 'GET,POST,PUT,DELETE'
}
app.use(cors(corsOptions));

// Create a router object
const router = express.Router();
app.use(router);
router.use(cp())
router.use(express.json());
router.use(express.urlencoded({ extended: true }));

// create the connection to database
let dbConn = mysql.createConnection({
    host: process.env.MYSQL_HOST,
    user: process.env.MYSQL_USERNAME,
    password: process.env.MYSQL_PASSWORD,
    database: process.env.MYSQL_DATABASE
    });


// apply route
//=====================================================================================================================================================

//=====================================================================================================================================================
//get Login check

router.get('/login/:user/:pass', function(req, res) {
    let GetUserName = req.params.user;
    let pass = req.params.pass;

                            // const username =  req.params.user;
                            // const user = { name: username}
                            // const accessToken = jwt.sign(user, process.env.ACCESS_TOKEN_SECRET);
                            // res.cookie('token',accessToken);
                            
    dbConn.query(`SELECT * FROM LOGIN_INFO 
                  WHERE username = ? AND password = ?`,[GetUserName, pass], function (error, login_info) {
    if (error){
        throw error;
    } else if(login_info.length != 0){
        dbConn.query(`SELECT * FROM Admin 
                      WHERE login_id = ?`,[login_info[0].login_id], function (error, admin_info) {
                        if (error){
                            throw error;
                        }else if(admin_info.length == 0){
                            dbConn.query(`SELECT * FROM Customer_Account 
                                          WHERE login_id = ?`,[login_info[0].login_id], function (error, customer_info) {
                                                if (error){
                                                    throw error;
                                                }else
                                                customer_info.forEach(value1 => value1.type = 'Customer');
                                                return res.send({error: false, data: customer_info, message: 'login as customer' });
                            });
                        }else if(admin_info.length==1){
                            
                            admin_info.forEach(value2 => value2.type = 'admin');
                            return res.send({error: false, data: admin_info, message: 'login as admin' });
                        }
        })
    }else  
    return res.send({error: false, data: login_info, message: 'login info not found' });
    });
});

//=====================================================================================================================================================
//get customer account info

router.get('/accountInfo/:ID', function(req, res) {

    let id = req.params.ID;

    dbConn.query(`SELECT * FROM Customer_Account 
                  WHERE customer_id = ?`,[id], function (error, results) {
    if (error) throw error;
    return res.send({ error: false, data: results, message: 'last 3 image send' });
    });
});

//=====================================================================================================================================================
//get account detail

router.get('/accountPage/:ID', function (req, res) {

    let id = req.params.ID;

    dbConn.query(`SELECT * FROM Customer_Account
                  INNER JOIN Favorite_Item ON Customer_Account.customer_id = Favorite_Item.customer_id
                  INNER JOIN ITEM ON Favorite_Item.item_id = ITEM.item_id
                  INNER JOIN Image ON ITEM.item_id = Image.item_id
                  WHERE isTumbnail = 1 AND
                  Customer_Account.customer_id = ?`,[id], function (error, results) {
    if (error) throw error;
    return res.send({ error: false, data: results, message: 'All item that is favorite by this account' });
    });
})

//=====================================================================================================================================================
//add item to favorite

router.post('/addToFavorite', function (req, res) {
let customer_id = req.body.customer_id;
let item_id = req.body.item_id;

    dbConn.query(`SELECT * FROM Favorite_Item
                  WHERE item_id = ? AND
                  customer_id = ?`,[item_id,customer_id], function (error, results) {
                    console.log(results)
    if (error){
        throw error;
    } else if(results.length==0){
        dbConn.query(`INSERT INTO Favorite_Item (item_id, customer_id, date_added) VALUES
                      (?, ?, now())`,[item_id,customer_id], function (error, addResult) {
                        if (error) throw error;
                        return res.send({ error: false, data: addResult, message: 'item added to favorite successfully' });
                        });
    }else{
        return res.send({ error: false, data: results, message: 'item already exist in favorite' });
    }
    });
})
//=====================================================================================================================================================
//product management

router.get('/ProductManagement', function (req, res) {
    dbConn.query("SELECT item_id, name, price, quantity FROM ITEM", function (error, results) {
    if (error) throw error;
    return res.send({error: false, data: results, message: 'Product data have been successfully retrieve.'});
    });
});


router.post('/ProductManagement', function (req, res) {
    
    
    let admin_id = req.body.admin_id;
    let item_name = req.body.item_name;
    let quantity = req.body.quantity;
    let description = req.body.description;
    let price = req.body.price;
    let brand = req.body.brand;
    let series = req.body.series;
    let item_type = req.body.item_type;

    dbConn.query(`INSERT ITEM (admin_id, name, status, quantity, description, price, brand, series, item_type, release_date) VALUES
                (?, ?, 1, ?, ?, ?, ?, ?, ?, now())`, [admin_id, item_name, quantity, description, price, brand, series, item_type], function (error, results) {
    if (error) throw error;
    return res.send({error: false, data: results, message: 'item information have been successfully added.'});
    });
});

router.post('/ImageAdd', function (req, res) {
    let imgType = req.body.isThumbnail;
    let name = req.body.item_name;
    let url = req.body.url;
    let item_id = req.body.item_id;
    let imgNum = req.body.imgNum
    
    

    if(imgType==1){
        dbConn.query(`INSERT INTO Image (isTumbnail, image_name, image_url, item_id) VALUES
                     ('1', ?, ?, ?)`,[name, url, item_id], function (error, results){
        if (error) throw error;
        return res.send({error: false, data: results, message: 'item information have been successfully added.'});
                     });
    }else if(imgType==0){
        dbConn.query(`INSERT INTO Image (isTumbnail, image_name, image_url, item_id) VALUES
                     ('0', ?, ?, ?)`,[name+' '+imgNum, url, item_id], function (error, results){
        if (error) throw error;
        return res.send({error: false, data: results, message: 'item image information have been successfully added.'});
                     });
    }
})


router.put('/ProductManagement', function (req, res) {
    let item_id = req.body.item_id;
    let item_name = req.body.item_name;
    let status = req.body.status;
    let quantity = req.body.quantity;
    let description = req.body.description;
    let price = req.body.price;
    
    dbConn.query(`UPDATE ITEM SET name = ?,
                  status = ? ,
                  quantity = ? ,
                  description = ? ,
                  price = ?
                  WHERE item_id = ? `, [item_name, status, quantity, description, price, item_id], function (error,results) {
    if (error) throw error;
    return res.send({error: false, data: results, message: 'Customer Account information have been successfully updated.'})
    });
});

router.delete('/ProductManagement', function (req, res) {
    console.log(req.body)
    let item_id = req.body.item_id;
    
    dbConn.query('DELETE FROM Favorite_Item WHERE item_id = ?', [item_id])
    dbConn.query('DELETE FROM Item_Tag WHERE item_id = ?', [item_id])
    dbConn.query('DELETE FROM Image WHERE item_id = ?', [item_id])
    dbConn.query('DELETE FROM ITEM WHERE item_id = ?', [item_id], function (error, results)
    {
    if (error) throw error;
    return res.send({ error: false, data: results, message: 'Customer Account information have been successfully deleted.' });
    });
});

router.get('/getItemInfo/:id', function (req, res) {
    let productId = req.params.id

    dbConn.query(`SELECT * FROM ITEM
                  WHERE item_id = ?`,[productId], function (error, results) {
    if (error) throw error;
    return res.send({error: false, data: results, message: 'Item information successfully retrieve.'});
    });
});

//=====================================================================================================================================================

//Account management
router.get('/AccountManagement', function (req, res) {
    dbConn.query("SELECT customer_id, username, fname, lname FROM Customer_Account", function (error, results) {
    if (error) throw error;
    return res.send({error: false, data: results, message: 'New Product have been successfully retrieve.'});
    });
});


router.post('/AccountManagement', function (req, res) {

    console.log(req.body)
    
    let fname = req.body.fname;
    let lname = req.body.lname;
    let username = req.body.username;
    let phone_num = req.body.phone_num;
    let email = req.body.email;
    let password = req.body.password;

    dbConn.query(`INSERT LOGIN_INFO (username, email ,password, acc_time) VALUES
                (?, ?, ?, now())`, [username, email, password], function (error, results) {
    if (error){
        throw error;
    } dbConn.query(`INSERT Customer_Account (login_id, username, fname, lname, email, password, phone_num) VALUES
    (?, ?, ?, ?, ?, ?, ?)`, [results.insertId, username, fname, lname, email, password, phone_num], function (error, customerAccData) {
        if (error) throw error;
            return res.send({error: false, data: customerAccData, message: 'Customer Account information have been successfully added.'});
});
    });
    
});

router.put('/AccountManagement', function (req, res) {

    console.log(req.body)
    let customer_id = req.body.customer_id;
    let fname = req.body.fname;
    let lname = req.body.lname;
    let username = req.body.username;
    let phone_num = req.body.phone_num;
    let email = req.body.email;
    let password = req.body.password;
    let acc_type = req.body.acc_type;

    
    dbConn.query(`UPDATE Customer_Account SET username = ?,
                  fname = ? ,
                  lname = ? ,
                  email = ? ,
                  password = ?
                  WHERE customer_id = ? `, [username, fname, lname, email, password, customer_id], function (error,results) {
    if (error) throw error;
    return res.send({error: false, data: results, message: 'Customer Account information have been successfully updated.'})
    });
});

router.delete('/AccountManagement', function (req, res) {

    console.log(req.body)
    let customer_id = req.body.customer_id;
    
    dbConn.query('DELETE FROM Favorite_Item WHERE customer_id = ?', [customer_id])
    dbConn.query('DELETE FROM Customer_Account WHERE customer_id = ?', [customer_id], function (error, results)
    {
    if (error) throw error;
    return res.send({ error: false, data: results, message: 'Customer Account information have been successfully deleted.' });
    });
});


//=====================================================================================================================================================
//search product

router.get('/searchProduct',async function (req, res) {
    dbConn.query(`SELECT * FROM ITEM 
                  INNER JOIN Image on ITEM.item_id = Image.item_id 
                  WHERE isTumbnail = 1`, function (error, results) {

    if (error) throw error;
    return res.send({ error: false, data: results, message: 'ALL item information list.' });
    });
}); 


router.get('/searchProduct/:input', function (req, res) {
    let data = '\'%'+ req.params.input+'%\'';
    console.log(data);
    
    dbConn.query(`SELECT * FROM ITEM 
                  INNER JOIN Image on ITEM.item_id = Image.item_id 
                  WHERE name LIKE`+ data+`AND isTumbnail = 1`, function (error, results) {
    if (error) throw error;
    return res.send({ error: false, data: results, message: 'Personal information retrieved' });
    });
});       


router.get('/searchProduct/:input/:brand/:type/:series/:order', function (req, res) {

    let data = req.params.input=='*' ? '%%' : '%'+ req.params.input+'%';
    let brand = req.params.brand=='*' ? '%%' : '%'+req.params.brand+'%';
    let series = req.params.series=='*' ? '%%' : '%'+req.params.series+'%';
    let type = req.params.type=='*' ? '%%' : '%'+req.params.type+'%';
    // var order = req.params.order;
    if(req.params.order=='price'){
        dbConn.query(`SELECT * FROM ITEM 
                      INNER JOIN Image on ITEM.item_id = Image.item_id 
                      WHERE name LIKE ? AND 
                      isTumbnail = 1 AND
                      brand LIKE ? AND
                      item_type LIKE ? AND
                      series LIKE ? 
                      ORDER BY price`,[data,brand,type,series], function (error, results) {
                        
        if (error) throw error;
        return res.send({ error: false, data: results, message: 'Personal information retrieved' });
        });
    }else if(req.params.order=='name'){
        dbConn.query(`SELECT * FROM ITEM 
                      INNER JOIN Image on ITEM.item_id = Image.item_id 
                      WHERE name LIKE ? AND 
                      isTumbnail = 1 AND
                      brand LIKE ? AND
                      item_type LIKE ? AND
                      series LIKE ? 
                      ORDER BY name`,[data,brand,type,series], function (error, results) {
                        
        if (error) throw error;
        return res.send({ error: false, data: results, message: 'Personal information retrieved' });
        });
    }else if(req.params.order=='new'){
        dbConn.query(`SELECT * FROM ITEM 
                      INNER JOIN Image on ITEM.item_id = Image.item_id 
                      WHERE name LIKE ? AND 
                      isTumbnail = 1 AND
                      brand LIKE ? AND
                      item_type LIKE ? AND
                      series LIKE ? 
                      ORDER BY ITEM.item_id desc`,[data,brand,type,series], function (error, results) {
                        
        if (error) throw error;
        return res.send({ error: false, data: results, message: 'Personal information retrieved' });
        });
    }else if(req.params.order=='old'){
        dbConn.query(`SELECT * FROM ITEM 
                      INNER JOIN Image on ITEM.item_id = Image.item_id 
                      WHERE name LIKE ? AND 
                      isTumbnail = 1 AND
                      brand LIKE ? AND
                      item_type LIKE ? AND
                      series LIKE ? 
                      ORDER BY ITEM.item_id`,[data,brand,type,series], function (error, results) {
                        
        if (error) throw error;
        return res.send({ error: false, data: results, message: 'Personal information retrieved' });
        });
    }



}); 
//=====================================================================================================================================================
//get product image
router.get('/getProductImg', function (req, res) {
    dbConn.query(`SELECT * FROM image 
                  INNER JOIN ITEM ON image.item_id = ITEM.item_id 
                  WHERE isTumbnail = 1 
                  ORDER BY image_id 
                  desc`, function (error, results) {
    if (error) throw error;
    return res.send({ error: false, data: results, message: 'all product information loaded from last inserted' });
    });
});    

//=====================================================================================================================================================
//productInfoPage
router.get('/product/:id', function (req, res) {
    let productId = req.params.id
    dbConn.query(`SELECT * FROM ITEM 
                  INNER JOIN image ON ITEM.item_id = image.item_id 
                  WHERE ITEM.item_id = ? ORDER BY image_id`, productId, function (error, results) {
    if (error) throw error;
    return res.send({ error: false, data: results, message: 'load product info' });
    });
});  

//=====================================================================================================================================================
//getImg
router.get('/jpg/:id', function(req, res) {
    let imgId = req.params.id;
    res.sendFile(path.join(__dirname + '/img/thumbnail/'+imgId+'.jpg'));
});

router.get('/:product/:id', function(req, res) {
    let product = req.params.product;
    let id= req.params.id
    res.sendFile(path.join(__dirname + '/img/prod/'+product+'/'+id+'.jpg'));
});

//=====================================================================================================================================================
//get tag-info for search page

router.get('/tag-info', function(req, res) {
    dbConn.query(`SELECT DISTINCT brand, series, item_type FROM ITEM`, function (error, results) {
    if (error) throw error;
    return res.send({ error: false, data: results, message: 'last 3 image send' });
    });
});



// connect to port
app.listen(port, () =>{
    console.log(`Server listening on port: ${port}`)
})

dbConn.connect(function(err){
    if(err) throw err;
    console.log("Connected DB: "+ process.env.MYSQL_DATABASE);
    });