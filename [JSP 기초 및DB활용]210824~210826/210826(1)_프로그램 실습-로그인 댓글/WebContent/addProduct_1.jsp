<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, model_productVO.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품을 구매예정목록에 추가하는 페이지</title>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");
	String product = request.getParameter("product");
	// 장바구니담고 로그인유지할때까지 데이터 유지
	// 세선에게 배열을 설정
	//  -> "배열" : 크기를 알아야 함! 3요소
	//			  (서로 관련있어야하고, 크기가 정해져있어야하고, 타입이 같아야함)
	//  --> 이러한 단점을 위해 배열리스트(컬렉션)
	
//int cnt = Integer.parseInt(request.getParameter("cnt"));
	// Controller: 사용자가 입력한 값들을 Java로 가져오는 작업
	
//int price = 20000; // M: DB에서 값을 가져오는 작업(select)
//int total=price*cnt;  // C : DB에서 가져온 값 x 사용자가 입력한 값
	
	// 이렇게하면 매번 리스트를 만들어서 최근 한개껏만 들어온다.
	//ArrayList<String> list = new ArrayList<String>();
	ArrayList<String> list = (ArrayList)session.getAttribute("list"); // main에서 리스트를 받아올것임
//ArrayList<Product> list = (ArrayList)session.getAttribute("list"); //DB사용시(MODEL PART)
	
	// 받아온 데이터가 없다면 == 최초주문이라면
	if(list==null){ 
		list=new ArrayList<String>(); // 객체화 진행
		session.setAttribute("list", list); // AL형식으로 세션에 속성추가
		// 세션에 등록도해주자 -> 그러면 이후에 세션에 list가(장바구니) 등록이됨
	}
	
	list.add(product);
	
%>
<script>
	
	alert("<%= product %>(이)가 추가되었습니다!");
	history.go(-1); //뒤로가기(이전페이지로 돌아가기) == 장바구니추가하고 기존페이지로 돌아가기위함
</script>



</body>
</html>