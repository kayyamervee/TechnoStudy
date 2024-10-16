package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseDriver;

public class TermsOfUse_POM{
    public TermsOfUse_POM(){PageFactory.initElements(BaseDriver.driver,this);
    }
    @FindBy(xpath = "//div[@class='t-checkbox__indicator']")
    public WebElement checkbox;

    @FindBy(xpath = "//font[text()='Terms of Use']")
    public WebElement termsOfUse;
}
