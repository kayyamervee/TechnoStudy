import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CrossToCampus_POM;
import utility.BaseDriver;
import utility.ConfigReader;
import utility.MyFunc;

public class US_CrossToCampus extends BaseDriver {
    @Test()
    public void crossToCampus() {
        CrossToCampus_POM elements = new CrossToCampus_POM();

        driver.get(ConfigReader.getProperty("URL"));
        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("URL")));

        wait.until(ExpectedConditions.elementToBeClickable(elements.campusLogin));
        MyFunc.myClick(elements.campusLogin);

        wait.until(ExpectedConditions.elementToBeClickable(elements.userName));
        elements.userName.sendKeys(ConfigReader.getProperty("username"));

        wait.until(ExpectedConditions.elementToBeClickable(elements.passWord));
        elements.passWord.sendKeys(ConfigReader.getProperty("password"));

        wait.until(ExpectedConditions.elementToBeClickable(elements.button));
        MyFunc.myClick(elements.button);
    }
}