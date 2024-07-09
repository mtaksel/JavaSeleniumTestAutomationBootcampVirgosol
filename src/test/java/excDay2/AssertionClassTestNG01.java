package excDay2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionClassTestNG01 {

    @Test
    public void test1(){

        Assert.assertEquals("test", "test");
    }

    @Test
    public void test2(){

        String expectedText = "play";
        String actualText = "playStation";

        Assert.assertTrue(actualText.startsWith(expectedText));

    }

    @Test
    public void test3(){
        String expectedText = "play";
        String actualText = "playStation";

        Assert.assertTrue(actualText.contains(expectedText));
    }

    @Test
    public void test4(){

        Assert.assertFalse(12>23, "verify 12 is greater than 23");

    }

    @Test
    public void test5(){

        Assert.assertNotEquals(2.3,7.5);

    }
}
