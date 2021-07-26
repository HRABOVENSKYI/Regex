package com.epam.rd.java.basic.practice3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Part1 {

    public static void main(String[] args) {
        String fileName = "part1.txt";
        System.out.println(convert1(Util.getInput(fileName)));
        System.out.println(convert2(Util.getInput(fileName)));
        System.out.println(convert3(Util.getInput(fileName)));
        System.out.println(convert4(Util.getInput(fileName)));
    }

    public static String convert1(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("(.+);(.+);(.+@.+)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            stringBuilder.append(matcher.group(1))
                    .append(": ")
                    .append(matcher.group(3))
                    .append("\n");
        }
        return stringBuilder.toString();
    }

    public static String convert2(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("(.+);(.+\\s.+);(.+)@(.+)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            stringBuilder.append(matcher.group(2))
                    .append(" (email: ")
                    .append(matcher.group(3))
                    .append(")")
                    .append("\n");
        }
        return stringBuilder.toString();
    }

    public static String convert3(String input) {
        Map<String, List<String>> domainsLogins = new HashMap<>();
        Pattern pattern = Pattern.compile("(.+);(.+\\s.+);(.+)@(.+)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String domain = matcher.group(4);
            String login = matcher.group(1);
            if (domainsLogins.containsKey(domain)) {
                domainsLogins.get(domain).add(login);
            } else {
                domainsLogins.put(domain, new ArrayList<>(Arrays.asList(login)));
            }
        }

        return domainsLogins.entrySet().stream()
                .map(stringListEntry -> stringListEntry.getKey() + " ==> " + stringListEntry.getValue().toString()
                                .substring(1, stringListEntry.getValue().toString().length() - 1) + "\n")
                .collect(Collectors.joining());
    }

    public static String convert4(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("(.+;.+;.+)");
        Matcher matcher = pattern.matcher(input);
        matcher.find();
        stringBuilder.append(matcher.group(1))
                .append(";Password\n");
        pattern = Pattern.compile("(.+;.+;.+@.+)");
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            stringBuilder.append(matcher.group())
                    .append(";")
                    .append(getPassword())
                    .append("\n");
        }
        return stringBuilder.toString();
    }

    public static String getPassword() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }
}
