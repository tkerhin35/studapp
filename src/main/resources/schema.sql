create table  if not exists students (
    id integer not null auto_increment,
    name varchar(20) not null,
    surname varchar(20) not null,
    date_of_birth timestamp not null,
    jmbag char(20) not null unique,
    number_of_ects int,
    primary key (id)
);

create table if not exists semester(
    id integer not null auto_increment,
    name varchar(20) not null ,
    primary key (id)
);

create table if not exists courses (
    id integer not null auto_increment ,
    name varchar(70) not null ,
    ects_number integer not null,
    semester_id integer not null ,
    primary key (id),
    foreign key (semester_id) references semester(id)
);

create table if not exists student_course (
    student_id integer not null ,
    course_id integer not null ,
    foreign key (student_id) references students(id),
    foreign key (course_id) references courses(id)
);

create table if not exists user(
    id integer auto_increment,
    username varchar(20) not null ,
    password char(60) not null ,
    first_name varchar(20) not null ,
    last_name varchar(20) not null ,
    primary key (id)
);

create table if not exists authority(
    id integer not null auto_increment,
    name varchar(20) not null ,
    primary key (id)
);

create table if not exists user_authority(
    user_id integer not null ,
    authority_id integer not null ,
    foreign key (user_id) references user(id),
    foreign key (authority_id) references authority(id)
);

