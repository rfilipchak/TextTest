package com.playtika.second.HomeWork2;

import java.util.*;
import java.util.stream.Collectors;

public class Text {

    private String text;


    public Text(String text) {

        if (text.equals("")) {
            throw new IllegalArgumentException("Text can't be empty");
        } else if (text.equals(null)) {
            throw new NullPointerException(" Text can't be NULL");
        } else {
            this.text = text;
        }
    }

    public List<String> getTopWords(int wordCount) {
        if (wordCount <= 0) {
            throw new IllegalArgumentException(" Incorrect word counter <= 0");
        }
        TreeSet<String> uniqueWords = new TreeSet<String>();
        for (int i = 0; i < wordsCollection().size(); i++) {
            uniqueWords.add(wordsCollection().get(i));
        }
        //        wordsCollection().forEach(a->uniqueWords.add(a));
        int current = 0;
        List<String> result = new ArrayList<>();
        for (String word : uniqueWords) {
            result.add(word);
            current++;
            if (current == wordCount) {
                break;
            }
        }
//        List<String> result = uniqueWords.stream().limit(wordCount).collect(Collectors.toList());
        return result;
    }

    public Map<String, Integer> getWordsFrequencies() {
        HashMap<String, Integer> wordsFrequency = new HashMap<>();
        List<String> topWords = getTopWords(wordsCollection().size());

        for (String word : topWords) {
            int count = 0;
            for (int i = 0; i < wordsCollection().size(); i++) {
                if (word.equals(wordsCollection().get(i))) {
                    count++;
                }
            }
            wordsFrequency.put(word, count);
        }
        return wordsFrequency;
    }

    public int getLengthInChars() {
        int totaWordsSumm = 0;
        for (String word : wordsCollection()) {
            totaWordsSumm += word.length();
        }
        return totaWordsSumm;
    }

    private List<String> wordsCollection() {
        List<String> words = Arrays.asList(text.toLowerCase().trim().split("[^a-zA-Z0-9а-яА-Я]+"));//[\s,.!?\t\n]+

        for (String word : words) {
            if (word.equals("")) {
                throw new IllegalArgumentException(" Text can't be punctuation or symbols");
            }
        }
        if (words.isEmpty()){
            throw new IllegalArgumentException(" Text can't be punctuation or symbols");
        }else {
            return words;
        }
    }


}
