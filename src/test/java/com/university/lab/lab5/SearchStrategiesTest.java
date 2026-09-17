package com.university.lab.lab5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SearchStrategiesTest {

    @Test
    public void testResultsDifferWithDuplicates() {
        int[] arr = {5, 8, 8, 8, 2};
        int first = SearchStrategies.findFirst(arr, 8);
        int last = SearchStrategies.findLast(arr, 8);
        assertEquals(1, first);
        assertEquals(3, last);
        assertNotEquals(first, last, "findFirst and findLast should differ when duplicates exist");
    }

    @Test
    public void testResultsAgreeWhenValueAppearsOnce() {
        int[] arr = {10, 20, 30, 40};
        int first = SearchStrategies.findFirst(arr, 30);
        int last = SearchStrategies.findLast(arr, 30);
        assertEquals(2, first);
        assertEquals(2, last);
        assertEquals(first, last, "Both methods should agree when the value appears exactly once");
    }

    @Test
    public void testDifferentNotFoundConventions() {
        int[] arr = {1, 2, 3};
        assertEquals(arr.length, SearchStrategies.findFirst(arr, 99));
        assertEquals(-1, SearchStrategies.findLast(arr, 99));
    }
}
