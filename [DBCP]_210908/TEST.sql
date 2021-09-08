select * from all_tables;

create table test(
	name varchar(20),
	email varchar(30)
);
insert into test values('kim','coding_helper@naver.com');
insert into test values('ari','ari@naver.com');
insert into test values('timo','teemo@naver.com');
select * from test;

drop table test;

create table login(
	mnum int primary key,
	userID varchar(20),
	userPW varchar(20),
	userName varchar(30)
);
select * from login;
SELECT * FROM LOGIN WHERE USERID LIKE '%1234%' AND USERPW LIKE '%%';
insert into login values('1','1234', '1234', 'Çª¿ì');
INSERT INTO LOGIN (MNUM, USERID, USERPW, USERNAME) VALUES ((SELECT NVL(MAX(MNUM, 0)+1 FROM LOGIN), '1111', '1111', '1111')
