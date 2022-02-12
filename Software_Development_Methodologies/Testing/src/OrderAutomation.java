import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class OrderAutomation {

	public static void main(String[] args) {
		int i = new Random().nextInt(1000 - 1) + 1;
		System.setProperty("webdriver.edge.driver",
				"G:\\FARAZ\\Github\\PGDAC-CDAC\\Software_Development_Methodologies\\edgedriver_win64\\msedgedriver.exe");

		// WebDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		// pageload timeout
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // Implicit Wait for 20 seconds

		driver.navigate().to("http://commerce.vinayavish.com/");

		// Select degree college
		driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a")).click();
		// select Post graduation
		driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[2]/a")).click();
		// select M.Sc information Technology
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul/li[3]/a")).click();
		// select add to cart for artificial intelligence book
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/div[2]/button[1]")).click();

		// select checkout
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[5]/a")).click();

		// select continue button
		driver.findElement(By.id("button-account")).click();

		// first name
		driver.findElement(By.id("input-payment-firstname")).sendKeys("Faraz");

		// last name
		driver.findElement(By.id("input-payment-lastname")).sendKeys("Haque");

		// email
		driver.findElement(By.id("input-payment-email")).sendKeys("faraz" + i + "@gmail.com");

		// mobile number
		driver.findElement(By.id("input-payment-telephone")).sendKeys("7596885401");

		// address
		driver.findElement(By.id("input-payment-address-1")).sendKeys("Naaz Apartment, Rajabazar");

		// city
		driver.findElement(By.id("input-payment-city")).sendKeys("Patna");

		// password
		driver.findElement(By.id("input-payment-password")).sendKeys("Faraz1234");

		// confirm password
		driver.findElement(By.id("input-payment-confirm")).sendKeys("Faraz1234");

		// country
		Select country = new Select(driver.findElement(By.id("input-payment-country")));
		country.selectByVisibleText("India");

		// country
		Select zone = new Select(driver.findElement(By.id("input-payment-zone")));
		zone.selectByVisibleText("Bihar");

		// agree privacy policy
		driver.findElement(By.name("agree")).click();

		// continue
		driver.findElement(By.id("button-register")).click();

		// agree privacy policy
		driver.findElement(By.name("agree")).click();

		// shipping continue
		driver.findElement(By.id("button-shipping-method")).click();

		// agree privacy policy
		driver.findElement(By.name("agree")).click();

		// payment continue
		driver.findElement(By.id("button-payment-method")).click();

		// final ok
		driver.findElement(By.id("button-confirm")).click();

	}

}
