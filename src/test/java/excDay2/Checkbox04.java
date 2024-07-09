package excDay2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Checkbox04 {


    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void testIsSelected() throws InterruptedException {

        WebElement redButton = driver.findElement(By.cssSelector("input[value='red']"));
        Assert.assertFalse(redButton.isSelected(),"redButton is selected");

        redButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(redButton.isSelected(),"is not selected");

    }

    @Test
    public void testIsDisplayed() throws InterruptedException {

        WebElement redButton = driver.findElement(By.cssSelector("input[value='red']"));
        Assert.assertTrue(redButton.isDisplayed(),"there is not a red checkbox");

        redButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(redButton.isSelected(),"is not selected");

    }
}
