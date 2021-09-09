<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, model.bank.*"%>
<%
// 트랜잭션-계좌이체실습_control
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="bankDAO" class="model.bank.BankDAO"/>
    
 <%
    
 String action = request.getParameter("action");
 if(action.equals("main")){
	 ArrayList<BankVO> bankList = bankDAO.bankList();
	 request.setAttribute("bankList", bankList);
	 pageContext.forward("YN(1)_main.jsp");
 }
 
 else if(action.equals("pay")){
	 BankVO outUser = new BankVO();
	 BankVO inUser = new BankVO();
	 
	 outUser.setBname(request.getParameter("outUser"));
	 inUser.setBname(request.getParameter("inUser"));
	 System.out.println(outUser.getBname());
	 
	 outUser = bankDAO.bankOne(outUser);
	 inUser = bankDAO.bankOne(inUser);
	
	 outUser.setBalance(Integer.parseInt(request.getParameter("money")));
	 
	 boolean pay = bankDAO.pay(outUser, inUser);
	 
	 request.setAttribute("pay", pay);
	 pageContext.forward("YN(1)_payApply.jsp");
 }
 
 
 
    
    %>