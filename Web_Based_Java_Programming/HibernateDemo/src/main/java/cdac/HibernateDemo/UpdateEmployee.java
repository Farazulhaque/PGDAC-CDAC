package cdac.HibernateDemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee {
	public static void updateUsingMerge(Session session, Transaction tx) {
		Employee emp = new Employee();
		emp.setEname("sid101");
		emp.setEpassword("12345");
		session.save(emp);
		// Remove this instance from the session cache.
		// Changes to the instance will not be synchronized with the database.
		session.evict(emp);
		emp.setEname("sid kumar");
		emp.setEpassword("4000");
		Employee mergeemp = (Employee) session.merge(emp);
		tx.commit();

	}

	public static void updateEmployeeUsingTransientUpdate(Session session, Transaction tx) {
		Employee e = new Employee();
		e.setEid(13);
		e.setEname("Pranshun");
		session.update(e);
		tx.commit();
	}

	public static void updateEmployeeUsingPersistentUpdate(Session session, Transaction tx) {
		Employee emp = session.get(Employee.class, 13);
		if (emp != null) {
			emp.setEname("Pintola");
			emp.setEpassword("28384");
			session.update(emp);
			tx.commit();
		}
	}

	public static void updateEmployeeUsingUpdateAndSave(Session session, Transaction tx) {
		Employee e = new Employee();
		e.setEid(10);
		e.setEname("junior g");
		e.setEpassword("sismsim");
		session.saveOrUpdate(e);
		tx.commit();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 to udate using merge");
		System.out.println("Enter 2 to update using update ");
		System.out.println("Enter 3 to update persistent object");
		System.out.println("Enter 4 to save or  update object");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			updateUsingMerge(session, tx);
			break;
		case 2:
			updateEmployeeUsingTransientUpdate(session, tx);
			break;
		case 3:
			updateEmployeeUsingPersistentUpdate(session, tx);
			break;
		case 4:
			updateEmployeeUsingUpdateAndSave(session, tx);
			break;
		}
	}
}