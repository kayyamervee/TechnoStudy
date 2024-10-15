import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogoToHomePage_POM;
import utility.BaseDriver;
import utility.ConfigReader;
import utility.MyFunc;

public class US_LogoToHomePage extends BaseDriver {

    @Test
    public void logoToHomePage(){
        LogoToHomePage_POM element=new LogoToHomePage_POM();

        driver.get(ConfigReader.getProperty("URL"));
        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("URL")));

        for (int i = 0; i < element.courses.size(); i++) {
            wait.until(ExpectedConditions.elementToBeClickable(element.coursesBtn));
            new Actions(driver).moveToElement(element.coursesBtn).perform();

            String keyWordStr=element.courses.get(i).getText();
            System.out.println(keyWordStr);
            MyFunc.Wait(2);
            System.out.println(driver.getTitle());

            MyFunc.myClick(element.courses.get(i));
            //Assert.assertTrue(driver.getTitle().equals(keyWordStr));
            MyFunc.myClick(element.logoImg);
        }

        wait.until(ExpectedConditions.elementToBeClickable(element.contactUsBtn));
        MyFunc.myClick(element.contactUsBtn);
        Assert.assertTrue(element.contactUsControl.getText().contains("ulaşın!"));

    }
}
