package com.example.treeassignment.util;

public class StringUtils {

    private StringUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String maskString(String input) {
        if (input == null) {
            return "NULL";
        }
        return input.replaceAll(".(?=.{4})", "x");
    }
}