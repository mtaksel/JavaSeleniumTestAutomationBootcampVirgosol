package tasks.task1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class task1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void hw1() {

        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        driver.findElement(By.xpath("//input[@name='keyword']")).sendKeys("fish");
        driver.findElement(By.xpath("//input[@name='searchProducts']")).click();


        String expectedID = "FI-FW-02";
        String actualResult = driver.findElement(By.xpath("//font[contains(.,'FI-FW-02')]")).getText();
        Assert.assertEquals(expectedID, actualResult, "they are not equal");

    }

    @Test
    public void hw2() {

        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        driver.findElement(By.xpath("//input[@name='keyword']")).sendKeys("fish");
        driver.findElement(By.xpath("//input[@name='searchProducts']")).click();
        driver.findElement(By.xpath("//font[contains(.,'FI-FW-02')]")).click();
        driver.findElement(By.xpath("//tr[2]//a[.='Add to Cart']")).click();
        driver.findElement(By.xpath("//img[@src='../images/sm_fish.gif']")).click();
        driver.findElement(By.xpath("//a[.='FI-SW-01']")).click();
        driver.findElement(By.xpath("//tr[2]//a[.='Add to Cart']")).click();

        String expectedPrice = "$22.00";
        String actualResult = driver.findElement(By.xpath("//td[contains(.,'Sub Total: $22.00')]")).getText();
        Assert.assertTrue(actualResult.contains(expectedPrice));
    }

    @Test
    public void hw3() {

        driver.get("https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html");
        WebElement red = driver.findElement(By.xpath("//input[@value='red']"));
        red.click();
        WebElement green = driver.findElement(By.xpath("//input[@value='green']"));
        green.click();

        Assert.assertTrue(red.isSelected(), "red is not selected");
        Assert.assertTrue(green.isSelected(), "green is not selected");

    }

    @Test
    public void h4() throws InterruptedException {
        driver.get("https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 0; i < 2; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250)");
        }
        WebElement radioIE = driver.findElement(By.xpath("//input[@value='IE']"));
        radioIE.click();
        WebElement radioMozzilla = driver.findElement(By.xpath("//input[@value='Mozilla']"));
        WebElement radioOpera = driver.findElement(By.xpath("//input[@value='Opera']"));
        radioIE.isSelected();
        Assert.assertTrue(radioIE.isSelected(), "IE is not selected");
        radioOpera.isSelected();
        Assert.assertFalse(radioOpera.isSelected(), "Opera is selected");
        radioMozzilla.click();
        radioMozzilla.isSelected();
        Assert.assertTrue(radioMozzilla.isSelected(), "Mozilla is not selected");
        radioIE.isSelected();
        Assert.assertFalse(radioIE.isSelected(), "IE is selected");

    }

    @Test
    public void hw5() throws InterruptedException {

        driver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250)");
        }

        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@name='Month']"));

        Select select = new Select(dropDownMenu);
        List<WebElement> months = select.getOptions();
        int dropdownSize = months.size();
        System.out.println("Size of dropdown menu: " + dropdownSize);

        for (WebElement each : months) {
            System.out.println("element.getText() = " + each.getText());
        }

        select.selectByValue("Ma");
        select.selectByIndex(5);
        select.selectByVisibleText("October");

        List<WebElement> selectedMonths = select.getAllSelectedOptions();
        int selectedMonthsSize = selectedMonths.size();
        System.out.println("selectedMonthsSize = " + selectedMonthsSize);
        Assert.assertEquals(selectedMonthsSize,3,"number of selected months is not 3");

    }

    @Test
    public void hw6(){

        driver.get("https://demoqa.com/select-menu");
        WebElement selectMenu = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(selectMenu);
        List<WebElement> colors = select.getOptions();

        for (WebElement each : colors){
            System.out.println("each.getText() = " + each.getText());
        }
        select.selectByIndex(4);
        WebElement selectedIndex = select.getFirstSelectedOption();
        System.out.println("selectedIndex.getText() = " + selectedIndex.getText());

        select.selectByVisibleText("Magenta");
        WebElement selectedIndex2 = select.getFirstSelectedOption();
        System.out.println("selectedIndex2.getText() = " + selectedIndex2.getText());

        select.selectByValue("6");
        WebElement selectedIndex3 = select.getFirstSelectedOption();
        System.out.println("selectedIndex3.getText() = " + selectedIndex3.getText());

    }
}

