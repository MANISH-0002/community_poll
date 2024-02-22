package testnglisteners;


	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;


	public class ITestListeners implements ITestListener{
		WebDriver driver;
		
		public void onTestStart(ITestResult result) {
			System.out.println("Test case started");
		}

		public void onTestSuccess(ITestResult result) {
			System.out.println("Test case passed");
		}

		 public void onTestFailure(ITestResult result) {
			System.out.println("Test case failed");
			/*Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File destFile = new File("C:\\Community_Poll\\Com_poll\\failedScreenshoots\\"+sdf.format(d)+".png");
			try {
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}

		public void onTestSkipped(ITestResult result) {
			System.out.println("Test case skipped");
		}


		public void onStart(ITestContext context) {
			System.out.println("TestNG started");
		}

		public void onFinish(ITestContext context) {
			System.out.println("TestNG finished");
		}

	}


