package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DbService2 implements DbInerface {

	static Connection con = null;
	private static String user = "root";
	private static String password = "mysql";
	private static String dbName = "cdac";

	@Override
	public Connection getConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/" + dbName;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (con != null) {
			return con;
		}
		return con;
	}

	@Override
	public void insertData() {
		int i = 0;
		String query = "insert into student values(?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
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
			i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Data is inserted");
			} else {
				System.out.println("Data insertion failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
