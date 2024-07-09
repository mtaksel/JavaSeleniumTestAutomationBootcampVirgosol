package excDay2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropDown08 {

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

        driver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");

        WebElement dropDown = driver.findElement(By.name("name"));

        Select dropDownElement = new Select(dropDown);

        List<WebElement> elements = dropDownElement.getOptions();
        System.out.println("elements.size() = " + elements.size());

        for (WebElement each : elements){
            System.out.println("each.getText() = " + each.getText());
        }
    }

    @Test
    public void test2() throws InterruptedException {

        WebElement dropDown = driver.findElement(By.name("country"));
        Select select = new Select(dropDown);

        String expectedFirst = "Country...";
        String actualFirst = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualFirst,expectedFirst);

        // visibleText
        select.selectByVisibleText("Japan");

        String actualtext = select.getFirstSelectedOption().getText();
        String expectedText = "Japan";
        Assert.assertEquals(actualtext, expectedText);

        Thread.sleep(2000);

        // value

        select.selectByValue("MV");

        String expectedValue = "Maldives";
        String actualValue = select.getFirstSelectedOption().getText();
        System.out.println("actualValue = " + actualValue);
        Assert.assertEquals(actualValue, expectedValue);

        Thread.sleep(2000);

        // index

        select.selectByIndex(247);

        String expectedIndexText = "Zimbabwe";
        String actualIndextText = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualIndextText,expectedIndexText);

    }
}
