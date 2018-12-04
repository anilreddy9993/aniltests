package test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gmailsentmethods
{
	public WebDriver driver;
	public WebDriverWait wait;
	public String launch(String e,String d,String c)
	{
		if(e.contentEquals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\project\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(e.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "E:\\project\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
		{
			return("unknown browser");
		}
		driver.get(d);
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='identifier']")));
		driver.manage().window().maximize();
		return("done");
	}
	public String fill(String e,String d,String c)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(e)));
		driver.findElement(By.xpath(e)).sendKeys(d);
		return ("done");
	}
	public String click(String e,String d,String c)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(e)));
		driver.findElement(By.xpath(e)).click();
		return ("done");
	}
	public String validateMail(String e,String d,String c) throws IOException
	{
	try 
	  {
		if(c.equalsIgnoreCase("mail_sent")&&driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[1]/div[5]/div[1]/div/div[3]/div/div/div[2]")).isDisplayed())
		{
			return("passed");
					
		}
		else
		{
			String temp=this.screenShot();
			return("test failed"+temp+".png");
		}
	  }//try block closing
		catch(Exception ex)
		{
			String temp=this.screenShot();
			return("test was interrupted"+temp+".png");
		}
	}
	public void close()
	{
		driver.close();
	}
	public String screenShot() throws IOException
	{
		Date dt=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yy-hh-mm-ss");
		String ssname=sdf.format(dt);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(ssname+".png");
		FileHandler.copy(src, dest);
		return ssname;
	}

}
