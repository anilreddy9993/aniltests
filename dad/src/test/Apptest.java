package test;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Apptest {

	public static void main(String[] args) throws Exception {
		// device details
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setCapability(CapabilityType.BROWSER_NAME, "");
				dc.setCapability("deviceName", "0915f9490b1b3104");
				dc.setCapability("platformName", "android");
				dc.setCapability("platformVersion", "7.0");
				dc.setCapability("automationName", "Uiautomator2");
				dc.setCapability("appPackage", "bakerhughes.ambit.mobile.publish");
				dc.setCapability("appActivity", "bakerhughes.ambit.mobile.publish.MainActivity");
				// start appium server
				Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
				URL u = new URL("http://0.0.0.0:4723/wd/hub");
				// create object to android driver

				AndroidDriver driver;
				while (2 > 1) {
					try {
						driver = new AndroidDriver(u, dc);
						break;

					} catch (Exception ex) {
						ex.getMessage();
					}
				}
				// Automation
				try {
					WebDriverWait w = new WebDriverWait(driver, 20);
					Thread.sleep(5000);

					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='ALLOW']")));
					TouchAction ta = new TouchAction(driver);
					
					
					driver.findElement(By.xpath("//*[@text='ALLOW']")).click();
				
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='txtserver']")));
				
					driver.findElement(By.xpath("//*[@resource-id='txtserver']")).sendKeys("productionlink.uat1c.bakerhughes.com");
					driver.findElement(By.xpath("//*[@resource-id='txtmail']")).sendKeys("Ambit001");
					driver.findElement(By.xpath("//*[@resource-id='txtpass']")).sendKeys("Baker123$");
					driver.findElement(By.xpath("//*[@resource-id='btn_login']")).click();
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='No']")));
					driver.findElement(By.xpath("//*[@text='No']")).click();
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Dashboard']")));
					driver.findElement(By.xpath("//*[@text='Dashboard']")).click();
					w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Alarm']")));
					//MobileElement e=(MobileElement)driver.findElement(By.xpath("//*[text='Well']"));
					Screen s=new Screen();
					if(s.exists("E:\\project\\1.png") != null)
					{
						System.out.println("data given is matching");
					}
					else
					{
						System.out.println("given data is not matching");
					}
					if(s.exists("E:\\project\\2.png") != null)
					{
						System.out.println("data given is matching");
					}
					else
					{
						System.out.println("given data is not matching");
					}
					if(s.exists("E:\\project\\3.png") != null)
					{
						System.out.println("data given is matching");
					}
					else
					{
						System.out.println("given data is not matching");
					}
				}
				    catch (Exception exe) 
				    {
					System.out.println("Exception occured" + exe.getMessage());
				     }

				// close app
				// driver.closeApp();
				// stop appium server
				Thread.sleep(10000);
				Runtime.getRuntime().exec("taskkill /F /IM node.exe");
				Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
