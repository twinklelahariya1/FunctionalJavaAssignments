package database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import util.HibernateUtil;

public class UpdateQuery {

    public static void main(String[] args) {
        // Get session factory using Hibernate Util class
        SessionFactory sf = HibernateUtil.getSessionFactory();
        // Get session from Sesson factory
        Session session = sf.openSession();
        Query query = session.createQuery("update Applicant set age=:age where id=:id");
        query.setParameter("age", 30);
        query.setParameter("id", 1);
        // Begin transaction
        Transaction transaction = session.beginTransaction();
        int result = query.executeUpdate();
        // Commit the transaction and close the session
        transaction.commit();
        System.out.println("No of rows updated: "+result);

        session.close();
    }



}

