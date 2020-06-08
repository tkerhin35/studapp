INSERT INTO students (name ,surname, date_of_birth,jmbag ,number_of_ects ) VALUES
    ('Marko', 'Horvat', TO_DATE('11/02/1997', 'dd.MM.yyyy.'), '1234567890', 120);
INSERT INTO students (name ,surname, date_of_birth,jmbag ,number_of_ects ) VALUES
    ('Lana', 'Lacković', TO_DATE('11/02/1997', 'dd.MM.yyyy.'), '1234567891', 120);

insert into semester(name) values ('ZIMSKI');
insert into semester(name) values ('LJETNI');

insert into courses(name, ects_number, semester_id) values ('Programiranje web aplikacija u Javi', 7,2);
insert into courses(name, ects_number, semester_id) values ('Neknovencionalni računalni postupci', 6,1);

insert into student_course(student_id, course_id) values (1,1);
insert into student_course(student_id, course_id) values (2,2);
insert into student_course(student_id, course_id) values (1,2);

insert into authority(name) values ('ROLE_USER');
insert into authority(name) values ('ROLE_ADMIN');
insert into authority(name) values ('ROLE_DELETER');

insert into user(username, password, first_name, last_name) values ('Korisnik',
    '$2y$12$N149zAHMd7DLKle.Tc0HZ.3doYU2W61HiiA8NWjr6YeOlVlCNkZiS', 'Pero', 'Perić');
insert into user(username, password, first_name, last_name) values ('Administrator',
    '$2y$12$k3tWoiunKly9frasDxhmtuOP8IaxMShacih4KkkPh/UN.lOuxsifO', 'Ivo', 'Ivić');
insert into user(username, password, first_name, last_name) values ('Deleter',
    '$2y$12$N149zAHMd7DLKle.Tc0HZ.3doYU2W61HiiA8NWjr6YeOlVlCNkZiS', 'Pero', 'Perić');

insert into user_authority(user_id, authority_id) values (1,1);
insert into user_authority(user_id, authority_id) values (2,2);
insert into user_authority(user_id, authority_id) values (3,3);