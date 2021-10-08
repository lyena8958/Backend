package com.lee.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import model.member.MemberVO;

/*get()와 함께 사용됨(return이므로 getter류와 사용이 된다.)
after보다 먼저 실행됨*/

// new를 안했는데 new가 되어있는건, 바인드변수이다. jp, obj
@Service // @Component(컴포넌트)를 상속받은 어노테이션
@Aspect
public class AfterReturningAdvice {
	
	// 포인트 컷 설정
/*	@Pointcut("execution(* model.member.*Impl.get*(..))")
	public void cPointcut() {}
	*/
	
	// 
	//축약형 @After(pointcut="bPointcut()")가 생략되어있던것을 다시 풀어쓰자 ->  왜? 바인드변수에는 정의를 해주어야하기 때문
	@AfterReturning(pointcut="PointcutCommon.cPointcut()", returning="obj")
	public void printLog(JoinPoint jp, Object obj) {
		
		String name = jp.getSignature().getName();
		System.out.println("메서드명: "+name);
		//System.out.println(obj);
		// 어드바이스는 어떤거랑 연결되어 사용될지 모르기 때문에, 그래서 이를 정의해주자 (안정적으로!!)
		
		if(obj instanceof MemberVO) { // 캐스팅 가능여부 instanceof
			MemberVO data = (MemberVO)obj;
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
