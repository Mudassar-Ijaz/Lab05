package com.university.lab.lab5;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class JoinStringsTest {

    @Test
    public void testJoinMultipleWords() {
        List<String> words = List.of("apple", "banana", "cherry");
        assertEquals("apple, banana, cherry", JoinStrings.joinStrings(words, ", "));
    }

    @Test
    public void testJoinEmptyListReturnsEmptyString() {
        assertEquals("", JoinStrings.joinStrings(List.of(), "-"));
    }

    @Test
    public void testJoinSingleWordHasNoDelimiter() {
        assertEquals("solo", JoinStrings.joinStrings(List.of("solo"), ","));
    }

    @Test
    public void testNoTrailingDelimiter() {
        String result = JoinStrings.joinStrings(List.of("a", "b"), "-");
        assertFalse(result.endsWith("-"));
        assertEquals("a-b", result);
    }
}
