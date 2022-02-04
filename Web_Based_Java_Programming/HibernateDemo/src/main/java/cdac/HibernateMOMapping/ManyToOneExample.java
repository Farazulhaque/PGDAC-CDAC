package cdac.HibernateMOMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToOneExample {
	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Products p1 = new Products();
		p1.setProductName("silk");
		p1.setPrice(70);

		Products p2 = new Products();
		p2.setProductName("fruit and nuts");
		p2.setPrice(60);

		Products p3 = new Products();
		p3.setProductName("milkybar");
		p3.setPrice(20);

		Company1 c1 = new Company1();
		c1.setCompanyName("Cadbury");

		Company1 c2 = new Company1();
		c2.setCompanyName("Nestle");

		p1.setPcompany(c1);
		p2.setPcompany(c1);
		p3.setPcompany(c2);

		session.save(p1);
		session.save(p2);
		session.save(p3);
		tx.commit();
		session.close();
		System.out.println("Many to one example");
	}
}
