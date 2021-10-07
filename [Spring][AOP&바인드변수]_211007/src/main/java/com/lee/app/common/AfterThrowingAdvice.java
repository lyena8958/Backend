package com.lee.app.common;

import org.aspectj.lang.JoinPoint;

import model.member.MemberVO;

public class AfterThrowingAdvice {
	public void printLog(JoinPoint jp, Exception excep) {
		
		// 2
		String name = jp.getSignature().getName();
		System.out.println("메서드명: "+name);
		System.out.println("예외: "+excep);
		
		if(excep instanceof IllegalArgumentException) {
			System.out.println("매개변수로 적절하지않습니다!");
			System.out.println("1. id가 pk인데 0 or 이미존재하는 값으로 처리했는지 확인");
		}
		else if(excep instanceof ArithmeticException) {
			System.out.println("0으로 나눌수없습니다!");
			System.out.println("1. /0 했는지 확인 - by 이예나");
			System.out.println("2. 보니까 이거 오타나는 구역 있음... 3번메서드 오타확인");
		}
		else if(excep instanceof Exception) {
			System.out.println("미확인 예외입니다.");
		}
	
		// 1
		System.out.println("예외발생시 호출됨"); 
		
	}
}
