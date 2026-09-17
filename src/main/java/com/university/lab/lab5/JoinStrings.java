package com.university.lab.lab5;

import java.util.List;


public class JoinStrings {

 
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
