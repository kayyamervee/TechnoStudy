import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Booking_POM;
import utility.BaseDriver;
import utility.ConfigReader;
import utility.MyFunc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class US_Booking extends BaseDriver {
    long randomNumber = ThreadLocalRandom.current().nextLong(10000000000L, 100000000000L);
    public static Faker faker = new Faker();
    public static Random random = new Random();

    @Test
    public void bookingTest() {
        Booking_POM element = new Booking_POM();

        driver.get(ConfigReader.getProperty("URL"));
        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("URL")));

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
}