package com.lee.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {

	@Before("PointcutCommon.aPointcut()")
	public void printLog(JoinPoint jp) {
		System.out.println("around에서 보내는 메서드명: "+jp.getSignature().getName()); // 메서드명 출력
		System.out.println("데이터 출력이 시작됩니다 :)\n");
	}
}
