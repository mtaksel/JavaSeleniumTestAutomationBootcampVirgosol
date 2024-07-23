package tasks.task2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class frames1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void hw1() {

        driver.get("https://demoqa.com/frames");
        String expectedFrameText = "Frames";
        String actualframesText = driver.findElement(By.cssSelector(".text-center")).getText();
        Assert.assertEquals(expectedFrameText,actualframesText, "texts are not matching");
        System.out.println("actualframesText = " + actualframesText);

        driver.switchTo().frame(driver.findElement(By.id("frame1")));
        String expectedBigFrame = "This is a sample page";
        String actualBigFrame = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(actualBigFrame,expectedBigFrame,"texts are not matching.");
        System.out.println("actualBigFrame = " + actualBigFrame);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 0; i < 2; i++) {
            jse.executeScript("window.scrollBy(0,500)");
        }

        driver.switchTo().parentFrame();
        driver.switchTo().frame(driver.findElement(By.id("frame2")));
        String expectedSmallFrame = "This is a sample page";
        String actualSmallFrame = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(actualSmallFrame,expectedSmallFrame,"texts are not matching.");
        System.out.println("actualSmallFrame = " + actualSmallFrame);

        driver.switchTo().parentFrame();
        String expectedMainText = "Sample Iframe page There are 2 Iframes in this page";
        String actualMainText = driver.findElement(By.xpath("//div[@id='framesWrapper']/div[contains(.,'Sample Iframe page There are 2 Iframes in this page')]")).getText();
        Assert.assertTrue(actualMainText.contains(expectedMainText));
        System.out.println("actualMainText = " + actualMainText);

    }

    /*
    Frames1
1)    https://demoqa.com/frames sayfasına gidilir
2)    Sayfadaki “Frames” yazısı kontrol edilir (<h1>)
3)    “This is a sample page” yazısı kontrol edilir (Büyük frame içinde)
4)    “This is a sample page” yazısı kontrol edilir (küçük frame içinde)
5)    Syafada “Sample Iframe page There are 2 Iframes in this page” texti kontrol edilir
     */
}
