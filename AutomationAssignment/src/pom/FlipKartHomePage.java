package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlipKartHomePage{

	WebDriver driver;
	public FlipKartHomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(xpath = "//button[.='✕']")
	private WebElement crossbutton;
	
	public WebElement getcrossbutton()
	{
		return searchbox;
	}
	
	public void clickCrossButton()
	{
		crossbutton.click();
	}
	
	@FindBy(xpath = "//input[@name='q']")
	private WebElement searchbox;
	
	public WebElement searchbox()
	{
		return searchbox;
	}
	
	public void getsearchbox(String chars)
	{
		searchbox.sendKeys(chars);
	}

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchBtn;
	
	public WebElement getSearchBtn()
	{
		return searchBtn;
	}
	
	public void clickSearchBtn()
	{
		searchBtn.click();
	}
}
