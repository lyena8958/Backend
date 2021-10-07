package com.lee.app.common;

// aspectj -> 디펜던시 주입한 거(pom.xml)
import org.aspectj.lang.JoinPoint;

/*핵심관심 "후"에 호출됨
혹시라도 핵심관심중에 예외가 발생해도 호출됨*/

// 스프링컨테이너가 JoinPoint를 객체로 만든다
// 메서드 수행자체를 jp에 받게된다.
//JoinPoint류는 모두 바인드변수이다.
public class AfterAdvice {
	public void printLog(JoinPoint jp) { // JoinPoint 핵심관심 정보를 알 수 있음
		//jp.getSignature()
		Object[] args = jp.getArgs(); //20% 사용
		String name = jp.getSignature().getName(); //80% 사용 - getSignature == 인풋, 아웃풋을 알 수 있게됨
		
		
		System.out.println("메서드명 : "+ name);
		System.out.println("매개변수정보 : "+ args[0]);
		System.out.println("핵심관심 후에 호출됨");
	}
}
// 함수도 메모리를 갖고있다.