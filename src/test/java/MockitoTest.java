import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;



class MyClass{
    public int getUniqueId(){
        System.out.println("Get unique id.");
        return 0;
    }

    public void testing(int val){
        System.out.println("Testing.");
    }

    public void stringMethod(String s){
        System.out.println("String method");
    }
}



@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Test
    public void testListWithoutMockAnnotation() {
        List mockList = mock(LinkedList.class);
        mockList.add("ana"); // o introducem intr-o lista fake
        verify(mockList).add("ana"); // verificam daca e introdusa

        assertEquals(0, mockList.size()); //  1 da failed (size = 0 nu 1) pentru ca lista nu exista
        when(mockList.size()).thenReturn(10);
        assertEquals(10, mockList.size()); // nu mai da failed daca folosim when  then

    }

    @Mock
    private List<String> mockedList;

    @Test
    public void testListWithMockAnnotation(){
        mockedList.add("ana"); // o introducem intr-o lista fake
        verify(mockedList).add("ana"); // verificam daca e introdusa

        assertEquals(0, mockedList.size()); //  1 da failed (size = 0 nu 1) pentru ca lista nu exista
        when(mockedList.size()).thenReturn(10);
        assertEquals(10, mockedList.size()); // nu mai da failed daca folosim when  then
    }

    @Spy
    private List<String> spiedList = new LinkedList<String>();

    @Test
    public void testSpiedListOne(){
        Mockito.doReturn("ana").when(spiedList).get(0);
        assertEquals("ana", spiedList.get(0));
    }

    @Test
    public void testSpiedListTwo(){
        spiedList.add("ana");
        spiedList.add("maria");
        assertEquals(2, spiedList.size());
    }

    @Test
    public void testVerify(){
        MyClass test = mock(MyClass.class);

        when(test.getUniqueId()).thenReturn(5); // se face fake
        assertEquals(5, test.getUniqueId());
        test.getUniqueId();
       // test.getUniqueId();
        verify(test, times(2)).getUniqueId();

        test.stringMethod("calledAtLeastOnce");
        test.stringMethod("calledAtLeastOnce");

        verify(test, atLeastOnce()).stringMethod("calledAtLeastOnce");

        test.stringMethod("calledAtLeastTwice");
        test.stringMethod("calledAtLeastTwice");
        test.stringMethod("calledAtLeastTwice");
        verify(test, atLeast(2)).stringMethod("calledAtLeastTwice");

        test.stringMethod("calledAtMostThreeTimes");
        test.stringMethod("calledAtMostThreeTimes");
        test.stringMethod("calledAtMostThreeTimes");
        //test.stringMethod("calledAtMostThreeTimes");

        verify(test, atMost(3)).stringMethod("calledAtMostThreeTimes");

        //test.stringMethod("neverCalled");
        verify(test,never()).stringMethod("neverCalled");

        //test.testing(5);
        verifyNoMoreInteractions(test);
    }
}
