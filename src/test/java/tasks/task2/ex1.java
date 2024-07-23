package tasks.task2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ex1 {

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
    public void hw2() throws InterruptedException {

        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement appoinmentButton = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        appoinmentButton.click();
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        WebElement loginButton = driver.findElement(By.id("btn-login"));
        loginButton.click();

        //Alert popUP = driver.switchTo().alert();
        //popUP.accept();

        WebElement facility = driver.findElement(By.id("combo_facility"));
        Select dropDown = new Select(facility);
        dropDown.selectByValue("Hongkong CURA Healthcare Center");

        WebElement checkBox = driver.findElement(By.id("chk_hospotal_readmission"));
        checkBox.click();

        driver.findElement(By.id("radio_program_medicare")).click();
        driver.findElement(By.id("txt_visit_date")).sendKeys("31/07/2024");
        driver.findElement(By.id("txt_comment")).sendKeys("Comment");
        driver.findElement(By.id("btn-book-appointment")).click();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 0; i < 2; i++) {
            jse.executeScript("window.scrollBy(0,500)");
        }

        String expectedConfirmationText = "Appointment Confirmation";
        String actualConfirmationText = driver.findElement(By.xpath("//h2[.='Appointment Confirmation']")).getText();
        Assert.assertTrue(actualConfirmationText.contains(expectedConfirmationText),"texts are not matching");

        WebElement menuButton = driver.findElement(By.xpath("//i[@class='fa fa-bars']"));
        menuButton.click();
        WebElement logoutButton = driver.findElement(By.xpath("//a[.='Logout']"));
        logoutButton.click();

        String expectedUrl = "https://katalon-demo-cura.herokuapp.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl,"links are not same");

        String expectedMainText = "We Care About Your Health";
        String actualMainText = driver.findElement(By.xpath("//h3[.='We Care About Your Health']")).getText();
        Assert.assertEquals(actualMainText,expectedMainText,"texts are not matching");

    }

    /*
    Exercise
1)    Tarayıcı açılır (https://katalon-demo-cura.herokuapp.com/)
2)    Make Appointment butonuna tıklanır
3)    Kullanıcı adı ve şifre girilir (Kullanıcı adı ve şifreyi “Demo account” alanından get metodu kullanarak alıp girilir)
4)    Login butonuna tıklanır
5)    Şifrenizi değiştirin popupı tamama tıklanır
6)    Facility Honkong seçilir
7)    “Apply for hospital readmission” check boxı seçilir
8)    “Healthcare Program” Medicare radyo butonu seçilir
9)    “Visit Date (Required)” alanına tarih girilir
10)    “Comment” girilir
11)    “Book Appointment” butonuna tıklanır
12)    “Appointment Confirmation” yazısı kontrol edilir
13)    Sağ üst köşedeki üç çizgi olan menü butonuna tıklanır
14)    “Log out” butonuna tıklanır
15)    Url kontrol edilir (https://katalon-demo-cura.herokuapp.com/ )
16)    “We Care About Your Health” yazısı kontrol edilir
     */
}
