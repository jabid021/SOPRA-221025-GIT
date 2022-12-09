package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import context.Singleton;

public class StartAppListener implements ServletContextListener {

   
	public void contextInitialized(ServletContextEvent sce)  { 
	
		//System.out.println("LE SERVEUR START !");
		try{Class.forName("com.mysql.jdbc.Driver");}
		catch(Exception e) {}
		
		Singleton.getInstance();
   }
	
	
    public void contextDestroyed(ServletContextEvent sce)  { 
        
    	//System.out.println("LE SERVEUR STOP !");
    	Singleton.getInstance().getEmf().close();
    }

    
}
