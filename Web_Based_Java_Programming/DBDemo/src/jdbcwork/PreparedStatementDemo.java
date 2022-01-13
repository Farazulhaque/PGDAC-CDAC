package jdbcwork;

import java.sql.*;
import java.util.Scanner;

public class PreparedStatementDemo {

	static Connection con = null;

	public static void insertData(PreparedStatement pstmt) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Student Id: ");
		int id = sc.nextInt();
		System.out.print("Enter Student Name: ");
		String name = sc.next();
		System.out.print("Enter Student Password: ");
		String pass = sc.next();
		System.out.print("Enter Student Department: ");
		String dept = sc.next();

		pstmt = con.prepareStatement("insert into student values (?,?,?,?)");
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, pass);
		pstmt.setString(4, dept);
		int result = pstmt.executeUpdate();
		if (result > 0) {
			System.out.println("Data inserted");
		} else {
			System.out.println("Data not inserted");
		}
		// sc.close();
	}

	public static void deleteData(PreparedStatement pstmt) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Student Id: ");
		int id = sc.nextInt();

		String query = "delete from student where sid=?";
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, id);
		int result = pstmt.executeUpdate();
		if (result > 0) {
			System.out.println("Data is deleted");
		} else {
			System.err.println("Data deletion failed");
		}
		// sc.close();
	}

	public static void updateData(PreparedStatement pstmt) throws SQLException {
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
				query = "update student set sname=? where sid=?";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, name);

			} else if (choice == 2) {
				System.out.print("Enter Student Password: ");
				String pass = sc.next();
				query = "update student set spass=? where sid=?";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, pass);
			} else if (choice == 3) {
				System.out.print("Enter Student Department: ");
				String dept = sc.next();
				query = "update student set sdept=? where sid=?";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, dept);
			} else {
				System.out.println("Invalid input. Please try again");
				choice = sc.nextInt();
			}
		} while (choice > 3 || choice < 1);

		pstmt.setInt(2, id);
		int result = pstmt.executeUpdate();
		if (result > 0) {
			System.out.println("Data is Updated");
		} else {
			System.err.println("Data updation failed");
		}
		// sc.close();
	}

	public static boolean authStudentPrepared(PreparedStatement pstmt) throws SQLException {
		ResultSet rs = pstmt.executeQuery();
		Boolean found = false;
		if (rs.next()) {
			System.out.println("Login Successfull!!");
			System.out.println("Welcome: " + rs.getString(1));
			found = true;
		} else {
			System.out.println("Invalid ID/Password");
		}
		return found;
	}

	public static void main(String[] args) {
		String user = "root";
		String password = "mysql";
		String dbName = "cdac";

		try {
			String url = "jdbc:mysql://localhost:3306/" + dbName;
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, user, password);
			if (con != null) {
				PreparedStatement stmt = con.prepareStatement("select sname from student where sid=? and spass=?");
				Scanner sc = new Scanner(System.in);
				System.out.println("Input your credentals to login:");
				System.out.print("Enter your Student ID: ");
				int id = sc.nextInt();
				System.out.print("Enter your Student Password: ");
				String pwd = sc.next();

				stmt.setInt(1, id);
				stmt.setString(2, pwd);
				// authStudentPrepared(stmt);
				if (authStudentPrepared(stmt)) {
					System.out.println("Enter 1 to insert data");
					System.out.println("Enter 2 to update data");
					System.out.println("Enter 3 to delete data");
					System.out.println("Enter 4 to Exit");
					System.out.println("Enter your choice");
					int choice = sc.nextInt();
					while (true) {
						if (choice == 1)
							insertData(stmt);

						else if (choice == 2)
							updateData(stmt);

						else if (choice == 3)
							deleteData(stmt);
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
