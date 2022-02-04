package cdac.HibernateMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneExample {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Employee1 emp = new Employee1();
		emp.setEmpName("Arisha");
		emp.setEmpMail("arisha@gmail.com");

		Address addr = new Address();
		addr.setStreet("Street no 1");
		addr.setCity("Delhi");
		addr.setPincode(110032);
		addr.setEmployee(emp);

		emp.setAddress(addr);

		session.save(emp);
		tx.commit();
		session.close();
		System.out.println("Work done");
	}

}
