package cdac.HibernateDemo;

import java.util.ArrayList;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateAssignment {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			System.out.println("\nEnter 1 to add product details");
			System.out.println("Enter 2 to add company details");
			System.out.println("Enter 3 to delete product on basis of ID as persistent");
			System.out.println("Enter 4 to delete company on basis of ID as persistant");
			System.out.println("Enter 5 to create a list of product and add to table");
			System.out.println("Enter 6 to exit");
			System.out.print("Enter your choice: ");
			ch = sc.nextInt();
			switch (ch) {
				case 1:
					addProduct(sc, session, tx);
					break;
				case 2:
					addCompany(sc, session, tx);
					break;
				case 3:
					deleteProduct(sc, session, tx);
					break;
				case 4:
					deleteCompany(sc, session, tx);
					break;
				case 5:
					addListOfProduct(sc, session, tx);
					break;
				default:
					break;
			}

		} while (ch != 6);

	}

	private static void addProduct(Scanner sc, Session session, Transaction tx) {
		Product pr = new Product();
		System.out.print("Enter Product Name: ");
		String pname = sc.next();
		System.out.print("Enter Product Price: ");
		float price = sc.nextFloat();
		System.out.print("Enter Product Company: ");
		String pcompany = sc.next();

		pr.setProductName(pname);
		pr.setProductPrice(price);
		pr.setProductCompany(pcompany);
		session.save(pr);
		tx.commit();
	}

	private static void addCompany(Scanner sc, Session session, Transaction tx) {
		Company comp = new Company();
		System.out.print("Enter Company Name: ");
		String comp_name = sc.next();
		System.out.print("Enter Company Category: ");
		String comp_category = sc.next();

		comp.setCompName(comp_name);
		comp.setCompCategory(comp_category);
		session.save(comp);
		tx.commit();

	}

	private static void deleteProduct(Scanner sc, Session session, Transaction tx) {
		System.out.print("Enter Product Id: ");
		int pid = sc.nextInt();
		Product pr = session.get(Product.class, pid);
		if (pr != null) {
			session.remove(pr);
			System.out.println("Product is Removed");
		} else {
			System.out.println("Product Not Found");
		}
		tx.commit();

	}

	private static void deleteCompany(Scanner sc, Session session, Transaction tx) {
		System.out.print("Enter Company Id: ");
		int cid = sc.nextInt();
		Company com = session.get(Company.class, cid);
		if (com != null) {
			session.remove(com);
			System.out.println("Company is Removed");
		} else {
			System.out.println("Company Not Found");
		}
		tx.commit();

	}

	private static void addListOfProduct(Scanner sc, Session session, Transaction tx) {
		System.out.print("Enter Number Of Products To Add: ");
		int n = sc.nextInt();
		ArrayList<Product> prlist = new ArrayList<Product>();
		for (int i = 0; i < n; i++) {
			Product pr = new Product();
			System.out.print("\nEnter Product Name: ");
			String pname = sc.next();
			System.out.print("Enter Product Price: ");
			float price = sc.nextFloat();
			System.out.print("Enter Product Company: ");
			String pcompany = sc.next();

			pr.setProductName(pname);
			pr.setProductPrice(price);
			pr.setProductCompany(pcompany);

			prlist.add(pr);
		}
		for (Product pr : prlist) {
			session.save(pr);
		}
		tx.commit();

	}

}
