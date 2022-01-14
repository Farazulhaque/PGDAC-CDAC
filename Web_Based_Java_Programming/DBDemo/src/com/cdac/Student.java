package com.cdac;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import dao.DbService;

public class Student {
	public static void main(String[] args) {
		System.out.println("Enter 1 to insert data");
		System.out.println("Enter 2 to fetch data");
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
			default:
				break;
		}
	}

}
