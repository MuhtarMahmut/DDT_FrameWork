package Pages.CTKPracticeElements;

import Utility.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage  {


    public HomePage(){

        PageFactory.initElements(TestBase.driver, this);

    }

    @FindBy(xpath = "//a[text()='Frames']")
    public WebElement frameLink;

        @FindBy(xpath = "//a[contains(text(), 'iFram')]")
        public WebElement iFrameLink;

        @FindBy(xpath = "//h3[contains(text(),'An iFrame containing')]")
        public WebElement iFrameMessage;

        @FindBy(xpath = "//iframe")
        public WebElement iFrame;

        @FindBy(xpath = "//p[contains(text(),'Your content goes here.')]")
        public WebElement yourContent;
















}
