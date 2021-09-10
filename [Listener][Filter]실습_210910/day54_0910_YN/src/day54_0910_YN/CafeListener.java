package day54_0910_YN;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class CafeListener
 *
 */
@WebListener
public class CafeListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public CafeListener() {
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
    	context.setAttribute("Cafelatte", new CafeMenu("카페라떼"));
    	context.setAttribute("IceAmericano", new CafeMenu("아이스아메리카노"));
    	context.setAttribute("Affogato", new CafeMenu("아포가토"));
    }
	
}
