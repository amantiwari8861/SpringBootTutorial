use rolebasedauth;
show tables;
select * from role;
select * from user;
SELECT * FROM user_role;

1234 -> $2a$10$Z6iSKrV5eJeNtgdeeMNa1OEA785r/rrtRr3n2h4Kwn8HPiHnQtXpe

$2a$10$AIoRzt7r58axoLrQOI2Ple23GXij7Ar92uiE/WVSANk7b3/XWWzQu

"token": 
"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbWFudGl3YXJpODg2MUBnbWFpbC5jb20iLCJleHAiOjE2ODUwMzY2OTMsImlhdCI6MTY4NTAxODY5M30.Rz2TWk46Ia8tCAamTii3Wiy97Rd6jKN7wDM8fltCUSR7Mdiz5Tl_XwhEoS_6TwRqCcprKfffzQjvmPFCl8rN1A"

Admin Token:eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbWFudGl3YXJpODg2MUBnbWFpbC5jb20iLCJleHAiOjE2ODUwNDI3NTksImlhdCI6MTY4NTAyNDc1OX0.guhhmuASds1dN-n7tn21G9QoeE0tg8L9hpHwkHn6Yw3DcYm4RTgDFeVTI4mLBIF12N2nrbnIQAR4GDmjRA1nvQ

User Token:eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyaXRlc2hAZ21haWwuY29tIiwiZXhwIjoxNjg1MDQ1OTg3LCJpYXQiOjE2ODUwMjc5ODd9.hDJA2o96tqAfk17l4aJ-NnWgzguwbWRqxZWIgX5Eh8G1usZIubpQ0fGGU-QlTQQbgiA_HlhAAKpcMjd48e2Ntg

Manager Token:eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyYWphdEBnbWFpbC5jb20iLCJleHAiOjE2ODUwNTAyMDksImlhdCI6MTY4NTAzMjIwOX0.BUOZhResFJ0ueqwG1uUIKm53clUA6e16MQzs86wAEREBy_7OBt5p4weAoDzll-1RK2cNpu4IybvwA9iegPh5ag



use jdbc;
create table allusers(id int primary key auto_increment,name varchar(255),
salary float,phone bigint);


insert into allusers(name,salary,phone)
values ("Aman",50000,"9891062743");

insert into allusers
values (2,"Aman",50000,"9891062743");
select * from allusers;

alter table allusers modify column phone bigint;



create database jdbc;
use jdbc;
desc megastudents;

select * from megastudents;
