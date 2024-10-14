package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseDriver;

import java.util.List;

public class Booking_POM {

    public Booking_POM() {
        PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy(linkText = "BAŞVUR")
    public WebElement applyButton;

    @FindBy(xpath = "//strong[text()='Bize ulaşın!']")
    public WebElement controlText;

    @FindBy(name = "name")
    public WebElement fullNameBox;

    @FindBy(name = "email")
    public WebElement emailBox;

    @FindBy(css = "[type='tel']")
    public WebElement phoneNumberBox;

    @FindBy(xpath = "//input[@name='Input']")
    public WebElement ageBox;

    @FindBy(xpath = "//input[@name='Input_2']")
    public WebElement jobBox;

    @FindBy(xpath = "(//div[@class='t-select__wrapper t-select__wrapper_bbonly'])[1]")
    public WebElement educationInfoButton;

    @FindBy(xpath = "//select[@name='country']/option")
    public List<WebElement>educationInfoList;

    @FindBy(xpath = "//option[text()='Argentina']")
    public WebElement selectCountry;

    @FindBy(xpath = "//select[@name='course']/option")
    public List<WebElement>courseList;

    @FindBy(xpath = "//select[@name='survey']/option")
    public List<WebElement>surveyList;

    @FindBy(xpath = "//div[@class='t-checkbox__indicator']")
    public WebElement checkBox;

    @FindBy(xpath = "//button[text()='Gönder']")
    public WebElement submitButton;

    @FindBy(xpath = "(//span[.='Başvurunuz alınmıştır. Bilgilendirme emailinize gönderilmiştir.'])[2]")
    public WebElement confirmMessage;
}
