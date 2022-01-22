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
	static {
		try {
			String url = "jdbc:mysql://localhost:3306/" + dbName;
			// Step 1 load driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Step 2 establish connection
			con = DriverManager.getConnection(url, user, password);
			if (con != null) {
				System.out.println("Connection done successfully");
				// Step 3 create statement interface refrence
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("Driver class not found" + ex);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int insertData(int id, String name, String pass, String dept) {
		int i = 0;
		try {
			String query = "insert into student values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, pass);
			ps.setString(4, dept);
			ps.setInt(5, 0);
			i = ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Exception while adding new student" + e);
		}
		return i;

	}

	public static ResultSet fetchStudent() {
		ResultSet rs = null;
		try {
			String query = "select * from student";
			PreparedStatement ps = con.prepareStatement(query);
			rs = ps.executeQuery();

		} catch (SQLException ex) {
			System.err.println("Exception while fetching data" + ex);
		}
		return rs;

	}

	public static int deleteStudent(int rollno) {

		int i = 0;
		try {
			String query = "delete from student where sid=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, rollno);
			i = ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println("exception while removing student" + e);
		}
		return i;
	}

	public static ResultSet validate(String uname, String pass) {
		ResultSet rs = null;
		try {
			String query = "select * from student where sname=? and spass=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, pass);
			rs = ps.executeQuery();

		} catch (SQLException e) {
			System.err.println("exception while validation" + e);

		}
		return rs;

	}

	public static ResultSet fetchProfile(String uname, String pass) {
		ResultSet rs = null;
		try {
			String query = "select * from student where sname=? and spass=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, pass);
			rs = ps.executeQuery();

		} catch (SQLException e) {
			System.err.println("exception while validation" + e);

		}
		return rs;
	}

	public static int updateInfo(int roll, String n, String p) {
		int i = 0;
		try {
			String query = "update student set sname=?, spass=? where sid=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, n);
			ps.setString(2, p);
			ps.setInt(3, roll);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("exception while updating" + e);

		}

		return i;
	}

}
