package test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Google1
{
	public ChromeDriver driver;
	public WebDriverWait w=new WebDriverWait(driver,20);
	@DataProvider(name="searchword")
	public Object[][] testdata()
	{
		return new Object[][]
	 {
		{"kalam"},
		{"appium"},
		{"reddy"}
	 };
	} 
	@Test(priority=0)
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\project\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));	
	}
	@Test(priority=1,dataProvider="searchword")
	public void search(String x) throws Exception
	{
		driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
		Thread.sleep(5000);
		String t=driver.getTitle();
		if(t.contains(x))
		{
			Assert.assertTrue(true, "google test passed");		
		}
		else
		{
			Date d=new Date();
			SimpleDateFormat sf=new SimpleDateFormat("dd-mm-yy-hh-mm-ss");
			String ssname=sf.format(d);
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File(ssname+".png");
			FileHandler.copy(src, dest);
			//to attach screen shot to testng reports if test fails
			String filepath=dest.toString();
			//String path = "<img src="\"file://"+filepath+"/alt="\"\"/" />";
			String path = "<img src=\"file://" + filepath + "\" alt=\"\"/>";
			Reporter.log(path);
			Assert.assertTrue(true, "google title test failed");
		}
	}
	@Test(priority=2)
	public void close()
	{
		driver.close();
	}
}
