package cdac.HibernateDemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "empTable1")
// use Entity to create table 
// To set the name of the table use Table entity
// by default table name is Java class name 
public class Employee {
	@Id
//	Id is primary key
	@Column(name = "t_eid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	// IDENTITY is used for auto increment primary key
	// length property is used to set length of the column
	// name property is used for column name, by default column name is variable
	// name
	// nullable is not null
	// insertable to insert data

	@Column(name = "t_empname", length = 120)
	private String ename;
	@ColumnDefault("1234")
//	To set default value of a column epassword
//	another method is @Column(columnDefinition="int default 100")
//	do while creating schema
	private String epassword;

	public Employee() {

	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEpassword() {
		return epassword;
	}

	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}

}
