package com.dao;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;

import java.sql.*;

public class DbService implements IDbService {

	private static Connection con;

	@Override
	public Connection getDbConnection() {
		String user = "root";
		String password = "mysql";
		String dbName = "cdac";
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			if (con == null) // To create connection only first time
				con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

	// Method for ResultSet
	@Override
	public ResultSet fetchData(String qry) throws SQLException {
		// Connection con = getDbConnection();
		// Statement stmt = con.createStatement();
		Statement stmt = getDbConnection().createStatement();

		ResultSet rs = stmt.executeQuery(qry);
		return rs;
	}

	// Method for DML operations
	@Override
	public int executeNonQuery(String query) throws SQLException {
		Connection con = getDbConnection();
		if (con != null) {
			Statement stmt = con.createStatement();
			return stmt.executeUpdate(query);
		}
		return 0;
	}

}
