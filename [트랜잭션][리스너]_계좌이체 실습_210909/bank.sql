select * from all_tables;

create table bank(
	bid int,
	bname varchar(50) primary key,
	balance int
);

insert into bank values (1, '�Ǳ۷�', 10000);
insert into bank values (2, 'Ǫ��', 2000);

SELECT * FROM BANK WHERE BID=10 OR BNAME='�Ǳ۷�';
DELETE FROM BANK WHERE BID= 1;
UPDATE BANK SET BALANCE=BALANCE+10000 WHERE BID=1;
drop table bank;