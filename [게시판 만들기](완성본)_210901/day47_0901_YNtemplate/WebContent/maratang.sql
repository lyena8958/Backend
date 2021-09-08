select * from all_tables;
create table orderMember(
	onum int primary key,
	userName varchar(20),
	userID varchar(50),
	userPW varchar(50)
);
select * from orderMember;
insert into orderMember values(1, 'Ǫ', '1234', '1234');
delete from ORDERMEMBER where onum=1;

create table review(
	onum int,
	rnum int primary key,
	writer varchar(100),
	title varchar(200),
	content varchar(1000),
	wdate date,
	foreign key (onum) references orderMember(onum) on delete cascade
);

drop table review;
select * from review;
insert into review values(1, 1, 'Ǫ', '�����̳׿�', '��ġ ������ �� ���̾����ϴ�!',sysdate );
SELECT * FROM REVIEW WHERE CONTENT LIKE'%��%' OR TITLE LIKE '%��%' ORDER BY RNUM;
SELECT * FROM REVIEW WHERE ONUM=1;
