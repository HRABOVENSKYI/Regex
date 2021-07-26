package com.epam.rd.java.basic.practice3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Part2 {

    public static void main(String[] args) {
        System.out.println(convert(Util.getInput("part2.txt")));
    }

    public static String convert(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = input.split("[\\r\\s,'-]+");
        Map<Integer, List<String>> map = Arrays.stream(words)
                .collect(Collectors.groupingBy(String::length));
        Integer minWordLength = map.keySet().stream().min(Integer::compare).get();
        Integer maxWordLength = map.keySet().stream().max(Integer::compare).get();
        return stringBuilder.append("Min: ")
                .append(map.get(minWordLength).stream()
                        .distinct()
                        .collect(Collectors.joining(", ")))
                .append("\n")
                .append("Max: ")
                .append(map.get(maxWordLength).stream()
                        .distinct()
                        .collect(Collectors.joining(", ")))
                .toString();
    }
}
