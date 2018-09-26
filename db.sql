create database employee_portal14;

use employee_portal14;

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
    emp_code VARCHAR(200) NOT NULL,
    role VARCHAR(50) NOT NULL DEFAULT 'ROLE_EMPLOYEE',
    FOREIGN KEY (emp_code) references employee(emp_code)
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

ALTER TABLE `employee_skill` ADD UNIQUE `unique_index`(`emp_code`, `skill_id`);

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




