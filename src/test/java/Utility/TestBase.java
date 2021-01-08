package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    public static WebDriver driver;
    protected ExtentReports reports=new ExtentReports();
    protected ExtentHtmlReporter html= new ExtentHtmlReporter("src/test/Reports/HTML/MyHTMLReport.html");
    protected ExtentTest tests;  // needed for every single @Test
    protected Actions act;
    protected WebDriverWait wait;



    @BeforeMethod  // runs before each @Test
    protected final void setUp(){
       driver = Driver.driver();  // setup and opens the browser
       wait = new WebDriverWait(driver,10); // explicit wait
       act = new Actions(driver);
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.navigate().to( ConfigReader.get("website") );

   }

    @AfterMethod
    protected final void tearDown(ITestResult result){ // gets the result of @Test
        if(result.getStatus() == ITestResult.FAILURE ){
            tests.log(Status.FAIL, result.getName());
            tests.info(result.getThrowable());
            Library.TakeScreenShots(result.getName());
        } else if(result.getStatus() == ITestResult.SKIP ){
            tests.log(Status.SKIP,result.getName());
            tests.info(result.getThrowable());
        }
        Library.sleep(1);

       driver.quit();

    }

    @AfterTest
    protected final void EndTest(){
        reports.attachReporter(html);
        reports.setSystemInfo("Website",ConfigReader.get("website"));
        reports.setSystemInfo("Username",ConfigReader.get("username"));
        reports.setSystemInfo("PassWord",ConfigReader.get("password"));
        reports.setSystemInfo("Browser", ConfigReader.get("browser"));
        html.config().setReportName("Automation Result of Bitrix");
        html.config().setDocumentTitle("Bitrix");
        reports.flush();
    }



}
