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
		System.out.println("around���� ������ �޼����: "+jp.getSignature().getName()); // �޼���� ���
		System.out.println("������ ����� ���۵˴ϴ� :)\n");
	}
}
