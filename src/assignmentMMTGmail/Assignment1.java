package assignmentMMTGmail;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment1 {
	static WebDriver driver ;

	public static void main(String[] args) throws InterruptedException {




		System.setProperty("webdriver.chrome.driver","F:\\naman QA\\Selenium\\chromedriver win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> LoginPopup = driver.findElements(By.xpath("//div[@class='autopop__wrap makeFlex column defaultCursor']"));




		if(LoginPopup.size()>0)
		{

			driver.findElement(By.xpath("//li[@data-cy='account']")).click();
			FromLocation();
			ToLocation();
			departureDate("'Mon Jun 28 2021')]");
			returnDate("'Wed Jun 30 2021')]");
			SearchClick();
			Flightsdata();
			selectflightdeparture();
			selectFlightReturn();
			BooknowContinue();
			ReviewBooking();
			closeBrowser();
		}
		else
		{
			System.out.println("in else ");
			FromLocation();
			ToLocation();
			departureDate("'Mon Jun 28 2021')]");
			returnDate("'Wed Jun 30 2021')]");
			SearchClick();
			Flightsdata();
			selectflightdeparture();
			selectFlightReturn();
			BooknowContinue();
			ReviewBooking();
			closeBrowser();
		}

	}
	// This function will help to locate & print the elements from city
	public static void FromLocation() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();

		//Get a List of all the 'From' Location
		List<WebElement> locations = driver.findElements(By.xpath("//div[@class='calc60']"));


		for(int i=0; i<locations.size();i++)

		{
			//System.out.println(locations.get(i).getText());
		}

		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("Goa");
		Thread.sleep(5000);

		List<WebElement>dynamicLocation =driver.findElements(By.xpath("//ul[@role='listbox']//li//div//div//p[1]"));

		for(WebElement element : dynamicLocation)
		{
			//System.out.println(element.getText());
			if(element.getText().equals("Goa, India"))
			{
				element.click();
				break;
			}
		}

	}


	// This function will help to locate  the elements to city
	public static void ToLocation() throws InterruptedException
	{
		try{
			driver.findElement(By.xpath("//input[@id='toCity']")).click();
			Thread.sleep(2000);
		}
		catch(Exception e)
		{

		}
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("bangalore");
		Thread.sleep(2000);


		List<WebElement>dynamicLocation =driver.findElements(By.xpath("//ul[@role='listbox']//li//div//div//p[1]"));

		for(WebElement element : dynamicLocation)
		{

			//System.out.println(element.getText());
			if(element.getText().equalsIgnoreCase("Bengaluru, India"))
			{
				element.click();
				break;
			}}

	}


	//This function will help to select the departure date
	public static void departureDate(String Date) throws InterruptedException
	{

		String beforexpath= "//div[contains(@aria-label,";
		//String Date = "'Mon Jun 28 2021')]";
		try{
			driver.findElement(By.xpath("//input[@id='departure']")).click();
		}

		catch(Exception e)
		{
		}
		driver.findElement(By.xpath(beforexpath+Date)).click();;
		Thread.sleep(2000);
	}


	//This function will help to select the departure date

	public static void returnDate(String Date) throws InterruptedException
	{

		driver.findElement(By.xpath("//span[contains(text(),'RETURN')]")).click();

		Thread.sleep(2000);
		String beforexpath= "//div[@class='DayPicker-Day'][contains(@aria-label,";
		driver.findElement(By.xpath(beforexpath+Date)).click();;
	}

	// This function will help to click on search button 
	public static void SearchClick()
	{
		driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();
	}


	// This function will help to get the data of flights for both return & departure
	public static void Flightsdata()
	{
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='listingCard']"));	
		for(WebElement element : elements)
			System.out.println(element.getText());

	}

	// This function will help to select the early departure flight 
	public static void selectflightdeparture()  
	{
		driver.findElement(By.xpath("//div[@id='listing-id']//div[1]//div[1]//div[1]//div[1]//div[3]//span//span[1]")).click();
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/label[1]/div[1]/div[2]/div[2]/span[1]")).click();
		//Thread.sleep(2000);

	}


	// This function will help to select the early return flight 
	public static void selectFlightReturn()
	{
		System.out.println("flight return");

		try{
			WebElement flightReturndata =driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/span[1]/span[1]"));
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(flightReturndata));
			flightReturndata.click();
		}
		catch(Exception e)
		{

		}
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/label[1]/div[1]/div[2]/div[2]/span[1]/span[1]")).click();



	}

	// With this function can click on Book now and continue button 
	public static void BooknowContinue() 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[contains(text(),'Book Now')]")));

		driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
	}

	//This function is used for to Print details of Base Fare,Fee & Surcharges, Other Services, Total Amount.
	public static void ReviewBooking()
	{
		String ParenetWindow = driver.getWindowHandle();
		Set<String> Allwindow =	driver.getWindowHandles();

		for(String AW : Allwindow)
			driver.switchTo().window(AW);

		WebElement FareSummary = driver.findElement(By.xpath("//div[@class='rvw-sctn append_bottom15 make_relative']"));

		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(FareSummary));
		System.out.println(FareSummary.getText());

		driver.switchTo().window(ParenetWindow);

	}

	public static void closeBrowser()
	{
		driver.quit();
	}
}




