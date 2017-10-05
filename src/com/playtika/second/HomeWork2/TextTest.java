package com.playtika.second.HomeWork2;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class TextTest {
    Text text = new Text("Я считываю текст в строку % *.");
    Text textWitDublicates = new Text("Я считываю текст в строку, Я считываю текст");

    @Test(expected = NullPointerException.class)
    public void nullTextCouldNotBeProcessed() {
        new Text(null);
    }

    @Test
    public void punctuationProcessedLikeEmptyCollection() {
        //new Text(" ,....!").getTopWords(5);
        assertThat((new Text(" ,....!").getTopWords(5)),is(emptyCollectionOf(String.class)));
    }

    @Test
    public void invisibleSymbolsProcessedLikeEmptyCollection() {
       assertThat((new Text("\\\n\\\t\\\f\\\r").getTopWords(5)),is(emptyCollectionOf(String.class)));
    }

    @Test
    public void symbolsProcessedLikeEmptyCollection() {
        //new Text("&^(()^&%*^^^*(*()@#)").getTopWords(5);
        assertThat((new Text("&^(()^&%*^^^*(*()@#)").getTopWords(5)),is(emptyCollectionOf(String.class)));
    }

    @Test
    public void emptyTextProcessedLikeEmptyCollection() {
        assertThat(new Text("").getTopWords(5),is(empty()));
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
//        List<String> testedText = new ArrayList<>();
//        testedText.add("в");
//        testedText.add("строку");
//        testedText.add("считываю");
//        testedText.add("текст");
//        testedText.add("я");
//        assertEquals(testedText, text.getTopWords(5));
        assertThat(text.getTopWords(5), is(Arrays.asList("в","строку","считываю","текст","я")));
    }

    @Test
    public void getWordsFrequenciesForApperCaseSymbols() {
//        Text textApperCase = new Text("StrinG IntEGeR DouBlE ");
//        ArrayList<String> testedTextApperCase = new ArrayList<>();
//        testedTextApperCase.add("double");
//        testedTextApperCase.add("integer");
//        testedTextApperCase.add("string");
//        assertEquals(testedTextApperCase, textApperCase.getTopWords(3));
        assertThat(new Text("StrinG IntEGeR DouBlE ").getTopWords(3),is(Arrays.asList("double","integer","string")));
    }

    @Test
    public void getTopWordsReturnedCorrectResultFromTextWithDublicates() throws Exception {
//        ArrayList<String> testedText = new ArrayList<>();
//        testedText.add("в");
//        testedText.add("строку");
//        testedText.add("считываю");
//        testedText.add("текст");
//        testedText.add("я");
//        assertEquals(testedText, textWitDublicates.getTopWords(5));
//        assertThat(new Text("Я считываю текст в строку, Я считываю текст").getTopWords(5)
//                ,hasItems("в","строку","считываю","текст","я"));
        assertThat(new Text("Я считываю текст в строку, Я считываю текст").getTopWords(5)
                ,is(Arrays.asList("в","строку","считываю","текст","я")));
    }

    @Test
    public void getWordsFrequenciesReturnedCorrectAmountWordsFrequency() {
        Map<String, Integer> testWordFrequencies = new HashMap<>();
        testWordFrequencies.put("я", 2);
        testWordFrequencies.put("в", 1);
        testWordFrequencies.put("строку", 1);
        testWordFrequencies.put("считываю", 2);
        testWordFrequencies.put("текст", 2);
        //assertEquals(testWordFrequencies, textWitDublicates.getWordsFrequencies());
        assertThat(textWitDublicates.getWordsFrequencies(),is(testWordFrequencies) );
    }
    @Test
    public void getTopWordsProcessedMoreThanMaxLimitOfWordsAsMax() throws Exception {
        int highestLimit = 1000;
        assertThat(new Text("Я считываю текст в строку, Я считываю текст").getTopWords(highestLimit)
                ,is(Arrays.asList("в","строку","считываю","текст","я")));
    }

    @Test
    public void getLengthInCharsReturnTotalEmountOfChars() {
        //assertEquals(21, text.getLengthInChars());
        assertThat(text.getLengthInChars(),is(21));
    }
    @Test
    public void getLengthForEmptyTextEqualZero(){
        assertThat(new Text("").getLengthInChars(),equalTo(0));
    }
}


