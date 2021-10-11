package com.lee.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// 포인트컷을 관리하는 클래스를 정의
@Aspect // 결합이 완료되었음을 알려줌
public class PointcutCommon { 
	// 참조 메서드
	// 어드바이스가 포인트컷을 "식별"하기위해 작성 (포인트표현법 참고)
	// 식별이 목적이며, 로직은 작성할필요xxx. {}바디블럭이 비어있음
	@Pointcut("execution(* model.board.*Impl.get*(..))")
	public void aPointcut() {}
	
	@Pointcut("execution(* model.board.*Impl.*(..))")
	public void bPointcut() {} 
	
	@Pointcut("execution(* model.member.*Impl.get*(..))")
	public void cPointcut() {}
	
}
