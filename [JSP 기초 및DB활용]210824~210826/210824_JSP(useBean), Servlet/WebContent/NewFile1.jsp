<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 자바코드안에 html을 넣을수있음== jsp -->

<%-- % > 순수 자바 코드만 넣을 수 있다. --%>
<!DOCTYPE html>
<!-- 변수를 html상단에 배치해주자! -->
<% // Controller ~62 line
	// 변수 선언
	int result = 0;

	// 요청 (get, post) - post일때만 실행 , 태그방식이 대문자로 옴
	//	getMethod == getter, setter 류
	if(request.getMethod().equals("POST")){//요청의 방식이 == POST일때 
		String op = request.getParameter("op"); // op값을갖고옴
		
		//오직 form에 있는 submit으로만 post액션을 수행할 수 있기때문에 post와 get을나눈다
		//get과 post로 나눈이유?
		//주소를 넘겨주는 것 get 
		// --> a태그의 href 누르면 get방식
		//이전페이지에<태그 form태그가 있었고 post로 되어있었을 때 -> submit를 누르면 post
		//main페이지 -> a태그의 버튼을 누르면 계산기페이지로 넘어올때 -> 
		// == get방식으로 사용자가 요청한것 -> 계산한게아니라 페이지를 보여달라는것
		// 
		
		//처음에 딱돌리면 get방식 ---> 위 조건문이 미성립
		// 계산하기 누르면(submit) post 조건문이 성립
		
		/*이전페이지 -- 직접url을 타고 가는것?
		a href="www.naver.com" -- get(참고로 일부 get에서는 데이터도들어갈수가있다.)
		-----------------------------------------------------------------------
		post --> 데이터가 있음을 암시할 수 있다.
		<form method="post" action ="www.naver.com">
		<input type="submit">
		-----------------------------------------------------------------------
		보편적으로 페이지만 보여주는게 get, 데이터요소가 들어간것은 post로 이해하면되는게맞을까욤?
 		==> yes*/
		
		
		// getParameter==메서드이름
		int num1 = Integer.parseInt(request.getParameter("num1")); // request.getParameter("num1"); 자료형문제(자료가 올때str로 넘어옴) 
		/* int num2 = Integer.parseInt(request.getParameter("num2")); */
		//파라미터 값은 문자열로 주고받음
		
		// MODEL
		int num2 = 2000; // 서버의 DB에 2000원이라고 저장되어있음
		
		if(op.equals("+")){
			result = num1+num2;
		}
		else if(op.equals("+")){
			result = num1+num2;
		}
		else if(op.equals("-")){
			result = num1-num2;
		}
		else if(op.equals("*")){
			result = num1*num2;
		}
		else if(op.equals("/")){
			result = num1/num2;
		}
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>계산기 실습1</title>
</head>
<body>
<!-- VIEW -->
<h2>계산기</h2>
<hr>
<!-- 폼태그는 앱보다 웹으로 보내려는게 많아서 post가많다 -->
<!-- form이 다른 위치에서 처리할거였으면 액션을 넣어줬을 텐데, 본페이지에서 하니 제외 -->
<!-- 유지보수성을위해 name추가, 밑에id 추가 -->
<form method="post" name="form1">  <!-- 백엔드 : name, 프론트 : id .. 프론트를위해 name도해주자-->
<!-- method를 post로지정안해서 get으로 받아온거죠? yes > 결론은 post로 지정안하면 자동(디폴트값)으로 get으로 받아오는것 -->
	<input type="text" name="num1", id="num1"> <!-- name속성은 id속성과 동일한 역할, 유지보수를 위해 id도 같이넣어줌 -->
	<select name="op"><!-- 명확한 값을 받을때는 select로하자 -->
		<option selected>+</option>
		<option>-</option>
		<option>*</option>
		<option>/</option>
	</select>
	<input type="text" name="num2", id="num2"> <!-- name속성은 id속성과 동일한 역할, 유지보수를 위해 id도 같이넣어줌 -->
	<input type="submit" value="계산하기" name="btn1">
	<input type="reset" value="다시입력" name="btn2"> <!-- 웹접근성지침 > reset -->
</form>
<hr>
<h3>계산결과 : <%= result %></h3> <%-- ==out.println(result) --%>
</body>
</html>