package com.lee.app.common;

import org.aspectj.lang.JoinPoint;

import model.member.MemberVO;

public class AfterThrowingAdvice {
	public void printLog(JoinPoint jp, Exception excep) {
		
		// 2
		String name = jp.getSignature().getName();
		System.out.println("�޼����: "+name);
		System.out.println("����: "+excep);
		
		if(excep instanceof IllegalArgumentException) {
			System.out.println("�Ű������� ���������ʽ��ϴ�!");
			System.out.println("1. id�� pk�ε� 0 or �̹������ϴ� ������ ó���ߴ��� Ȯ��");
		}
		else if(excep instanceof ArithmeticException) {
			System.out.println("0���� �����������ϴ�!");
			System.out.println("1. /0 �ߴ��� Ȯ�� - by �̿���");
			System.out.println("2. ���ϱ� �̰� ��Ÿ���� ���� ����... 3���޼��� ��ŸȮ��");
		}
		else if(excep instanceof Exception) {
			System.out.println("��Ȯ�� �����Դϴ�.");
		}
	
		// 1
		System.out.println("���ܹ߻��� ȣ���"); 
		
	}
}
