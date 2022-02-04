package cdac.HibernateOMMapping;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyExample {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Answers ans1 = new Answers();
		ans1.setStatus(true);
		ans1.setAns("hibernate is framework");

		Answers ans2 = new Answers();
		ans2.setStatus(true);
		ans2.setAns("hibernate is used for database connectivity");

		Answers ans3 = new Answers();
		ans3.setStatus(true);
		ans3.setAns("hibernate is orm based");
		ArrayList<Answers> ansList = new ArrayList<Answers>();
		ansList.add(ans1);
		ansList.add(ans2);
		ansList.add(ans3);

		Question ques = new Question();
		ques.setQuestion("What is hibernate?");
		ques.setAnswers(ansList);

		session.save(ques);
		tx.commit();
		session.close();
		System.out.println("Question and answer...");
	}

}
