package excDay1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class D1_navigate {

    public static void main(String[] args) {

        WebDriver driver = WebDriverManager.chromedriver().create();
        //manage window
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        driver.navigate().to("https://www.amazon.com/");

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();

    }
}
