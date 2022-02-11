import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver",
		// "G:\FARAZ\Github\PGDAC-CDAC\Software_Development_Methodologies\chromedriver_win32\\chromedriver.exe");

		System.setProperty("webdriver.edge.driver",
				"G:\\FARAZ\\Github\\PGDAC-CDAC\\Software_Development_Methodologies\\edgedriver_win64\\msedgedriver.exe");

		// WebDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver();

		driver.navigate().to("http://vinayavish.com/user-account");

		driver.findElement(By.name("login")).sendKeys("farazattari786@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Faraz");
		driver.findElement(By.xpath("//*[@id=\"stm-lms-login\"]/div[2]/div[3]/a")).click();

		TimeUnit.MINUTES.sleep(1);
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
	}

}
