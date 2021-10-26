
create table board(
	id int primary key,
	title varchar(30),
	writer varchar(15),
	content varchar(100),
	wdate date default sysdate
);
create table member2(
	id varchar(15) primary key,
	password varchar(10),
	name varchar(15),
	role varchar(15)
);

drop table board;
drop table member2;
select * from board;
select * from member2;
SELECT * FROM BOARD WHERE CONTENT LIKE '%~~%';
insert into member2 values('kim', '1234', '辫揪', 'USER');
insert into member2 values('admin', '1234', '包府磊', 'ADMIN');

insert into board (id, title, writer, content) values (1, '力格', 'kim', '臂 郴侩');

SELECT * FROM BOARD ORDER BY wdate DESC;