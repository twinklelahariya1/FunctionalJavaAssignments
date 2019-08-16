package database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.ApplicantBackup;
import util.HibernateUtil;

public class DeleteQuery {

	public static void main(String[] args) {

		ApplicantBackup applicantBackup = new ApplicantBackup();
		// Get session factory using Hibernate Util class
		SessionFactory sf = HibernateUtil.getSessionFactory();
		// Get session from Session factory
		Session session = sf.openSession();
//        Query query = session.createQuery("delete from ApplicantBackup where id=:id");
		applicantBackup.setApplicantId(1);
		// Begin transaction
		Transaction transaction = session.beginTransaction();

		session.delete(applicantBackup);

		// int result = query.executeUpdate();
		// Commit the transaction and close the session
		transaction.commit();
//		System.out.println("No of rows Deleted: " + result);

		session.close();
	}

}
