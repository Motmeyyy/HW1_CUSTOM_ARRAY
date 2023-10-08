import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;
import java.util.Iterator;

import static org.junit.Assert.*;

public class CustomArrayTest {

    private CustomArray<String> customArray;


    @Before
    public void setUp() {
        customArray = new CustomArray<>();

    }

    @Test
    public void testAdd() {

        String element = "apple";

        boolean result = customArray.add(element);

        assertTrue(result);
        assertEquals(1, customArray.size());
        assertEquals(element, customArray.get(0));
    }

    @Test
    public void testGet() {

        customArray.add("apple");
        customArray.add("banana");

        String element = customArray.get(1);

        assertEquals("banana", element);
    }

    @Test
    public void testRemove() {

        customArray.add("apple");
        customArray.add("banana");
        customArray.add("cherry");

        customArray.remove(1);

        assertEquals(2, customArray.size());
        assertEquals("apple", customArray.get(0));
        assertEquals("cherry", customArray.get(1));
    }

    @Test
    public void testSortString() {

        customArray.add("banana");
        customArray.add("apple");
        customArray.add("cherry");
        Comparator<String> stringComparator = Comparator.naturalOrder();

        customArray.sort(stringComparator);

        assertEquals("apple", customArray.get(0));
        assertEquals("banana", customArray.get(1));
        assertEquals("cherry", customArray.get(2));
    }
    @Test
    public void testSortStringInt() {

        customArray.add("-2");
        customArray.add("3");
        customArray.add("1");
        Comparator<String> stringComparator = Comparator.naturalOrder();

        customArray.sort(stringComparator);

        assertEquals("-2", customArray.get(0));
        assertEquals("1", customArray.get(1));
        assertEquals("3", customArray.get(2));
    }
    @Test
    public void testSortWithCustomComparator() {

        CustomArray<Integer> customArray = new CustomArray<>();
        customArray.add(-5);
        customArray.add(3);
        customArray.add(8);
        customArray.add(1);

        Comparator<Integer> customComparator = (a, b) -> b - a; // Обратный порядок
        customArray.sort(customComparator);

        assertEquals(8, customArray.get(0).intValue());
        assertEquals(3, customArray.get(1).intValue());
        assertEquals(1, customArray.get(2).intValue());
        assertEquals(-5, customArray.get(3).intValue());
    }


    @Test
    public void testUpdate() {

        customArray.add("apple");
        customArray.add("banana");

        customArray.update(1, "cherry");

        assertEquals("cherry", customArray.get(1));
    }

    @Test
    public void testGetOutOfBounds() {
        assertNull(customArray.get(0));
    }


}