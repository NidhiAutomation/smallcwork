package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlipKartCartPage {

	WebDriver driver;
	public FlipKartCartPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(xpath = "//button[text()='ADD TO CART']")
	private WebElement addToCart;
	
	public WebElement getAddToCart()
	{
		return addToCart;
	}
	
	public void clickAddToCart()
	{
		addToCart.click();
	}
	
	@FindBy(xpath = "//button[text()='+']")
	private WebElement incQtyBtn;
	
	public WebElement getIncQtyBtn()
	{
		return incQtyBtn;
	}
	
	public void clickIncQtyBtn()
	{
		incQtyBtn.click();
	}
	
	@FindBy(xpath = "//div[.='Total Amount']/..//span//span")
	private WebElement totalprice;
	
	public WebElement getTotalprice()
	{
		return totalprice;
	}
	
	public String getPrice()
	{
		return totalprice.getText();
	}
}
