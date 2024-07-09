package excDay2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsClass09 {

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

    //vertical scroll

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://selenium08.blogspot.com/2020/02/vertical-scroll.html");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(2000);

        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//a[text()='Events']"));
        Thread.sleep(1000);

        actions.moveToElement(element).perform();

    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("https://demo.guru99.com/test/drag_drop.html");
        Actions actions = new Actions(driver);

        WebElement sourceElement = driver.findElement(By.xpath("//li[@id='credit2']/a"));
        WebElement targetElement = driver.findElement(By.xpath("//*[@id='bank']"));

        actions.dragAndDrop(sourceElement,targetElement).perform();
        Thread.sleep(2000);


    }

    @Test
    public void ScrollDownAndUp() throws InterruptedException {
        driver.get("https://selenium08.blogspot.com/2020/02/vertical-scroll.html");

        // how to scroll down or up in Selenium with JS
        // scroll up/down yapmak için pencereyi maksimize etmek gerekebilir

        JavascriptExecutor jse= (JavascriptExecutor) driver;
        // scroll down
        for (int i = 0; i < 4; i++) { // 2 times make scroll down
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250)"); // 0: horizontally moving , 250: vertically moving (www.w3schools)
        }

        // scroll up
        for (int i = 0; i < 2; i++) { // 5 times make scroll up
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-250)");
        }

    }


}
