package com.cdac;

import java.sql.*;

import dao.DbService2;

public class Employee {

	public static void main(String[] args) {
		DbService2 db = new DbService2();
		Connection con = db.getConnection();

	}

}
