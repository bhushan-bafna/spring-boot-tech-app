drop table person "if exists";

CREATE TABLE person (
  id NUMBER PRIMARY KEY,
  firstname VARCHAR2(50),
  lastname VARCHAR2(50),
  email VARCHAR2(100)
);


insert into person values (1,'Bhushan','Bafna','bhushan@atrangi.com');

insert into person values (2,'Gunjan','Bafna','gunjan@atrangi.com');

SELECT * FROM C##springtechappdb.PERSON where id=1;

select * from person;

