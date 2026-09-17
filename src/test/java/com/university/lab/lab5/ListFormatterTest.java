package com.university.lab.lab5;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ListFormatterTest {

    @Test
    public void testSortInPlaceMutatesOriginalList() {
        List<String> names = new ArrayList<>(List.of("Charlie", "Alice", "Bob"));
        ListFormatter.sortInPlace(names);
        assertEquals(List.of("Alice", "Bob", "Charlie"), names);
    }

    @Test
    public void testToLowerCaseDoesNotMutateOriginal() {
        List<String> original = new ArrayList<>(List.of("HELLO", "World", "JAVA"));
        List<String> snapshot = new ArrayList<>(original);

        List<String> lower = ListFormatter.toLowerCase(original);

        assertEquals(snapshot, original, "Original list must remain unchanged");
        assertEquals(List.of("hello", "world", "java"), lower);
    }

    @Test
    public void testToLowerCaseReturnsNewListInstance() {
        List<String> original = new ArrayList<>(List.of("ABC"));
        List<String> lower = ListFormatter.toLowerCase(original);
        assertNotSame(original, lower);
    }
}
