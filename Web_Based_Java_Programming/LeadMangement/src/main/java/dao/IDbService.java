package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDbService {
	
	Connection getDbConnection();//to get Connection Object
	
	ResultSet fetchData(String qry) throws SQLException;//to get ResultSet
	
	int       excecuteNonQuery(String qry) throws SQLException;//for insert/update/delete

}
