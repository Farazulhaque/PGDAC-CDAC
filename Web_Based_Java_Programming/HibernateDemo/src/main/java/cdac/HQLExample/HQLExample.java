package cdac.HQLExample;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cdac.HibernateOMMapping.*;

public class HQLExample {

	public static void fetchData(Session session, Transaction tx) {
		// here Books is class name of java POJO Class from which table is created
		// String hql = "FROM Books b where b.bookId=102";
		// String hql = "FROM Books b where b.bookName='Head First Java'";
		// String hql = "FROM Books b WHERE b.bookName=:param" ;

		String hql = "FROM Books b WHERE b.bookId>:param ORDER BY b.bookId desc";
		Query query = session.createQuery(hql);
		query.setParameter("param", 1);
		List<Books> list = query.list();
		for (Books b : list) {
			System.out.println(b.getBookId() + " : " + b.getBookName() + " : " + b.getBookPublisher());
		}

		String hql2 = "SELECT b.bookPublisher FROM Books b WHERE b.bookName='Head First Java'";
		Query query2 = session.createQuery(hql2);
		List list2 = query2.list();
		System.out.println(list2);
	}

	public static void fetchData2(Session session, Transaction tx) {
		// count(), sum(), min(), max(), avg()
		String hql2 = "select count(distinct b.bookId) from Books b";
		Query query2 = session.createQuery(hql2);
		List list2 = query2.list();
		System.out.println(list2);
	}

	public static void insertData(Session session, Transaction tx) {
		Books bk = new Books();
		bk.setBookId(102);
		bk.setBookName("Head First Java");
		bk.setBookPublisher("XYZ");

		session.save(bk);
		tx.commit();

	}

	public static void insertDataUsingHQL(Session session, Transaction tx) {
		// String hql = "insert into Books(bookId, bookName, bookPublisher) values";
		// we can not specify the values explicitly
		String hql = "insert into Books(bookId, bookName, bookPublisher) "
				+ "select b.bookId+1, b.bookName, b.bookPublisher from Books b where b.bookId=60";

		Query query = session.createQuery(hql);
		int r = query.executeUpdate();
		if (r > 0) {
			System.out.println("Data inserted");
		} else {
			System.out.println("Data insertion failed");
		}
	}

	public static void deleteDataUsingHQL(Session session, Transaction tx) {
		// we can not specify the values explicitly
		String hql = "delete Books b where b.bookId=:param";
		Query query = session.createQuery(hql);
		query.setParameter("param", 59);
		int r = query.executeUpdate();
		if (r > 0) {
			System.out.println("Data deleted");
		} else {
			System.out.println("Data deletion failed");
		}
		tx.commit();
	}

	public static void updateDataUsingHQL(Session session, Transaction tx) {
		// we can not specify the values explicitly
		String hql = "update Books b set b.bookPublisher=:param1 where b.bookId=:param2";
		Query query = session.createQuery(hql);
		query.setParameter("param1", "Silver");
		query.setParameter("param2", 60);
		int r = query.executeUpdate();
		if (r > 0) {
			System.out.println("Data updated");
		} else {
			System.out.println("Data updation failed");
		}
		tx.commit();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Configuration cfg = new Configuration().configure().addAnnotatedClass(cdac.HQLExample.Books.class);
		// cfg.configure();

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		// insertData(session, tx);
		// fetchData(session, tx);
		System.out.println("1 to fetch using hql");
		System.out.println("2 to insert without hql");
		System.out.println("3 to insert using hql");
		System.out.println("4 to delete using hql");
		System.out.println("5 to update using hql");
		System.out.println("6 to count distinct data using hql");
		System.out.print("Enter your choice: ");
		int ch = sc.nextInt();

		switch (ch) {
			case 1:
				fetchData(session, tx);
				break;
			case 2:
				insertData(session, tx);
				break;
			case 3:
				insertDataUsingHQL(session, tx);
				break;
			case 4:
				deleteDataUsingHQL(session, tx);
				break;
			case 5:
				updateDataUsingHQL(session, tx);
				break;
			case 6:
				fetchData2(session, tx);
				break;
			default:
				break;
		}
		session.close();
	}

}
