insert into role_tbl values(1,'ADMIN');
insert into role_tbl values(2,'USER');
insert into role_tbl values(3,'EMPLOYEE');
insert into user_tbl(id,fullname,username,password) values(101,'Krishna Kumar','krishna123','$2a$12$C0IjgIBlbzH3gK5PJ1b6seXgVhmWeiCfP07ewKbk7TNw2e4uAtgF2');
insert into user_tbl(id,fullname,username,password) values(102,'Abhinav Gupta','abhi123','$2a$12$C0IjgIBlbzH3gK5PJ1b6seXgVhmWeiCfP07ewKbk7TNw2e4uAtgF2');
insert into user_roles values(101,1);
insert into user_roles values(101,2);
insert into user_roles values(102,2);