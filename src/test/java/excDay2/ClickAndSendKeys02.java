package excDay2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ClickAndSendKeys02 {

    @Test
    public void test(){

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

        WebElement searchbox = driver.findElement(By.cssSelector("input[placeholder='Search Amazon']"));
        // searchbox.sendKeys("watch");

        // WebElement submitbuton = driver.findElement(By.id("nav-search-submit-button"));
        // submitbuton.click();

        // driver.findElement(By.id("nav-search-submit-button")).click();

        searchbox.sendKeys("watch for women", Keys.ENTER);

    }
}
