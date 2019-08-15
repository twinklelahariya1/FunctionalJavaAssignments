package database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import util.HibernateUtil;

public class InsertQuery {

    public static void main(String[] args) {
        // Get session factory using Hibernate Util class
        SessionFactory sf = HibernateUtil.getSessionFactory();
        // Get session from Session factory
        Session session = sf.openSession();
        Query query = session.createQuery("insert into ApplicantBackup (applicantId,firstName, lastName, age, education) select id, firstName, lastName, age, education from Applicant ");
        // Begin transaction
        Transaction t = session.beginTransaction();
        int result = query.executeUpdate();
        // Commit the transaction and close the session
        t.commit();
        System.out.println("No of rows inserted: " + result);

        session.close();
    }

}
