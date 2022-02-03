package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbService implements IDbService {
	 private static Connection con;
		@Override
		public Connection getDbConnection() {		
			String user="root";
			String password="mysql";
			String dbName="cdac";
			String url="jdbc:mysql://127.0.0.1/"+dbName;		
	       try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//if(con==null)
		        con=DriverManager.getConnection(url, user, password);		
		    }
	       catch (ClassNotFoundException | SQLException e) {		
			e.printStackTrace();
		   }       
	       return con;
		}
	    //Method for resultSet
		@Override
		public ResultSet fetchData(String qry) throws SQLException {		
			//Connection con=getDbConnection();		
			//Statement stmt=con.createStatement();
			Statement stmt=getDbConnection().createStatement();		
			ResultSet rs=stmt.executeQuery(qry);		
			return rs;
		}
	    //Method for DML operations
		@Override
		public int excecuteNonQuery(String qry) throws SQLException {
			Connection con=getDbConnection();
			if(con!=null) {
				    Statement stmt=con.createStatement();
				    return stmt.executeUpdate(qry);
		    }
			return 0;
		}
}
