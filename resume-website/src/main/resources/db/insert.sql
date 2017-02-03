drop table interest;
drop table skill;
drop table contact;
drop table language;
drop table education;
drop table experience;
drop table cv;
drop table person;
drop table guest;


CREATE TABLE person (
id_person BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(300) NULL,
cpf VARCHAR(30) NULL
);

CREATE TABLE cv (
id_cv BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
career_profile_text VARCHAR(10000) NULL,
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
FOREIGN KEY (id_person) REFERENCES person(id_person),
INDEX(idiom)
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

CREATE TABLE guest (
id_guest BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
ip_address VARCHAR(300) NULL,
user_agent VARCHAR(300) NULL,
referer VARCHAR(300) NULL,
idiom VARCHAR(300) NULL,
city VARCHAR(500) NULL,
region VARCHAR(500) NULL,
country VARCHAR(500) NULL,
date_insert TIMESTAMP DEFAULT '0000-00-00 00:00:00'
);

insert into person (id_person,name,cpf) values (1,'Eduardo Augusto Crestani','25786399818');

insert into cv (id_cv,career_profile_text,career_profile_title,experiences_title,name,role,skills_title,idiom,id_person,education_title,interests_title,language_title) values (1,'Engenharia de Software. Desenvolvimento de aplicações complexas com alta performance. Uso dos melhores paradigmas de programação, padrões de projeto, frameworks e metodologias ágeis. Tenho experiência em mais de 14 anos com desenvolvimento de backend e frontend e mais de 9 anos de experiência com Java EE. Também tenho passaporte da União Européia.','Perfil da Carreira','Experiências','Eduardo Crestani','Engenheiro de Software','Habilidades e Proficiência','PORTUGUES',1,'EDUCAÇÃO','INTERESSES','IDIOMAS');

insert into cv (id_cv,career_profile_text,career_profile_title,experiences_title,name,role,skills_title,idiom,id_person,education_title,interests_title,language_title) values (2,'Software engineering. Development of complex applications with high performance. Use of the best programming paradigms, patterns, frameworks and agile methodologies. I have experience more than 14 years with backend and frontend software development and more than 9 years with Java EE. Also I have EU passport.','Career Profile','Experiences','Eduardo Crestani','Software Engineer','Skills & Proficiency','ENGLISH',1,'EDUCATION','INTERESTS','LANGUAGES');		

insert into contact (text,label,type,id_person) values ('eduacspbr@gmail.com','eduacspbr@gmail.com','EMAIL',1);

insert into contact (text,label,type,id_person) values ('http://br.linkedin.com/pub/eduardo-crestani/16/259/587','Linkedin','LINKEDIN',1);	

insert into contact (text,label,type,id_person) values ('https://github.com/eduacsp','Github','GITHUB',1);	

insert into education (course_name, institution_name,from_date,to_date,id_cv) values ('Tecnólogo em Desenvolvimento de Sistemas','UMC-Univer. Mogi das Cruzes',	STR_TO_DATE('01/01/2004', '%m/%d/%Y'),STR_TO_DATE('12/31/2006', '%m/%d/%Y'),1);

insert into education (course_name, institution_name,from_date,to_date,id_cv) values ('Bachelor of Technology (B.Tech.)','UMC-Mogi das Cruzes University',STR_TO_DATE('01/01/2004', '%m/%d/%Y'),STR_TO_DATE('12/31/2006', '%m/%d/%Y'),2);
	
insert into language (name, language_proficiency,id_cv) values ('Português','NATIVE',1);

insert into language (name, language_proficiency,id_cv) values ('Inglês','FLUENT',1);

insert into language (name, language_proficiency,id_cv) values ('Portuguese','NATIVE',2);

insert into language (name, language_proficiency,id_cv) values ('English','FLUENT',2);

insert into experience (company, location, from_date, to_date, role_title, until_now, id_cv, text) values ('UOL','São Paulo, Brasil',STR_TO_DATE('11/01/1999', '%m/%d/%Y'),STR_TO_DATE('12/31/2002', '%m/%d/%Y'),'Analista de Suporte Jr','N',1,'Suporte telefônico para usuários do provedor; Desenvolvimento de aplicações web;');

insert into experience (company, location, from_date, to_date, role_title, until_now, id_cv, text) values ('Giant Cargo','São Paulo, Brasil',STR_TO_DATE('08/01/2003', '%m/%d/%Y'),STR_TO_DATE('04/30/2007', '%m/%d/%Y'),'Programador Pl','N',1,'Desenvolvimento e analise de projetos relativos a área de comércio exterior (aéreo e marítimo). Implementação de arquitetura de alta disponibilidade, tanto software quanto hardware; Suporte aos servidores;');

insert into experience (company, location, from_date, to_date, role_title, until_now, id_cv, text) values ('Accenture','São Paulo, Brasil',STR_TO_DATE('07/01/2007', '%m/%d/%Y'),STR_TO_DATE('08/31/2007', '%m/%d/%Y'),'Programador Java Pl','N',1,'Desenvolvimento de aplicações web para área bancária');

insert into experience (company, location, from_date, to_date, role_title, until_now, id_cv, text) values ('Capgemini','São Paulo, Brasil',STR_TO_DATE('09/01/2007', '%m/%d/%Y'),STR_TO_DATE('05/31/2010', '%m/%d/%Y'),'Analista de Sistemas Sr','N',1,'Desenvolvimento e suporte de projetos web na área editorial; Definição de arquitetura de software; Ensino de programação Java para novos funcionários;');

insert into experience (company, location, from_date, to_date, role_title, until_now, id_cv, text) values ('Resource Tecnology','São Paulo, Brasil',STR_TO_DATE('06/01/2010', '%m/%d/%Y'),STR_TO_DATE('10/31/2014', '%m/%d/%Y'),'Analista de Sistemas Sr','N',1,'Desenvolvimento e suporte de projetos web e desktop; Implementação de rotinas de encriptação e integração de software legado; Definição de arquitetura de software; Construção de códigos com alta performance;');

insert into experience (company, location, from_date, to_date, role_title, until_now, id_cv, text) values ('Disys','São Paulo, Brasil',STR_TO_DATE('11/01/2014', '%m/%d/%Y'),STR_TO_DATE('11/29/2015', '%m/%d/%Y'),'Analista de Sistemas Java Sr','N',1,'Desenvolvimento e suporte de projetos web na área de seguros; Implementação de melhorias de performance e usabilidade; Construção de testes unitários automatizados; Liderança de equipe;');

insert into experience (company, location, from_date, to_date, role_title, until_now, id_cv, text) values ('Entelgy','São Paulo, Brasil',STR_TO_DATE('12/01/2015', '%m/%d/%Y'),STR_TO_DATE('08/31/2016', '%m/%d/%Y'),'Analista Programador Especialista','N',1,'Desenvolvimento e suporte web fullstack  de projetos de portais; Construção de códigos com alta performance; Liderança de equipe;');

insert into experience (company, location, from_date, to_date, role_title, until_now, id_cv, text) values ('SupportComm','São Paulo, Brasil',STR_TO_DATE('08/01/2016', '%m/%d/%Y'),STR_TO_DATE('08/31/2100', '%m/%d/%Y'),'Desenvolvedor Sr','Y',1,'Desenvolvimento de aplicações web na área de marketing mobile; Implementação de melhorias de performance e usabilidade; Criação de testes unitários automatizados;');

insert into experience (company, location, from_date, to_date, role_title, until_now, id_cv, text) values ('UOL','São Paulo, Brazil',STR_TO_DATE('11/01/1999', '%m/%d/%Y'),STR_TO_DATE('12/31/2002', '%m/%d/%Y'),'Junior Support Analyst','N',2,'Telephone support to customers; Web application development;');

insert into experience (company, location, from_date, to_date, role_title, until_now, id_cv, text) values ('Giant Cargo','São Paulo, Brazil',STR_TO_DATE('07/01/2003', '%m/%d/%Y'),STR_TO_DATE('04/30/2007', '%m/%d/%Y'),'Engineer Programmer','N',2,'Development projects for the area of foreign trade; Implementation of high-availability architecture, both in software and hardware; Support for servers;');

insert into experience (company, location, from_date, to_date, role_title, until_now, id_cv, text) values ('Accenture','São Paulo, Brazil',STR_TO_DATE('06/01/2007', '%m/%d/%Y'),STR_TO_DATE('07/31/2007', '%m/%d/%Y'),'Engineer Java Programmer','N',2,'Web application development for the baking area.');

insert into experience (company, location, from_date, to_date, role_title, until_now, id_cv, text) values ('Capgemini','São Paulo, Brazil',STR_TO_DATE('08/01/2007', '%m/%d/%Y'),STR_TO_DATE('05/31/2010', '%m/%d/%Y'),'Senior Systems Analyst','N',2,'Development projects and support for web applications in the publishing area; Definition of software architecture; Java teaching and trainees mentoring;');

insert into experience (company, location, from_date, to_date, role_title, until_now, id_cv, text) values ('Resource Tecnology','São Paulo, Brazil',STR_TO_DATE('06/01/2010', '%m/%d/%Y'),STR_TO_DATE('10/31/2014', '%m/%d/%Y'),'Senior Analyst','N',2,'Development projects and support for web and desktop applications; Implementation of data encryption routines and integration of legacy software; Definition of software architecture; Building codes with improved performance;');

insert into experience (company, location, from_date, to_date, role_title, until_now, id_cv, text) values ('Disys','São Paulo, Brazil',STR_TO_DATE('11/01/2014', '%m/%d/%Y'),STR_TO_DATE('11/29/2015', '%m/%d/%Y'),'Senior Java System Analyst','N',2,'Web development projects in the insurance area; Improvements on performance and usability; Building automated unit testing; Team leadership;');

insert into experience (company, location, from_date, to_date, role_title, until_now, id_cv, text) values ('Entelgy','São Paulo, Brazil',STR_TO_DATE('12/01/2015', '%m/%d/%Y'),STR_TO_DATE('08/31/2016', '%m/%d/%Y'),'Programmer Analyst Expert','N',2,'Fullstack web development projects and support for portal applications; Building codes with improved performance; Technical leadership;');

insert into experience (company, location, from_date, to_date, role_title, until_now, id_cv, text) values ('SupportComm','São Paulo, Brazil',STR_TO_DATE('08/01/2016', '%m/%d/%Y'),STR_TO_DATE('08/31/2100', '%m/%d/%Y'),'Senior Java Developer ','Y',2,'Web development projects in the mobile marketing; Improvements on performance and usability; Building automated unit testing;');
		
insert into skill (name,percent,id_cv) values ('JEE',100.0,1);

insert into skill (name,percent,id_cv) values ('JSE',90.0,1);

insert into skill (name,percent,id_cv) values ('Linux',70.0,1);

insert into skill (name,percent,id_cv) values ('Javascript',80.0,1);

insert into skill (name,percent,id_cv) values ('PL/SQL',85.0,1);

insert into skill (name,percent,id_cv) values ('C++',20.0,1);

insert into skill (name,percent,id_cv) values ('Bash Script',50.0,1);

insert into skill (name,percent,id_cv) values ('Banco de Dados Oracle',90.0,1);

insert into skill (name,percent,id_cv) values ('PostgreSQL',75.0,1);

insert into skill (name,percent,id_cv) values ('MySQL',70.0,1);

insert into skill (name,percent,id_cv) values ('Struts',70.0,1);

insert into skill (name,percent,id_cv) values ('JSF',95.0,1);

insert into skill (name,percent,id_cv) values ('SAP Netweaver',50.0,1);

insert into skill (name,percent,id_cv) values ('Hibernate',85.0,1);

insert into skill (name,percent,id_cv) values ('Spring Boot',80.0,1);

insert into skill (name,percent,id_cv) values ('Spring IoC',90.0,1);

insert into skill (name,percent,id_cv) values ('JQuery',75.0,1);

insert into skill (name,percent,id_cv) values ('Maven',90.0,1);

insert into skill (name,percent,id_cv) values ('Gradle',30.0,1);

insert into skill (name,percent,id_cv) values ('Git',60.0,1);

insert into skill (name,percent,id_cv) values ('EJB',70.0,1);

insert into skill (name,percent,id_cv) values ('SOA/Restful webservices',90.0,1);

insert into skill (name,percent,id_cv) values ('JEE',100.0,2);

insert into skill (name,percent,id_cv) values ('JSE',90.0,2);

insert into skill (name,percent,id_cv) values ('Linux',70.0,2);

insert into skill (name,percent,id_cv) values ('Javascript',80.0,2);

insert into skill (name,percent,id_cv) values ('PL/SQL',85.0,2);

insert into skill (name,percent,id_cv) values ('C++',20.0,2);

insert into skill (name,percent,id_cv) values ('Bash Script',50.0,2);

insert into skill (name,percent,id_cv) values ('Oracle database',90.0,2);

insert into skill (name,percent,id_cv) values ('PostgreSQL',75.0,2);

insert into skill (name,percent,id_cv) values ('MySQL',70.0,2);

insert into skill (name,percent,id_cv) values ('Struts',70.0,2);

insert into skill (name,percent,id_cv) values ('JSF',95.0,2);

insert into skill (name,percent,id_cv) values ('SAP Netweaver',50.0,2);

insert into skill (name,percent,id_cv) values ('Hibernate',85.0,2);

insert into skill (name,percent,id_cv) values ('Spring Boot',80.0,2);

insert into skill (name,percent,id_cv) values ('Spring IoC',90.0,2);

insert into skill (name,percent,id_cv) values ('JQuery',75.0,2);

insert into skill (name,percent,id_cv) values ('Maven',90.0,2);

insert into skill (name,percent,id_cv) values ('Gradle',30.0,2);

insert into skill (name,percent,id_cv) values ('Git',60.0,2);

insert into skill (name,percent,id_cv) values ('EJB',70.0,2);

insert into skill (name,percent,id_cv) values ('SOA/Restful webservices',90.0,2);

insert into interest (name,id_cv) values ('Leitura',1);

insert into interest (name,id_cv) values ('Musculação',1);

insert into interest (name,id_cv) values ('Teologia',1);

insert into interest (name,id_cv) values ('Artes Marciais',1);

insert into interest (name,id_cv) values ('Idiomas',1);

insert into interest (name,id_cv) values ('Reading',2);

insert into interest (name,id_cv) values ('Workout',2);

insert into interest (name,id_cv) values ('Theology',2);

insert into interest (name,id_cv) values ('Martial Arts',2);

insert into interest (name,id_cv) values ('Idioms',2);

