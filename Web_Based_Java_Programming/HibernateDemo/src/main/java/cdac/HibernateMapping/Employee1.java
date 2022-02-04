package cdac.HibernateMapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "empDetails") // set name of table
public class Employee1 {
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	@PrimaryKeyJoinColumn // Specifies a primary key column that is used as a foreign key to join to
							// another table.
	private int eid;

	private String empName;
	private String empMail;

	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL) // targetEntity = location of target class,
	// cascading is a feature of hibernate which is used to manage the state of
	// mapped entity whenever the relationship owner us saved or modified mapped
	// entity associated with it also saver or modified automatically
	private Address address;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpMail() {
		return empMail;
	}

	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
