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

public class Gmailloginmethods 
{
	public WebDriver driver;
	public WebDriverWait wait;
	// opening browser method
	public String launch(String e,String d,String c)throws Exception
	{
		if(e.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\project\\chrome.exe");
			driver=new ChromeDriver();
		}
		 else if (e.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","E:\\project\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		 else
		 {
			 return("unknown browser");
		 }
		driver.get(d);
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='identifierId']")));
		driver.manage().window().maximize();
		return ("done");
	 }
	//fill method
	    public String fill(String e,String d,String c)
	    {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(e)));
	    	driver.findElement(By.xpath(e)).sendKeys(d);
			return ("done");
	    	
	    }
	    //click method
	    public String click(String e,String d,String c)
	    {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(e)));
	    	driver.findElement(By.xpath(e)).click();
			return ("Done");
	    }
	    // validation method
	    public String validateLogin(String e,String d,String c) throws Exception
	    {
	    	try
	     {
	    	if(c.equalsIgnoreCase("all_valid")&& driver.findElement(By.xpath("//*[@class='gb_ab gbii']")).isDisplayed())
	    	{
			return ("passed");
	    	}
	    	else
	    	{
	    		String temp=this.screenShot();
	    	return("test fail"+temp+".png");
	    	}
	     }
	    	catch(Exception ex)
	    	{
	    		String temp=this.screenShot();
	    		return("test was interrupted"+temp+".png");
	    	}
	    }
	    // close site method
	    public String close()
	    {
	    	driver.close();
			return ("Done");
	    }
	    //screenshot method
	    public String screenShot() throws Exception
	    {
	    	Date d=new Date();
	    	SimpleDateFormat sfd=new SimpleDateFormat("dd-mm-yy-hh-mm-ss");
	    	String ssname=sfd.format(d);
	    	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	File dest=new File (ssname+".png");
	    	FileHandler.copy(src, dest);
			return ("ssname");
	    	
	    }
	
}
