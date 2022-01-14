package jdbcwork.student;

import com.dao.IDbService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.dao.DbFactory;

public class StudentManager {

	public static void main(String[] args) {

		IDbService service = DbFactory.getDbService();
		Scanner sc = new Scanner(System.in);

		int choice;
		do {
			System.out.println("\n****Student Manager****");
			System.out.println("1. Add new student");
			System.out.println("2. View all student");
			System.out.println("3. Exit");
			System.out.print("Enter your choice[1-3]: ");
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					addNewStudent(service);
					break;
				case 2:
					displaystudent(service);
					break;
				case 3:
					break;

				default:
					System.out.println("Invalid Choice");
			}
		} while (choice != 3);
	}

	private static void addNewStudent(IDbService service) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID: ");
		String id = sc.next();
		System.out.println("Enter Name: ");
		String name = sc.next();
		System.out.println("Enter password: ");
		String password = sc.next();
		System.out.println("Enter department: ");
		String dept = sc.next();
		System.out.println("Enter status: ");
		String status = sc.next();
		String query = "insert into student values (" + id + ", '" + name + "', '" + password + "', '" + dept + "', "
				+ status + ")";
		try {
			if (service.executeNonQuery(query) > 0) {
				System.out.println("Student details saved");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void displaystudent(IDbService service) {
		try {
			ResultSet rs = service.fetchData("select * from student");
			System.out.println("====================Student Details=====================");
			System.out.println("+------+-----------+------------+------------+---------+");
			System.out.printf("| %-5s| %-10s| %-10s | %-10s | %7s |", "ID", "Name", "Password", "Department", "Status");
			System.out.print("\n+------+-----------+------------+------------+---------+");
			while (rs.next()) {
				System.out.printf("\n| %-5s| %-10s| %-10s | %-10s | %7s |", rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5));
			}
			System.out.println("\n+------+-----------+------------+------------+---------+");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
