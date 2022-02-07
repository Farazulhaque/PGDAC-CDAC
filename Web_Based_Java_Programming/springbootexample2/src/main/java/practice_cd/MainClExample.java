package practice_cd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClExample {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Question question = (Question) context.getBean("mcq");
		question.show();

		Customer customer = (Customer) context.getBean("customer");
		customer.details();
	}
}
