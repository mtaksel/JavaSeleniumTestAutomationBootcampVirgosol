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

public class RadioButton05 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test1(){

        driver.get("https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html");

        WebElement browserIE = driver.findElement(By.xpath("//input[@value='IE']"));
        Assert.assertTrue(browserIE.isSelected());

        WebElement browserOpera = driver.findElement(By.xpath("//input[@value='Opera']"));
        browserOpera.click();
        Assert.assertTrue(browserOpera.isSelected());
        Assert.assertFalse(browserIE.isSelected(), "ie is selected");

        WebElement browserMozilla = driver.findElement(By.xpath("//input[@value='Mozilla']"));
        Assert.assertTrue(browserMozilla.isEnabled());

    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("https://demoqa.com/radio-button");
        WebElement impressiveButton = driver.findElement(By.cssSelector("label[for='impressiveRadio']"));
        Assert.assertTrue(impressiveButton.isEnabled(), "is not enabled");
        impressiveButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(impressiveButton.isSelected());
        
        
        String impressiveButtontext = driver.findElement(By.xpath("//span[text()='Impressive']")).getText();
        System.out.println("impressiveButtontext = " + impressiveButtontext);

        WebElement noButton = driver.findElement(By.cssSelector("label[for='noRadio']"));
        Assert.assertFalse(noButton.isEnabled(), "no radio button is enabled");
    }
}
