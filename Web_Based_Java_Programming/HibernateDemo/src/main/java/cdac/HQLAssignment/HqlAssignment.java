package cdac.HQLAssignment;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HqlAssignment {

	public static void insertData(Session session, Transaction tx) {
		Scanner sc = new Scanner(System.in);
		User u = new User();
		System.out.println("Enter User Name: ");
		String name = sc.next();
		System.out.println("Enter Movie Id: ");
		int movieid = sc.nextInt();
		System.out.println("Enter rating(0-5): ");
		float rating = sc.nextFloat();
		LocalDate date = LocalDate.now();
		System.out.println("Enter Time in Hours: ");
		int hr = sc.nextInt();
		System.out.println("Enter Time in Minutes: ");
		int min = sc.nextInt();
		System.out.println("Enter time in Seconds: ");
		int sec = sc.nextInt();

		int time_in_sec = hr * 3600 + min * 60 + sec;
		u.setUsername(name);
		u.setMovieId(movieid);
		u.setRating(rating);
		u.setDate(date);
		u.setTime(time_in_sec);
		session.save(u);
		tx.commit();
		System.out.println("Data inserted Successfully");
	}

	public static void showNoOfUser(Session session) {
		String hql = "select count(u.userId) from User u";
		Query query = session.createQuery(hql);
		List list = query.list();
		System.out.print("Total number of users are: ");
		System.out.println(list);
	}

	public static void showUserName(Session session) {
		String hql = "select u.username from User u where u.rating>3.5";
		Query query = session.createQuery(hql);
		List list = query.list();
		System.out.print("Total number of users having rating greater than 3.5 are: ");
		System.out.println(list);
	}

	public static void showTotalTime(Session session) {
		String hql = "select sec_to_time(sum(u.time)) from User u";
		Query query = session.createQuery(hql);
		List list = query.list();
		System.out.print("Total time spend by users are: ");
		System.out.println(list);
	}

	public static void updateMovieRatingUsingHQL(Session session, Transaction tx) {
		String hql = "update User u set u.rating=:rating where u.userId=:userid";
		Query query = session.createQuery(hql);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User id: ");
		int userid = sc.nextInt();
		System.out.println("Enter rating: ");
		float rating = sc.nextFloat();
		query.setParameter("rating", rating);
		query.setParameter("userid", userid);
		int r = query.executeUpdate();
		if (r > 0) {
			System.out.println("Data updated successfully");
		} else {
			System.out.println("Data updation failed");
		}
		tx.commit();

	}

	public static void deleteUserOnBasisOfMovieIdUsingHQL(Session session, Transaction tx) {
		String hql = "delete User u where u.movieId=:movieid";
		Query query = session.createQuery(hql);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter movie id: ");
		int movieid = sc.nextInt();
		query.setParameter("movieid", movieid);
		int r = query.executeUpdate();
		if (r > 0) {
			System.out.println("Data deleted successfully");
		} else {
			System.out.println("Data deletion failed");
		}
		tx.commit();
	}

	public static void showAllUsersFromYesterday(Session session) {
		String hql = "from User u where u.date<=subdate(curdate(),1)";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		System.out.println("Users from yesterday are: ");
		for (User u : list) {
			System.out.println(u.getUserId() + " : " + u.getUsername() + " : " + u.getMovieId() + " : " + u.getRating()
					+ " : " + u.getDate() + " : " + u.getTime());
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Configuration cfg = new Configuration().configure().addAnnotatedClass(cdac.HQLExample.Books.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		int ch;
		do {
			System.out.println("1 to insert data");
			System.out.println("2 to show number of user in user table using hql");
			System.out.println("3 to show user name watching movie having rating higher than 3.5. using hql");
			System.out.println("4 to show total time spent by all user in hr and min and sec using hql");
			System.out.println("5 to update movie rating by user using hql");
			System.out.println("6 to delete all the user on basis of movieid  using hql");
			System.out.println("7 to show all the users from yesterday");
			System.out.println("8 to exit");
			System.out.print("Enter your choice: ");
			ch = sc.nextInt();

			switch (ch) {
				case 1:
					insertData(session, tx);
					break;
				case 2:
					showNoOfUser(session);
					break;
				case 3:
					showUserName(session);
					break;
				case 4:
					showTotalTime(session);
					break;
				case 5:
					updateMovieRatingUsingHQL(session, tx);
					break;
				case 6:
					deleteUserOnBasisOfMovieIdUsingHQL(session, tx);
					break;
				case 7:
					showAllUsersFromYesterday(session);
					break;
				default:
					break;
			}

		} while (ch != 8);

		session.close();
	}

}
