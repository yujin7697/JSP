package Listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class C01ServletContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("C01ServletContextListener contextInitialized 불러잉");
		sce.getServletContext().setAttribute("CL", "CL_VALUE");
		sce.getServletContext().setAttribute("CL_2", 1);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("C01ServletContextListener contextDestroyed 불러잉");
	}
	
}
