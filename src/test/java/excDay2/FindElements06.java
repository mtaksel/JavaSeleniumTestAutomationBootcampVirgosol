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

import java.util.ArrayList;
import java.util.List;

public class FindElements06 {

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
    public void testList() throws InterruptedException {

        driver.get("https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html");

        Thread.sleep(2000);

        List<WebElement> listOfColor = new ArrayList<>();
        listOfColor.add(driver.findElement(By.cssSelector("input[value='red']")));
        listOfColor.add(driver.findElement(By.cssSelector("input[value='blue']")));
        listOfColor.add(driver.findElement(By.cssSelector("input[value='purple']")));

        for(WebElement element : listOfColor) {
            element.isEnabled();
            element.click();
            Thread.sleep(2000);
            Assert.assertTrue(element.isSelected(),"not selected");


        }
    }

    @Test
    public void testList2(){

        driver.get("https://demoqa.com/webtables");
        
        List<WebElement> list = driver.findElements(By.cssSelector("div[class='rt-tr-group']"));
        System.out.println("list.size() = " + list.size());
        
    }
}
