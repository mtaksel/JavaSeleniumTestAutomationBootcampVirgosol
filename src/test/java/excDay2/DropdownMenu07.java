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

import java.util.List;

public class DropdownMenu07 {

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
    public void test1() throws InterruptedException {

        driver.get("https://pynishant.github.io/dropdown-selenium-python-select.html");

        driver.findElement(By.xpath("//div[@class='select-selected']")).click();
        Thread.sleep(1000);

        List<WebElement> languages = driver.findElements(By.xpath("//div[@class='select-items']/div"));

        System.out.println("languages.size() = " + languages.size());

        Assert.assertEquals(languages.get(2).getText(),"Java");
        System.out.println("java = " + languages.get(2).getText());

        for (WebElement element : languages){
            System.out.println("element.getText() = " + element.getText());
        }

    }
}
