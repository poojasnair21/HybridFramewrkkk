package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    WebDriver driver;
    public LandingPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void clickSignIn()
    {
        driver.findElement(By.xpath("//a[text()='Sign In']")).click();
    }
}
