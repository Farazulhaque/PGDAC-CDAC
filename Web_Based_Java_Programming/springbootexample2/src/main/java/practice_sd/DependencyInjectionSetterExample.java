package practice_sd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyInjectionSetterExample {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Lead lead = (Lead) context.getBean("leadbean");
		System.out.println("Lead is " + lead.getLeadid());
		System.out.println("Lead Name is " + lead.getLeadName());
		System.out.println("Lead Course is " + lead.getLeadCourse());

		MyProduct product = (MyProduct) context.getBean("myproduct1");
		System.out.println("Product name is " + product.getMproductName());
		product.productInfo();
	}

}
