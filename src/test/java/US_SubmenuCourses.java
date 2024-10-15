import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SubmenuCourses_POM;
import utility.BaseDriver;
import utility.ConfigReader;
import utility.MyFunc;

public class US_SubmenuCourses extends BaseDriver {
    @Test
    public void subMenuCourses() {
        SubmenuCourses_POM element = new SubmenuCourses_POM();

        driver.get(ConfigReader.getProperty("URL"));
        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("URL")));

        MyFunc.myClick(element.courseDropdown);
        Assert.assertTrue(element.sdet.isDisplayed());

        MyFunc.myClick(element.sdet);
        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("sdetURL")));
        Assert.assertTrue(driver.getCurrentUrl().contains("sdet"));

        System.out.println(element.controlTextSdet.isDisplayed());
        Assert.assertTrue(element.controlTextSdet.getText().contains("TEST"));

        Assert.assertTrue(element.shortTextSdet.isDisplayed());
        Assert.assertTrue(element.shortTextSdet.getText().contains("Yoğun Online Eğitim Kampı"));

        MyFunc.myClick(element.courseDropdown);
        Assert.assertTrue(element.androidApp.isDisplayed());

        MyFunc.myClick(element.androidApp);
        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("androidAppURL")));
        Assert.assertTrue(driver.getCurrentUrl().contains("android"));

        System.out.println(element.controlTextAndroid.isDisplayed());
        Assert.assertTrue(element.controlTextAndroid.isDisplayed());
        Assert.assertTrue(element.controlTextAndroid.getText().contains("Android"));

        MyFunc.jsClick(element.androidButton);
        Assert.assertTrue(element.shortTextAndroid.getText().contains("Android"));

        MyFunc.myClick(element.courseDropdown);
        Assert.assertTrue(element.sdet.isDisplayed());

        MyFunc.myClick(element.dataScience);
        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("dataScienceURL")));
        Assert.assertTrue(element.controlTextDataSci.getAccessibleName().contains("Veri Bilimi"));

        wait.until(ExpectedConditions.visibilityOf(element.detailedInfoButton));
        MyFunc.jsClick(element.detailedInfoButton);

        element.controlTextDataSci.isDisplayed();
        Assert.assertTrue(element.shorTextData.getText().contains("Online"));

        MyFunc.myClick(element.courseDropdown);
        Assert.assertTrue(element.jobCenter.isDisplayed());

        MyFunc.myClick(element.jobCenter);
        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("jobCenterURL")));
        Assert.assertTrue(driver.getCurrentUrl().contains("jobcenter"));

        wait.until(ExpectedConditions.visibilityOf(element.jobCenterControlText));
        Assert.assertTrue(element.jobCenterControlText.getText().contains("Yeni"));

        wait.until(ExpectedConditions.elementToBeClickable(element.detailedInfoButton));
        MyFunc.jsClick(element.detailedInfoButton);

        wait.until(ExpectedConditions.visibilityOf(element.jobCenterShortText));
        Assert.assertTrue(element.jobCenterShortText.getText().contains("Techno"));
    }
}
