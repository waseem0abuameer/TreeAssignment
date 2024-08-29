package com.example.treeassignment.util;

public class StringUtils {
    public static String maskString(String input) {

        if(input == null) {
            return "NULL";
        }
        return input.replaceAll(".(?=.{4})", "x");
    }
}
