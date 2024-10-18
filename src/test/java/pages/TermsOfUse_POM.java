package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseDriver;

public class TermsOfUse_POM{

    public TermsOfUse_POM(){
        PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy(css = "[class='t-checkbox__control'] > input")
    public WebElement checkbox;

    @FindBy(linkText = "Kullanım Şartlarını")
    public WebElement termsOfUse;
}
