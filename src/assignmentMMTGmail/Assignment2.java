package assignmentMMTGmail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment2 {

	static WebDriver driver ;

	public static void main(String[] args) {

		
		System.setProperty("webdriver.gecko.driver","F:\\selenium\\geckodriver-v0.20.1-win64\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		login();

	}

	
	public static void login()
	{
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		
	}
}
