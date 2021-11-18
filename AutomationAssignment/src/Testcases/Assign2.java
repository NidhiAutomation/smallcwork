package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.Utilities;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Assign2 extends Baseclass{

	int incQty = 1;
	Utilities util = new Utilities();
	boolean contains = false;
	
	@Test(priority = 2)
	public void login()
	{		
		try {
					String toSearch = util.getPropertiesFile("searchitem");
			util.navigateURL(driver, util.getPropertiesFile("flipkarturl"));
			String amazonPrice = null;
			hp.clickCrossButton();
			hp.getsearchbox(toSearch);
			hp.clickSearchBtn();
			String productName = driver.findElement(By.xpath("//span[.='Sort By']/../../../../following-sibling::div[1]/div/div[1]//a[2]")).getText();
			String flipkartprice = driver.findElement(By.xpath("//span[.='Sort By']/../../../../following-sibling::div[1]/div/div[1]//a[3]/div/div")).getText();
			
			String[] split = productName.split(" ");
			String name = split[0]+" "+split[1]+ " "+ split[2];
			System.out.println("Product name is : "+name);
			System.out.println("Price of item " +flipkartprice);
			
			util.lowSleep();
			// Amazon
			util.navigateURL(driver, util.getPropertiesFile("amazonurl"));
			
			ahp.enterInSearchBox(toSearch);
			ahp.clickSearchBtn();
			
			List<WebElement> findElements = asp.getpagination();
			int init = Integer.parseInt(findElements.get(1).getText());
			String count = findElements.get(findElements.size()-2).getText();
			for(int i = init ; i <= Integer.parseInt(count) ; i++)
			{
	//			System.out.println("Page : "+i);
				driver.findElement(By.xpath("//ul[@class='a-pagination']/li/a[.='"+i+"']")).click();
				util.highSleep();
				String mainwindow = driver.getWindowHandle();
				List<WebElement> productlistinpage = asp.getproductList();
				for(WebElement wb : productlistinpage)
				{
	//				System.out.println(wb.getText());
					String productNameInAmazonPage = wb.getText().toLowerCase();
					String productNameInFlipkartPage = name.toLowerCase();
					contains = productNameInAmazonPage.contains(productNameInFlipkartPage);
					if(contains)
					{
						wb.click();
						Set<String> windowHandles = driver.getWindowHandles();
						
						Iterator<String> iterator = windowHandles.iterator();
						while(iterator.hasNext())
						{
							String otherwin = iterator.next();
							if(!otherwin.equals(mainwindow))
								util.switchWindow(driver, otherwin);			
						}
						amazonPrice = asp.getProductPriceText();
						break;
					}
				}
				if(contains)
					break;
			}
	//		System.out.println(contains);
			if(contains) {
				System.out.println("Product in flipkart is present in amazon");
				double amaz = Double.parseDouble(amazonPrice.substring(1, amazonPrice.length()).replace(",", ""));
				double flip = Double.parseDouble(flipkartprice.substring(1, flipkartprice.length()).replace(",", ""));
				if(amaz > flip)
					System.out.println("But Flipkart is cheaper");
				else if(amaz == flip)
					System.out.println("Price is same in Flipkart and Amazon.");				
				else
					System.out.println("But Amazon is cheaper");
			}
			else
				System.out.println("Product in flipkart is not present in amazon");
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
