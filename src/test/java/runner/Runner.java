package runner;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import utility.BaseDriver;
import utility.ConfigReader;
import utility.MyFunc;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Runner extends BaseDriver {
    long randomNumber = ThreadLocalRandom.current().nextLong(10000000000L, 100000000000L);
    public static Faker faker = new Faker();
    public static Random random = new Random();

    @Test(groups = "Smoke Test", priority = 1)
    @Parameters("browserType")
    public void dropDownMenu() {
        Dropdown_POM element = new Dropdown_POM();

        wait.until(ExpectedConditions.elementToBeClickable(element.coursesBtn));
        new Actions(driver).moveToElement(element.coursesBtn).perform();

        int randomCourses = (int) (Math.random() * element.courses.size());
        String keyWordStr = element.courses.get(randomCourses).getText().replaceAll("-", " ");

        wait.until(ExpectedConditions.elementToBeClickable(element.courses.get(randomCourses)));
        MyFunc.myClick(element.courses.get(randomCourses));

        Assert.assertTrue(driver.getTitle().contains(keyWordStr));
    }

    @Test(groups = "Smoke Test", priority = 2)
    @Parameters("browserType")
    public void crossToCampus() {
        CrossToCampus_POM elements = new CrossToCampus_POM();

        driver.get(ConfigReader.getProperty("URL"));
        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("URL")));

        Assert.assertTrue(elements.campusLogin.isEnabled());
        MyFunc.myClick(elements.campusLogin);
        Assert.assertTrue(elements.campusLoginControl.isDisplayed());

        Assert.assertTrue(elements.userName.isEnabled());
        MyFunc.mySendKeys(elements.userName, ConfigReader.getProperty("username"));
        Assert.assertTrue(elements.userName.isDisplayed());

        Assert.assertTrue(elements.password.isEnabled());
        MyFunc.mySendKeys(elements.password, ConfigReader.getProperty("password"));
        Assert.assertTrue(elements.userName.isDisplayed());

        Assert.assertTrue(elements.loginButton.isEnabled());
        MyFunc.myClick(elements.loginButton);

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//hot-toast-container/div/div/div//*"), 0));
        WebElement messageBox = BaseDriver.driver.findElement(By.tagName("mat-panel-description"));
        Assert.assertTrue(messageBox.getAttribute("innerHTML").toLowerCase().contains("Invalid username".toLowerCase()));
    }

    @Test(groups = "Smoke Test", priority = 3)
    @Parameters("browserType")
    public void bookingTest() {
        Booking_POM element = new Booking_POM();

        MyFunc.myClick(element.applyButton);

        driver.get(ConfigReader.getProperty("formURL"));
        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("formURL")));
        Assert.assertTrue(driver.getCurrentUrl().equals(ConfigReader.getProperty("formURL")));
        Assert.assertTrue(element.controlText.getText().equalsIgnoreCase("Bize Ulaşın!"), "Text could not mathched");

        if (element.controlText.isDisplayed()) {
            String name = faker.name().fullName();
            MyFunc.mySendKeys(element.fullNameBox, "Test " + name);

            String email = faker.internet().emailAddress();
            MyFunc.mySendKeys(element.emailBox, "test_" + email);

            String phoneNumber = String.valueOf(randomNumber);
            MyFunc.mySendKeys(element.phoneNumberBox, phoneNumber);

            int randomNumber = random.nextInt(18, 50);
            String intRandom = String.valueOf(randomNumber);
            MyFunc.mySendKeys(element.ageBox, intRandom);

            MyFunc.mySendKeys(element.jobBox, ConfigReader.getProperty("job"));
            MyFunc.myClick(element.educationInfoButton);

            List<WebElement> filteredEducationList = new ArrayList<>();
            for (WebElement education : element.educationInfoList) {
                if (!education.getText().contains("Eğitim durumu")) {
                    filteredEducationList.add(education);
                }
            }
            if (!filteredEducationList.isEmpty()) {
                int randomEducation = (int) (Math.random() * filteredEducationList.size());
                MyFunc.myClick(filteredEducationList.get(randomEducation));
            }

            MyFunc.myClick(element.selectCountry);
            Assert.assertTrue(element.selectCountry.getText().equalsIgnoreCase("argentina"));

            List<WebElement> filteredCourseList = new ArrayList<>();
            for (WebElement course : element.courseList) {
                if (!course.getText().contains("Kursunuzu seçin")) {
                    filteredCourseList.add(course);
                }
            }
            if (!filteredCourseList.isEmpty()) {
                int randomCourse = (int) (Math.random() * filteredCourseList.size());
                wait.until(ExpectedConditions.elementToBeClickable(filteredCourseList.get(randomCourse)));
                MyFunc.myClick(filteredCourseList.get(randomCourse));
            }

            List<WebElement> filteredSurveyList = new ArrayList<>();
            for (WebElement course : element.surveyList) {
                if (!course.getText().contains("Bizi nereden duydunuz?")) {
                    filteredSurveyList.add(course);
                }
            }
            if (!filteredSurveyList.isEmpty()) {
                int randomSurvey = (int) (Math.random() * filteredSurveyList.size());
                wait.until(ExpectedConditions.elementToBeClickable(filteredSurveyList.get(randomSurvey)));
                MyFunc.myClick(filteredSurveyList.get(randomSurvey));
            }

            MyFunc.myClick(element.checkBox);
            Assert.assertTrue(element.checkBox.isDisplayed());
            Assert.assertTrue(element.checkBox.isEnabled());

            MyFunc.myClick(element.submitButton);

            wait.until(ExpectedConditions.visibilityOf(element.confirmMessage));
            Assert.assertTrue(element.confirmMessage.getText().contains("Başvurunuz alınmıştır."));
        }
    }

    @Test(groups = "Regression Test", priority = 4)
    @Parameters("browserType")
    public void subMenuCourses() {
        SubmenuCourses_POM element = new SubmenuCourses_POM();

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

    @Test(groups = "Regression Test", priority = 5)
    @Parameters("browserType")
    public void submenuSocialMedia() {
        SubmenuSocialMedia_POM element = new SubmenuSocialMedia_POM();

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

    @Test(groups = "Regression Test", priority = 6)
    @Parameters("browserType")
    public void logoToHomePage() {
        LogoToHomePage_POM element = new LogoToHomePage_POM();

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

        List<WebElement> buttons = Arrays.asList(
                element.termsofUseBtn, element.cookiePolicyBtn, element.privacyPolicyBtn
        );

        List<WebElement> controls = Arrays.asList(
                element.termsofUseControl, element.cookiePolicyControl, element.privacyPolicyControl
        );

        for (int i = 0; i < buttons.size(); i++) {
            WebElement button = buttons.get(i);
            WebElement control = controls.get(i);

            wait.until(ExpectedConditions.elementToBeClickable(button));
            MyFunc.scrollToElement(button);
            MyFunc.myClick(button);

            for (String handle : handles) {
                if (!handle.equals(homepageHandle)) {
                    driver.switchTo().window(handle);
                    Assert.assertTrue(control.getText().contains(button.getText()));
                    MyFunc.myClick(element.logoImg);
                }
            }
        }
    }

    @Test(groups = "Regression Test", priority = 7)
    @Parameters("browserType")
    public void courseDetails() {
        CourseDetails_POM element = new CourseDetails_POM();

        MyFunc.scrollToElement(element.courseSDET);
        Assert.assertTrue(element.courseSDET.isDisplayed());

        MyFunc.myClick(element.detailedInformationButton);

        MyFunc.scrollToElement(element.applyNowButton);
        Assert.assertTrue(element.informationSDET.isDisplayed());

        Assert.assertTrue(element.technoLogo.isDisplayed());
        MyFunc.myClick(element.technoLogo);
        Assert.assertTrue(element.homepageControl.isDisplayed());

        MyFunc.scrollToElement(element.courseAndroidApplication);
        Assert.assertTrue(element.courseAndroidApplication.isDisplayed());

        MyFunc.myClick(element.androidApplicationButton);
        Assert.assertTrue(element.androidApplicationText.isDisplayed());
        MyFunc.myClick(element.detailedButtonSecond);

        MyFunc.scrollToElement(element.informationField);
        Assert.assertTrue(element.informationField.isDisplayed());
        Assert.assertTrue(element.informationFieldSecond.isDisplayed());
        Assert.assertTrue(element.informationFieldThird.isDisplayed());

        Assert.assertTrue(element.technoLogo.isDisplayed());
        MyFunc.myClick(element.technoLogo);
        Assert.assertTrue(element.homepageControl.isDisplayed());

        MyFunc.scrollToElement(element.dataScience);
        Assert.assertTrue(element.dataScience.isDisplayed());

        MyFunc.myClick(element.dataScienceButton);

        wait.until(ExpectedConditions.visibilityOf(element.onlineText));
        Assert.assertTrue(element.onlineText.isDisplayed());

        MyFunc.myClick(element.detailedButton);

        wait.until(ExpectedConditions.visibilityOf(element.dataScienceContent));
        Assert.assertTrue(element.dataScienceContent.isDisplayed());

        Assert.assertTrue(element.technoLogo.isDisplayed());
        MyFunc.myClick(element.technoLogo);
        Assert.assertTrue(element.homepageControl.isDisplayed());
    }

    @Test(groups = "Regression Test", priority = 8)
    @Parameters("browserType")
    public void TermsOfUse() {
        TermsOfUse_POM elements = new TermsOfUse_POM();

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
