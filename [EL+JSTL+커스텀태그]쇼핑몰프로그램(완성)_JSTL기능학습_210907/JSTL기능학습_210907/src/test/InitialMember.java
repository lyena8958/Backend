// 0903_test 클래스 그대로 가져옴

package test;
//리스너 클래스 생성
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// 어노테이션
// == 애너테이션
// @Override처럼 없어도되지만 있어야 리스너 동작이 잘될 수가 있다.
@WebListener
						// 페이지 스코프를 굳이 하진 않는다. (낭비라서)
//리스너 클래스로 동작하게 하려면 --> 인터페이스를 implements를 사용해야한다.
//이때 인터페이스의 정의된 메서드 == 추상메서드의 "강제성"으로 인해 메서드 오버라이딩을 해야한다. // 톰캣의 시작을 모니터링해서 자신이 인지하기때문에 contextInitialized를 수행한다.
public class InitialMember implements ServletContextListener {//servlet~listener가 모니터링을 하기때문에 메서드가 자동호출이 되는 것이다.
	// ServletContextListener는 서버에 대한 리스너이다.
	// 해서 단위가 서버이므로, 톰캣 외에도 타서버프로그램으로도 사용이 가능하며, 서버가 시작/종료에 따라 아래 메서드가 자동호출된다.
	// 서버==Application scope가 맞는데, 
	// session에 대한 리스너는 따로 구현이 되어있다고 한다.
	// 해서 결론은 ServletContextListener 서버(application)전용!!
	
	//톰캣 종료될 때 자동호출
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	//톰캣 시작될 때 자동호출
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// DB데이터를 생성
		// -> Member.java
		
		ArrayList<Member> datas = new ArrayList<Member>();
		for(int i = 0; i < 5; i++) {
			Member data = new Member("티모"+i,"timo"+i+"@naver.com");
			datas.add(data);
		}
		
		//일부러 이메일이 없는 데이터도 생성
		datas.add(new Member("아리",null));
		datas.add(new Member("아무무",null));
		
		// 현재 만든 데이터들은 톰캣이 시작될 때 생성된 것들
		// scope: application에 저장하고싶다!
		ServletContext context = sce.getServletContext();
		context.setAttribute("members", datas);
		context.setAttribute("member", new Member());
		  // context로 setAttribute 하는 것들은 모두 →→ scope가 application에 저장되는 것이다.
		
		
	}

}
