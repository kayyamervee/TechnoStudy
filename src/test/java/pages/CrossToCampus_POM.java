package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseDriver;

public class CrossToCampus_POM{
    public CrossToCampus_POM(){PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy(xpath = "//a[text()='Campus Login']")
    public WebElement campusLogin;

    @FindBy(css = "[class='logo'] img")
    public WebElement campusLoginControl;

    @FindBy(id = "mat-input-0")
    public WebElement userName;

    @FindBy(id = "mat-input-1")
    public WebElement password;
}


