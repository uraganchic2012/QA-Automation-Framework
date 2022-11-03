import org.testng.Assert;
import org.testng.annotations.Test;

public class CiTests {

    @Test
    public void addTwoNumbersPositive(){
        Assert.assertEquals(1 + 1, 2);
    }

    @Test
    public void addTwoNumbersNegative(){
        Assert.assertEquals(1 + 2, 2);
    }

    @Test
    public void addTwoNumbersRegressionOne(){
        Assert.assertEquals(0 + 1, 1);
    }

    @Test
    public void addTwoNumbersRegressionTwo(){
        Assert.assertEquals(0 + 0, 0);
    }
}
