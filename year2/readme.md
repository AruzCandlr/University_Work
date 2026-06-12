--This is the readme for the project--


Thank you for using poggoToy

this small txt document will demonstrate to you how the project is to be run on your computer

1. to start using poggoToy, first you open up ide of your choic andmust put the current directory to the main frontend server path (the folder where PoggoToyClient is located).
from there type "npm start" into the terminal and you should see "Server listening on port: 8025" as a responds

2. Next connect the SQL with our .env file. Firstly open up MySQL and login, run the .sql file once to generate the schema and set user and privileges to allow access to the data base(located in the server option at the top left). Set the user name to be "team25" and host as "localhost", the password should be set as "UK44RE", click apply and move to the schema Privileges. From here click add entry an add toy_catalog into it. Afterward, select the toy_catalog schema and tick "SELECT","INSERT","UPDATE", and "DELETE" in Object Right section
click apply and that's all for the sql.

3.lastly,go back to your ide and set the current path to the server folder(the one with the PoggoToyService.js inside). Type "npm start" into the terminal and you should see "Server listening on port: 8125" and "Connected DB: toy_catalog" as a responds, if an error occure check that you did step 2 correctly or contact us for help.

once everything is setup and running, type http://localhost:8025/ to get to our homepage. The documentaton of how each page work and the code can be find with in this folder and should be read upon for help.

'footnote'
- customer can add item to favorite but cannot remove from it
- only customer account can be edit 
- the signup page does not add you information into the database, if you would like to make an account please contact one of our admin
- the policy page does not exist
- when adding new item, make sure to give sometime for the api to generate the url for displaying image first, usually wait around 5 second after pressing add, before proceding to other task
- admin cannot get back to the admin_page once go back to home, for this proble, logout and login again
