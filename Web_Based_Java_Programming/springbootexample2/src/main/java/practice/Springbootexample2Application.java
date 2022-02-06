package practice;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Springbootexample2Application {

	public static void main(String[] args) {
		// SpringApplication.run(Springbootexample2Application.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

		// Sales s = new Sales();
		// Sales s = context.getBean(Sales.class);
		Sales s = (Sales) context.getBean("salebean");
		System.out.println(s.getSalesId());
		System.out.println(s.getSalesName());
		s.show();

		// Product p = (Product) context.getBean("myproduct");
		// System.out.println(p);
	}
}
