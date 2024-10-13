package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseDriver;

public class SubmenuSocialMedia_POM {

    public SubmenuSocialMedia_POM() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(css = "[data-field-top-value='170'] a")
    public WebElement facebookIcon;

    @FindBy(css = "(//div[@data-field-top-value='169']//a)[1]")
    public WebElement instagramIcon;

    @FindBy(xpath = "(//div[@data-field-top-value='169']//a)[2]")
    public WebElement youTubeIcon;

    @FindBy(xpath = "(//div[@data-field-top-value='169']//a)[3]")
    public WebElement linkedInIcon;

    @FindBy(css = "[aria-label='Close']")
    public WebElement facebookLoginClose;

    @FindBy(css = "[aria-label='Facebook']")
    public WebElement facebookVerify;

    @FindBy(css = "[aria-label='Instagram']")
    public WebElement instagramVerify;

    @FindBy(id = "logo-icon")
    public WebElement youtubeVerify;

    @FindBy(css = "[aria-label='LinkedIn']")
    public WebElement linkedInVerify;
}

