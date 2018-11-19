package test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Jxlp 
{

	public static void main(String[] args) throws Exception, IOException 
	{
		System.setProperty("webdriver.gecko.driver", "E:\\project\\geckodriver.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://www.google.com/gmail");
		WebDriverWait w=new WebDriverWait(driver,20);
		File f=new File("E:\\project\\xlpt.xls");
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0);
		int nour=rsh.getRows();
		int nouc=rsh.getColumns();
		System.out.println("number of used rows"+" "+nour);
		System.out.println("number of used columns"+" "+nouc);
		String x=rsh.getCell(0,1).getContents();		
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(x);
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		String y=rsh.getCell(1,1).getContents();
		Thread.sleep(5000);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name=\"password\"]")));
		driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys(y);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[text()='Next']")).click();
	//	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@title='Gmail'])[2]")));
		WritableWorkbook wwb=Workbook.createWorkbook(f, rwb);
		WritableSheet wsh=wwb.getSheet(0);
		Label l=new Label(2,1,"test pass");
		wsh.addCell(l);
		wwb.write();
		
		
	}


	}


