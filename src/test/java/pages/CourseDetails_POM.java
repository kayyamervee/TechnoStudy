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

    @FindBy(xpath = "(//*[text()='Detaylı bilgi'])[2]")
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

    @FindBy(xpath = "(//*[text()='Detaylı bilgi'])[3]")
    public WebElement androidApplicationButton;

    @FindBy(xpath = "(//*[text()='Android Uygulama Geliştirme'])[3]")
    public WebElement androidApplicationText;

    @FindBy(xpath = "//*[text()='Detaylı bilgi']")
    public WebElement detailedButtonSecond;

    @FindBy(xpath = "(//p[@style='text-align: center;'])[4]")
    public WebElement informationField;

    @FindBy(xpath = "(//p[@style='text-align: center;'])[6]")
    public WebElement informationFieldSecond;

    @FindBy(xpath = "//*[.='Mezunlarımızı neler bekliyor?']")
    public WebElement informationFieldThird;

    @FindBy(xpath = "(//*[text()='Veri Bilimi'])[2]")
    public WebElement dataScience;

    @FindBy(xpath = "//*[text()='Detaylı bilgi']")
    public WebElement dataScienceButton;

    @FindBy(xpath = "//*[text()='Detaylı bilgi']")
    public WebElement detailedButton;

    @FindBy(xpath = "//div[.='Online Veri Bilimi Dersleri']")
    public WebElement onlineText;

    @FindBy(xpath = "//*[.='Techno Study ile Veri Bilimci Olun']")
    public WebElement dataScienceContent;
}
