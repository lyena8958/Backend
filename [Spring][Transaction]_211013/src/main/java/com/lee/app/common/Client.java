package com.lee.app.common;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.board.BoardService;
import model.board.BoardVO;
import model.member.MemService;
import model.member.MemberVO;

public class Client {
	public static void main(String[] args) {

		// �����̳� ����
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		/*
		 Ʈ����� ó���� �Ǿ����� ������ �߻��ϰ� �ִ�.
		Ʈ����� ó���� �ϰ� ���ϰ��� ���� ������ �߻��ϰ� ������,
		���������δ� rollback�� ó���Ͽ� ���ڼ��� ��Ÿ���� �ִ�.
		
		���丸 ������ �ɵ�, �ڼ��Ѱ� ���ϸ鼭 �߰� ��޵� ����
		*/
		
		
	// MEM -------------------------------------------------------------------------------		
		// MEM beanȣ��
		MemService ms = (MemService)factory.getBean("memberService");
		MemberVO mvo = new MemberVO();
		
		// set
		mvo.setId("12345678");
		mvo.setPassword("1111");
		mvo.setName("����1");
		mvo.setRole("USER");

		// insert
		ms.insertMember(mvo);
		
		// List
		//List<MemberVO> mDatas = ms.getListMember();
		
		/*	// forEach
		for(MemberVO vo : mDatas) {
			System.out.println(vo);
		}
		System.out.println("------------------------------");
		
		//get
		Scanner sc = new Scanner(System.in);
		System.out.print("���̵��Է� : ");
		mvo.setId(sc.next());
		System.out.print("��й�ȣ�Է� : ");
		mvo.setPassword(sc.next());
		
		mvo = ms.getMember(mvo);
		


		System.out.println("������������������������������������������������������������");*/
		
	// BOARD -------------------------------------------------------------------------------
		/*// MEM beanȣ��
		BoardService bs = (BoardService)factory.getBean("boardService");
		
		BoardVO bvo = new BoardVO();
		
		// set
		bvo.setTitle("ȭ���� '��'");
		bvo.setWriter("����1");
		bvo.setContent("~~~~~");
		
		// insert
		bs.insertBoard(bvo);
		
		bvo.setContent("~~");
		
		// List
		List<BoardVO> bDatas = bs.getListBoard(bvo);
		
		// forEach
		for(BoardVO vo : bDatas) {
			System.out.println(vo);
		}
		*/
		factory.close();
		
	}
}
