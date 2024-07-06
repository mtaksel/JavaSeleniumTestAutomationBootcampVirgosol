package excDay1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestngIntro {

    @Test
    public void test1(){
        System.out.println("ilk testcase");
    }

    @Test
    public void test2(){
        System.out.println("ikinci testcase");
    }

    @Test
    public void titlt(){

        WebDriver driver = WebDriverManager.chromiumdriver().create();
        driver.manage().window().maximize();
        driver.get("http://www.amazon.com");

        String expectedResult = "Amazon.com. Spend less. Smile more.";
        System.out.println("expectedResult = " + expectedResult);

        String actualResult = driver.getTitle();
        System.out.println("actualResult = " + actualResult);

        if(actualResult.contains(expectedResult)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }
        driver.quit();

    }

    @Test
    public void currentULR(){

        WebDriver driver = WebDriverManager.chromiumdriver().create();
        driver.manage().window().maximize();
        driver.get("http://www.amazon.com");
        String currenturl = driver.getCurrentUrl();
        System.out.println("currenturl = " + currenturl);
        driver.quit();
    }
}
