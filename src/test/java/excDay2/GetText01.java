package excDay2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetText01 {


    @Test
    public void test() throws InterruptedException {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        driver.findElement(By.id("userName")).sendKeys("Melek");
        driver.findElement(By.id("userEmail")).sendKeys("melek.sahin@virgosol.com");
        driver.findElement(By.id("currentAddress")).sendKeys("eskişehir");
        driver.findElement(By.id("permanentAddress")).sendKeys("isparta");

        driver.findElement(By.id("submit")).click();
        Thread.sleep(3000);

        String name = driver.findElement(By.id("name")).getText();
        System.out.println("name = " + name);

        String expectedName = "Name:Melek";
        Assert.assertTrue(name.contains(expectedName));

        Thread.sleep(2000);

        driver.close();
    }

    @Test
    public void test2() throws InterruptedException {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        driver.findElement(By.id("userName")).sendKeys("Melek");
        driver.findElement(By.id("userEmail")).sendKeys("melek.sahin@virgosol.com");
        driver.findElement(By.id("currentAddress")).sendKeys("eskişehir");
        driver.findElement(By.id("permanentAddress")).sendKeys("isparta");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(3000);
        
        
        String expectedName = "Melek";
        System.out.println("expectedName = " + expectedName);
        String name = driver.findElement(By.id("name")).getText();
        System.out.println("name = " + name);

        String[] array = name.split(":");

        String actualName = array[1];
        System.out.println("actualName = " + actualName);

        Assert.assertEquals(actualName,expectedName);

        driver.close();
    }
}
