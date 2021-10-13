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

		// 컨테이너 동작
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		/*
		 트랜잭션 처리가 되었으나 오류가 발생하고 있다.
		트랜잭션 처리를 하고 안하고의 같은 오류가 발생하고 있으나,
		내부적으로는 rollback을 처리하여 원자성을 나타내고 있다.
		
		개념만 잡으면 될듯, 자세한건 웹하면서 추가 언급될 예정
		*/
		
		
	// MEM -------------------------------------------------------------------------------		
		// MEM bean호출
		MemService ms = (MemService)factory.getBean("memberService");
		MemberVO mvo = new MemberVO();
		
		// set
		mvo.setId("12345678");
		mvo.setPassword("1111");
		mvo.setName("루피1");
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
		System.out.print("아이디입력 : ");
		mvo.setId(sc.next());
		System.out.print("비밀번호입력 : ");
		mvo.setPassword(sc.next());
		
		mvo = ms.getMember(mvo);
		


		System.out.println("──────────────────────────────");*/
		
	// BOARD -------------------------------------------------------------------------------
		/*// MEM bean호출
		BoardService bs = (BoardService)factory.getBean("boardService");
		
		BoardVO bvo = new BoardVO();
		
		// set
		bvo.setTitle("화요일 'ㅅ'");
		bvo.setWriter("루피1");
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
