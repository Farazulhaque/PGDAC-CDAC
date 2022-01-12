package jdbcwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FetchDataFromDatabase {
	private static String user = "root";
	private static String password = "mysql";
	private static String dbName = "cdac";

	private static void displayStudentData(Statement stmt) throws SQLException {
		String selQry = "select sid, sname, sdept from student";
		ResultSet rs = stmt.executeQuery(selQry); // Passing query for getting resultSet reference
		System.out.println("=========Student Details=========");
		System.out.println("+------+-----------+------------+");
		System.out.printf("| %-5s| %-10s| %-10s |", "ID", "Name", "Department");
		System.out.print("\n+------+-----------+------------+");
		while (rs.next()) {
			System.out.printf("\n| %-5s| %-10s| %-10s |", rs.getString(1), rs.getString(2), rs.getString(3));
		}
		System.out.println("\n+------+-----------+------------+");

	}

	public static boolean authStudent(Statement stmt, String sid, String pwd) throws SQLException {
		String authQry = "select sname from student where sid=" + sid + " and spass = '" + pwd + "'";
		ResultSet rs = stmt.executeQuery(authQry);
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
		try {
			String url = "jdbc:mysql://localhost:3306/" + dbName;
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, user, password);
			if (con != null) {
				Statement s = con.createStatement();
				displayStudentData(s);
				Scanner sc = new Scanner(System.in);
				System.out.println("Input your credentials to login:");
				System.out.print("Enter your Student ID: ");
				String id = sc.nextLine();
				System.out.print("Enter your Student Password: ");
				String pwd = sc.nextLine();
				if (authStudent(s, id, pwd)) {
					displayStudentData(s);
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
