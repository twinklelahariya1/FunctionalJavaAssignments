package database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Applicant;
import util.HibernateUtil;

public class PopulateData {
    public static void main(String[] args) {

        // Get session factory using Hibernate Util class
        SessionFactory sf = HibernateUtil.getSessionFactory();
        // Get session from Sesson factory
        Session session = sf.openSession();

        // Begin transaction
        Transaction transaction = session.beginTransaction();

        //Create Applicant Model data
//        Applicant applicant1 = new Applicant();
//        applicant1.setFirstName("John");
//        applicant1.setLastName("KC");
//        applicant1.setAge(28);
//        applicant1.setEducation("Graduation");
//
//        Applicant applicant2 = new Applicant();
//        applicant2.setFirstName("Jacob");
//        applicant2.setLastName("JC");
//        applicant2.setAge(30);
//        applicant2.setEducation("Graduation");
        
        Applicant applicant3 = new Applicant();
        applicant3.setFirstName("Twinkle");
        applicant3.setLastName("Lahariya");
        applicant3.setAge(21);
        applicant3.setEducation("Graduation");

//        session.save(applicant1);
//        session.save(applicant2);
        session.save(applicant3);

        // Commit the transaction and close the session
        transaction.commit();

        session.close();
        System.out.println("successfully persisted Applicant details");

    }

}
