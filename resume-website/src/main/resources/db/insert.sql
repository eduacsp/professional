drop table interest;
drop table skill;
drop table contact;
drop table language;
drop table education;
drop table experience;
drop table cv;
drop table person;

CREATE TABLE person (
id_person BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(300) NULL,
cpf VARCHAR(30) NULL
);

CREATE TABLE cv (
id_cv BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
career_profile_text VARCHAR(20000) NULL,
career_profile_title VARCHAR(300) NULL,
experiences_title VARCHAR(300) NULL,
name VARCHAR(300) NULL,
role VARCHAR(300) NULL,
skills_title VARCHAR(300) NULL,
idiom VARCHAR(300) NULL,
education_title VARCHAR(300) NULL,
interests_title VARCHAR(300) NULL,
language_title VARCHAR(300) NULL,
id_person BIGINT(20) UNSIGNED,
FOREIGN KEY (id_person) REFERENCES person(id_person)
);

CREATE TABLE experience (
id_experience BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
text VARCHAR(20000) NULL,
company VARCHAR(300) NULL,
location VARCHAR(300) NULL,
role_title VARCHAR(300) NULL,
from_date date,
to_date date,
until_now varchar(1) DEFAULT NULL,
id_cv BIGINT(20) UNSIGNED,
FOREIGN KEY (id_cv) REFERENCES cv(id_cv)
);

CREATE TABLE education (
id_education BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
course_name VARCHAR(300) NULL,
institution_name VARCHAR(300) NULL,
from_date date NULL,
to_date date NULL,
id_cv BIGINT(20) UNSIGNED,
FOREIGN KEY (id_cv) REFERENCES cv(id_cv)
);

CREATE TABLE language (
id_language BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(300) NULL,
language_proficiency VARCHAR(300) NULL,
id_cv BIGINT(20) UNSIGNED,
FOREIGN KEY (id_cv) REFERENCES cv(id_cv)
);

CREATE TABLE contact (
id_contact BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
text VARCHAR(1000) NULL,
type VARCHAR(300) NULL,
label VARCHAR(300) NULL,
id_person BIGINT(20) UNSIGNED,
FOREIGN KEY (id_person) REFERENCES person(id_person)
);

CREATE TABLE skill (
id_skill BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(200) NULL,
percent DOUBLE(10,2),
id_cv BIGINT(20) UNSIGNED,
FOREIGN KEY (id_cv) REFERENCES cv(id_cv)
);

CREATE TABLE interest (
id_interest BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(200) NULL,
id_cv BIGINT(20) UNSIGNED,
FOREIGN KEY (id_cv) REFERENCES cv(id_cv)
);

insert into person (id_person,name,cpf) values (1,'John Smith','25786399818');

insert into cv (id_cv,career_profile_text,career_profile_title,experiences_title,name,role,skills_title,idiom,id_person,education_title,interests_title,language_title) values (1,'Engenharia de Software. Nononon Nononon Nononon.','Perfil da Carreira','Experiências','John Smith','Engenheiro de Software','Habilidades e Proficiência','PORTUGUES',1,'EDUCAÇÃO','INTERESSES','IDIOMAS');

insert into cv (id_cv,career_profile_text,career_profile_title,experiences_title,name,role,skills_title,idiom,id_person,education_title,interests_title,language_title) values (2,'Software engineering. Nononon Nononon Nononon .','Career Profile','Experiences','John Smith','Software Engineer','Skills & Proficiency','ENGLISH',1,'EDUCATION','INTERESTS','LANGUAGES');		

insert into contact (id_contact,text,label,type,id_person) values (1,'nononon@outlook.com','nononon@outlook.com','EMAIL',1);

insert into contact (id_contact,text,label,type,id_person) values (2,'http://br.linkedin.com/pub/NONONON','Linkedin','LINKEDIN',1);	

insert into contact (id_contact,text,label,type,id_person) values (3,'https://github.com/Nonononon','Github','GITHUB',1);	

insert into education (id_education, course_name, institution_name,from_date,to_date,id_cv) values (1,'Nononon','Havard',	STR_TO_DATE('01/01/2004', '%m/%d/%Y'),STR_TO_DATE('12/31/2006', '%m/%d/%Y'),1);

insert into education (id_education, course_name, institution_name,from_date,to_date,id_cv) values (2,'Nononon','Havard',STR_TO_DATE('01/01/2004', '%m/%d/%Y'),STR_TO_DATE('12/31/2006', '%m/%d/%Y'),2);
	
insert into language (id_language, name, language_proficiency,id_cv) values (1,'Português','NATIVE',1);

insert into language (id_language, name, language_proficiency,id_cv) values (2,'Inglês','FLUENT',1);

insert into language (id_language, name, language_proficiency,id_cv) values (3,'Portuguese','NATIVE',2);

insert into language (id_language, name, language_proficiency,id_cv) values (4,'English','FLUENT',2);

insert into experience (id_experience, company, location, from_date, to_date, role_title, until_now, id_cv, text) values (1,'Nonononon','Nonononon, Brasil',STR_TO_DATE('11/01/1999', '%m/%d/%Y'),STR_TO_DATE('12/31/2002', '%m/%d/%Y'),'Nonononon','N',1,'Nonononon Nonononon Nonononon ;');

insert into experience (id_experience, company, location, from_date, to_date, role_title, until_now, id_cv, text) values (2,'Nonononon','Nonononon, Brasil',STR_TO_DATE('08/01/2003', '%m/%d/%Y'),STR_TO_DATE('04/30/2007', '%m/%d/%Y'),'Nonononon','N',1,'Nonononon Nonononon Nonononon ;');

insert into experience (id_experience, company, location, from_date, to_date, role_title, until_now, id_cv, text) values (3,'Nonononon','Nonononon, Brasil',STR_TO_DATE('07/01/2007', '%m/%d/%Y'),STR_TO_DATE('08/31/2007', '%m/%d/%Y'),'Nonononon','N',1,'Nonononon Nonononon Nonononon ');

insert into experience (id_experience, company, location, from_date, to_date, role_title, until_now, id_cv, text) values (4,'Nonononon','Nonononon, Brasil',STR_TO_DATE('09/01/2007', '%m/%d/%Y'),STR_TO_DATE('05/31/2010', '%m/%d/%Y'),'Nonononon','N',1,'Nonononon Nonononon Nonononon ;');

insert into experience (id_experience, company, location, from_date, to_date, role_title, until_now, id_cv, text) values (5,'Nonononon','Nonononon, Brasil',STR_TO_DATE('06/01/2010', '%m/%d/%Y'),STR_TO_DATE('10/31/2014', '%m/%d/%Y'),'Nonononon','N',1,'Nonononon Nonononon Nonononon ;');

insert into experience (id_experience, company, location, from_date, to_date, role_title, until_now, id_cv, text) values (6,'Nonononon','Nonononon, Brasil',STR_TO_DATE('11/01/2014', '%m/%d/%Y'),STR_TO_DATE('11/29/2015', '%m/%d/%Y'),'Nonononon','N',1,'Nonononon Nonononon Nonononon ;');

insert into experience (id_experience, company, location, from_date, to_date, role_title, until_now, id_cv, text) values (7,'Nonononon','Nonononon, Brasil',STR_TO_DATE('12/01/2015', '%m/%d/%Y'),STR_TO_DATE('08/31/2016', '%m/%d/%Y'),'Nonononon','N',1,'Nonononon Nonononon Nonononon ;');

insert into experience (id_experience, company, location, from_date, to_date, role_title, until_now, id_cv, text) values (8,'Nonononon','Nonononon, Brasil',STR_TO_DATE('08/01/2016', '%m/%d/%Y'),STR_TO_DATE('08/31/2100', '%m/%d/%Y'),'Nonononon','Y',1,'Nonononon Nonononon Nonononon ;');
--
insert into experience (id_experience, company, location, from_date, to_date, role_title, until_now, id_cv, text) values (9,'Nonononon','Nonononon, Brasil',STR_TO_DATE('11/01/1999', '%m/%d/%Y'),STR_TO_DATE('12/31/2002', '%m/%d/%Y'),'Nonononon','N',2,'Nonononon Nonononon Nonononon ;');

insert into experience (id_experience, company, location, from_date, to_date, role_title, until_now, id_cv, text) values (10,'Nonononon','Nonononon, Brasil',STR_TO_DATE('07/01/2003', '%m/%d/%Y'),STR_TO_DATE('04/30/2007', '%m/%d/%Y'),'Nonononon','N',2,'Nonononon Nonononon Nonononon ;');

insert into experience (id_experience, company, location, from_date, to_date, role_title, until_now, id_cv, text) values (11,'Nonononon','Nonononon, Brasil',STR_TO_DATE('06/01/2007', '%m/%d/%Y'),STR_TO_DATE('07/31/2007', '%m/%d/%Y'),'Nonononon','N',2,'Nonononon Nonononon Nonononon ');

insert into experience (id_experience, company, location, from_date, to_date, role_title, until_now, id_cv, text) values (12,'Nonononon','Nonononon, Brasil',STR_TO_DATE('08/01/2007', '%m/%d/%Y'),STR_TO_DATE('05/31/2010', '%m/%d/%Y'),'Nonononon','N',2,'Nonononon Nonononon Nonononon ;');

insert into experience (id_experience, company, location, from_date, to_date, role_title, until_now, id_cv, text) values (13,'Nonononon','Nonononon, Brasil',STR_TO_DATE('06/01/2010', '%m/%d/%Y'),STR_TO_DATE('10/31/2014', '%m/%d/%Y'),'Nonononon','N',2,'Nonononon Nonononon Nonononon ;');

insert into experience (id_experience, company, location, from_date, to_date, role_title, until_now, id_cv, text) values (14,'Nonononon','Nonononon, Brasil',STR_TO_DATE('11/01/2014', '%m/%d/%Y'),STR_TO_DATE('11/29/2015', '%m/%d/%Y'),'Nonononon','N',2,'Nonononon Nonononon Nonononon ;');

insert into experience (id_experience, company, location, from_date, to_date, role_title, until_now, id_cv, text) values (15,'Nonononon','Nonononon, Brasil',STR_TO_DATE('12/01/2015', '%m/%d/%Y'),STR_TO_DATE('08/31/2016', '%m/%d/%Y'),'Nonononon','N',2,'Nonononon Nonononon Nonononon ;');

insert into experience (id_experience, company, location, from_date, to_date, role_title, until_now, id_cv, text) values (16,'Nonononon','Nonononon, Brasil',STR_TO_DATE('08/01/2016', '%m/%d/%Y'),STR_TO_DATE('08/31/2100', '%m/%d/%Y'),'Nonononon','Y',2,'Nonononon Nonononon Nonononon ;');
		
insert into skill (id_skill,name,percent,id_cv) values (1,'JEE',100.0,1);

insert into skill (id_skill,name,percent,id_cv) values (2,'JSE',85.0,1);

insert into skill (id_skill,name,percent,id_cv) values (3,'Java Swing',65.0,1);

insert into skill (id_skill,name,percent,id_cv) values (4,'Linux',70.0,1);

insert into skill (id_skill,name,percent,id_cv) values (5,'Javascript',80.0,1);

insert into skill (id_skill,name,percent,id_cv) values (6,'PL/SQL',85.0,1);

insert into skill (id_skill,name,percent,id_cv) values (7,'C++',25.0,1);

insert into skill (id_skill,name,percent,id_cv) values (8,'Bash Script',50.0,1);

insert into skill (id_skill,name,percent,id_cv) values (9,'Banco de Dados Oracle',90.0,1);

insert into skill (id_skill,name,percent,id_cv) values (10,'PostgreSQL',75.0,1);

insert into skill (id_skill,name,percent,id_cv) values (11,'MySQL',70.0,1);

insert into skill (id_skill,name,percent,id_cv) values (12,'Struts',70.0,1);

insert into skill (id_skill,name,percent,id_cv) values (13,'JSF',95.0,1);

insert into skill (id_skill,name,percent,id_cv) values (14,'SAP Netweaver',50.0,1);

insert into skill (id_skill,name,percent,id_cv) values (15,'Hibernate',85.0,1);

insert into skill (id_skill,name,percent,id_cv) values (16,'Spring MVC',70.0,1);

insert into skill (id_skill,name,percent,id_cv) values (17,'Spring IoC',90.0,1);

insert into skill (id_skill,name,percent,id_cv) values (18,'JQuery',75.0,1);

insert into skill (id_skill,name,percent,id_cv) values (19,'Maven',90.0,1);

insert into skill (id_skill,name,percent,id_cv) values (20,'Gradle',30.0,1);

insert into skill (id_skill,name,percent,id_cv) values (21,'Git',50.0,1);

insert into skill (id_skill,name,percent,id_cv) values (22,'EJB',65.0,1);


insert into skill (id_skill,name,percent,id_cv) values (23,'JEE',100.0,2);

insert into skill (id_skill,name,percent,id_cv) values (24,'JSE',85.0,2);

insert into skill (id_skill,name,percent,id_cv) values (25,'Java Swing',65.0,2);

insert into skill (id_skill,name,percent,id_cv) values (26,'Linux',70.0,2);

insert into skill (id_skill,name,percent,id_cv) values (27,'Javascript',80.0,2);

insert into skill (id_skill,name,percent,id_cv) values (28,'PL/SQL',85.0,2);

insert into skill (id_skill,name,percent,id_cv) values (29,'C++',25.0,2);

insert into skill (id_skill,name,percent,id_cv) values (30,'Bash Script',50.0,2);

insert into skill (id_skill,name,percent,id_cv) values (31,'Oracle database',90.0,2);

insert into skill (id_skill,name,percent,id_cv) values (32,'PostgreSQL',75.0,2);

insert into skill (id_skill,name,percent,id_cv) values (33,'MySQL',70.0,2);

insert into skill (id_skill,name,percent,id_cv) values (34,'Struts',70.0,2);

insert into skill (id_skill,name,percent,id_cv) values (35,'JSF',95.0,2);

insert into skill (id_skill,name,percent,id_cv) values (36,'SAP Netweaver',50.0,2);

insert into skill (id_skill,name,percent,id_cv) values (37,'Hibernate',85.0,2);

insert into skill (id_skill,name,percent,id_cv) values (38,'Spring MVC',75.0,2);

insert into skill (id_skill,name,percent,id_cv) values (39,'Spring IoC',90.0,2);

insert into skill (id_skill,name,percent,id_cv) values (40,'JQuery',75.0,2);

insert into skill (id_skill,name,percent,id_cv) values (41,'Maven',90.0,2);

insert into skill (id_skill,name,percent,id_cv) values (42,'Gradle',30.0,2);

insert into skill (id_skill,name,percent,id_cv) values (43,'Git',50.0,2);

insert into skill (id_skill,name,percent,id_cv) values (44,'EJB',65.0,2);

insert into interest (id_interest,name,id_cv) values (1,'Leitura',1);

insert into interest (id_interest,name,id_cv) values (2,'Musculação',1);

insert into interest (id_interest,name,id_cv) values (3,'Teologia',1);

insert into interest (id_interest,name,id_cv) values (4,'Artes Marciais',1);

insert into interest (id_interest,name,id_cv) values (5,'Idiomas',1);

insert into interest (id_interest,name,id_cv) values (6,'Reading',2);

insert into interest (id_interest,name,id_cv) values (7,'Workout',2);

insert into interest (id_interest,name,id_cv) values (8,'Theology',2);

insert into interest (id_interest,name,id_cv) values (9,'Martial Arts',2);

insert into interest (id_interest,name,id_cv) values (10,'Idioms',2);

