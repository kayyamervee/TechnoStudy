import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Dropdown_POM;
import utility.BaseDriver;
import utility.ConfigReader;
import utility.MyFunc;


public class US_DropdownMenu extends BaseDriver {

    @Test
    public void dropDownMenu(){
        Dropdown_POM element=new Dropdown_POM();

        driver.get(ConfigReader.getProperty("URL"));
        wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("URL")));

        wait.until(ExpectedConditions.elementToBeClickable(element.coursesBtn));
        new Actions(driver).moveToElement(element.coursesBtn).perform();

        int randomCourses=(int)(Math.random()*element.courses.size());
        String keyWordStr=element.courses.get(randomCourses).getText();

        wait.until(ExpectedConditions.elementToBeClickable(element.courses.get(randomCourses)));
        MyFunc.myClick(element.courses.get(randomCourses));

        Assert.assertTrue(driver.getTitle().contains(keyWordStr));
    }
}
