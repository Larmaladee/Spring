CREATE TABLE Personal (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role_id VARCHAR(255)
);

CREATE TABLE Role(
    role_id SERIAL PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL

);

CREATE TABLE TASKS(
    task_id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    priority_id INTEGER REFERENCES task_priorities(priority_id),
    status_id INTEGER REFERENCES task_statuses(status_id),
    project_id INTEGER REFERENCES projects(project_id),
    assigned_to INTEGER REFERENCES Personal(user_id)
);

CREATE TABLE task_statuses(
    status_id SERIAL PRIMARY KEY,
    status_name VARCHAR(255) NOT NULL
);

CREATE TABLE PROJECTS(
    project_id SERIAL PRIMARY KEY,
    project_name VARCHAR(255) NOT NULL,
    manager_id INTEGER REFERENCES Personal(user_id)
);

CREATE TABLE COMMENTS(
    comment_id SERIAL PRIMARY KEY,
    task_id INTEGER REFERENCES TASKS(task_id),
    user_id INTEGER REFERENCES Personal(user_id),
    comment_text TEXT NOT NULL
);

CREATE TABLE TYPE(
    category_id SERIAL PRIMARY KEY,
    category_name VARCHAR(255) NOT NULL
);

CREATE TABLE task_priorities(
    priority_id SERIAL PRIMARY KEY,
    priority_name VARCHAR(255) NOT NULL
);

select  * from Personal;
select  * from PROJECTS;
select  * from task_priorities;
select  * from task_statuses;
select * from comments;


drop table  Personal;
drop table  TASKS;
drop table  PROJECTS;

insert into Personal (username, password, role_id) values ('user','user','Admin');
insert into Personal (username, password, role_id) values ('admin','admin','User');
insert into role (role_name) values ('Admin');
insert into role (role_name) values ('User');

ALTER TABLE Personal RENAME COLUMN role_id TO Role;
ALTER TABLE Personal DROP COLUMN Role;