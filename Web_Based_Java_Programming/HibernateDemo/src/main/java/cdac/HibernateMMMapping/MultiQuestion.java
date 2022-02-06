package cdac.HibernateMMMapping;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "test_ques")
public class MultiQuestion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int questionId;
	private String questionname;
	@ManyToMany(targetEntity = MultiAnswers.class, cascade = CascadeType.ALL)
	// A join table is typically used in the mapping of many-to-many and
	// unidirectional one-to-many associations. It may also be used to map
	// bidirectional many-to-one/one-to-many associations,unidirectional many-to-one
	// relationships, and one-to-one associations (both bidirectional and
	// unidirectional).
	@JoinTable(name = "testmcq_join",
			// The foreign key columns of the join table which reference the primary table
			// of the entity owning the association.
			// (I.e. the owning side of the association).
			joinColumns = { @JoinColumn(name = "mcqqid") },
			// The foreign key columns of the join table which reference the primary table
			// of the entity that does not own the association.
			// (I.e. the inverse side of the association).
			inverseJoinColumns = { @JoinColumn(name = "mcqansid") })
	private List<MultiAnswers> answer;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionname() {
		return questionname;
	}

	public void setQuestionname(String questionname) {
		this.questionname = questionname;
	}

	public List<MultiAnswers> getAnswer() {
		return answer;
	}

	public void setAnswer(List<MultiAnswers> answer) {
		this.answer = answer;
	}
}
