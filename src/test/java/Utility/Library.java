package Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;

public class Library extends TestBase{

    public static void TakeScreenShots(String saveAs){

        String DateTime= LocalDate.now().toString()+ LocalTime.now().toString().substring(0,5);
        saveAs = saveAs+"_"+DateTime.replaceAll("[-,:]","");
        try {
            TakesScreenshot ss = (TakesScreenshot) driver;
            File f = ss.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(f, new File("src/test/Reports/CapturedScreenShots/"+saveAs+".png"));
        } catch (Exception e){}

    }


    public static void sleep(double a){

        try {
            Thread.sleep((long)(a * 1000));
        } catch (Exception e){}

    }

}
