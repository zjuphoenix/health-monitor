create database health;
use health;
create table user(
id INT(4) not null primary key auto_increment,
username VARCHAR(40) not null,
gender VARCHAR(2) not null,
password VARCHAR(40),
tel VARCHAR(20),
mail VARCHAR(30));
SELECT * FROM users WHERE username = #{username} LIMIT 1