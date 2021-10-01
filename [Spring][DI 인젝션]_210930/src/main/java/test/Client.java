package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
   public static void main(String[] args) {

      // 1. 스프링 컨테이너(applicationContext)를 동작시켜보자!~~				// 실습용 context
	    		// ▶️설정한 스프링컨테이너(applicationContext) 동작 	== new BeanFactory();
      AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
      			// 부모								// 자식
      
      
      
      
      
      // 2. 객체를 요청하면, 해당 객체를 준다. 	▶️빈즈Class 호출 	== (캐스팅)factory.getBean(args[0]);
      Phone phone = (Phone)factory.getBean("phone");
      phone.power();
      phone.soundUp();


/* 컨테이너에 갤럭시를 먼저 입력했는데 스마트워치가 호출된다.
   스마트워치 기본생성자 호출됨
      갤럭시 생성자 호출됨		--> 기본생성자가 호출이안된것은 오버로딩도 컨테이너가 감별하기 때문이다.
      갤럭시 전원!	
      스마트워치로 소리업!
*/
      
      
      // 3. 스프링 컨테이너 종료
      factory.close();
      
      
      
      
      
      // => Console
      // 현재 <bean> 등록된 모든 클래스에 대한 객체를 미리 만들어놓습니다!
      // pre-loaging 즉시 로딩 -- POJO로 실행되어 가벼운 편!!(리스너, 필터처럼) < - > 안쓰는Class에 대해서는 설정에 따라 -- lazy loading 지연 로딩
      // 기본 생성자 호출됨!
      
      
      
      // => Console
      // 기본 생성자 호출됨!
      // 출력
      
   }
}
