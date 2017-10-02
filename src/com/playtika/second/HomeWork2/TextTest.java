package com.playtika.second.HomeWork2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class TextTest {
    Text text = new Text("Я считываю текст в строку % *.");

    Text textWitDublicates = new Text("Я считываю текст в строку, Я считываю текст");

    private ArrayList<String> testedText() {
        ArrayList<String> testedText = new ArrayList<>();
        testedText.add("в");
        testedText.add("строку");
        testedText.add("считываю");
        testedText.add("текст");
        testedText.add("я");
        return testedText;
    }

    @Test(expected = NullPointerException.class)
    public void nullTextCouldNotBeProcessed() {
        new Text(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void punctuationCouldNotBeProcessed() {
        new Text(" ,....!").getTopWords(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void symbolsCouldNotBeProcessed() {
        new Text("&^(()^&%*^^^*(*()@#)").getTopWords(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyTextCouldNotBeProcessed() {
        new Text("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTopWordCouldNotBeProcessedZero() {
        text.getTopWords(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTopWordCouldNotBeProcessedNegativeCount() {
        text.getTopWords(-15);
    }

    @Test
    public void getTopWordsReturnedCorrectWordsAndOder() throws Exception {
        assertEquals(testedText(), text.getTopWords(5));
    }
    @Test
    public void getWordsFrequenciesForApperCaseSymbols() {
        Text textApperCase = new Text("StrinG IntEGeR DouBlE ");
        ArrayList<String> testedTextApperCase = new ArrayList<>();
        testedTextApperCase.add("double");
        testedTextApperCase.add("integer");
        testedTextApperCase.add("string");
        assertEquals(testedTextApperCase,textApperCase.getTopWords(3));
    }

    @Test
    public void getTopWordsReturnedCorrectResultFromTextWithDublicates() throws Exception {
        assertEquals(testedText(), textWitDublicates.getTopWords(5));
    }

    @Test
    public void getWordsFrequenciesReturnedCorrectAmountWordsFrequency() {
        HashMap<String, Integer> testWordFrequencies = new HashMap<>();
        testWordFrequencies.put("я", 2);
        testWordFrequencies.put("в", 1);
        testWordFrequencies.put("строку", 1);
        testWordFrequencies.put("считываю", 2);
        testWordFrequencies.put("текст", 2);
        assertEquals(testWordFrequencies, textWitDublicates.getWordsFrequencies());
    }

    @Test
    public void getLengthInCharsReturnTotalEmountOfChars() {
        assertEquals(21, text.getLengthInChars());
    }


}


