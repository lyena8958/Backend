
create table member(
	mnum int primary key,
	userID varchar(50),
	userPW varchar(50),
	userName varchar(50)
);

select * from member;
insert into member values(0, 'admin', 'admin', 'admin');
insert into member values(1, '1234', '1234', 'Çª');
INSERT INTO MEMBER (MNUM, USERID, USERPW, USERNAME) VALUES ((SELECT NVL(MAX(MNUM), 0)+1 FROM MEMBER), '12345', '12345', '12345');

create table product(
	pnum int primary key,
	pName varchar(100),
	price int,
	cnt int
);

INSERT INTO PRODUCT (PNUM, PNAME, PRICE, CNT) VALUES ((SELECT NVL(MAX(PNUM), 0)+1 FROM PRODUCT), 'ºí·¢°¡µð°Ç', '15000', 3)
select * from product;
insert into product (pnum, pName, price, cnt) values(1, 'ºí·¢°¡µð°Ç', 15000, 3);
insert into product (pnum, pName, price, cnt) values(2, 'ºí·¢½½·¢½º', 23000, 5);

SELECT * FROM PRODUCT WHERE PNAME LIKE '%%' ORDER BY PNUM DESC;


SELECT * FROM REVIEW WHERE CONTENT LIKE'%¸À%' OR TITLE LIKE '%¸À%' ORDER BY RNUM;
SELECT * FROM REVIEW WHERE ONUM=1;

SELECT * FROM member WHERE USERID='1234' AND USERPW='1234';


drop table product;
