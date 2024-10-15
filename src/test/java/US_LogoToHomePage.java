import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogoToHomePage_POM;
import utility.BaseDriver;
import utility.ConfigReader;
import utility.MyFunc;

import java.util.Set;

public class US_LogoToHomePage extends BaseDriver {

    @Test
    public void logoToHomePage() {
        LogoToHomePage_POM element = new LogoToHomePage_POM();

        driver.get(ConfigReader.getProperty("URL"));
        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("URL")));
        String homeTitle = driver.getTitle();

        wait.until(ExpectedConditions.elementToBeClickable(element.contactUsBtn));
        MyFunc.myClick(element.contactUsBtn);
        Assert.assertTrue(element.contactUsControl.getText().contains("ulaşın!"));
        MyFunc.myClick(element.logoImg);

        for (int i = 0; i < element.courses.size(); i++) {
            wait.until(ExpectedConditions.elementToBeClickable(element.coursesBtn));
            new Actions(driver).moveToElement(element.coursesBtn).perform();

            String keyWordStr = element.courses.get(i).getText().replaceAll("-", " ");
            MyFunc.myClick(element.courses.get(i));

            Assert.assertTrue(driver.getTitle().equalsIgnoreCase(keyWordStr));
            MyFunc.myClick(element.logoImg);
            wait.until(ExpectedConditions.titleIs(homeTitle));
        }

        String homepageHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();

        wait.until(ExpectedConditions.elementToBeClickable(element.termsofUseBtn));
        MyFunc.scrollToElement(element.termsofUseBtn);
        MyFunc.myClick(element.termsofUseBtn);
        for (String handle : handles) {
            if (!handle.equals(homepageHandle)) {
                driver.switchTo().window(handle);
                Assert.assertTrue(element.termsofUseControl.getText().contains(element.termsofUseBtn.getText()));
                MyFunc.myClick(element.logoImg);
                MyFunc.Wait(5);
                break;
            }
        }

        wait.until(ExpectedConditions.elementToBeClickable(element.cookiePolicyBtn));
        MyFunc.myClick(element.cookiePolicyBtn);
        for (String handle : handles) {
            if (!handle.equals(homepageHandle)) {
                driver.switchTo().window(handle);
                Assert.assertTrue(element.termsofUseControl.getText().contains(element.cookiePolicyBtn.getText()));
                MyFunc.myClick(element.logoImg);
            }
        }

        wait.until(ExpectedConditions.elementToBeClickable(element.privacyPolicyBtn));
        MyFunc.myClick(element.privacyPolicyBtn);
        for (String handle : handles) {
            if (!handle.equals(homepageHandle)) {
                driver.switchTo().window(handle);
                Assert.assertTrue(element.termsofUseControl.getText().contains(element.privacyPolicyBtn.getText()));
                MyFunc.myClick(element.logoImg);
            }
        }
    }
}
