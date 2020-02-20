import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


public class GreeterTest {

    @Test
    public void testGreeterSaysHelloWorld(){
        System.out.println("Testing....");
        Greeter greeter = new Greeter();
        String s = greeter.sayHello();
        assertThat(s, equalTo("Hello World!"));
    }
}
