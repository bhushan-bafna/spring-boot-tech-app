show con_name;

------------------------------
--CON_NAME 
------------------------------
--CDB$ROOT
------------------------------

show pdbs;
------------------------------
--    CON_ID CON_NAME                       OPEN MODE  RESTRICTED
---------- ------------------------------ ---------- ----------
--         2 PDB$SEED                       READ ONLY  NO        
--         3 XEPDB1                         READ WRITE NO        
------------------------------

alter session set container = XEPDB1;
--Session altered.

show con_name;
------------------------------
--CON_NAME 
------------------------------
--XEPDB1
------------------------------

--Now you can create user with adding common prefix namespace
--Create the new user which is also termed as schema creation in oracel DB.
--CREATE USER C##springtechappdb IDENTIFIED BY springtechappdb;

CREATE USER springtechappdb IDENTIFIED BY springtechappdb;


--Assigning the new role with all the grant same as SYS user.

GRANT DBA TO springtechappdb;


select * from all_users;

update all_users set common='YES', INHERITED='YES' where username='SPRINGTECHAPPDB';

