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

        Assert.assertTrue(elements.campusLogin.isEnabled());
        MyFunc.myClick(elements.campusLogin);

        MyFunc.mySendKeys(elements.userName, ConfigReader.getProperty("username"));
        Assert.assertTrue(elements.userName.isDisplayed());

        MyFunc.mySendKeys(elements.password, ConfigReader.getProperty("password"));
        Assert.assertTrue(elements.userName.isDisplayed());

        MyFunc.myClick(elements.loginButton);

        elements.verifyMessageContainsText("Invalid username");
    }
}