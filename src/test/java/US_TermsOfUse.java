import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TermsOfUse_POM;
import utility.BaseDriver;
import utility.ConfigReader;
import utility.MyFunc;

public class US_TermsOfUse extends BaseDriver {
    @Test()
    public void TermsOfUse(){
        TermsOfUse_POM elements=new TermsOfUse_POM();

        driver.get(ConfigReader.getProperty("termsOfUseURL"));
        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("termsOfUseURL")));

        wait.until(ExpectedConditions.elementToBeClickable(elements.checkbox));
        MyFunc.myClick(elements.checkbox);

        wait.until(ExpectedConditions.elementToBeClickable(elements.termsOfUse));
        MyFunc.myClick(elements.termsOfUse);

        driver.switchTo().window("termsOfUseURL");
        wait.until(ExpectedConditions.visibilityOf(elements.termsOfUse));
        Assert.assertTrue(elements.termsOfUse.getText().contains("Terms of Use"));
    }
}
