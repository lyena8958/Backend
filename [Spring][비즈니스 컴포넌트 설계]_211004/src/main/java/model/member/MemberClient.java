package model.member;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



public class MemberClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		// 			부모									자식
		
					// 어노테이션으로 설정했기 때문에 불러올수 있게된다.
		MemberService ms = (MemberService)factory.getBean("memberService");
		
	/*	MemberVO vo = new MemberVO();
		vo.setId("1111");
		vo.setPassword("1111");
		vo.setName("몽");
		vo.setRole("사용자");
		
		ms.insertMember(vo);*/
		
		List<MemberVO> datas = ms.getAll();
		for(MemberVO v : datas) {
			System.out.println(v);
		}
		factory.close();//안닫아주어도 좋지만 성능상 닫아주는 것이 좋다(가비지컬렉터)
	}
}
