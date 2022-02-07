package practice_cd;

import java.util.List;

public class Question {
	private int qid;
	private String questionName;
	private List<String> answers;

	public Question() {

	}

	public Question(int qid, String questionName, List<String> answers) {
		super();
		this.qid = qid;
		this.questionName = questionName;
		this.answers = answers;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

	public void show() {
		System.out.println("Question is " + questionName);
		System.out.println("Choose ans");
		for (String ans : answers) {
			System.out.println(ans);
		}
	}
}
