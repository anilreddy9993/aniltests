package test;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
public class Listeners1 implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) 
	{
		Reporter.log("test started successfuly");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log("test successful");	
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		Reporter.log("test failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
  
}
