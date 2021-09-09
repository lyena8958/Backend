package day53;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * Application Lifecycle Listener implementation class TestListener
 *
 */
// 컨테이너(서버)가 동작할때 "어노테이션을 훑어보면서" ServletContextListener 맞는지 확인하고 수행을 시킨다. -> 맞으면 32라인 수행
@WebListener
public class TestListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public TestListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 

    	ServletContext context = sce.getServletContext();
    	context.setAttribute("student", new Student("홍길동", 50));
    	
    }
	
}
