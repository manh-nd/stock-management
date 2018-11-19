package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationContextInitializer implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setRequestCharacterEncoding("UTF-8");
		sce.getServletContext().setResponseCharacterEncoding("UTF-8");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
	
}
