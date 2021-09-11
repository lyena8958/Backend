create table message(
	mid int primary key,
    title varchar(15),
    writer varchar(15),
    content varchar(50),
    wdate date
);
create table userTable(
	unum int primary key,
    userID varchar(15),
    userPW varchar(15)
);
select * from all_tables;