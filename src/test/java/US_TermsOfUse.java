import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TermsOfUse_POM;
import utility.BaseDriver;
import utility.ConfigReader;

public class US_TermsOfUse extends BaseDriver {
    @Test()
    public void TermsOfUse(){
        TermsOfUse_POM elements=new TermsOfUse_POM();

        driver.get(ConfigReader.getProperty("termsOfUseURL"));
        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("termsOfUseURL")));

        wait.until(ExpectedConditions.elementToBeClickable(elements.checkbox));
        elements.checkbox.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.termsOfUse));
        elements.termsOfUse.click();

        wait.until(ExpectedConditions.visibilityOf(elements.termsOfUse));
        Assert.assertTrue(elements.termsOfUse.getText().contains("Terms of Use document not found."));

    }
}
