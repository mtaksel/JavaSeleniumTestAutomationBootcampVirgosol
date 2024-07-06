package excDay1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D1_getTitle {


    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        String title = driver.getTitle();
        System.out.println("title = " + title);


        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);
        driver.quit();
    }
}
