package com.lee.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;
//ProceedingJoinPoint는 aop:config부터 만들어지는지?
// 테스팅할 때 주로 사용됨 (자원확인, 수행시간(6번라인~10번라인)
public class AroundAdvice { //클라이언트가 사용하는 메서드(핵심관심)를 가로챔 -> 매개변수를 받아야 한다. 
	public Object printLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("pjp인자를 갖는 메서드에서 출력하는 문구-1");
		System.out.println("메서드명: "+pjp.getSignature().getName());
		
		StopWatch sw = new StopWatch(); // 스프링프레임워크에서 제공
		
		sw.start(); // 1. 시작
		
		//메서드 수행의 반환값을 받게된다.
		Object obj = pjp.proceed(); // 여기서 DAO를 수행하게 된다. // 2. 수행
		//System.out.println(pjp);
		sw.stop(); // 3. 종료
		
		System.out.println("소요시간 : "+sw.getTotalTimeMillis()); // 수행시간 확인
		System.out.println("pjp인자를 갖는 메서드에서 출력하는 문구-2");
		return obj;
	}
}
