package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable exception) {
            // Make sure you log the exception to track it
            System.err.println("SessionFactory creation failed." + exception);
            throw new ExceptionInInitializerError(exception);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Optional but can be used to Close caches and connection pools
        getSessionFactory().close();
    }

}