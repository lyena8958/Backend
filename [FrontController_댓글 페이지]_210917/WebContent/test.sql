create table userInfo(
	userID varchar(30),
	userPW varchar(30),
	userName varchar(30),
 	datetime date
);

create table message(
	mnum int primary key,
	userId varchar(30),
	msg varchar(300),
	datetime date,
	likeCnt int default 0,
	replyCnt int default 0
);

create table reply(
	rnum int primary key,
	mnum int,
	userID varchar(30),
	rmsg varchar(300),
	datetime date,
	foreign key (mnum) references message(mnum) on delete cascade
);
SELECT * FROM REPLY WHERE MNUM=1 ORDER BY RNUM DESC;
insert into userInfo values ('1111','1111','·çÇÇ',sysdate);
insert into userInfo values ('2222','2222','¿ì´Ï',sysdate);
SELECT * FROM (SELECT * FROM MESSAGE ORDER BY MNUM DESC) WHERE ROWNUM <= 1 AND USERID LIKE '%' ORDER BY DATETIME DESC;
INSERT INTO REPLY (RNUM, MNUM, USERID, RMSG, DATETIME) VALUES ((SELECT NVL(MAX(RNUM),0)+1 FROM REPLY), 1, '1111', '!!',sysdate)


insert into message (mnum, userID, msg, datetime) values (1, '1111', '1´ñ±Û', sysdate);
insert into message (mnum, userID, msg, datetime) values (2, '2222', '2´ñ±Û', sysdate);

insert into reply (rnum, mnum, userID, rmsg, datetime) values (1, 2, '2222', '1-1´ñ±Û', sysdate);
insert into reply (rnum, mnum, userID, rmsg, datetime) values (2, 2, '2222', '1-2´ñ±Û', sysdate);
insert into reply (rnum, mnum, userID, rmsg, datetime) values (3, 1, '1111', '2-1´ñ±Û', sysdate);
insert into reply (rnum, mnum, userID, rmsg, datetime) values (4, 1, '1111', '2-2´ñ±Û', sysdate);
DROP TABLE USERINFO;
select * from userInfo;
select * from message;
select * from reply;
UPDATE MESSAGE SET REPLYCNT=1 WHERE MNUM=5; 
DELETE FROM message WHERE mnum=3;
DELETE FROM REPLY WHERE RNUM = 10;
DELETE FROM userInfo WHERE userID='9999';
SELECT * FROM MESSAGE WHERE ROWNUM <= 2 AND USERID LIKE '%1' ORDER BY DATETIME DESC