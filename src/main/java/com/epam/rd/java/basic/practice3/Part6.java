package com.epam.rd.java.basic.practice3;

import java.util.*;
import java.util.stream.Collectors;

public class Part6 {

    public static void main(String[] args) {
        System.out.println(convert(Util.getInput("part6.txt")));
    }

    public static String convert(String input) {
        String[] lines = input.split(System.lineSeparator());

        String[] words = input.split("[\\r\\s]+");
        List<String> wordsList = Arrays.asList(words);
        Set<String> duplicates = wordsList.stream()
                .filter(word -> Collections.frequency(wordsList, word) > 1)
                .collect(Collectors.toSet());
        for (String word : duplicates) {
            input = input.replaceAll( "\\b"+ word + "\\b", "_" + word + " ");
        }
        return input;
    }
}
