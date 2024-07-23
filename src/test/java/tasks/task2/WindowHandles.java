package tasks.task2;

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
import java.util.Set;

public class WindowHandles {

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
    public void hw4(){

        driver.get("https://demoqa.com/browser-windows");

        String expectedHeaderText = "Browser Windows";
        String actualHeaderText  = driver.findElement(By.xpath("//h1[@class='text-center']")).getText();
        Assert.assertEquals(actualHeaderText,expectedHeaderText,"texts are not matching.");

        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        newTabButton.click();

        String expectedUrl = "https://demoqa.com/sample";
        Set<String> windowHandlesSet = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandlesSet);
        String mainWindow = windowHandlesList.get(0);
        String newWindow = windowHandlesList.get(1);
        String actualUrl = driver.switchTo().window(newWindow).getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl,"URL not matching");
        System.out.println("actualUrl = " + actualUrl);

        String expectedNewPageText = "This is a sample page";
        String actualNewPageText = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(actualNewPageText,expectedNewPageText,"Texts are not matching.");
        System.out.println("actualNewPageText = " + actualNewPageText);

        driver.switchTo().window(mainWindow);
        WebElement newWindowButton = driver.findElement(By.id("windowButton"));
        newWindowButton.click();

        windowHandlesSet = driver.getWindowHandles();
        windowHandlesList = new ArrayList<>(windowHandlesSet);
        String newWindowHandle = windowHandlesList.get(2);
        driver.switchTo().window(newWindowHandle);
        String expectedNewWindowText = "This is a sample page";
        String actualNewWindowText = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(actualNewWindowText,expectedNewWindowText,"Texts are not matching");
        System.out.println("actualNewWindowText = " + actualNewWindowText);

    }
    /*
    1)    https://demoqa.com/browser-windows sayfasına gidilir
2)    “Browser Windows” başlık kontrol edilir (<h1>)
3)    “New Tab” butonuna tıklanır
4)    Açılan sayfanın Url’si kontrol edilir (https://demoqa.com/sample )
5)    Açılan sayfadaki “This is a sample page” yazı kontrol edilir
6)    Ana sayfaya geçilip “New Window” butonuna tıklanır
7)    Açılan sayfadaki “This is a sample page” yazı kontrol edilir
8)    Açılan sayfa kapatılır
     */
}
