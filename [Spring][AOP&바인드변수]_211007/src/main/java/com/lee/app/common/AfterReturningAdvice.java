package com.lee.app.common;

import org.aspectj.lang.JoinPoint;

import model.member.MemberVO;

/*get()와 함께 사용됨(return이므로 getter류와 사용이 된다.)
after보다 먼저 실행됨*/

// new를 안했는데 new가 되어있는건, 바인드변수이다. jp, obj
public class AfterReturningAdvice { 
	public void printLog(JoinPoint jp, Object obj) {
		
		
		String name = jp.getSignature().getName();
		System.out.println("메서드명: "+name);
		MemberVO data = (MemberVO)obj;
		
		// 어드바이스는 어떤거랑 연결되어 사용될지 모르기 때문에, 그래서 이를 정의해주자 (안정적으로!!) 
		if(obj instanceof MemberVO) { // 캐스팅 가능여부 instanceof
			// 캐스팅이 가능하면 아래 수행
			if(data.getRole().equals("ADMIN")) {
				System.out.println("관리자 로그인");
			}
			else {
				System.out.println("일반사용자 로그인");
			}
		}
		

		System.out.println("get()와 조합되는 returning");
	}
}
