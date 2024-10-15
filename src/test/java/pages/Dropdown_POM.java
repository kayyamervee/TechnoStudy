package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseDriver;

import java.util.List;

public class Dropdown_POM {

    public Dropdown_POM() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(linkText = "Kurslar")
    public WebElement coursesBtn;

    @FindBy(xpath = "//span[contains(@class,'link-inner_left')]")
    public List<WebElement> courses;
}
