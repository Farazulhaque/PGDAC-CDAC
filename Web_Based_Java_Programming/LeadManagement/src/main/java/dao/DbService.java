package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
				// System.out.println("Connection Established");
			}
		} catch (ClassNotFoundException e) {
			System.err.println("Driver class not found" + e);
		} catch (SQLException e) {
			System.err.println("SQL Exception while connection");
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
			System.err.println("Exception while adding new student");
		}
		return i;
	}

	public static ResultSet fetchData() throws SQLException {
		ResultSet rs = null;
		try {
			String query = "select * from student";
			PreparedStatement ps = con.prepareStatement(query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Exception while fetching data");
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
			System.err.println("Exception while deleting student data" + e);
		}

		return i;
	}

	public static boolean validateData(String name, String password) {
		ResultSet rs = null;
		try {
			String query = "select * from student where sname=? and spass=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.err.println("Exception while validating data");
		}

		return false;
	}

	public static ResultSet showData(String name, String password) {
		ResultSet rs = null;
		try {
			String query = "select * from student where sname=? and spass=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, password);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Exception while fetching data");
		}
		return rs;
	}

	public static ResultSet fetchProfile(String name, String password) {
		ResultSet rs = null;
		try {
			String query = "select * from student where sname=? and spass=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, password);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.err.println("Exception while fetching data");
		}
		return rs;
	}

	public static int updateData(int sid, String name, String password, String dept, int status) {
		int i = 0;
		try {

			String query = "update student set sname=?, spass=?, sdept=?, status=? where sid=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, dept);
			ps.setInt(4, status);
			ps.setInt(5, sid);

			i = ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Exception while updating student data" + e);
		}

		return i;
	}

}
