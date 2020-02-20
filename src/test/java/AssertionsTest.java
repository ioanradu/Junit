import org.junit.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.*;

public class AssertionsTest {
    // Before si after ar trebuie puse primele
    @Before
    public void messageBefore() {
        System.out.println("Message is displayed BEFORE EVERY test!");
    }

    @After
    public void messageAfter() {
        System.out.println("Message is displayed AFTER EVERY test!");
    }

    @BeforeClass
    public static void messageBeforeAllTest() {
        System.out.println("Message is displayed BEFORE ALL test!");
    }

    @AfterClass
    public static void messageAfterAllTest() {
        System.out.println("Message is displayed AFTER ALL test!");
    }

    @Test
    public void testOperation() {
        System.out.println("Testing <add> opperation...");
        int a = 20;
        int b = 7;
        String s = null;
        String sir1 = "a";
        String sir2 = new String("y");

        assertEquals(27, a + b);
        // assertTrue(a > b); // da true = verifica daca e true
        // assertFalse(a < b);// da true = verifica daca e false
        // assertNull(s); // da true, testul trece, verifica daca e null
         assertSame(sir1, sir2); //da false, testul pica, verifica referintele
    }

    @Test
    public void testMatcherIs() {
        System.out.println("Testing <is> matcher...");
        int a = 1, b = 1;
        assertThat(a, is(b));
    }

    @Test
    public void testMatcherAnyOf() {
        System.out.println("Testing <anyOf> matcher...");
        int a = 1, b = 1, c = 2;
        assertThat(a, anyOf(is(b), is(c)));
    }

    ;

    @Test
    // atrebuie sa fie egal atat cu b cat si cu c adica toate valorile trebuie sa fie egale
    public void testMatcherAllOf() {
        System.out.println("Testing <allOf> matcher...");
        int a = 1, b = 1, c = 1;
        assertThat(a, allOf(is(b), is(c)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void TestExpectedIndexOutOfBoundsException() {
        System.out.println("Testing expected exception IndexOutOfBoundsException.");
        ArrayList arraylist = new ArrayList();
        arraylist.get(4);
    }

    @Test(expected = ArithmeticException.class)
    public void TestExpectedArithmeticException() {
        System.out.println("Testing expected exception ArithmeticException.");
        int a = 3;
        int b = a / 0;
    }

    @Test(expected = FileNotFoundException.class)
    public void TestExpectedFileNotFoundException() throws FileNotFoundException {
        System.out.println("Testing expected exception FileNotFoundException.");
        File file = new File("tdd.txt");
        FileReader fileReader = new FileReader(file);
    }


   /* OUTPUT

    Message is displayed BEFORE ALL test!
    Message is displayed BEFORE EVERY test!
    Testing <add> opperation...
    Message is displayed AFTER EVERY test!
    Message is displayed BEFORE EVERY test!
    Testing <allOf> matcher...
    Message is displayed AFTER EVERY test!
    Message is displayed BEFORE EVERY test!
    Testing <anyOf> matcher...
    Message is displayed AFTER EVERY test!
    Message is displayed BEFORE EVERY test!
    Testing expected exception ArithmeticException.
    Message is displayed AFTER EVERY test!
    Message is displayed BEFORE EVERY test!
    Testing expected exception IndexOutOfBoundsException.
    Message is displayed AFTER EVERY test!
    Message is displayed BEFORE EVERY test!
    Testing <is> matcher...
    Message is displayed AFTER EVERY test!
    Message is displayed BEFORE EVERY test!
    Testing expected exception FileNotFoundException.
    Message is displayed AFTER EVERY test!
    Message is displayed AFTER ALL test!*/

}
