package cdac.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObjectStatesExample {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Employee e = new Employee();
		e.setEname("mickey");
		session.save(e);
		if (session.contains(e) == true) {
			System.out.println("object is attached to session");
		} else {
			System.err.println("object is transient");
		}
		session.close();
		e.setEname("ramu");
		session.save(e);
		if (session.isOpen() == false) {
			System.out.println(session.contains(e));
		}
	}
}
