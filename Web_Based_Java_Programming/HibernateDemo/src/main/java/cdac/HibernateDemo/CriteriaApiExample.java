package cdac.HibernateDemo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class CriteriaApiExample {

	@SuppressWarnings("deprecation")
	public static void fetchAllEmployees(Session session, Transaction tx) {
		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> emplist = criteria.list();
		for (Employee emp : emplist) {
			System.out.println(emp.getEid() + " " + emp.getEname() + " " + emp.getEpassword());
		}
		// tx.commit();
	}

	@SuppressWarnings("deprecation")
	public static void fetchEmployeesOnBasisOfName(Session session, Transaction tx) {
		Criteria criteria = session.createCriteria(Employee.class);
		// get all employees whose name starts with letter "A"
		criteria.add(Restrictions.like("ename", "A%"));
		List<Employee> emplist = criteria.list();
		System.out.println("Name starts with A: ");
		for (Employee emp : emplist) {
			System.out.println(emp.getEid() + " " + emp.getEname() + " " + emp.getEpassword());
		}

		tx.commit();
	}

	public static void fetchAllEmployeesOnBasisOfId(Scanner sc, Session session, Transaction tx) {
		// creating criteria reference
		Criteria criteria = session.createCriteria(Employee.class);
		System.out.println("Enter id: ");
		int id = sc.nextInt();
		criteria.add(Restrictions.gt("eid", id));
		criteria.add(Restrictions.lt("eid", 12));
		List<Employee> emplist = criteria.list();
		System.out.println("Detail of employee on basis of id");
		for (Employee emp : emplist) {
			System.out.println(emp.getEname());
		}

		tx.commit();
	}

	public static void fetchEmployeeDetail(Scanner sc, Session session, Transaction tx) {
		// creating critera reference
		Criteria criteria = session.createCriteria(Employee.class);
		System.out.println("Enter username: ");
		String uname = sc.next();
		System.out.println("Enter password: ");
		String upass = sc.next();
		criteria.add(Restrictions.and(Restrictions.eq("ename", uname), Restrictions.eq("epassword", upass)));

		List<Employee> emplist = criteria.list();
		System.out.println("Detail of employee on basis of id: ");
		for (Employee emp : emplist) {
			System.out.println(emp.getEname());
		}

		tx.commit();
	}

	public static void main(String[] args) {
		Configuration config = new Configuration().configure();
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 to fetch all employee list");
		System.out.println("Enter 2 to fetch employee name starting with specific character ");
		System.out.println("Enter 3 to update persistent object");
		System.out.println("Enter 4 to save or  update object");
		int ch = sc.nextInt();
		switch (ch) {
			case 1:
				fetchAllEmployees(session, tx);
				break;
			case 2:
				fetchEmployeesOnBasisOfName(session, tx);
				break;
			case 3:
				fetchAllEmployeesOnBasisOfId(sc, session, tx);
				break;
			case 4:
				fetchEmployeeDetail(sc, session, tx);
				break;
		}
	}
}
