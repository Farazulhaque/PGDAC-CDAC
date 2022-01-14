package com.dao;
// dao-data access object

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDbService {

	Connection getDbConnection(); // To get Connection object

	ResultSet fetchData(String qry) throws SQLException; // To get ResultSet

	int executeNonQuery(String query) throws SQLException; // To insert/update/delete

	// Non query-DML,DDL-INSERT, UPDATE, DELETE
	// query-SELECT
}
