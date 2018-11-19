package amma;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Phonetest {

	public static void main(String[] args) throws IOException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName", "0915f9490b1b3104");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("appPackage", "com.samsung.android.contacts");
		dc.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
		// start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u = new URL("http://0.0.0.0:4723/wd/hub");
		// create object to android driver

		AndroidDriver driver;
		while (2 > 1) {
			try {
				driver = new AndroidDriver(u, dc);
				break;

			} 
			catch (Exception ex)
			{
				
			}
		}
        try
        {
        	Thread.sleep(5000);
        	driver.findElement(By.xpath("//*[@text='RECENTS'")).click();
        	driver.findElement(By.xpath("//*[@resource-id='com.samsung.android.contacts:id/floating_action_button'")).click();
        }
        catch(Exception exe)
        {
        	System.out.println(exe.getMessage());
        }
	}

}
