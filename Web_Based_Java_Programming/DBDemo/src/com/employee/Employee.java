package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Employee {
	private static Connection con = null;
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

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Employee Name: ");
		String name = sc.next();
		System.out.print("Enter Employee Password: ");
		String pwd = sc.next();
		String query = "select ename, status from employee_master where ename=? and epass=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, name);
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int status = rs.getInt(2);
			if (status == 1) {
				String ename = rs.getString(1);
				System.out.println("Welcome " + ename);
				int choice;
				do {
					System.out.println("\n1. Add new Lead");
					System.out.println("2. View All Lead");
					System.out.println("3. Pending leads");
					System.out.println("4. Follow Up");
					System.out.println("5. Exit");
					System.out.print("Enter your choice: ");
					choice = sc.nextInt();
					switch (choice) {
						case 1:
							addLead(sc);
							break;
						case 2:
							viewLead(sc);
							break;
						case 3:
							pendingLead(sc);
							break;
						case 4:
							followUp(sc);
							break;
						case 5:
							System.out.println("Exiting...");
							break;
						default:
							System.out.println("Invalid choice.");
					}
				} while (choice != 5);

			} else {
				System.out.println("Access Denied");
				System.out.println("Please ask admin to update status");
			}
		} else {
			System.out.println("Incorrect Username/Password");
		}
	}

	private static void followUp(Scanner sc) throws SQLException {
		System.out.println("Enter lead id: ");
		int id = sc.nextInt();
		System.out.println("Enter followup date: ");
		String date = sc.next();
		String query = "update lead_master set l_followed='yes',  l_followupdate=? where lid=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, date);
		ps.setInt(2, id);

		int result = ps.executeUpdate();
		if (result > 0) {
			System.out.println("Lead Data updated Successfully");
		} else {
			System.out.println("Error in updating Lead Data");
		}
		System.out.println("-------------------------------------------");
	}

	private static void pendingLead(Scanner sc) throws SQLException {
		String query = "select * from lead_master where l_followed='no'";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		System.out.println(
				"+------+----------------------+----------------------+----------------------+----------------------+"
						+ "----------------------+------------+----------------------+----------+----------------------+");
		System.out.printf("| %4s | %-20s | %-20s | %-20s | %-20s | %-20s | %-10s | %-20s | %-5s | %-20s |\n", "LID",
				"FNAME", "LNAME", "COURSE", "EMAIL", "COLLEGE", "SOURCE", "REFERENCE", "FOLLOWED", "FOLLOWUPDATE");
		System.out.println(
				"+------+----------------------+----------------------+----------------------+----------------------+"
						+ "----------------------+------------+----------------------+----------+----------------------+");
		while (rs.next()) {
			int lid = rs.getInt(1);
			String fname = rs.getString(2);
			String lname = rs.getString(3);
			String course = rs.getString(4);
			String email = rs.getString(5);
			String college = rs.getString(6);
			String source = rs.getString(7);
			String reference = rs.getString(8);
			String followed = rs.getString(9);
			String followupdate = rs.getString(10);
			System.out.printf("| %4s | %-20s | %-20s | %-20s | %-20s | %-20s | %-10s | %-20s | %-8s | %-20s |\n", lid,
					fname, lname, course, email, college, source, reference, followed, followupdate);
		}
		System.out.println(
				"+------+----------------------+----------------------+----------------------+----------------------+"
						+ "----------------------+------------+----------------------+----------+----------------------+");

	}

	private static void viewLead(Scanner sc) throws SQLException {
		String query = "select * from lead_master";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		System.out.println(
				"+------+----------------------+----------------------+----------------------+----------------------+"
						+ "----------------------+------------+----------------------+----------+----------------------+");
		System.out.printf("| %4s | %-20s | %-20s | %-20s | %-20s | %-20s | %-10s | %-20s | %-5s | %-20s |\n", "LID",
				"FNAME", "LNAME", "COURSE", "EMAIL", "COLLEGE", "SOURCE", "REFERENCE", "FOLLOWED", "FOLLOWUPDATE");
		System.out.println(
				"+------+----------------------+----------------------+----------------------+----------------------+"
						+ "----------------------+------------+----------------------+----------+----------------------+");
		while (rs.next()) {
			int lid = rs.getInt(1);
			String fname = rs.getString(2);
			String lname = rs.getString(3);
			String course = rs.getString(4);
			String email = rs.getString(5);
			String college = rs.getString(6);
			String source = rs.getString(7);
			String reference = rs.getString(8);
			String followed = rs.getString(9);
			String followupdate = rs.getString(10);
			System.out.printf("| %4s | %-20s | %-20s | %-20s | %-20s | %-20s | %-10s | %-20s | %-8s | %-20s |\n", lid,
					fname, lname, course, email, college, source, reference, followed, followupdate);
		}
		System.out.println(
				"+------+----------------------+----------------------+----------------------+----------------------+"
						+ "----------------------+------------+----------------------+----------+----------------------+");
	}

	private static void addLead(Scanner sc) throws SQLException {
		System.out.print("Enter First Name: ");
		String fname = sc.next();
		System.out.print("Enter Last Name: ");
		String lname = sc.next();
		System.out.print("Enter Course: ");
		String course = sc.next();
		System.out.print("Enter Email: ");
		String email = sc.next();
		System.out.print("Enter College: ");
		String college = sc.next();
		System.out.print("Enter Source: ");
		sc.nextLine();
		String source = sc.next();
		System.out.print("Enter Reference: ");
		String reference = sc.next();

		String query = "insert into lead_master(l_fname, l_lastname, l_course, l_email, l_college, l_source, l_reference ) values(?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);

		ps.setString(1, fname);
		ps.setString(2, lname);
		ps.setString(3, course);
		ps.setString(4, email);
		ps.setString(5, college);
		ps.setString(6, source);
		ps.setString(7, reference);

		int result = ps.executeUpdate();
		if (result > 0) {
			System.out.println("Lead Data Added Successfully");
		} else {
			System.out.println("Error in Adding Lead Data");
		}
		System.out.println("-------------------------------------------");
	}

}
