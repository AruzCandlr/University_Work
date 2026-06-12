SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 1;
SET time_zone = "+08:00";

DROP DATABASE IF EXISTS Toy_Catalog;
CREATE DATABASE IF NOT EXISTS Toy_Catalog DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE Toy_Catalog;

CREATE TABLE IF NOT EXISTS LOGIN_INFO (
    login_id INT AUTO_INCREMENT PRIMARY KEY, 
    username VARCHAR(30),
    password VARCHAR(30),
    email VARCHAR(30),
    acc_time DATETIME
);

CREATE TABLE IF NOT EXISTS Admin (
    admin_id INT AUTO_INCREMENT PRIMARY KEY, 
    login_id INT,
    fname VARCHAR(30), 
    lname VARCHAR(30), 
    phone_num INT,
    FOREIGN KEY (login_id) REFERENCES LOGIN_INFO(login_id) -- Added foreign key constraint
);



CREATE TABLE IF NOT EXISTS Customer_Account (
    customer_id INT AUTO_INCREMENT PRIMARY KEY, -- Added AUTO_INCREMENT
    login_id INT,
    username VARCHAR(30),
    fname VARCHAR(30),
    lname VARCHAR(30), 
    email VARCHAR(30),
    password VARCHAR(30),
    phone_num VARCHAR(15), 
    pfp_link VARCHAR(255),
     FOREIGN KEY (login_id) REFERENCES LOGIN_INFO(login_id)
);

CREATE TABLE IF NOT EXISTS ITEM (
    item_id INT  AUTO_INCREMENT PRIMARY KEY, -- Added AUTO_INCREMENT
    admin_id INT,
    name VARCHAR(255),
    status BOOLEAN,
    quantity INT,
    description VARCHAR(255),
    price FLOAT,
    brand VARCHAR(255), 
    series VARCHAR(255),
    item_type VARCHAR(255),
    release_date VARCHAR(255),
    FOREIGN KEY (admin_id) REFERENCES Admin(admin_id)
);

CREATE TABLE IF NOT EXISTS Tag (
    tag_id INT AUTO_INCREMENT PRIMARY KEY, -- Added AUTO_INCREMENT
    tagname VARCHAR(255),
    tagtype VARCHAR(255) 
);

CREATE TABLE IF NOT EXISTS Item_Tag (
    item_id INT,
    tag_id INT,
    update_date DATETIME,
    PRIMARY KEY (item_id, tag_id),
    FOREIGN KEY (item_id) REFERENCES ITEM(item_id),
    FOREIGN KEY (tag_id) REFERENCES Tag(tag_id) -- Added foreign key constraint
);

CREATE TABLE IF NOT EXISTS Favorite_Item (
    item_id INT,
    customer_id INT,
    date_added DATETIME, 
    PRIMARY KEY (item_id, customer_id),
    FOREIGN KEY (item_id) REFERENCES ITEM(item_id),
    FOREIGN KEY (customer_id) REFERENCES Customer_Account(customer_id)
);

CREATE TABLE IF NOT EXISTS Image (
    image_id INT AUTO_INCREMENT PRIMARY KEY,
    isTumbnail BOOLEAN,
    image_name VARCHAR(255),
    image_url VARCHAR(255),
    item_id INT,
    FOREIGN KEY (item_id) REFERENCES ITEM(item_id)
);

--  insert login_info into login
INSERT INTO LOGIN_INFO (username, email ,password, acc_time) VALUES
('John Chena','johnCena@gmail.com', 'VivaLaVida', NOW()),
('Emily:)','emily1985@gmail.com', 'Smith0522', NOW()),
('Fosterity', 'jasnefoster322@outlook.com', 'daisyJane10', NOW()),
('SmoothCriminal','MicJohnson85@hotmail.com', '19Mic82', NOW()),
('ShopiaUWU', 'sophia2020@gmail.com', 'Anderson4567', NOW()),
('DAVEY JONE','DaveyJone@gmail.com', 'gAllard023', NOW()),
('CHESSboard','GrandMasterJessica@gmail.com', 'Jessy3321', NOW()),
('WIlliam','william.brown@outlook.com', 'browney20', NOW()),
('ARIA','TaylorAria@gmail.com', 'taylor1989', NOW()),
('danielmiror','daniel.miller@outlook.com', 'Sunflower2023', NOW()),
('janeDoe22', 'jane.doe22@example.net', 'D0eJane2024', NOW()),
('johnSmith', 'john.smith@email.com', '123John456', NOW()),
('aliceSprings', 'alice.springs@site.org', 'A1ic3Spr1ngs', NOW()),
('bobBuilder', 'bob.builder@build.com', 'BuildBob2024!', NOW()),
('charlieG', 'charlie.g@internet.com', 'Charl!eG987', NOW()),
('dannyPhantom', 'danny.phantom@ghost.com', 'PhantomDanny1', NOW()),
('emilyRose', 'emily.rose@example.org', 'Rose2024Em', NOW()),
('frankOcean', 'frank.ocean@music.com', 'OceanFrank2024!', NOW()),
('graceHopper', 'grace.hopper@compute.com', 'GraceH0p!', NOW()),
('harryPotter', 'harry.potter@wizard.com', 'Expelliarmus1', NOW()),
('BlueMoon', 'blue.moon@example.com', 'LunarPhase123', NOW());

-- Insert admin into Admin
INSERT INTO Admin (login_id, fname, lname, phone_num) VALUES
(1, 'John', 'Chena', 123-456-7890),
(11, 'John', 'Doe', 123-456-7890),
(12, 'Jane', 'Smith', 123-456-7891),
(13, 'Alice', 'Johnson', 123-456-7892),
(14, 'Bob', 'Lee', 123-456-7893),
(15, 'Charlie', 'Brown', 123-456-7894),
(16, 'Daisy', 'Miller', 123-456-7895),
(17, 'Edward', 'White', 123-456-7896),
(18, 'Fiona', 'Green', 123-456-7897),
(19, 'George', 'Black', 123-456-7898),
(20, 'Hannah', 'Gray', 123-456-7899);

-- Insert customer into Customer_Account
INSERT INTO Customer_Account (login_id, username, fname, lname, email, password, phone_num) VALUES
(2, 'Emily:)', 'Emily', 'Smith', 'emily1985@gmail.com', 'Smith0522', '085-123-4567'),
(3, 'Fosterity', 'Jane', 'foster', 'jasnefoster322@outlook.com', 'daisyJane10', '085-845-7985'),
(4, 'SmoothCriminal', 'Michael', 'Jackson', 'MicJohnson85@hotmail.com', '19Mic82', '085-369-2587'),
(5, 'ShopiaUWU', 'Sophia', 'Anderson', 'sophia2020@gmail.com', 'Anderson4567', 987-654-3210),
(6, 'DAVEY JONE', 'Davey', 'Jone', 'DaveyJone@gmail.com', 'gAllard023', 987-654-3211),
(7, 'CHESSboard', 'Jessica', 'Chess', 'GrandMasterJessica@gmail.com', 'Jessy3321', 987-654-3212),
(8, 'WIlliam', 'William', 'Brown', 'william.brown@outlook.com', 'browney20', 987-654-3213),
(9, 'ARIA', 'Aria', 'Taylor', 'TaylorAria@gmail.com', 'taylor1989', 987-654-3214),
(10, 'danielmiror', 'Daniel', 'Miller', 'daniel.miller@outlook.com', 'Sunflower2023', 987-654-3215),
(21, 'BlueMoon', 'Luna', 'Moon', 'blue.moon@example.com', 'LunarPhase123', 998-877-6610);

-- Insert item_id into ITEM
INSERT INTO ITEM (admin_id, name, status, quantity, description, price, brand, series, item_type, release_date) VALUES
(1, 'OMER TYPE-LAHIRE STASIS FULL PACKAGE VERSION', 1, 3, 'Plastic Model Kit, 401-600', 3000, 'KOTOBUKIYA', 'ARMORED CORE', 'Plastic Model Kit', 'July, 2024'),
(1, 'ELENA', 1, 5, 'Plastic Model Kit, 201 - 400 part', 3000, 'KOTOBUKIYA', 'ARCANADEA', 'Plastic Model Kit', 'February, 2024'),
(1, 'RABIOT (ORANGE)', 1, 10, 'Plastic Model Kit, 100-150 part', 450, 'BANDAI', '30 MINUTES MISSIONS', 'Plastic Model Kit', 'April, 2020'),
(1, 'PORTANOVA (SPACE TYPE)', 1, 10, 'Plastic Model Kit, 150-200 part', 650, 'BANDAI', '30 MINUTES MISSIONS', 'Plastic Model Kit' ,'January, 2020'),
(1, 'BUSTER DOLL PALADIN', 1, 5, 'Plastic Model Kit, 201-400', 1900, 'KOTOBUKIYA', 'MEGAMI DEVICE', 'Plastic Model Kit', 'June, 2024'),
(1, 'BEARGGUY OHANA & ALOHARO SET', 1, 10, 'Plastic Model Kit, 100 part', 900, 'BANDAI', 'GUNPLA HIGH GRADE', 'Plastic Model Kit' ,'February, 2024'),
(1, 'Hyper Body Modernia', 1, 3, 'Figma, 10-15 part', 3600, 'GOOD SMILE COMPANY', 'GODDESS OF VICTORY: NIKKE', 'Figma', 'December 2024'),
(1, 'GUNDAM PERFECT STRIKE FREEDOM ROUGE', 1, 10, 'Plastic Model Kit, 150-200 part', 1100, 'BANDAI', 'GUNPLA HIGH GRADE', 'Plastic Model Kit', 'January 2024'),
(1, 'ROSENTHAL CR-HOGIRE NOBLESSE OBLIGE FULL PACKAGE VERSION', 1, 3, 'Plastic Model Kit, 401-600', 3000, 'KOTOBUKIYA', 'ARMORED CORE', 'Plastic Model Kit', ''),
(1, 'DURGA II', 1, 5, 'Plastic Model Kit, 200 part', 2500, 'KOTOBUKIYA', 'FRAME ARMS GIRL', 'Plastic Model Kit', 'December, 2023');

-- Insert tag_id into Tag
INSERT INTO Tag (tagname, tagtype) VALUES
('OMER TYPE-LAHIRE STASIS FULL PACKAGE VERSION', 'Plastic Model Kit'),
('ELENA', 'Plastic Model'),
('RABIOT (ORANGE)', 'Plastic Model'),
('PORTANOVA (SPACE TYPE)',  'Plastic Model'),
('BUSTER DOLL PALADIN','Plastic Model'),
('BEARGGUY OHANA & ALOHARO SET','Plastic Model'),
('Hyper Body Modernia','Figma'),
('GUNDAM PERFECT STRIKE FREEDOM ROUGE','Plastic Model'),
('ROSENTHAL CR-HOGIRE NOBLESSE OBLIGE FULL PACKAGE VERSION','Plastic Model Kit'),
('DURGA II','Plastic Model');
-- Insert item into Item_Tag
INSERT INTO Item_Tag (item_id, tag_id, update_date) VALUES
(1, 1, NOW()),
(2, 2, NOW()),
(3, 3, NOW()),
(4, 4, NOW()),
(5, 5, NOW()),
(6, 6, NOW()),
(7, 7, NOW()),
(8, 8, NOW()),
(9, 9, NOW()),
(10,10, NOW());
-- Insert item into Favorite_Item
INSERT INTO Favorite_Item (item_id, customer_id, date_added) VALUES
(1, 1, NOW()),
(2, 1, NOW()),
(3, 1, NOW()),
(4, 2, NOW()),
(5, 3, NOW()),
(1, 6, NOW()),
(1, 8, NOW()),
(3, 9, NOW()),
(4, 10, NOW()),
(5, 1, NOW());

-- insert image to Image
INSERT INTO Image (isTumbnail, image_name, image_url, item_id) VALUES
-- omer
('1','OMER TYPE-LAHIRE STASIS FULL PACKAGE VERSION', 'http://localhost:8125/jpg/1',1),
('0','OMER TYPE-LAHIRE STASIS FULL PACKAGE VERSION product pic 1', 'http://localhost:8125/OMER%20TYPE-LAHIRE%20STASIS%20FULL%20PACKAGE%20VERSION/omer%20(1)',1),
('0','OMER TYPE-LAHIRE STASIS FULL PACKAGE VERSION product pic 2', 'http://localhost:8125/OMER%20TYPE-LAHIRE%20STASIS%20FULL%20PACKAGE%20VERSION/omer%20(2)',1),
('0','OMER TYPE-LAHIRE STASIS FULL PACKAGE VERSION product pic 3', 'http://localhost:8125/OMER%20TYPE-LAHIRE%20STASIS%20FULL%20PACKAGE%20VERSION/omer%20(3)',1),
('0','OMER TYPE-LAHIRE STASIS FULL PACKAGE VERSION product pic 4', 'http://localhost:8125/OMER%20TYPE-LAHIRE%20STASIS%20FULL%20PACKAGE%20VERSION/omer%20(4)',1),
-- elena
('1','ELENA', 'http://localhost:8125/jpg/2', 2), -- localhost need change
('0',' product pic 1', 'http://localhost:8125/ELENA/elena%20(1)', 2),
('0',' product pic 2', 'http://localhost:8125/ELENA/elena%20(2)', 2),
('0',' product pic 3', 'http://localhost:8125/ELENA/elena%20(3)', 2),
('0',' product pic 4', 'http://localhost:8125/ELENA/elena%20(4)', 2),
-- rabiot
('1','RABIOT (ORANGE)', 'http://localhost:8125/jpg/3',3),
('0','RABIOT (ORANGE) product pic 1', 'http://localhost:8125/RABIOT%20(ORANGE)/rabiot%20(1)',3),
('0','RABIOT (ORANGE) product pic 2', 'http://localhost:8125/RABIOT%20(ORANGE)/rabiot%20(3)',3),
('0','RABIOT (ORANGE) product pic 3', 'http://localhost:8125/RABIOT%20(ORANGE)/rabiot%20(2)',3),
('0','RABIOT (ORANGE) product pic 4', 'http://localhost:8125/RABIOT%20(ORANGE)/rabiot%20(4)',3),
-- portnova
('1', 'PORTANOVA (SPACE TYPE)',  'http://localhost:8125/jpg/4',4),
('0', 'PORTANOVA (SPACE TYPE) product pic 1',  'http://localhost:8125/PORTANOVA%20(SPACE%20TYPE)/portnova%20(1)',4),
('0', 'PORTANOVA (SPACE TYPE) product pic 2',  'http://localhost:8125/PORTANOVA%20(SPACE%20TYPE)/portnova%20(2)',4),
('0', 'PORTANOVA (SPACE TYPE) product pic 3',  'http://localhost:8125/PORTANOVA%20(SPACE%20TYPE)/portnova%20(3)',4),
('0', 'PORTANOVA (SPACE TYPE) product pic 4',  'http://localhost:8125/PORTANOVA%20(SPACE%20TYPE)/portnova%20(4)',4),
-- paladin
('1','BUSTER DOLL PALADIN','http://localhost:8125/jpg/5',5),
('0','BUSTER DOLL PALADIN product pic 1','http://localhost:8125/BUSTER%20DOLL%20PALADIN/paladin%20(1)',5),
('0','BUSTER DOLL PALADIN product pic 2','http://localhost:8125/BUSTER%20DOLL%20PALADIN/paladin%20(2)',5),
('0','BUSTER DOLL PALADIN product pic 3','http://localhost:8125/BUSTER%20DOLL%20PALADIN/paladin%20(3)',5),
('0','BUSTER DOLL PALADIN product pic 4','http://localhost:8125/BUSTER%20DOLL%20PALADIN/paladin%20(4)',5),
-- ohana & aloharo
('1','BEARGGUY OHANA & ALOHARO SET','http://localhost:8125/jpg/6',6),
('0','BEARGGUY OHANA & ALOHARO SET product pic 1','http://localhost:8125/BEARGGUY%20OHANA%20&%20ALOHARO%20SET/ohana%20(1)',6),
('0','BEARGGUY OHANA & ALOHARO SET product pic 2','http://localhost:8125/BEARGGUY%20OHANA%20&%20ALOHARO%20SET/ohana%20(2)',6),
('0','BEARGGUY OHANA & ALOHARO SET product pic 3','http://localhost:8125/BEARGGUY%20OHANA%20&%20ALOHARO%20SET/ohana%20(3)',6),
('0','BEARGGUY OHANA & ALOHARO SET product pic 4','http://localhost:8125/BEARGGUY%20OHANA%20&%20ALOHARO%20SET/ohana%20(4)',6),
-- modernia
('1','Hyper Body Modernia','http://localhost:8125/jpg/7',7),
('0','Hyper Body Modernia product pic 1','http://localhost:8125/Hyper%20Body%20Modernia/mordernia%20(1)',7),
('0','Hyper Body Modernia product pic 2','http://localhost:8125/Hyper%20Body%20Modernia/mordernia%20(2)',7),
('0','Hyper Body Modernia product pic 3','http://localhost:8125/Hyper%20Body%20Modernia/mordernia%20(3)',7),
('0','Hyper Body Modernia product pic 4','http://localhost:8125/Hyper%20Body%20Modernia/mordernia%20(4)',7),
-- rabiot
('1','GUNDAM PERFECT STRIKE FREEDOM ROUGE','http://localhost:8125/jpg/8',8),
('0','GUNDAM PERFECT STRIKE FREEDOM ROUGE product pic 1','http://localhost:8125/GUNDAM%20PERFECT%20STRIKE%20FREEDOM%20ROUGE/rouge%20(1)',8),
('0','GUNDAM PERFECT STRIKE FREEDOM ROUGE product pic 2','http://localhost:8125/GUNDAM%20PERFECT%20STRIKE%20FREEDOM%20ROUGE/rouge%20(2)',8),
('0','GUNDAM PERFECT STRIKE FREEDOM ROUGE product pic 3','http://localhost:8125/GUNDAM%20PERFECT%20STRIKE%20FREEDOM%20ROUGE/rouge%20(3)',8),
('0','GUNDAM PERFECT STRIKE FREEDOM ROUGE product pic 4','http://localhost:8125/GUNDAM%20PERFECT%20STRIKE%20FREEDOM%20ROUGE/rouge%20(4)',8),
-- ROSENTHAL
('1','ROSENTHAL CR-HOGIRE NOBLESSE OBLIGE FULL PACKAGE VERSION','http://localhost:8125/jpg/9',9),
('0','ROSENTHAL CR-HOGIRE NOBLESSE OBLIGE FULL PACKAGE VERSION product pic 1','http://localhost:8125/ROSENTHAL%20CR-HOGIRE%20NOBLESSE%20OBLIGE%20FULL%20PACKAGE%20VERSION/rosenthal%20(1)',9),
('0','ROSENTHAL CR-HOGIRE NOBLESSE OBLIGE FULL PACKAGE VERSION product pic 2','http://localhost:8125/ROSENTHAL%20CR-HOGIRE%20NOBLESSE%20OBLIGE%20FULL%20PACKAGE%20VERSION/rosenthal%20(2)',9),
('0','ROSENTHAL CR-HOGIRE NOBLESSE OBLIGE FULL PACKAGE VERSION product pic 3','http://localhost:8125/ROSENTHAL%20CR-HOGIRE%20NOBLESSE%20OBLIGE%20FULL%20PACKAGE%20VERSION/rosenthal%20(3)',9),
('0','ROSENTHAL CR-HOGIRE NOBLESSE OBLIGE FULL PACKAGE VERSION product pic 4','http://localhost:8125/ROSENTHAL%20CR-HOGIRE%20NOBLESSE%20OBLIGE%20FULL%20PACKAGE%20VERSION/rosenthal%20(4)',9),
-- DURGA
('1','DURGA II','http://localhost:8125/jpg/10',10),
('0','DURGA II product Pic 1','http://localhost:8125/DURGA%20II/durga%20(1)',10),
('0','DURGA II product Pic 2','http://localhost:8125/DURGA%20II/durga%20(2)',10),
('0','DURGA II product Pic 3','http://localhost:8125/DURGA%20II/durga%20(3)',10),
('0','DURGA II product Pic 4','http://localhost:8125/DURGA%20II/durga%20(4)',10),
('0','DURGA II product Pic 5','http://localhost:8125/DURGA%20II/durga%20(5)',10),
('0','DURGA II product Pic 6','http://localhost:8125/DURGA%20II/durga%20(6)',10);





