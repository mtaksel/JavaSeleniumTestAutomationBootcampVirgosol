package tasks.task2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class frames2 {

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
    public void hw3(){

        driver.get("https://demoqa.com/nestedframes");
        String expectedHeaderText = "Nested Frames";
        String actualHeaderText = driver.findElement(By.xpath("//h1[@class='text-center']")).getText();
        Assert.assertTrue(actualHeaderText.contains(expectedHeaderText),"texts are not matching");

        driver.switchTo().frame(driver.findElement(By.id("frame1")));
        String expectedParentFrameText = "Parent frame";
        String actualParentFrameText = driver.findElement(By.xpath("//body[.='Parent frame']")).getText();
        Assert.assertEquals(actualParentFrameText,expectedParentFrameText, "texts are not matching");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']")));
        String expectedChildFrameText = "Child Iframe";
        String actualChildFrameText = driver.findElement(By.xpath("//p[.='Child Iframe']")).getText();
        Assert.assertEquals(actualChildFrameText,expectedChildFrameText,"texts are not matching");

        driver.switchTo().defaultContent();
        String expectedHeaderContext = "Sample Nested Iframe page.";
        String actualHeaderContext = driver.findElement(By.xpath("//div[@id='framesWrapper']/div[contains(.,'Sample Nested Iframe page.')]")).getText();
        Assert.assertTrue(actualHeaderContext.contains(expectedHeaderContext));

    }

    /*
    Frames2
1)    https://demoqa.com/nestedframes Sayfasına gidilir
2)    “Nested Frames” başlık kontrol edilir (<h1>)
3)    “Parent frame” yazısı kontrol edilir (büyük frame içinde)
4)    “Child Iframe” yazısı kontrol edilir (Büyük frame içindeki frame içinde)
5)    Sayffada “Sample Nested Iframe page.” texti kontrol edilir
     */
}
