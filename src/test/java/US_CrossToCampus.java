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
        Assert.assertTrue(elements.campusLogin.isEnabled());
        MyFunc.myClick(elements.campusLogin);
        Assert.assertTrue(elements.campusLoginControl.isDisplayed());

        wait.until(ExpectedConditions.elementToBeClickable(elements.userName));
        Assert.assertTrue(elements.userName.isEnabled());
        MyFunc.mySendKeys(elements.userName, ConfigReader.getProperty("username"));
        Assert.assertTrue(elements.userName.isDisplayed());

        wait.until(ExpectedConditions.elementToBeClickable(elements.password));
        Assert.assertTrue(elements.password.isEnabled());
        MyFunc.mySendKeys(elements.password, ConfigReader.getProperty("password"));
        Assert.assertTrue(elements.userName.isDisplayed());
    }
}