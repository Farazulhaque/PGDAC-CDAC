package dao;

import java.sql.*;
import java.util.*;
import com.beans.StudentBean;

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

	public static int updateStatus(StudentBean s) throws SQLException {
		String query = "update student set status=1 where sid=? and sname=? and spass=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, s.getId());
		ps.setString(2, s.getName());
		ps.setString(3, s.getPassword());
		int i = ps.executeUpdate();
		return i;
	}

	public static ArrayList<StudentBean> studentNames() throws SQLException {
		ArrayList<StudentBean> al = new ArrayList<StudentBean>();
		String query = "select sname from student";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			StudentBean sb = new StudentBean();
			String name = rs.getString(1);
			sb.setName(name);
			al.add(sb);
		}
		return al;
	}

	public static void addData(int id, String dname) throws SQLException {
		CallableStatement cs = con.prepareCall("call addDeptData(?, ?)");
		cs.setInt(1, id);
		cs.setString(2, dname);
		cs.execute();

		con.close();
	}
}
