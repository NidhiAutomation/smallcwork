package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage {

	WebDriver driver;
	public AmazonHomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchBox;
	
	public WebElement getSearchBox()
	{
		return searchBox;
	}
	
	public void enterInSearchBox(String input)
	{
		searchBox.sendKeys(input);
	}
	
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
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
