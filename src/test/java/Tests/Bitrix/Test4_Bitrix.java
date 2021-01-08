package Tests.Bitrix;

import Pages.BitrixElements.Btrix_S2_TC10;
import Utility.ConfigReader;
import Utility.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test4_Bitrix extends TestBase {

    Btrix_S2_TC10 bitrix;

    @BeforeMethod
    public void m(){
        bitrix = new Btrix_S2_TC10();

        bitrix.userName.sendKeys(ConfigReader.get("username"));
        bitrix.passWord.sendKeys(ConfigReader.get("password"));
        bitrix.logInButton.click();
    }

    @Test
    public void task1(){
        tests = reports.createTest("Add Tasks");
       act.moveToElement( bitrix.Tasks ).perform(); // mouse hover to the element tasks
       bitrix.addTasks.click();

        Assert.assertTrue(true);

    }


}
