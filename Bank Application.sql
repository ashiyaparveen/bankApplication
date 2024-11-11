create database bank01;
use bank01;
create table Account(acc_id int primary key unique,username varchar(20),acc_type varchar(20),balance int,password varchar(20),phone int,address varchar(30),branch varchar(10));
select * from Account;
show tables;

create table admin(admin_id int primary key auto_increment,username varchar(50) not null,password varchar(20));

create table Transactions(trans_id int primary key not null auto_increment,acc_id int,foreign key(acc_id) references Account(acc_id),from_acc int,foreign key(from_acc) references Account(acc_id),to_acc int,foreign key(to_acc) references Account(acc_id),amount int,dateosftrans date,type varchar(20) not null,trans_amt float,acc_bal float not null);
desc Transactions; 
desc admin;
select * from admin;
select * from Account;
Insert into account values(1,"Ashiya","savings",4786,"ashiya",984679,"dh","cbe");
select * from account;
select * from transactions;
Insert into account values(2,"Ashi","savings",4786,"ashi",984679,"dh","cbe");
select * from account;
select * from transactions;
select * from account where acc_id in(
select distinct(acc_id) from transactions where
 dateosftrans="2024-11-09");
 select distinct (a.acct_id),a.* from account a join trasactions t
 on a.acc_id=t.acc_id where
 d.date = 2024-11-09;
 select * from transactions;