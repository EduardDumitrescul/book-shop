create table inventories(id int not null primary key auto_increment);

create table users(id int not null primary key auto_increment,username varchar(64) not null,password varchar(64) not null,inventoryId int not null references inventories(id));

create table shops(id int not null primary key auto_increment,openingHour int not null ,closingHour int not null,location varchar(64) not null,itemsSold int not null,dollarsReceived int not null,inventoryId int not null references inventories(id),ownerId int not null references users(id));

create table items(id int not null primary key auto_increment,price int not null);

create table notebooks(id int not null primary key references items(id),type varchar(64) not null,numberOfPages int not null,numberOfPagesWritten int not null);

create table cookbooks(id int not null primary key references items(id),skillLevel varchar(64) not null,numberOfRecipes int not null,numberOfRecipesTried int not null);

create table coloringBooks(id int not null primary key references items(id), theme varchar(64) not null,numberOfDrawings int not null,numberOfDrawingsCompleted int not null);

create table books(id int not null primary key references items(id),title varchar(64) not null,author varchar(64) not null,numberOfPages int not null,numberOfPagesRead int not null);

create table inventoryItemCrossRef(itemId int not null references items(id),inventoryId int not null references inventories(id), count int not null,primary key(itemId, inventoryId));



