package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseDriver;

public class SubmenuCourses_POM {
    public SubmenuCourses_POM() {
        PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy(linkText = "Kurslar")
    public WebElement courseDropdown;

    @FindBy(linkText = "SDET-Yazılım Test Uzmanı")
    public WebElement sdet;

    @FindBy(xpath = "//div[@data-elem-type='text']/h1")
    public WebElement controlTextSdet;

    @FindBy(xpath = "//*[contains(text(),'Yoğun Online Eğitim Kampı')]")
    public WebElement shortTextSdet;

    @FindBy(linkText = "Android Uygulama Geliştirme")
    public WebElement androidApp;

    @FindBy(xpath = "//div[@class='tn-atom']/p/strong")
    public WebElement controlTextAndroid;

    @FindBy(xpath = "//div[@data-elem-type='button']/a")
    public WebElement androidButton;

    @FindBy(xpath = "(//div[text()='Android Uygulama Geliştirme'])[1]")
    public WebElement shortTextAndroid;

    @FindBy(linkText = "Veri Bilimi")
    public WebElement dataScience;

    @FindBy(xpath = "//div[contains(text(),'Veri Bilimi Bootcamp')]")
    public WebElement controlTextDataSci;

    @FindBy(xpath = "//a[text()='Detaylı bilgi']")
    public WebElement detailedInfoButton;

    @FindBy(xpath = "//div[.='Online Veri Bilimi Dersleri']")
    public WebElement shorTextData;

    @FindBy(linkText = "Job Center & Arbeitsamt")
    public WebElement jobCenter;

    @FindBy(xpath = "//*[contains(text(),'Yeni Bir')]/br")
    public WebElement jobCenterControlText;

    @FindBy(xpath = ".+, u ")
    public WebElement jobCenterShortText;



}
