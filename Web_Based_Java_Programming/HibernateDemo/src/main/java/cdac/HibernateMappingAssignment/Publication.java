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
	private String publicationAddress;

	@OneToOne(targetEntity = Book.class, cascade = CascadeType.ALL)
	private Book book;

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

	public String getPublicationAddress() {
		return publicationAddress;
	}

	public void setPublicationAddress(String publicationAddress) {
		this.publicationAddress = publicationAddress;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
