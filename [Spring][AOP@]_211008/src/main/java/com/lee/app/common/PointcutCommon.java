package com.lee.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// ����Ʈ���� �����ϴ� Ŭ������ ����
@Aspect // ������ �Ϸ�Ǿ����� �˷���
public class PointcutCommon { 
	// ���� �޼���
	// �����̽��� ����Ʈ���� "�ĺ�"�ϱ����� �ۼ� (����Ʈǥ���� ����)
	// �ĺ��� �����̸�, ������ �ۼ����ʿ�xxx. {}�ٵ���� �������
	@Pointcut("execution(* model.board.*Impl.get*(..))")
	public void aPointcut() {}
	
	@Pointcut("execution(* model.board.*Impl.*(..))")
	public void bPointcut() {} 
	
	@Pointcut("execution(* model.member.*Impl.get*(..))")
	public void cPointcut() {}
	
}
