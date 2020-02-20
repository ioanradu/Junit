import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assert.assertEquals;

public class AssertJTests {
    @Test
    public void testStringIsEqualWithAnotherString(){
        System.out.println("Testing assertj <isEqualTo> ");
        String test = "abc";
        //assertEquals(test, "abc"); // asta e din jUnit
        assertThat(test).isEqualTo("abc"); // asta e din AssertJ
        assertThat(test).isGreaterThan("a");

    }

    @Test
    public void testMultipleConditionsForAnArray(){
        System.out.println("Testing assertj multipleConditions");
        String[] array = {"abc", "def", "gfi"};
        assertThat(array)
                .hasSize(3)
                .contains("abc")
                .doesNotContain("xyz");
    }
}


     /*OUTPUT

     Testing assertj multipleConditions
     Testing assertj <isEqualTo>
    */