select * from all_tables;

create table userMsg(
    id varchar(15) primary key,
    name varchar(15),
    passwd varchar(10),
    datetime date
);

/*uid������ fk�� �������� �ʾҴµ�, �� ������ ȸ��Ż�� �Ǿ �����ʹ� ����� ���ؼ� �̴�.*/
/*�Ͻ������� uid�� fk������� �����Ͽ��� �Ѵ�.*/
create table message(
    mid int primary key,
    id varchar(15),
    msg varchar(100),
    favcount int default 0,
    replycount int default 0,
    datetime date
);
/*��۰� ������ fk�� �Ǿ��ִµ�, ����� �������Ǹ�, ������ ���ֱ� ���� fk�� �����Ǿ���.*/
create table reply(
    rid int primary key,
    mid int,
    id varchar(15),
    datetime date,
    rmsg varchar(50),
    constraint msgrp foreign key (mid) references message (mid) on delete cascade
);

insert into userMsg values('1234', '�Ѳ�', '1234', sysdate);
insert into userMsg values('5678', '����', '5678', sysdate);

insert into message values((SELECT NVL(MAX(MID),0)+1 FROM MESSAGE), '1234', '���1', 0,0, sysdate);
insert into message values((SELECT NVL(MAX(MID),0)+1 FROM MESSAGE), '5678', '���2', 0,0, sysdate);
insert into message (MID, ID, MSG, DATETIME) values ((SELECT NVL(MAX(MID),0)+1 FROM MESSAGE), '1111', '�Ƴ�', sysdate);

insert into reply values ((SELECT NVL(MAX(RID),0)+1 FROM REPLY), 1, '1234', sysdate, '���1-����1');
insert into reply values ((SELECT NVL(MAX(RID),0)+1 FROM REPLY), 1, '5678', sysdate, '���1-����2');
insert into reply values ((SELECT NVL(MAX(RID),0)+1 FROM REPLY), 1, '1234', sysdate, '���1-����3');

insert into reply values ((SELECT NVL(MAX(RID),0)+1 FROM REPLY), 2, '1234', sysdate, '���2-����1');
insert into reply values ((SELECT NVL(MAX(RID),0)+1 FROM REPLY), 2, '5678', sysdate, '���2-����2');


SELECT * FROM MESSAGE WHERE ROWNUM <= 2 AND ID LIKE '%1234%' ORDER BY DATETIME DESC;
SELECT * FROM reply WHERE ROWNUM <= 5 AND ID LIKE '%1234%' ORDER BY DATETIME DESC;

select * from userMsg;
select * from message;
select * from reply;
select * from reply where rownum <= 2;
/*mysql������ limit ---- oracle������ rownum*/

insert into user values('timo','Ƽ��','1234',now());
insert into message values(1,'timo','���ۼ�',1,2,now());
insert into reply values(1,1,'timo',now(),'���1');
insert into reply values(2,1,'timo',now(),'���2');
insert into message values(2,'timo','111',2,3,now());
insert into reply values(3,2,'timo',now(),'���1');
insert into reply values(4,2,'timo',now(),'���2');
insert into reply values(5,2,'timo',now(),'���3');
insert into message values(3,'timo','Ȯ��',2,0,now());

DELETE FROM MESSAGE WHERE MID=3;


select * from message;

drop table message;