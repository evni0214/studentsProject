package listeners;

import database.DataService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Evgeny on 18.02.2016.
 */
public class ContextInitListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DataService service = new DataService();
        service.init();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}