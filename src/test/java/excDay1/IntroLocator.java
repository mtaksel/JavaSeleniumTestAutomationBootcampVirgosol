package excDay1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IntroLocator {

    @Test
    public void testTask(){

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("http://www.amazon.com");

        WebElement inputBoxElement = driver.findElement(By.id("twotabsearchtextbox"));
        inputBoxElement.sendKeys("watch");

    }

    @Test
    public void testName(){

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement genderInputBox = driver.findElement(By.name("gender"));
        if (genderInputBox!=null) System.out.println("element bulundu");
        driver.quit();

    }

    @Test
    public void testLink(){

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/accessing-link.html");

        WebElement linkText = driver.findElement(By.linkText("go here"));
        linkText.click();
        driver.navigate().back();
        WebElement partiallinkText = driver.findElement(By.partialLinkText("click"));
        partiallinkText.click();
        driver.quit();

    }

    @Test
    public void testCSS(){

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("http://www.amazon.com");

        WebElement inputBoxElement = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
        inputBoxElement.sendKeys("watch");
    }
}
