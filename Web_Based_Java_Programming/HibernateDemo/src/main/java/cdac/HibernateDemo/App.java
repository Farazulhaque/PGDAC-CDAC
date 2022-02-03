package cdac.HibernateDemo;

import java.util.ArrayList;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// dialect specifes the type of database used in hibernate 
// so that hibernate generate appropriate sql statement
public class App {
	public static void insertData(Session session, Transaction tx) {
		Employee emp = new Employee();
		// emp.setEid(1);
		emp.setEname("Sadia");
		// emp.setEpassword("faraz123");
		session.save(emp);
		tx.commit();

	}

	// delete a transient object
	// transient object -> object that is not saved in database
	// we created a object that is not saved
	// because save() function is not called
	// pass this object to delete() method
	public static void deleteData(Scanner sc, Session session, Transaction tx) {
		System.out.print("Enter id: ");
		int id = sc.nextInt();
		Employee emp = new Employee();
		emp.setEid(id);
		session.delete(emp);
		// delete() is used to delete given object
		tx.commit();

	}

	// delete a persistent object
	// persistent object -> that is saved in database
	// here we are first fetching / running select query on database, it returns an
	// employee object
	// we are not creating object of employee
	// if emp is not null then run delete query
	public static void deleteEmployee(Scanner sc, Session session, Transaction tx) {
		System.out.print("Enter id: ");
		int id = sc.nextInt();
		Employee emp = session.get(Employee.class, id);
		if (emp != null) {
			session.remove(emp);
			System.out.println("Customer is removed");
		} else {
			System.out.println("No employee found");
		}
		tx.commit();

	}

	// add a set of employees to a database using array list object
	public static void addEmployees(Scanner sc, Session session, Transaction tx) {
		System.out.print("Enter number of employee to add: ");
		int no = sc.nextInt();
		ArrayList<Employee> emplist = new ArrayList<Employee>();
		for (int i = 0; i < no; i++) {
			Employee emp = new Employee();
			System.out.print("Enter name of employee: ");
			String ename = sc.next();
			System.out.print("Enter pasword: ");
			String epass = sc.next();
			emp.setEname(ename);
			emp.setEpassword(epass);
			emplist.add(emp);

		}
		for (Employee emp : emplist) {
			session.save(emp);
		}
		tx.commit();
	}

	public static void main(String[] args) {
		// Mapping pojo class without mapping it in hibernate.cfg.xml
		// Configuration cfg = new
		// Configuration().configure().addAnnotatedClass(cdac.HibernateDemo.Employee.class);

		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 to insert data");
		System.out.println("Enter 2 to delete data");
		System.out.println("Enter 3 to delete persistent data");
		System.out.println("Enter 4 to add multiple employees");
		System.out.print("Enter your choice: ");
		int ch = sc.nextInt();
		switch (ch) {
			case 1:
				insertData(session, tx);
				break;
			case 2:
				deleteData(sc, session, tx);
				break;
			case 3:
				deleteEmployee(sc, session, tx);
				break;
			case 4:
				addEmployees(sc, session, tx);
				break;
			default:
				break;
		}
	}
}
