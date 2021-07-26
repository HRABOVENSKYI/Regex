package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    public static void main(String[] args) {
        System.out.println(convert(Util.getInput("part3.txt")));
    }

    public static String convert(String input) {
        Pattern pattern = Pattern.compile("\\b\\w{3,}\\b");
        Matcher matcher = pattern.matcher(input);

        return matcher.replaceAll(match -> {
            StringBuilder sb = new StringBuilder();
            String w = match.group();
            if (Character.isUpperCase(w.charAt(0))) {
                sb.append(Character.toLowerCase(w.charAt(0)));
            } else {
                sb.append(Character.toUpperCase(w.charAt(0)));
            }
            sb.append(w.substring(1));
            return sb.toString();
        });
    }
}

