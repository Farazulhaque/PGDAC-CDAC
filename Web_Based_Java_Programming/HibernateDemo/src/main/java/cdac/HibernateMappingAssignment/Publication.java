package cdac.HibernateMappingAssignment;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assign_publication")
public class Publication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int publicationId;
	private String pubicationName;

	@OneToOne(targetEntity = Address1.class, cascade = CascadeType.ALL)
	private Address1 publicationAddress;

	public int getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(int publicationId) {
		this.publicationId = publicationId;
	}

	public String getPubicationName() {
		return pubicationName;
	}

	public void setPubicationName(String pubicationName) {
		this.pubicationName = pubicationName;
	}

	public Address1 getPublicationAddress() {
		return publicationAddress;
	}

	public void setPublicationAddress(Address1 publicationAddress) {
		this.publicationAddress = publicationAddress;
	}
}
