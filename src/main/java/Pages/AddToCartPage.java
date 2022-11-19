package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage {
    WebDriver driver;
    public AddToCartPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void orderPlaced()
    {
        driver.findElement(By.xpath("//a[contains(@href,'categoryId=DOGS')]")).click();
        System.out.println("selected category is dogs");
        driver.findElement(By.xpath("//a[contains(@href,'productId=K9-BD-01')]")).click();
        System.out.println("selected to cart");
        driver.findElement(By.xpath("//a[contains(@href,'workingItemId=EST-6')]")).click();
        System.out.println("Item added to the cart");
        driver.findElement(By.xpath("//*[text()='Proceed to Checkout']")).click();
        System.out.println("Proceeded to checkout");
        driver.findElement(By.xpath("//input[@name='newOrder']")).click();
        System.out.println("new order placed");
        driver.findElement(By.xpath("//*[text()='Confirm']")).click();
        System.out.println("Confirm to pay");
        String txtorderplaced=driver.findElement(By.xpath("//*[text()='Thank you, your order has been submitted.']")).getText();
        System.out.println(txtorderplaced);


    }

}
