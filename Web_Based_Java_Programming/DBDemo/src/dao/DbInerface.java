package dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.beans.StudentBean;

interface DbInerface {
	// abstract ArrayList<StudentBean> studentNames();
	public abstract Connection getConnection();

	public abstract void insertData();
}
