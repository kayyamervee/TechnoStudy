package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseDriver;

public class TermsOfUse_POM{
    public TermsOfUse_POM(){PageFactory.initElements(BaseDriver.driver,this);
    }
    @FindBy(xpath = "//input[@placeholder='Name Surname']")
    public WebElement nameSurname;

    @FindBy(name = "[name=email]")
    public WebElement eMail;

    @FindBy(xpath = "//span[@class='t-input-phonemask__select-flag']")
    public WebElement countryCode;

    @FindBy(id = "[t-phonemask_ar]")
    public WebElement coDe;

    @FindBy(id = "[input_1661174990146]")
    public WebElement phoneNumber;

    @FindBy(name = "[Input]")
    public WebElement yourAge;

    @FindBy(name = "[Input_2]")
    public WebElement yourProfession;

    @FindBy(id = "[sb-1667664755026]")
    public WebElement educationStatus;

    @FindBy(xpath = "//option[@value='Üniversite']")
    public WebElement univerSity;

    @FindBy(id = "[sb-1714463229186]")
    public WebElement selectYourCountry;

    @FindBy(xpath = "//option[@value='Argentina']")
    public WebElement argenTina;

    @FindBy(id = "[sb-1663337581601]")
    public WebElement selectYourCourse;

    @FindBy(css = "option[value='SDET Türkçe']")
    public WebElement sDet;

    @FindBy(id = "[sb-1670423010572]")
    public WebElement whereDidYouHearAboutUs;

    @FindBy(css = "option[value='LinkedIn']")
    public WebElement linkedLn;

    @FindBy(xpath = "//div[@class='t-checkbox__indicator']")
    public WebElement checkbox;

    @FindBy(xpath = "//font[text()='Terms of Use']")
    public WebElement termsOfUse;

    @FindBy(xpath = "//font[text()='Send']")
    public WebElement send;








}
