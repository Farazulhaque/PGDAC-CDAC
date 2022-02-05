package cdac.HibernateMappingAssignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Book b1 = new Book();
		b1.setBookName("English");
		b1.setPageNo(1);

		Book b2 = new Book();
		b2.setBookName("Science");
		b2.setPageNo(2);

		Book b3 = new Book();
		b3.setBookName("Math");
		b3.setPageNo(3);

		Publication p1 = new Publication();
		p1.setPubicationName("NCERT");

		Publication p2 = new Publication();
		p2.setPubicationName("Kidzee");

		Address1 a1 = new Address1();
		a1.setStreetName("New Town");
		a1.setCity("Kolkata");
		a1.setState("WB");
		a1.setPincode(987654);

		Address1 a2 = new Address1();
		a2.setStreetName("Ameerpet");
		a2.setCity("Hyderabad");
		a2.setState("telangana");
		a2.setPincode(123456);

		// One to one for address and publication
		p1.setPublicationAddress(a1);
		p2.setPublicationAddress(a2);

		// many to one for book and publication
		b1.setPublication(p1);
		b2.setPublication(p1);
		b3.setPublication(p2);

		session.save(b1);
		session.save(b2);
		session.save(b3);

		tx.commit();
		session.close();
		System.out.println("Successfully Executed");
	}

}
