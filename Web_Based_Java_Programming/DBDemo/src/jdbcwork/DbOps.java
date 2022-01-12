import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DbOps {

	private static String user = "root";
	private static String password = "mysql";
	private static String dbName = "cdac";

	public static void insertData(Statement s) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Student Id: ");
		int id = sc.nextInt();
		System.out.print("Enter Student Name: ");
		String name = sc.next();
		System.out.print("Enter Student Password: ");
		String pass = sc.next();
		System.out.print("Enter Student Department: ");
		String dept = sc.next();

		String query = "insert into student values (" + id + ",'" + name + "','" + pass + "','" + dept + "')";
		int i = s.executeUpdate(query);
		if (i != 0) {
			System.out.println("Data is inserted");
		} else {
			System.err.println("Data insertion failed");
		}
		sc.close();
	}

	public static void deleteData(Statement s) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Student Id: ");
		int id = sc.nextInt();

		String query = "delete from student where sid=" + id;
		int i = s.executeUpdate(query);
		if (i != 0) {
			System.out.println("Data is deleted");
		} else {
			System.err.println("Data deletion failed");
		}
		sc.close();
	}

	public static void updateData(Statement s) throws SQLException {
		String query = "";
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Student Id: ");
		int id = sc.nextInt();
		System.out.println("What you want to update?");
		System.out.println("Enter 1 for name, 2 for password, 3 for department");
		int choice = sc.nextInt();
		do {
			if (choice == 1) {
				System.out.print("Enter Student Name: ");
				String name = sc.next();
				query = "update student set sname='" + name + "' where sid=" + id;
			} else if (choice == 2) {
				System.out.print("Enter Student Password: ");
				String pass = sc.next();
				query = "update student set spass='" + pass + "' where sid=" + id;
			} else if (choice == 3) {
				System.out.print("Enter Student Department: ");
				String dept = sc.next();
				query = "update student set sdept='" + dept + "' where sid=" + id;
			} else {
				System.out.println("Invalid input. Please try again");
				choice = sc.nextInt();
			}
		} while (choice > 3 || choice < 1);

		int i = s.executeUpdate(query);
		if (i != 0) {
			System.out.println("Data is Updated");
		} else {
			System.err.println("Data updation failed");
		}
		sc.close();
	}

	public static void main(String[] args) {
		// Step - 1: Load driver Class

		// It throws ClassNotFoundException
		try {
			String url = "jdbc:mysql://localhost:3306/" + dbName;
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Step - 2: Establish connection
			Connection con = DriverManager.getConnection(url, user, password);
			if (con != null) {
				System.out.println("Connection Established");
				// Step - 3: Create statement interface reference
				Statement s = con.createStatement();
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter 1 to insert data");
				System.out.println("Enter 2 to update data");
				System.out.println("Enter 3 to delete data");
				System.out.println("Enter 4 to Exit");
				System.out.println("Enter your choice");
				int choice = sc.nextInt();
				while (true) {
					if (choice == 1)
						insertData(s);

					else if (choice == 2)
						updateData(s);

					else if (choice == 3)
						deleteData(s);
					else if (choice == 4) {
						System.out.println("Exiting");
						break;
					}

					else
						System.out.println("Invalid choice");

					System.out.println("\nEnter 1 to insert data");
					System.out.println("Enter 2 to update data");
					System.out.println("Enter 3 to delete data");
					System.out.println("Enter 4 to Exit");
					System.out.println("Enter your choice");
					choice = sc.nextInt();
				}
				sc.close();
			}
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.err.println("Driver class not found" + e);
		} catch (SQLException e) {
			// e.printStackTrace();
			System.err.println("SQL Exception while connection");
		}
	}

}
