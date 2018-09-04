create database user_details;

use user_details;

CREATE TABLE user_info(
user_id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(100),
last_name VARCHAR(100),
age INT,
dob DATE,
mobile_number VARCHAR(100),
email VARCHAR(100) UNIQUE,
password VARCHAR(100),
org_name VARCHAR(100),
image_url VARCHAR(100) DEFAULT './images/dummy.jpg'
);

INSERT INTO user_info(first_name, last_name,age,dob,mobile_number,email,password,org_name) VALUES ('dummy_user1','dummy',5,'1997-08-10',1234567890,'abc@abc.com','abcd','metacube');
INSERT INTO user_info(first_name, last_name,age,dob,mobile_number,email,password,org_name) VALUES ('dummy_user2','dummy',6,'1997-08-10',1234567890,'abc@abcd.com','abcd','metacube');
INSERT INTO user_info(first_name, last_name,age,dob,mobile_number,email,password,org_name) VALUES ('dummy_user3','dummy',7,'1997-08-10',1234567890,'abc@abcde.com','abcd','metacube');
INSERT INTO user_info(first_name, last_name,age,dob,mobile_number,email,password,org_name) VALUES ('dummy_user4','dummy',8,'1997-08-10',1234567890,'abc@abcsde.com','abcd','metacube');
INSERT INTO user_info(first_name, last_name,age,dob,mobile_number,email,password,org_name) VALUES ('dummy_user5','dummy',58,'1997-08-10',1234567890,'abc@abcdefg.com','abcd','google');

