package com.lee.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

/*핵심관심 "후"에 호출됨
혹시라도 핵심관심중에 예외가 발생해도 호출됨*/

// 스프링컨테이너가 JoinPoint를 객체로 만든다
// 메서드 수행자체를 jp에 받게된다.
//JoinPoint류는 모두 바인드변수이다.
@Service // @Component(컴포넌트)를 상속받은 어노테이션
@Aspect // 설정이 완료되면 aspect로 작성하여 인식하게 된다. // 결합이 완료되었음을 알려줌
public class AfterAdvice {
	
	// aspect를 사용하려면  >>포인트컷과 어드바이스를 결합하여야한다.<<
	// 즉 어드바이스는 준비가되어 포인트컷만 결합을 시켜주면 된다.
	//					↓
	// 참조 메서드 -> 따로 클래스로 정의 (PointcutCommon)
	// 어드바이스가 포인트컷을 "식별"하기위해 작성 (포인트표현법 참고)
	// 식별이 목적이며, 로직은 작성할필요xxx. {}바디블럭이 비어있음
/*	@Pointcut("execution(* model.board.*Impl.get*(..))")
	public void aPointcut() {} // 로직이 필요없기 때문에 몸체만 작성
	
	@Pointcut("execution(* model.board.*Impl.*(..))")
	public void bPointcut() {} // 로직이 필요없기 때문에 몸체만 작성
	*/
	// 축약형
	//@After(pointcut="bPointcut()")가 생략되어있던것
	//@After("bPointcut()") // 어떤 동작과 어느포인트컷을 결합할지 작성
	@After("PointcutCommon.bPointcut()")
	public void printLog(JoinPoint jp) {
		//jp.getSignature()
/*		Object[] args = jp.getArgs(); //20% 사용
		String name = jp.getSignature().getName(); //80% 사용 - getSignature == 인풋, 아웃풋을 알 수 있게됨
		
		
		System.out.println("메서드명 : "+ name);
		System.out.println("매개변수정보 : "+ args[0]);*/
		System.out.println("핵심관심 후에 호출됨");
		
	}
}
// 함수도 메모리를 갖고있다.