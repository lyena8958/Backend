package com.lee.app.common;

import org.aspectj.lang.JoinPoint;

import model.member.MemberVO;

/*get()�� �Բ� ����(return�̹Ƿ� getter���� ����� �ȴ�.)
after���� ���� �����*/

// new�� ���ߴµ� new�� �Ǿ��ִ°�, ���ε庯���̴�. jp, obj
public class AfterReturningAdvice { 
	public void printLog(JoinPoint jp, Object obj) {
		
		
		String name = jp.getSignature().getName();
		System.out.println("�޼����: "+name);
		MemberVO data = (MemberVO)obj;
		
		// �����̽��� ��Ŷ� ����Ǿ� ������ �𸣱� ������, �׷��� �̸� ���������� (����������!!) 
		if(obj instanceof MemberVO) { // ĳ���� ���ɿ��� instanceof
			// ĳ������ �����ϸ� �Ʒ� ����
			if(data.getRole().equals("ADMIN")) {
				System.out.println("������ �α���");
			}
			else {
				System.out.println("�Ϲݻ���� �α���");
			}
		}
		

		System.out.println("get()�� ���յǴ� returning");
	}
}
