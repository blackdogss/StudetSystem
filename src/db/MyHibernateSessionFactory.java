package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MyHibernateSessionFactory {
	private static SessionFactory sessionFactory;	//会化工厂属性
	private MyHibernateSessionFactory(){
		
	}
	
	//一个公有的静态方法，获得会化工厂方法
	 public  static SessionFactory getsessionFactory()
	    {
	    	if(sessionFactory==null)
	    		{
	           Configuration configuration=new Configuration().configure();
	           ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	           sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    	}
				return sessionFactory;
	    		
	    }

}
