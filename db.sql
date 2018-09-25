create database employee_portal13;

use employee_portal13;

create table employee( 
 emp_code VARCHAR (50) PRIMARY KEY,
 first_name VARCHAR(100) NOT NULL,
 last_name VARCHAR(100),
 dob DATE NOT NULL,
 gender VARCHAR(1) NOT NULL,
 primary_contact_number VARCHAR(10),
 secondary_contact_number VARCHAR(10),
 email_id VARCHAR(100) NOT NULL,
 skype_id VARCHAR(100),
 profile_picture VARCHAR(512),
 password VARCHAR(100) DEFAULT "abcd",
 enabled BOOLEAN DEFAULT true
);

CREATE TABLE job_title_master(
 job_id INT AUTO_INCREMENT PRIMARY KEY ,
 job_title VARCHAR(100) NOT NULL
);


CREATE TABLE user_role(
 user_role_id INT PRIMARY KEY AUTO_INCREMENT,
 user_name VARCHAR(200) NOT NULL,
 role VARCHAR(50) NOT NULL    
);

CREATE TABLE skill_master(
 skill_id BIGINT PRIMARY KEY AUTO_INCREMENT,
 skill_name VARCHAR(100) NOT NULL
);



CREATE TABLE employee_skill(
 emp_skill_id INT AUTO_INCREMENT PRIMARY KEY,
 emp_code VARCHAR(11) NOT NULL,
 skill_id BIGINT NOT NULL,
 FOREIGN KEY (emp_code)  REFERENCES employee(emp_code) ,
 FOREIGN KEY (skill_id)  REFERENCES skill_master(skill_id)
);



CREATE TABLE project(
 project_id BIGINT PRIMARY KEY auto_increment,
 project_name VARCHAR(100),
 project_description VARCHAR(200) NOT NULL,
 start_date DATE NOT NULL,
 end_date DATE
);


CREATE TABLE address(
 address_id INT PRIMARY KEY,
 emp_code VARCHAR(11) NOT NULL,
 add_line_1 VARCHAR(100) NOT NULL,
 add_line_2 VARCHAR(100),
 FOREIGN KEY (emp_code) REFERENCES employee(emp_code) ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE job_details(
  job_detail_id INT PRIMARY KEY AUTO_INCREMENT ,
  emp_code VARCHAR(11) NOT NULL,
  job_id INT NOT NULL,
  reproting_mgr VARCHAR(11),
  team_lead VARCHAR(11),
  curr_proj_id BIGINT,
  FOREIGN KEY (emp_code) REFERENCES employee(emp_code) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (job_id) REFERENCES job_title_master(job_id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (reproting_mgr) REFERENCES Employee(emp_code) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (team_lead) REFERENCES Employee(emp_code) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (curr_proj_id) REFERENCES project(project_id) ON UPDATE CASCADE ON DELETE CASCADE
);



CREATE TABLE token(
emp_code VARCHAR(20),
token VARCHAR(100)
);


#INSERT DATA INTO EMPLOYEE
INSERT INTO `employee_portal13`.`employee` (`emp_code`, `first_name`, `last_name`, `dob`, `gender`, `primary_contact_number`, `secondary_contact_number`, `email_id`, `password`, `enabled`) VALUES ('E18/0000', 'dummy', 'dummy', '1997-08-12', 'M', '123', '123', 'a@b.com', 'abcd', true);
INSERT INTO `employee_portal13`.`employee` (`emp_code`, `first_name`, `last_name`, `dob`, `gender`, `primary_contact_number`, `secondary_contact_number`, `email_id`, `password`, `enabled`) VALUES ('E18/0001', 'dummy1', 'dummy1', '1997-08-12', 'F', '123', '123', 'a2@bb.com', 'abcd', true);
select * from employee;

#INSERT INTO TOKENemployee_skill
INSERT INTO token VALUES('dsad','sd');
SELECT * FROM TOKEN;

#INSERT INTO JOB TITLE MASTER
INSERT INTO `employee_portal13`.`job_title_master` (`job_id`, `job_title`) VALUES (1, 'GET-Trainee');
INSERT INTO `employee_portal13`.`job_title_master` (`job_id`, `job_title`) VALUES (2, 'Team Leader');
INSERT INTO `employee_portal13`.`job_title_master` (`job_id`, `job_title`) VALUES (3, 'Manager');

SELECT * FROM JOB_TITLE_MASTER;

#INSERT INTO PROJECT
INSERT INTO `employee_portal13`.`project` (`project_id`, `project_name`, `project_description`, `start_date`, `end_date`) VALUES (1, 'Training', 'abc', '2018-12-12', '2019-12-12');
SELECT * FROM PROJECT;

#JOB DETAILS
INSERT INTO `employee_portal13`.`job_details` (`job_detail_id`, `emp_code`, `job_id`, `curr_proj_id`) VALUES (1, 'E18/0000', 2, 1);

INSERT INTO `employee_portal13`.`job_details` (`job_detail_id`, `emp_code`, `job_id`, `curr_proj_id`) VALUES (2, 'E18/0000', 3, 1);

INSERT INTO `employee_portal13`.`job_details` (`job_detail_id`, `emp_code`, `job_id`, `reproting_mgr`, `team_lead`, `curr_proj_id`) VALUES (3, 'E18/0001', 1, 'E18/0000', 'E18/0000', 1);

#skills
insert into skill_master(skill_name) VALUES('JAVA');
insert into skill_master(skill_name) VALUES('C');
insert into skill_master(skill_name) VALUES('C++');

select * from employee_skill;

insert into employee_skill (emp_code, skill_id) values ('E18/0000', 1);

show tables;





