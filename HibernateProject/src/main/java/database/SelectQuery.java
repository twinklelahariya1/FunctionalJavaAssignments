package database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import model.Applicant;
import model.ApplicantBackup;
import util.HibernateUtil;

public class SelectQuery {
    public static void main(String[] args) {
        // Get session factory using Hibernate Util class
        SessionFactory sf = HibernateUtil.getSessionFactory();
        // Get session from Sesson factory
        Session session = sf.openSession();
        @SuppressWarnings("rawtypes")
        Query query = session.createQuery("from ApplicantBackup");
//        List<Applicant> list = query.getResultList();
//        System.out.println("Number of Applicants present--> "+list.size());
//        for (Applicant applicant : list) {
//
//            System.out.println(applicant.getApplicantId());
//            System.out.println(applicant.getFirstName());
//        }
        
        List<ApplicantBackup> list = query.getResultList();
        System.out.println("Number of Applicants present--> "+list.size());
        for (ApplicantBackup applicantBackup : list) {

            System.out.println(applicantBackup.getApplicantId());
            System.out.println(applicantBackup.getFirstName());
        }

        session.close();
    }

}

