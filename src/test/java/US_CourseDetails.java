import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CourseDetails_POM;
import utility.BaseDriver;
import utility.ConfigReader;
import utility.MyFunc;

public class US_CourseDetails extends BaseDriver {

    @Test
    public void courseDetails(){
        CourseDetails_POM element=new CourseDetails_POM();

        driver.get(ConfigReader.getProperty("URL"));
        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("URL")));

        MyFunc.scrollToElement(element.courseSDET);
        Assert.assertTrue(element.courseSDET.isDisplayed());

        wait.until(ExpectedConditions.elementToBeClickable(element.detailedInformationButton));
        element.detailedInformationButton.click();

        MyFunc.scrollToElement(element.applyNowButton);
        Assert.assertTrue(element.informationSDET.isDisplayed());

        Assert.assertTrue(element.technoLogo.isDisplayed());
        MyFunc.myClick(element.technoLogo);
        Assert.assertTrue(element.homepageControl.isDisplayed(), "home page could not be reached");

        MyFunc.scrollToElement(element.courseAndroidApplication);
        Assert.assertTrue(element.courseAndroidApplication.isDisplayed());

        wait.until(ExpectedConditions.elementToBeClickable(element.androidApplicationButton));
        element.androidApplicationButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(element.detailedButtonSecond));
        element.detailedButtonSecond.click();
    }
}
