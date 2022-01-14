package com.dao;

public class DbFactory {

	public static IDbService getDbService() {
		return new DbService();
	}
}
