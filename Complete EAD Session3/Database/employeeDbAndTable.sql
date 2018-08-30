create database employee;
use employee;

create table if not exists employee (
    employee_id int primary key AUTO_INCREMENT,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email_id varchar(50) unique,
    age int
);

insert into employee (employee_id, first_name, last_name, email_id, age) values
    ('1','abhinav','sharma','abhi@gmail.com','23'),
    ('2','ajay','vijay','akv@gmail.com','21'),
    ('3','akshay','singh','akki@gmail.com','22'),
    ('4','aman','jain','aman@gmail.com','21'),
    ('5','anita','sahu','sahu@gmail.com','22');