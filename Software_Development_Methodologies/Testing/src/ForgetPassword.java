import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ForgetPassword {

	public static void main(String[] args) throws InterruptedException {

		// System.setProperty("webdriver.chrome.driver",
		// "G:\FARAZ\Github\PGDAC-CDAC\Software_Development_Methodologies\chromedriver_win32\\chromedriver.exe");

		System.setProperty("webdriver.edge.driver",
				"G:\\FARAZ\\Github\\PGDAC-CDAC\\Software_Development_Methodologies\\edgedriver_win64\\msedgedriver.exe");

		// WebDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver();

		driver.navigate().to("http://vinayavish.com/user-account");

		// get path of lost password link
		driver.findElement(By
				.cssSelector("#stm-lms-login > div.stm_lms_login_wrapper > div.stm_lms_login_wrapper__actions > span"))
				.click();
		// Enter email id in input box after clicking on lost password
		driver.findElement(By.xpath("//*[@id=\"stm-lms-login\"]/div[2]/div[4]/div/input"))
				.sendKeys("farazattari786@gmail.com");

		driver.findElement(
				By.cssSelector("#stm-lms-login > div.stm_lms_login_wrapper > div.stm_lms_lost_password_form > a"))
				.click();
		driver.navigate().to("https://mail.google.com/");
		driver.findElement(By.cssSelector("#\\:2s")).click();
		// TimeUnit.MINUTES.sleep(1);
		// driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();

	}

}
