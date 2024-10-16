import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CrossToCampus_POM;
import utility.BaseDriver;
import utility.ConfigReader;

public class US_CrossToCampus extends BaseDriver {
    @Test()
    public void crossToCampus() {
        CrossToCampus_POM elements = new CrossToCampus_POM();

        driver.get(ConfigReader.getProperty("URL"));
        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("URL")));

        wait.until(ExpectedConditions.elementToBeClickable(elements.campusLogin));
        elements.campusLogin.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.userName));
        elements.userName.sendKeys(ConfigReader.getProperty("userName"));

        wait.until(ExpectedConditions.elementToBeClickable(elements.passWord));
        elements.passWord.sendKeys(ConfigReader.getProperty("passWord"));

        wait.until(ExpectedConditions.elementToBeClickable(elements.button));
        elements.button.click();

        wait.until(ExpectedConditions.visibilityOf(elements.button));
        Assert.assertTrue(elements.button.getText().contains("Login to campus failed"));
    }
}