package com.cdac;

import java.sql.*;
import java.util.*;
import dao.DbService;
import com.beans.StudentBean;

public class Student {
	public static void main(String[] args) {
		System.out.println("Enter 1 to insert data");
		System.out.println("Enter 2 to fetch data");
		System.out.println("Enter 3 to authorize data");
		System.out.println("Enter 4 to fetch student");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your choice: ");
		int ch = sc.nextInt();
		switch (ch) {
			case 1:
				try {
					int i = DbService.insertData();
					if (i > 0) {
						System.out.println("Data inserted");
					} else {
						System.out.println("Data insertion failed");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;

			case 2:
				try {
					ResultSet rs = DbService.fetchData();
					String data = "";
					while (rs.next()) {
						int id = rs.getInt(1);
						String n = rs.getString(2);
						String p = rs.getString(3);
						String d = rs.getString(4);
						data += id + "\t" + n + "\t" + p + "\t" + d + "\n";
					}
					System.out.println(data);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;

			case 3:
				try {
					System.out.println("Enter Employee ID: ");
					int eid = sc.nextInt();
					System.out.println("Enter Employee Name: ");
					String n = sc.next();
					System.out.println("Enter Employee Password: ");
					String p = sc.next();
					StudentBean sb = new StudentBean(eid, n, p);
					int i = DbService.updateStatus(sb);
					if (i > 0) {
						System.out.println("Data is updated");
					} else {
						System.out.println("Data Updation Failed");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					ArrayList<StudentBean> slist = DbService.studentNames();
					for (StudentBean sb : slist) {
						System.out.println(sb.getName());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				break;
		}
	}

}
