package com.university.lab.lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Lab Task 3 - Mutation Contracts
 *
 * Demonstrates the distinction between a method that is explicitly
 * specified to mutate its argument (sortInPlace) and one that must NOT
 * mutate its argument because its specification doesn't say it does
 * (toLowerCase, which returns a new list instead).
 */
public class ListFormatter {

    /**
     * Sorts the given list of strings in place, in natural (alphabetical)
     * order. This method MUTATES its argument — the specification
     * explicitly says so via the method name and this doc comment.
     *
     * @param lst the list to sort; modified by this call
     */
    public static void sortInPlace(List<String> lst) {
        Collections.sort(lst);
    }

    /**
     * Returns a NEW list containing lowercase versions of every string in
     * lst, in the same order. The original list lst is left completely
     * unchanged — this method has no side effects on its input, since
     * nothing in its specification says it mutates the argument.
     *
     * @param lst the list to read from; not modified by this call
     * @return a new list with each element converted to lowercase
     */
    public static List<String> toLowerCase(List<String> lst) {
        List<String> result = new ArrayList<>();
        for (String s : lst) {
            result.add(s.toLowerCase());
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Charlie", "Alice", "Bob"));
        System.out.println("Before sortInPlace: " + names);
        sortInPlace(names);
        System.out.println("After sortInPlace (mutated): " + names);

        List<String> mixedCase = new ArrayList<>(List.of("HELLO", "World", "JAVA"));
        List<String> lower = toLowerCase(mixedCase);
        System.out.println("\nOriginal list (unchanged): " + mixedCase);
        System.out.println("New lowercase list: " + lower);
        System.out.println("Original list untouched? " + mixedCase.equals(List.of("HELLO", "World", "JAVA")));
    }
}
