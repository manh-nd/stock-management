package util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private volatile static SessionFactory sessionFactory;

	public static SessionFactory getSessionfactory() {
		if (sessionFactory == null) {
			try {
				sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			} catch (HibernateException e) {
				throw e;
			}
		}
		return sessionFactory;
	}

}
