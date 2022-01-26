package mybeans;

import java.io.Serializable;

public class Student implements Serializable {
	private int id;
	private String name;
	private String password;
	private String dept;

	public Student() {

	}

	public String Studentdetail(int id, String name, String password, String dept) {
		return "Welcome to Student bean class " + name + "\t" + password + "\t" + dept;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

}
