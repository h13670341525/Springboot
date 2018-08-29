create  table person_table
(
    person_id int auto_increment primary key,
    person_name varchar(30),
    address_id int
);

create table address_table
(
    address_id int auto_increment PRIMARY KEY,
    address_name varchar(30)
);
insert into address_table(address_name) VALUES ('文汇路'),('延安西路');
create table course_table
(
    course_id int auto_increment primary key,
    course_name varchar(30),
    tutor_id int
);
insert into course_table(course_name,tutor_id) values('c',1),('c++',1),('java',1);
create table tutor_table
(
    tutor_id int auto_increment primary key,
    tutor_name varchar(30)
);
insert into tutor_table values(null,'cherish');
create table student_table
(
    student_id int auto_increment primary key,
    student_name varchar(30)
);
INSERT INTO  student_table(student_name) VALUES ('cherish'),('joy'),('arron'),('horizon');
create table sc_table
(
    sc_id int auto_increment primary key,
    student_id int,
    course_id int
);
INSERT INTO sc_table(student_id,course_id) VALUES (1,1),(1,2),(1,3),(2,1),(2,2),(2,3),(3,1),(3,2),(3,3),(4,1),(4,2),(4,3)