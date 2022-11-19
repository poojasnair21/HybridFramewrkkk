package BaseClass;

import Utilities.UtilityFetchProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class DriverInstance {
    public WebDriver driver;
    @BeforeMethod
    public void initializeDriverInstance() throws IOException {
       /* String browsername="Chrome";*/
        String browsername= UtilityFetchProperties.fetchPropertyValue("browsername");
        switch (browsername)
        {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        driver.get(UtilityFetchProperties.fetchPropertyValue("url"));
        driver.manage().window().maximize();
    }
   @AfterMethod
    public void closeInstance()
    {
       // driver.quit();
    }
}
