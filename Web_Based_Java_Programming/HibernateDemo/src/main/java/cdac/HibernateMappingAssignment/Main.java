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
		b1.setBookName("Java");
		b1.setPageNo(100);

		Book b2 = new Book();
		b2.setBookName("Python");
		b2.setPageNo(200);

		Book b3 = new Book();
		b3.setBookName("C++");
		b3.setPageNo(300);

		Publication p1 = new Publication();
		p1.setPubicationName("Oriely");
		p1.setPublicationAddress("Delhi");

		Publication p2 = new Publication();
		p2.setPubicationName("MC Graw Hill");
		p2.setPublicationAddress("Delhi");

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
