package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseDriver;

public class CourseDetails_POM {

    public CourseDetails_POM() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "//*[text()='SDET']")
    public WebElement courseSDET;

    @FindBy(css = "[data-field-top-value='650']")
    public WebElement detailedInformationButton;

    @FindBy(xpath = "//*[text()='Şimdi Başvur']")
    public WebElement applyNowButton;

    @FindBy(css = "[class='tn-atom'] strong")
    public WebElement informationSDET;

    @FindBy(xpath = "//div[contains(@class,'leftcontainer')]//img")
    public WebElement technoLogo;

    @FindBy(xpath = "(//*[text()='BAŞVUR'])[2]")
    public WebElement homepageControl;

    @FindBy(xpath = "//*[text()='Android Uygulama Geliştiricisi']")
    public WebElement courseAndroidApplication;

    @FindBy(css = "[data-field-top-value='1060']")
    public WebElement androidApplicationButton;

    @FindBy(css = "[data-field-top-value='330']")
    public WebElement detailedButtonSecond;
}
