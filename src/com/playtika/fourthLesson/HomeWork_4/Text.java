package com.playtika.fourthLesson.HomeWork_4;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Text {

    private final String text;

    public Text(String text) {

        if (text.equals(null)) {
            throw new NullPointerException(" Text can't be NULL");
        } else {
            this.text = text;
        }
    }

    public List<String> getTopWords(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException(" Incorrect word counter <= 0");
        }
        Set<String> uniqueWords = new TreeSet<>(wordsCollection());
        return uniqueWords.stream().limit(limit).collect(toList());
    }

    public Map<String, Long> getWordsFrequencies() {
        if (wordsCollection().size() == 0) {
            throw new IllegalArgumentException("Can't count getWordsFrequencies() for empty collection");
        }
        return wordsCollection().stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public int getLengthInChars() {
        return wordsCollection().stream().mapToInt(String::length).sum();
    }

    private List<String> wordsCollection() {
        Pattern pattern = Pattern.compile("([a-zA-Z0-9а-яА-Я]+)");
        Matcher matcher = pattern.matcher(text.toLowerCase());
        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }
}
