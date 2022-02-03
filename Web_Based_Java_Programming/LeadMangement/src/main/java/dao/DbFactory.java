package dao;

public class DbFactory {
	static public IDbService	getDbService() {	
		return new DbService(); 	
	}
}
