package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utilities {

	public WebDriver driver;
    public WebDriverWait wait;
    
	public void lowSleep()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
	}
	
	public void highSleep()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
	}
	
	public void navigateURL(WebDriver driver, String url)
	{
		try {
            driver.navigate().to(url);
        } catch (Exception e) {
            System.out.println("URL did not load: " + url);
            Assert.fail("URL did not load: " + url);
        }
	}
	
	public void switchWindow(WebDriver driver, String window)
	{
		try {
			driver.switchTo().window(window);
		}catch (Exception e) {
			Assert.fail("Cannot switch to desired window");
		}
	}
	
	public List<WebElement> getList(WebDriver driver, String xpath)
	{
		try {
			return driver.findElements(By.xpath(xpath));
		}catch (Exception e) {
			Assert.fail("Couldnot get the list of elements");
			return null;
		}
	}
	
	public String getPropertiesFile(String objname)
	{
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/java/resource/TestData.properties");
			Properties pobj = new Properties();
			pobj.load(fis);
			return pobj.get(objname).toString();
		}catch (Exception e) {
			return "boat";
		}
	}
}
