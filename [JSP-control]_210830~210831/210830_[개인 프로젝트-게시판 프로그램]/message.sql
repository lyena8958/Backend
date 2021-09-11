create table message(
	mnum int primary key,  /*pk자체가 유니크하니 notnull기능이탑재*/
	writer varchar(15) not null, /*작성자*/
	title varchar(15) not null, /*글 제목*/
	content varchar(100) not null, /*내용*/
	wdate date default sysdate /*작성일*/
	/*insert , ?, ?,date() == 하면 해결이 되긴 함*/
	
	/*cnt int, 조회수 - 심화과정(역량되면 구현가능)*/
	/*fav int 좋아요! - 심화과정(역량되면 구현가능)*/

);

select * from message;

/*샘플데이터 : 일반적으로 서비스 될 때에는 샘플데이터 有*/
insert into message values (1, '티모', '210831', '피곤', '2021-08-31');
/*목록이 없으면 null exception 오류가 뜨기 때문에 샘플 데이터는 넣어주자.*/