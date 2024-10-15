package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseDriver;

import java.util.List;

public class LogoToHomePage_POM {

    public LogoToHomePage_POM() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(css = "[imgfield='img']")
    public WebElement logoImg;

    @FindBy(linkText = "Kurslar")
    public WebElement coursesBtn;

    @FindBy(xpath = "//span[contains(@class,'link-inner_left')]")
    public List<WebElement> courses;

    @FindBy(linkText = "Bilgi Alın")
    public WebElement contactUsBtn;

    @FindBy(xpath = "//strong[contains(text(),'Bize ulaşın!')]")
    public WebElement contactUsControl;

    @FindBy(linkText = "Kullanım Şartları")
    public WebElement termsofUseBtn;

    @FindBy(linkText = "Gizlilik Politikası")
    public WebElement privacyPolicyBtn;

    @FindBy(linkText = "Çerez Poli")
    public WebElement cookiePolicyBtn;
}
