import org.testng.annotations.Test;

@Test(groups = "deploy")
public class TestNGDependsOnGroupServerTest {

    @Test
    public void testServerDeployment(){
        System.out.println("Deploy server.");
    }

    @Test(dependsOnMethods = "testServerDeployment")
    public void testBackUpServerDeployment(){
        System.out.println("Deploy backup serv.er");
    }
}

    /*OUTPUT

    Deploy server.


    Deploy backup serv.er


    ===============================================
    Default Suite
    Total tests run: 2, Failures: 0, Skips: 0
    ===============================================
*/
