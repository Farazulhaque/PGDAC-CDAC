package cdac.HibernateMMMapping;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyExample {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		cfg.addAnnotatedClass(cdac.HibernateMMMapping.ManyToManyExample.class);
		cfg.configure();

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		MultiQuestion q1 = new MultiQuestion();
		q1.setQuestionname("What is ORM?");

		MultiQuestion q2 = new MultiQuestion();
		q2.setQuestionname("What is JDBC?");

		MultiAnswers ans1 = new MultiAnswers();
		ans1.setAnsName("ORM is Object Relation Mapping");

		MultiAnswers ans2 = new MultiAnswers();
		ans2.setAnsName("ORM help in conversion of object into entity");

		MultiAnswers ans3 = new MultiAnswers();
		ans3.setAnsName("JDBC is Java Data Base Connectivity");

		MultiAnswers ans4 = new MultiAnswers();
		ans4.setAnsName("JDBC is an API for Database connectivity");

		ArrayList<MultiAnswers> ansList1 = new ArrayList<MultiAnswers>();
		ansList1.add(ans1);
		ansList1.add(ans2);

		ArrayList<MultiAnswers> ansList2 = new ArrayList<MultiAnswers>();
		ansList2.add(ans3);
		ansList2.add(ans4);
		
		q1.setAnswer(ansList1);
		q2.setAnswer(ansList2);
		
		session.save(q1);
		session.save(q2);
		tx.commit();
		session.close();
		
		System.out.println("Done...");
	}

}
