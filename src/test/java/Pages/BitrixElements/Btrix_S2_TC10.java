package Pages.BitrixElements;

import Utility.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Btrix_S2_TC10  {


    public Btrix_S2_TC10(){
        PageFactory.initElements(TestBase.driver, this);
    }

    @FindBy (xpath = "//input[@placeholder='Login']")
    public WebElement userName;

    @FindBy (xpath = "//input[@placeholder='Password']")
    public WebElement passWord;

    @FindBy (xpath = "//input[@class='login-btn']")
    public WebElement logInButton;

    @FindBy (xpath = "//tbody/tr[1]/td[1]/div[1]/ul[1]/li[3]/a[1]")
    public WebElement Tasks;

    @FindBy (xpath = "//tbody/tr[1]/td[1]/div[1]/ul[1]/li[3]/span[3]/a[1]")
    public WebElement addTasks;










}
