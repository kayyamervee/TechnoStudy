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

        driver.get(ConfigReader.getProperty("URL"));
        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("URL")));

        wait.until(ExpectedConditions.elementToBeClickable(elements.nameSurname));
        elements.nameSurname.sendKeys(ConfigReader.getProperty("nameSurname"));

        wait.until(ExpectedConditions.elementToBeClickable(elements.eMail));
        elements.eMail.sendKeys(ConfigReader.getProperty("eMail"));

        wait.until(ExpectedConditions.elementToBeClickable(elements.countryCode));
        elements.countryCode.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.coDe));
        elements.coDe.click();

        wait.until(ExpectedConditions.visibilityOf(elements.coDe));
        Assert.assertTrue(elements.coDe.getText().contains("The country code was not entered correctly."));

        wait.until(ExpectedConditions.elementToBeClickable(elements.phoneNumber));
        elements.phoneNumber.sendKeys(ConfigReader.getProperty("phoneNumber"));

        wait.until(ExpectedConditions.elementToBeClickable(elements.yourAge));
        elements.yourAge.sendKeys(ConfigReader.getProperty("yourAge"));

        wait.until(ExpectedConditions.elementToBeClickable(elements.yourProfession));
        elements.yourProfession.sendKeys(ConfigReader.getProperty("yourProfession"));

        wait.until(ExpectedConditions.elementToBeClickable(elements.educationStatus));
        elements.educationStatus.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.univerSity));
        elements.univerSity.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.selectYourCountry));
        elements.selectYourCountry.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.argenTina));
        elements.argenTina.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.selectYourCourse));
        elements.selectYourCourse.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.sDet));
        elements.sDet.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.whereDidYouHearAboutUs));
        elements.whereDidYouHearAboutUs.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.linkedLn));
        elements.linkedLn.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.checkbox));
        elements.checkbox.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.termsOfUse));
        elements.termsOfUse.click();

        wait.until(ExpectedConditions.visibilityOf(elements.termsOfUse));
        Assert.assertTrue(elements.termsOfUse.getText().contains("The terms of use were not read."));

        wait.until(ExpectedConditions.elementToBeClickable(elements.send));
        elements.send.click();

        wait.until(ExpectedConditions.visibilityOf(elements.send));
        Assert.assertTrue(elements.send.getText().contains("Contact us was not filled out."));

    }
}
