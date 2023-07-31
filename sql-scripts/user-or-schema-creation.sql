--Create the new user which is also termed as schema creation in oracel DB.

CREATE USER C##springtechappdb IDENTIFIED BY springtechappdb;



--Assigning the new role with all the grant same as SYS user.

GRANT DBA TO C##springtechappdb;