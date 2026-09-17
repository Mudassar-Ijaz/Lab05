package com.university.lab.lab5;

import java.util.List;

/**
 * Lab Task 5 - Declarative vs. Operational Specs
 *
 * Contains two doc comments for the SAME method to contrast a bad,
 * operational specification (describing the internal implementation
 * step by step) against a good, declarative specification (describing
 * only the observable result the client can rely on).
 */
public class JoinStrings {

    /*
     * ================== BAD: OPERATIONAL JAVADOC (for comparison only) ==================
     *
     * joinStrings(words, delimiter):
     *   Creates an empty StringBuilder called result.
     *   Loops over the list "words" using an index variable i from 0 to words.size() - 1.
     *   For each word, appends it to result using result.append(words.get(i)).
     *   Then checks with an if-statement whether i is less than words.size() - 1
     *   (i.e., whether this is NOT the last element in the list).
     *   If it is not the last element, appends the delimiter string to result
     *   using result.append(delimiter), so that a trailing delimiter is never
     *   added after the final word.
     *   After the loop finishes, calls result.toString() and returns it.
     *
     * (This describes HOW the method works internally, step by step, which
     *  ties the client to a specific implementation and is harder to read
     *  than simply knowing what the method produces.)
     */

    /**
     * GOOD: DECLARATIVE JAVADOC.
     *
     * Returns the concatenation of the elements of words, in order, with
     * delimiter inserted between each adjacent pair of elements. Returns
     * the empty string if words is empty.
     *
     * @param words     the list of strings to join, in the order they
     *                  should appear in the result; not modified
     * @param delimiter the string to insert between adjacent elements
     * @return the elements of words joined together with delimiter
     *         between each pair, and no leading or trailing delimiter
     */
    public static String joinStrings(List<String> words, String delimiter) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            result.append(words.get(i));
            if (i < words.size() - 1) {
                result.append(delimiter);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "cherry");
        System.out.println("joinStrings(words, \", \") = " + joinStrings(words, ", "));
        System.out.println("joinStrings([], \"-\")      = \"" + joinStrings(List.of(), "-") + "\"");
        System.out.println("joinStrings([\"solo\"], \",\") = " + joinStrings(List.of("solo"), ","));
    }
}
