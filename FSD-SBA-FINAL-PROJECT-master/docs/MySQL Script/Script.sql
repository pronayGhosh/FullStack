#start the database in-secure
#mysqld --initialize-insecure

CREATE DATABASE PROJECTMANAGER;

drop table tasks;
drop table parent_tasks;
drop table projects;
drop table users;

CREATE TABLE users (
	employee_id VARCHAR(6) NOT NULL,
	first_name VARCHAR(50) NULL DEFAULT NULL,
	last_name VARCHAR(50) NULL DEFAULT NULL,
	status VARCHAR(1) NULL DEFAULT NULL,
	PRIMARY KEY (employee_id)
);

CREATE TABLE projects (
	project_id BIGINT(10) NOT NULL AUTO_INCREMENT,
	project_name VARCHAR(50) NULL DEFAULT NULL,
	start_date VARCHAR(10) NULL DEFAULT NULL,
	end_date VARCHAR(10) NULL DEFAULT NULL,
	priority VARCHAR(2) NULL DEFAULT NULL,
	status VARCHAR(15) NULL DEFAULT NULL,
	manager_id VARCHAR(6) NOT NULL,
	PRIMARY KEY (project_id),
	CONSTRAINT FK_PROJECTS_MANAGER_ID FOREIGN KEY (manager_id) REFERENCES users (employee_id)
);

CREATE TABLE parent_tasks (
	parent_task_id BIGINT(10) NOT NULL AUTO_INCREMENT,
	parent_task_name VARCHAR(50) NULL DEFAULT NULL,
	project_id BIGINT(10) NOT NULL,
	PRIMARY KEY (parent_task_id),
	CONSTRAINT FK_PARENT_TASKS FOREIGN KEY (project_id) REFERENCES projects (project_id)
);

CREATE TABLE tasks (
	task_id BIGINT(10) NOT NULL AUTO_INCREMENT,
	task_name VARCHAR(50) NULL DEFAULT NULL,
	parent_task_id BIGINT(10) NULL DEFAULT NULL,
	employee_id VARCHAR(6) NOT NULL,
	start_date VARCHAR(10) NULL DEFAULT NULL,
	end_date VARCHAR(10) NULL DEFAULT NULL,
	priority VARCHAR(2) NULL DEFAULT NULL,
	status VARCHAR(1) NULL DEFAULT NULL,
	project_id BIGINT(10) NOT NULL,
	PRIMARY KEY (task_id),
	CONSTRAINT FK_TASKS_PT FOREIGN KEY (parent_task_id) REFERENCES parent_tasks (parent_task_id),
	CONSTRAINT FK_TASKS_EI FOREIGN KEY (employee_id) REFERENCES users (employee_id),
	CONSTRAINT FK_TASKS_PI FOREIGN KEY (project_id) REFERENCES projects (project_id)
);


select * from users;
select * from projects;
select * from parent_tasks;
select * from tasks;


update tasks set status = 'A';