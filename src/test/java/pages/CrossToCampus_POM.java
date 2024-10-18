package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utility.BaseDriver;

public class CrossToCampus_POM extends BaseDriver {
    public CrossToCampus_POM() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "//a[text()='Campus Login']")
    public WebElement campusLogin;

    @FindBy(id = "mat-input-0")
    public WebElement userName;

    @FindBy(id = "mat-input-1")
    public WebElement password;

    @FindBy(xpath = "//span[@class='mdc-button__label']")
    public WebElement loginButton;

    @FindBy(tagName = "mat-panel-description")
    public WebElement messageBox;

    public void verifyMessageContainsText(String value) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//hot-toast-container/div/div/div//*"), 0));
        Assert.assertTrue(this.messageBox.getAttribute("innerHTML").toLowerCase().contains(value.toLowerCase()));
    }
}
