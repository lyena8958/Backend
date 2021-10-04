package model.member;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



public class MemberClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		// 			�θ�									�ڽ�
		
					// ������̼����� �����߱� ������ �ҷ��ü� �ְԵȴ�.
		MemberService ms = (MemberService)factory.getBean("memberService");
		
	/*	MemberVO vo = new MemberVO();
		vo.setId("1111");
		vo.setPassword("1111");
		vo.setName("��");
		vo.setRole("�����");
		
		ms.insertMember(vo);*/
		
		List<MemberVO> datas = ms.getAll();
		for(MemberVO v : datas) {
			System.out.println(v);
		}
		factory.close();//�ȴݾ��־ ������ ���ɻ� �ݾ��ִ� ���� ����(�������÷���)
	}
}
