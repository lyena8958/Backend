select * from all_tables;

create table userMsg(
    id varchar(15) primary key,
    name varchar(15),
    passwd varchar(10),
    datetime date
);

/*uid에서는 fk를 설정하지 않았는데, 그 이유는 회원탈퇴가 되어도 데이터는 남기기 위해서 이다.*/
/*암시적으로 uid가 fk라는점을 감안하여야 한다.*/
create table message(
    mid int primary key,
    id varchar(15),
    msg varchar(100),
    favcount int default 0,
    replycount int default 0,
    datetime date
);
/*댓글과 대댓글이 fk로 되어있는데, 댓글이 삭제가되면, 대댓글을 없애기 위해 fk로 설정되었다.*/
create table reply(
    rid int primary key,
    mid int,
    id varchar(15),
    datetime date,
    rmsg varchar(50),
    constraint msgrp foreign key (mid) references message (mid) on delete cascade
);

insert into userMsg values('1234', '뿌꾸', '1234', sysdate);
insert into userMsg values('5678', '배찌', '5678', sysdate);

insert into message values((SELECT NVL(MAX(MID),0)+1 FROM MESSAGE), '1234', '댓글1', 0,0, sysdate);
insert into message values((SELECT NVL(MAX(MID),0)+1 FROM MESSAGE), '5678', '댓글2', 0,0, sysdate);
insert into message (MID, ID, MSG, DATETIME) values ((SELECT NVL(MAX(MID),0)+1 FROM MESSAGE), '1111', '아농', sysdate);

insert into reply values ((SELECT NVL(MAX(RID),0)+1 FROM REPLY), 1, '1234', sysdate, '댓글1-대댓글1');
insert into reply values ((SELECT NVL(MAX(RID),0)+1 FROM REPLY), 1, '5678', sysdate, '댓글1-대댓글2');
insert into reply values ((SELECT NVL(MAX(RID),0)+1 FROM REPLY), 1, '1234', sysdate, '댓글1-대댓글3');

insert into reply values ((SELECT NVL(MAX(RID),0)+1 FROM REPLY), 2, '1234', sysdate, '댓글2-대댓글1');
insert into reply values ((SELECT NVL(MAX(RID),0)+1 FROM REPLY), 2, '5678', sysdate, '댓글2-대댓글2');


SELECT * FROM MESSAGE WHERE ROWNUM <= 2 AND ID LIKE '%1234%' ORDER BY DATETIME DESC;
SELECT * FROM reply WHERE ROWNUM <= 5 AND ID LIKE '%1234%' ORDER BY DATETIME DESC;

select * from userMsg;
select * from message;
select * from reply;
select * from reply where rownum <= 2;
/*mysql에서는 limit ---- oracle에서는 rownum*/

insert into user values('timo','티모','1234',now());
insert into message values(1,'timo','글작성',1,2,now());
insert into reply values(1,1,'timo',now(),'댓글1');
insert into reply values(2,1,'timo',now(),'댓글2');
insert into message values(2,'timo','111',2,3,now());
insert into reply values(3,2,'timo',now(),'댓글1');
insert into reply values(4,2,'timo',now(),'댓글2');
insert into reply values(5,2,'timo',now(),'댓글3');
insert into message values(3,'timo','확인',2,0,now());

DELETE FROM MESSAGE WHERE MID=3;


select * from message;

drop table message;