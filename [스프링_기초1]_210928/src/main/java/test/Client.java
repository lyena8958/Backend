package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
   public static void main(String[] args) {

      // 1. 스프링 컨테이너(applicationContext)를 동작시켜보자!~~				// 실습용 context
      AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
      			// 부모								// 자식
      
      
      // 2. 객체를 요청하면, 해당 객체를 준다.
      //  == Look up
      //		// 없는 id명으로 지정한 경우, null이 아닌 Exception오류가 발생한다.
      //		// 해당 부분에 대해서는 else류의 코드를 추가하여 설정할 것임.
      Test t = (Test)factory.getBean("test");
      t.print();

      
      
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
