package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
   public static void main(String[] args) {

      // 1. ������ �����̳�(applicationContext)�� ���۽��Ѻ���!~~				// �ǽ��� context
      AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
      			// �θ�								// �ڽ�
      
      
      // 2. ��ü�� ��û�ϸ�, �ش� ��ü�� �ش�.
      //  == Look up
      //		// ���� id������ ������ ���, null�� �ƴ� Exception������ �߻��Ѵ�.
      //		// �ش� �κп� ���ؼ��� else���� �ڵ带 �߰��Ͽ� ������ ����.
      Test t = (Test)factory.getBean("test");
      t.print();

      
      
      // 3. ������ �����̳� ����
      factory.close();
      
      
      
      // => Console
      // ���� <bean> ��ϵ� ��� Ŭ������ ���� ��ü�� �̸� ���������ϴ�!
      // pre-loaging ��� �ε� -- POJO�� ����Ǿ� ������ ��!!(������, ����ó��) < - > �Ⱦ���Class�� ���ؼ��� ������ ���� -- lazy loading ���� �ε�
      // �⺻ ������ ȣ���!
      
      
      
      // => Console
      // �⺻ ������ ȣ���!
      // ���
      
   }
}
