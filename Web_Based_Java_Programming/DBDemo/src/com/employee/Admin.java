package com.employee;

import java.sql.*;
import java.util.Scanner;

public class Admin {
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
		int choice;
		do {
			System.out.println("\nEnter 1 to add new Employee");
			System.out.println("Enter 2 to view all Employee");
			System.out.println("Enter 3 to authorize Employee");
			System.out.println("Enter 4 to Search Employee");
			System.out.println("Enter 5 to quit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("Enter Details Of An Employee");
				addEmployee(sc);
			} else if (choice == 2) {
				viewEmployee(sc);
			} else if (choice == 3) {
				authorizeEmployee(sc);
			} else if (choice == 4) {
				searchEmployee(sc);
			} else if (choice == 5) {
				System.out.println("Exiting...");
				break;
			} else {
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 5);
	}

	private static void searchEmployee(Scanner sc) throws SQLException {
		System.out.println("Enter 1 to Search Employee by ID");
		System.out.println("Enter 2 to Search Employee by department");
		System.out.print("Enter your choice: ");
		int choice = sc.nextInt();
		String query;
		PreparedStatement ps;
		ResultSet rs;
		switch (choice) {
			case 1:
				System.out.print("Enter Employee ID: ");
				int eid = sc.nextInt();
				query = "select * from employee_master where eid=?";
				ps = con.prepareStatement(query);
				ps.setInt(1, eid);
				rs = ps.executeQuery();

				if (rs.next() == false) {
					System.out.println("Employee details not available");
				}
				System.out.println(
						"+------+----------------------+-----------------+----------------------+-----------------+---------+");
				System.out.printf("| %4s | %-20s | %-15s | %-20s | %-15s | %7s |\n", "EID", "ENAME", "EPASS", "EMAIL",
						"EPROFILE", "STATUS");
				System.out.println(
						"+------+----------------------+-----------------+----------------------+-----------------+---------+");
				do {
					eid = rs.getInt(1);
					String ename = rs.getString(2);
					String epass = rs.getString(3);
					String email = rs.getString(4);
					String eprofile = rs.getString(5);
					String status = rs.getString(6);
					System.out.printf("| %4s | %-20s | %-15s | %-20s | %-15s | %7s |\n", eid, ename, epass, email,
							eprofile,
							status);
				} while (rs.next());
				System.out.println(
						"+------+----------------------+-----------------+----------------------+-----------------+---------+");

				break;
			case 2:
				System.out.print("Enter Employee Department: ");
				String eprofile = sc.next();
				query = "select * from employee_master where eprofile=?";
				ps = con.prepareStatement(query);
				ps.setString(1, eprofile);
				rs = ps.executeQuery();

				if (rs.next() == false) {
					System.out.println("Employee details not available");
				}
				System.out.println(
						"+------+----------------------+-----------------+----------------------+-----------------+---------+");
				System.out.printf("| %4s | %-20s | %-15s | %-20s | %-15s | %7s |\n", "EID", "ENAME", "EPASS", "EMAIL",
						"EPROFILE", "STATUS");
				System.out.println(
						"+------+----------------------+-----------------+----------------------+-----------------+---------+");
				do {
					eid = rs.getInt(1);
					String ename = rs.getString(2);
					String epass = rs.getString(3);
					String email = rs.getString(4);
					eprofile = rs.getString(5);
					String status = rs.getString(6);
					System.out.printf("| %4s | %-20s | %-15s | %-20s | %-15s | %7s |\n", eid, ename, epass, email,
							eprofile,
							status);
				} while (rs.next());
				System.out.println(
						"+------+----------------------+-----------------+----------------------+-----------------+---------+");

				break;

			default:
				System.out.println("Invalid choice.");
				break;
		}
	}

	private static void authorizeEmployee(Scanner sc) throws SQLException {
		System.out.print("Enter Employee ID to Authorize: ");
		int id = sc.nextInt();
		String query = "update employee_master set status=1 where eid=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		int result = ps.executeUpdate();
		if (result > 0) {
			System.out.println("Employee ID " + id + " is authorized successfully");
		} else {
			System.out.println("Error in updating status of Employee ID " + id);
		}
		System.out.println("-------------------------------------------");
	}

	private static void viewEmployee(Scanner sc) throws SQLException {
		String query = "select * from employee_master";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		System.out.println(
				"+------+----------------------+-----------------+----------------------+-----------------+---------+");
		System.out.printf("| %4s | %-20s | %-15s | %-20s | %-15s | %7s |\n", "EID", "ENAME", "EPASS", "EMAIL",
				"EPROFILE", "STATUS");
		System.out.println(
				"+------+----------------------+-----------------+----------------------+-----------------+---------+");
		while (rs.next()) {
			int eid = rs.getInt(1);
			String ename = rs.getString(2);
			String epass = rs.getString(3);
			String email = rs.getString(4);
			String eprofile = rs.getString(5);
			String status = rs.getString(6);
			System.out.printf("| %4s | %-20s | %-15s | %-20s | %-15s | %7s |\n", eid, ename, epass, email, eprofile,
					status);
		}
		System.out.println(
				"+------+----------------------+-----------------+----------------------+-----------------+---------+");
	}

	private static void addEmployee(Scanner sc) throws SQLException {
		System.out.print("Enter Employee Name: ");
		String name = sc.next();
		System.out.print("Enter Employee Password: ");
		String pwd = sc.next();
		System.out.print("Enter Employee Email: ");
		String email = sc.next();
		System.out.print("Enter Employee Profile\n(sales/management/trainer): ");
		String profile = sc.next();
		while (true) {
			if (profile.equalsIgnoreCase("sales")) {
				profile = "Sales";
				break;
			} else if (profile.equalsIgnoreCase("management")) {
				profile = "Management";
				break;
			} else if (profile.equalsIgnoreCase("trainer")) {
				profile = "Trainer";
				break;
			} else {
				System.out.println("Invalid profile. Please enter again.");
			}
		}

		String query = "insert into employee_master(ename, epass, email, eprofile) values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);

		ps.setString(1, name);
		ps.setString(2, pwd);
		ps.setString(3, email);
		ps.setString(4, profile);
		int result = ps.executeUpdate();
		if (result > 0) {
			System.out.println("Employee Data Added Successfully");
		} else {
			System.out.println("Error in Adding Employee Data");
		}
		System.out.println("-------------------------------------------");
	}

}
