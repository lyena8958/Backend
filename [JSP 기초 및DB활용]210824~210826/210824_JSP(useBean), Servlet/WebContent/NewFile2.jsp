<!-- 빈즈클래스로 값을 불러오는 형식 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- 이미지처럼 id가 필수!! (빈즈==클래스를 불러오자) > 파일생성시 클래스로 생성 -->
<jsp:useBean id="calc" class="test.CalcBean"/>  <!-- 객체화==인스턴스 생성(기본생성자) -->
<%--CalcBean이라는 클래스에서 calc이름의 객체를 생성 == 객체화 == 인스턴스화 --%>
<%--인스턴스화할라면? 생성자가 있어야한다. --%>
<!-- test.CalcBean 이런이유때문에 패키지가 반드시필요 -->
<!-- calc인스턴스가 뭐하는애야? > 계산하는애야 -->

<%--5번 라인이 서블릿으로 변환이 되면 CalcBean calc = new CalcBean();와 똑같다. --%>


<!-- jsp:useBean id="calc" class="test.CalcBean" > 기본생성자 -->

<!-- 기본생성자로 객체를 인스턴스화하고↑↑ , setter로 값을 넣어준다. ↓↓-->
<!-- 클래스의(CalcBean) get, set메서드를 접근하는 태그 - 자동연결을해줌 -->
<jsp:setProperty property ="*" name="calc"/> <!-- * > all -->
<!-- 속성을 SET할거야, 무슨속성? * 모두, 클래스이름은 calc야 -->
<!-- setter가 다 작동되어 셋업됨 -->
<!-- num1, 2받아올때 parseint로 안해도 됨 -> 알아서 적용해줌 -->
<!-- setProperty가 값을 가져올수있는 이유는 calc의 멤버변수와 html name명이 같기때문이다 -->

<!-- 기본 생성자로 인스턴스를 만들고 > setter로 멤버변수 채워넣고 > 필요한값있으면 받을거야 getter == 계산결과반환 -->
<!DOCTYPE html>

<%-- 계산하는 기능을 호출, 로 했으나 500 오류가 뜸 --%>
<%-- calc.calculate(); --%>
<% if(request.getMethod().equals("POST")){calc.calculate();}%>

<html>
<head>
<meta charset="UTF-8">
<title>계산기 실습2</title>
</head>
<body>
<!-- jsp -> view part 태그들로만 구성된것이 가장 좋은 뷰이다 디자이너들은 자바를 모른다고 가정 %같은 태그 -->
  <!-- mvc를 완벽분리하자 --> <!-- ★변수이름을 맞춰주자 -->
  <!-- V -->
  <!-- M은 클래스정의 CalcBean  -->
<form method="post" name="form1">  <!-- 백엔드 : name, 프론트 : id .. 프론트를위해 name도해주자-->
	<input type="text" name="num1", id="num1"> <!-- name속성은 id속성과 동일한 역할, 유지보수를 위해 id도 같이넣어줌 -->
	<select name="op"><!-- 명확한 값을 받을때는 select로하자 -->
		<option selected>+</option>
		<option>-</option>
		<option>*</option>
		<option>/</option>
	</select>
	<input type="text" name="num2", id="num2"> <!-- name속성은 id속성과 동일한 역할, 유지보수를 위해 id도 같이넣어줌 -->
	<input type="submit" value="계산하기" name="btn1"> <!-- 누르면 새페이지가 나오는데, -->
	<input type="reset" value="다시입력" name="btn2"> <!-- 웹접근성지침 > reset -->
</form>
<hr>					<!-- 정해져있기때문에 result를 넣었고 다필요하면 *로 넣어주자 -->
<h3>계산결과 : <jsp:getProperty property ="result" name="calc"/> </h3>
<!-- %result안에 자바코드를 쓸라면 변수를 만들어야한다. >삭제 -->
</body>
</html>