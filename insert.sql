use employee_portal14;


#INSERT DATA INTO EMPLOYEE
INSERT INTO `employee_portal14`.`employee` (`emp_code`, `first_name`, `last_name`, `dob`, `gender`, `primary_contact_number`, `secondary_contact_number`, `email_id`, `password`, `enabled`) VALUES ('E18/0000', 'dummy', 'dummy', '1997-08-12', 'M', '123', '123', 'a@b.com', 'abcd', true);
INSERT INTO `employee_portal14`.`employee` (`emp_code`, `first_name`, `last_name`, `dob`, `gender`, `primary_contact_number`, `secondary_contact_number`, `email_id`, `password`, `enabled`) VALUES ('E18/0001', 'dummy1', 'dummy1', '1997-08-12', 'F', '123', '123', 'a2@bb.com', 'abcd', true);
select * from employee;

#INSERT INTO TOKENemployee_skill
INSERT INTO token VALUES('dsad','sd');
SELECT * FROM TOKEN;

#INSERT INTO JOB TITLE MASTER
INSERT INTO `employee_portal14`.`job_title_master` (`job_id`, `job_title`) VALUES (1, 'GET-Trainee');
INSERT INTO `employee_portal14`.`job_title_master` (`job_id`, `job_title`) VALUES (2, 'Team Leader');
INSERT INTO `employee_portal14`.`job_title_master` (`job_id`, `job_title`) VALUES (3, 'Manager');

SELECT * FROM JOB_TITLE_MASTER;

#INSERT INTO PROJECT
INSERT INTO `employee_portal14`.`project` (`project_id`, `project_name`, `project_description`, `start_date`, `end_date`) VALUES (1, 'Training', 'abc', '2018-12-12', '2019-12-12');
SELECT * FROM PROJECT;

#JOB DETAILS
INSERT INTO `employee_portal14`.`job_details` (`job_detail_id`, `emp_code`, `job_id`, `curr_proj_id`) VALUES (1, 'E18/0000', 2, 1);

INSERT INTO `employee_portal14`.`job_details` (`job_detail_id`, `emp_code`, `job_id`, `curr_proj_id`) VALUES (2, 'E18/0000', 3, 1);

INSERT INTO `employee_portal14`.`job_details` (`job_detail_id`, `emp_code`, `job_id`, `reproting_mgr`, `team_lead`, `curr_proj_id`) VALUES (3, 'E18/0001', 1, 'E18/0000', 'E18/0000', 1);


#skills
insert into skill_master(skill_name) VALUES('JAVA');
insert into skill_master(skill_name) VALUES('C');
insert into skill_master(skill_name) VALUES('C++');

select * from employee_skill;

show tables;

insert into employee_skill (emp_code, skill_id) values ('E18/0000', 1);

insert into user_role VALUES('1', 'E18/0000', 'ROLE_EMPLOYEE');
insert into user_role VALUES('2', 'E18/0001', 'ROLE_ADMIN');
#insert into user_role VALUES('3', 'E18/0002', 'ROLE_EMPLOYEE');
select * from user_role;
select * from employee;

