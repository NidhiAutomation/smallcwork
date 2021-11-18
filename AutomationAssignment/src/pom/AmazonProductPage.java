package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonProductPage {

	WebDriver driver;
	public AmazonProductPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(xpath = "//ul[@class='a-pagination']/li")
	private List<WebElement> pagination;
	
	public List<WebElement> getpagination()
	{
		return pagination;
	}
	
	@FindBy(xpath = "//span[@id='priceblock_ourprice']")
	private WebElement productPrice;
	
	public WebElement getProductPrice()
	{
		return productPrice;
	}
	
	public String getProductPriceText()
	{
		return productPrice.getText();
	}

	@FindBy(xpath = "//div[contains(@data-component-type,'s-search-result')]//h2//span")
	private List<WebElement> productList;
	
	public List<WebElement> getproductList()
	{
		return productList;
	}
}
