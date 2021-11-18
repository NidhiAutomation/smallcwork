package Testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.Utilities;

public class Assign1 extends Baseclass{

	int incQty = 1;
	Utilities util = new Utilities();
	@Test(priority = 1)
	public void login()
	{
		try {
			util.navigateURL(driver, util.getPropertiesFile("flipkarturl"));
			hp.clickCrossButton();
			hp.getsearchbox("boat rockerz");
			String mainwindow = driver.getWindowHandle();
			hp.clickSearchBtn();
			String productName = driver.findElement(By.xpath("//span[.='Sort By']/../../../../following-sibling::div[1]/div/div[1]//a[2]")).getText();
			String price = driver.findElement(By.xpath("//span[.='Sort By']/../../../../following-sibling::div[1]/div/div[1]//a[3]/div/div")).getText();
			System.out.println("Product name is : "+productName);
			System.out.println("Price of item " +price);
			driver.findElement(By.xpath("//span[.='Sort By']/../../../../following-sibling::div[1]/div/div[1]")).click();
			
			Set<String> windowHandles = driver.getWindowHandles();
			
			Iterator<String> iterator = windowHandles.iterator();
			while(iterator.hasNext())
			{
				String otherwin = iterator.next();
				if(!otherwin.equals(mainwindow))
					util.switchWindow(driver, otherwin);			
			}
			cp.clickAddToCart();
			util.lowSleep();
			for(int i = 0 ; i < incQty ; i++)
				cp.clickIncQtyBtn();
			
			util.highSleep();
			String currentPrice = cp.getPrice();
			System.out.println("Price of 2 items : "+ currentPrice);
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
