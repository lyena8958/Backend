CREATE TABLE member(
	mnum int primary key,
	mName varchar(100),
	path varchar(30),
	startDate date,
	endDate date,
	birthDate date,
	teamName varchar(30),
	duty varchar(50),
	position varchar(30),
	mrank int
);

CREATE TABLE post(
	pnum int primary key,
	pmem int,
	category varchar(30),
	content varchar(4000),
	password varchar(20)
); 

CREATE TABLE HRAdmin(
	hnum int primary key,
	hmem int,
	pw varchar(30),
	foreign key (hmem) references member(mnum) on delete cascade
);

CREATE TABLE SchoolInfo(
	snum int primary key,
	stype varchar(20),
	sname varchar(100),
	startDate date,
	endDate date,
	field varchar(50),
	major varchar(1000),
	finish varchar(1),
	sMem int,
	foreign key (sMem) references member(mnum) on delete cascade
);

CREATE TABLE CareerInfo(
	cnum int primary key,
	startDate date,
	endDate date,
	compName varchar(200),
	position varchar(30),
	rank int,
	duty varchar(50),
	cmem int,
	foreign key (cmem) references member(mnum) on delete cascade
);

CREATE TABLE licenseInfo(
	lnum int primary key,
	getDate date,
	expireDate date,
	lname varchar(50),
	grade varchar(50),
	lmem int,
	foreign key (lmem) references member(mnum) on delete cascade
);
SELECT * FROM HRADMIN WHERE hmem=1000 AND PW='1000';
/*table*/
select * from all_tables;
SELECT * FROM HRADMIN WHERE hmem='1111' AND PW='1111';
select * from member;
select * from post;
select * from HRAdmin;
select * from SchoolInfo;
select * from CareerInfo;
select * from licenseInfo;

SELECT * FROM HRADMIN WHERE ID=1111 AND PW='1111';

drop table member CASCADE CONSTRAINTS;
drop table post;
drop table HRAdmin CASCADE CONSTRAINTS;
drop table SchoolInfo;
drop table CareerInfo;
drop table licenseInfo;

/*레코드*/
insert into post (pnum, pmem, category, content, password) 
values((select nvl(max(pnum),0)+1 from post),1, '업무태도', '업무 태도 불량합니다.','1234');

insert into member (mnum, mName, startDate, endDate, birthDate, teamName, duty, position, mrank)
values(1000,'루피', '2021-10-01', '9999-12-31', '1988-01-01', 'HR팀', '인사관리', '사원', 2);

insert into hradmin (hnum, hmem, pw) values ((select nvl(max(hnum),0)+1 from hradmin), 1000, '1111');
delete from hradmin where hnum=1;
insert into schoolInfo (snum, stype, sname, startDate, endDate, field, major, finish, smem)
values((select nvl(max(snum),0)+1 from schoolInfo),'고등학교', '서울고등학교', '2015-01-01','2018-01-01', '인문계열','인문', 'Y', 1);

insert into careerInfo (cnum, startDate, endDate, compName, position, rank, duty, cMem)
values((select nvl(max(cnum),0)+1 from careerInfo),'2018-01-01', '2021-01-01', '가나주식회사','사원', '2','사무업무', 1);

SELECT * FROM HRADMIN WHERE hmem=1000 AND PW='1000'
UPDATE HRADMIN SET PW='1000' WHERE HNUM=1000;
