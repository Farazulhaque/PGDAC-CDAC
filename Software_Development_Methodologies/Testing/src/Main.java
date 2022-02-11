import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Main {

	public static void main(String[] args) {
		// Declare and initialize object
		// System.setProperty("webdriver.chrome.driver",
		// "G:\FARAZ\Github\PGDAC-CDAC\Software_Development_Methodologies\chromedriver_win32\\chromedriver.exe");

		System.setProperty("webdriver.edge.driver",
				"G:\\FARAZ\\Github\\PGDAC-CDAC\\Software_Development_Methodologies\\edgedriver_win64\\msedgedriver.exe");

		// WebDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver();

		driver.navigate().to("http://www.google.co.in");

		driver.findElement(By.name("q")).sendKeys("Virat Kohli");

		driver.findElement(By.name("btnK")).submit();

		driver.getTitle();

		// WebElement searchBox = driver.findElement(By.name("q"));
		//
		// searchBox.sendKeys("Prof. Ajit Vishwakarma");

	}

}
