import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SubmenuSocialMedia_POM;
import utility.BaseDriver;
import utility.ConfigReader;
import utility.MyFunc;

public class US_SubmenuSocialMedia extends BaseDriver {

    @Test
    public void submenuSocialMedia() {
        SubmenuSocialMedia_POM element = new SubmenuSocialMedia_POM();

        driver.get(ConfigReader.getProperty("URL"));
        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("URL")));

        MyFunc.scrollToElement(element.facebookIcon);
        Assert.assertTrue(element.facebookIcon.isEnabled());
        MyFunc.myClick(element.facebookIcon);

        wait.until(ExpectedConditions.visibilityOf(element.facebookVerify));
        Assert.assertTrue(element.facebookVerify.isDisplayed());

        driver.navigate().back();

        MyFunc.scrollToElement(element.instagramIcon);
        Assert.assertTrue(element.instagramIcon.isEnabled());
        MyFunc.myClick(element.instagramIcon);

        wait.until(ExpectedConditions.visibilityOf(element.instagramVerify));
        Assert.assertTrue(element.instagramVerify.isDisplayed());

        driver.navigate().back();

        MyFunc.scrollToElement(element.youTubeIcon);
        Assert.assertTrue(element.youTubeIcon.isEnabled());
        MyFunc.myClick(element.youTubeIcon);

        wait.until(ExpectedConditions.visibilityOf(element.youtubeVerify));
        Assert.assertTrue(element.youtubeVerify.isDisplayed());

        driver.navigate().back();

        MyFunc.scrollToElement(element.linkedInIcon);
        Assert.assertTrue(element.linkedInIcon.isEnabled());
        MyFunc.myClick(element.linkedInIcon);

        wait.until(ExpectedConditions.elementToBeClickable(element.linkedInLoginClose));
        MyFunc.myClick(element.linkedInLoginClose);

        wait.until(ExpectedConditions.visibilityOf(element.linkedInVerify));
        Assert.assertTrue(element.linkedInVerify.isDisplayed());

        driver.navigate().back();
        Assert.assertTrue(element.technoLogo.isDisplayed());
    }
}
