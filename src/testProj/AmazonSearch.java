package testProj;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonSearch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		//System.setProperty("webdriver.gecko.driver", "geckodriver");
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		WebElement searchbox = driver.findElement(By.xpath("//input[@aria-label='Search']"));
		searchbox.sendKeys("iphone 12");
		
		WebElement submit = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		Thread.sleep(1000);
		submit.click();
		
		List<WebElement> productname = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> productprice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		System.out.println("List size : " +productname.size());

		for(int i=0;i<productname.size();i++) {
			System.out.println("Product Name: " +productname.get(i).getText());
			System.out.println("Product Price: " +productprice.get(i).getText());
		}
	}
}
