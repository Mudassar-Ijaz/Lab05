package com.university.lab.lab5;

/**
 * Lab Task 1 - Behavioral Equivalence
 *
 * Demonstrates how two different implementations can satisfy different
 * specifications while both being "correct" with respect to their own
 * contract, and how the client's needs determine whether they are
 * actually interchangeable.
 */
public class SearchStrategies {

    /**
     * Searches forward through the array and returns the index of the
     * FIRST occurrence of val.
     *
     * @param arr the array to search (not modified)
     * @param val the value to search for
     * @return the index of the first matching element, or arr.length if
     *         val does not appear in arr
     */
    public static int findFirst(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return arr.length;
    }

    /**
     * Searches backward through the array and returns the index of the
     * LAST occurrence of val.
     *
     * @param arr the array to search (not modified)
     * @param val the value to search for
     * @return the index of the last matching element, or -1 if val does
     *         not appear in arr
     */
    public static int findLast(int[] arr, int val) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] noDuplicates = {10, 20, 30, 40};
        int[] withDuplicates = {5, 8, 8, 8, 2};
        int[] missingValue = {1, 2, 3};

        System.out.println("=== Case: value appears exactly once (both agree) ===");
        System.out.println("findFirst(noDuplicates, 30) = " + findFirst(noDuplicates, 30));
        System.out.println("findLast(noDuplicates, 30)  = " + findLast(noDuplicates, 30));

        System.out.println("\n=== Case: value has duplicates (results differ) ===");
        System.out.println("findFirst(withDuplicates, 8) = " + findFirst(withDuplicates, 8));
        System.out.println("findLast(withDuplicates, 8)  = " + findLast(withDuplicates, 8));

        System.out.println("\n=== Case: value missing (different 'not found' conventions) ===");
        System.out.println("findFirst(missingValue, 99) = " + findFirst(missingValue, 99)
                + " (returns arr.length)");
        System.out.println("findLast(missingValue, 99)  = " + findLast(missingValue, 99)
                + " (returns -1)");
    }
}
