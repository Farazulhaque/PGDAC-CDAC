package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DbService {
	static Connection con = null;
	private static String user = "root";
	private static String password = "mysql";
	private static String dbName = "cdac";

	// Static block is automatically called
	static {
		try {
			String url = "jdbc:mysql://localhost:3306/" + dbName;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			if (con != null) {
				System.out.println("Connection Established");
			}
		} catch (ClassNotFoundException e) {
			System.err.println("Driver class not found" + e);
		} catch (SQLException e) {
			System.err.println("SQL Exception while connection");
		}

	}

	public static int insertData() throws SQLException {
		String query = "insert into student values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Student Id: ");
		int id = sc.nextInt();
		System.out.print("Enter Student Name: ");
		String name = sc.next();
		System.out.print("Enter Student Password: ");
		String pass = sc.next();
		System.out.print("Enter Student Department: ");
		String dept = sc.next();
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, pass);
		ps.setString(4, dept);
		int i = ps.executeUpdate();
		return i;
	}

	public static ResultSet fetchData() throws SQLException {
		String query = "select * from student";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		return rs;
	}
}
