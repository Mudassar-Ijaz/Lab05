package com.university.lab.lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ListFormatter {

  
    public static void sortInPlace(List<String> lst) {
        Collections.sort(lst);
    }

 
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
