package Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pom.AmazonHomePage;
import pom.AmazonProductPage;
import pom.FlipKartCartPage;
import pom.FlipKartHomePage;

public class Baseclass {
	
	public static WebDriver driver = null;
	public FlipKartHomePage hp = null;
	public FlipKartCartPage cp = null;
	public AmazonHomePage ahp = null;
	public AmazonProductPage asp = null;
	
	@BeforeMethod
	public void beforeclass()
	{
		System.getProperty("webdriver.chrome.exe",System.getProperty("user.dir")+"\"chromedriver.exe");
		driver = new ChromeDriver();
		initializeWebEle();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	public void initializeWebEle()
	{
		hp = PageFactory.initElements(driver, FlipKartHomePage.class);
		cp = PageFactory.initElements(driver, FlipKartCartPage.class);
		ahp = PageFactory.initElements(driver, AmazonHomePage.class);
		asp = PageFactory.initElements(driver, AmazonProductPage.class);
	}
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
}
