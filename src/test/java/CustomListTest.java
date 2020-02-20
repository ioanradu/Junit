import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomListTest {
    private CustomList myList;

    @Before
    public void init(){
        myList = new CustomList();
    }

    @Test
    public void testWhenListIsEmptyThenIsEmptyMethodReturnsTrue(){
        assertEquals(true, myList.isEmpty());
    }
    @Test
    public void testWhenListIsNotEmptyThenIsEmptyMethodReturnsFalse(){
        myList.add("abc");
        assertEquals(false, myList.isEmpty());
    }

    @Test
    public void testWhenAnElementIsAddedToAnEmptyListThenSizeMethodReturnsOne(){
        myList.add("abc");
        assertEquals(1,myList.size());
    }

    @Test
    public void testWhenAnElementIsAddedToAnEmptyListListThenGeMethodReturnsThatElement(){
        myList.add("abc");
        assertEquals("abc",myList.get(0));
    }

    @Test
    public void testWhenTwoElementsIsAddedToAnEmptyListThenSizeMethodReturnsBoth(){
        myList.add("abc");
        myList.add("def");
        String el1 = myList.get(0);
        String el2 = myList.get(1);
        assertEquals("abc",el1);
        assertEquals("def",el2);
    }









}
