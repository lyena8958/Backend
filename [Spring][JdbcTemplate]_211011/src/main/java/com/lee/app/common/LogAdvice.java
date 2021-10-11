package com.lee.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service // @Component(������Ʈ)�� ��ӹ��� ������̼�
@Aspect // ������ �Ϸ�Ǿ����� �˷���
public class LogAdvice {
	/*@Pointcut("execution(* model.board.*Impl.get*(..))")
	public void cPointcut() {} // id����
*/	
	@Before("PointcutCommon.cPointcut()")
	public void printLog() {
		System.out.println("����Ͻ� �޼��带 �����ϱ� ���� ��µǴ� �α�!");

	}
}

// 1. get*()����ÿ���
// 2. �ش� �ٽɰ��� ������ ����� �� �ֵ���
// 3. LogAdvice�� pointLog()��! 
