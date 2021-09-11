create table a(
	a varchar(20),
	b int
);
select * from all_tables;
select * from a;
insert into a values('ȫ�浿',5); 

create table member(
	mnum int primary key,
	userName varchar(50),
	userID varchar(50),
	userPW varchar(50)
);
select * from member;
delete from member where mnum=1;
drop table member;