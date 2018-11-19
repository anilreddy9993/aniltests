package amma;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		//ta.press(1128, 1530).release().perform();
			System.out.println("start");
			// driver.findElementByAndroidUIAutomator("new
			// uiselector().text(\"ALLOW\")").click();
			System.out.println("end");
			// w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='txtserver']")));
			driver.findElement(By.xpath("//*[@index='0']")).sendKeys("productionlink.uat1c.bakershughes.com");
			driver.findElement(By.xpath("//*[@index='2']")).sendKeys("Ambit001");
			driver.findElement(By.xpath("//*[@index='5']")).sendKeys("Baker123$");
			driver.findElement(By.xpath("//*[@resource-id='btn_login']")).click();
		} catch (Exception exe) {
			System.out.println("Exception occured" + exe.getMessage());
		}

		// close app
		// driver.closeApp();
		// stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
