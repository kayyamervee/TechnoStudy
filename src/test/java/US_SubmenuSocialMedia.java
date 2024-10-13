import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SubmenuSocialMedia_POM;
import utility.BaseDriver;
import utility.ConfigReader;
import utility.MyFunc;

public class US_SubmenuSocialMedia extends BaseDriver {

    @Test
    public void submenuSocialMedia(){
        SubmenuSocialMedia_POM element=new SubmenuSocialMedia_POM();

        driver.get(ConfigReader.getProperty("URL"));
        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("URL")));

        MyFunc.scrollToElement(element.facebookIcon);
        element.facebookIcon.click();
    }
}
