import org.testng.annotations.Test;

@Test(groups = "app", dependsOnGroups = {"deploy", "db"})
public class TestNGDependsOnGroupAppTest {

    @Test
    public void testAppStarted(){
        System.out.println("Test app started");
    }

    @Test(dependsOnMethods = "testAppStarted")
    public void testAppRunning(){
        System.out.println("Test app running");
    }
}

    /*OUTPUT
    Test ignored.
        org.testng.TestNGException:
        DependencyMap::Method "TestNGDependsOnGroupAppTest.testAppStarted()[pri:0, instance:TestNGDependsOnGroupAppTest@76908cc0]" depends on nonexistent group "db"
        at org.testng.DependencyMap.getMethodsThatBelongTo(DependencyMap.java:41)
        at org.testng.internal.DynamicGraphHelper.createDynamicGraph(DynamicGraphHelper.java:76)
        at org.testng.TestRunner.privateRun(TestRunner.java:618)
        at org.testng.TestRunner.run(TestRunner.java:505)
        at org.testng.SuiteRunner.runTest(SuiteRunner.java:455)
        at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:450)
        at org.testng.SuiteRunner.privateRun(SuiteRunner.java:415)
        at org.testng.SuiteRunner.run(SuiteRunner.java:364)
        at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)
        at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:84)
        at org.testng.TestNG.runSuitesSequentially(TestNG.java:1208)
        at org.testng.TestNG.runSuitesLocally(TestNG.java:1137)
        at org.testng.TestNG.runSuites(TestNG.java:1049)
        at org.testng.TestNG.run(TestNG.java:1017)
        at com.intellij.rt.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:66)
        at com.intellij.rt.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:110)
*/
