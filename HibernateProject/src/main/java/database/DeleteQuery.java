package database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import util.HibernateUtil;

public class DeleteQuery {

    public static void main(String[] args) {
        // Get session factory using Hibernate Util class
        SessionFactory sf = HibernateUtil.getSessionFactory();
        // Get session from Session factory
        Session session = sf.openSession();
        Query query = session.createQuery("delete from ApplicantBackup where id=:id");
        query.setParameter("id", 4);
        // Begin transaction
        Transaction t = session.beginTransaction();
        int result = query.executeUpdate();
        // Commit the transaction and close the session
        t.commit();
        System.out.println("No of rows Deleted: "+result);

        session.close();
    }

}
