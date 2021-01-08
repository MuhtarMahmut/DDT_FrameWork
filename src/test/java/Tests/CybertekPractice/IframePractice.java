package Tests.CybertekPractice;

import Pages.CTKPracticeElements.HomePage;
import Utility.Library;
import Utility.TestBase;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframePractice extends TestBase {

    HomePage homePage;

    @BeforeMethod
    public void set(){
        homePage = new HomePage();
    }

    @Test()
    public void Test1(){
        homePage.frameLink.click();
        homePage.iFrameLink.click();

        driver.switchTo().frame( homePage.iFrame );
        homePage.yourContent.click();
       homePage.yourContent.clear();
      //  homePage.yourContent.sendKeys(Keys.COMMAND+"a"+Keys.BACK_SPACE);

        act.sendKeys("Hazel").pause(2000).sendKeys(" Likes").pause(2000).sendKeys(" Muhtar").perform();

        Library.sleep(3);

        driver.switchTo().defaultContent();

        Assert.assertTrue(homePage.iFrameMessage.isDisplayed());


    }


}
