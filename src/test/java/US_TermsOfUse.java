import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TermsOfUse_POM;
import utility.BaseDriver;
import utility.MyFunc;

import java.util.Set;

public class US_TermsOfUse extends BaseDriver {

    @Test()
    public void TermsOfUse() {
        TermsOfUse_POM elements = new TermsOfUse_POM();

        MyFunc.scrollToElement(elements.checkbox);

        MyFunc.jsClick(elements.checkbox);

        MyFunc.myClick(elements.termsOfUse);

        String homepage = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(homepage)) {
                driver.switchTo().window(handle);
                Assert.assertTrue(driver.getTitle().contains("Kullanım Şartları"));
            }
        }
    }
}
