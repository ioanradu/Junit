import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGExecutionOrderTest {

    @Test
    public void divide() {
        System.out.println("Test divide method.");
        int a = 20, b = 4;
        Assert.assertEquals(5, a / b);
    }

    @Test(dependsOnMethods = "divide")
    public void processNumber(){
        System.out.println("Test process numbers.");
    }
}


    /*OUTPUT


     Test divide method.


     Test process numbers.


     ===============================================
     Default Suite
     Total tests run: 2, Failures: 0, Skips: 0
     ===============================================*/