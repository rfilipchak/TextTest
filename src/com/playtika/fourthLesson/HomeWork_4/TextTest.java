package com.playtika.fourthLesson.HomeWork_4;

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
        assertThat((new Text(" ,....!").getTopWords(5)), is(emptyCollectionOf(String.class)));
    }

    @Test
    public void invisibleSymbolsProcessedLikeEmptyCollection() {
        assertThat((new Text("\\\n\\\t\\\f\\\r").getTopWords(5)), is(emptyCollectionOf(String.class)));
    }

    @Test
    public void symbolsProcessedLikeEmptyCollection() {
        assertThat((new Text("&^(()^&%*^^^*(*()@#)").getTopWords(5)), is(emptyCollectionOf(String.class)));
    }

    @Test
    public void emptyTextProcessedLikeEmptyCollection() {
        assertThat(new Text("").getTopWords(5), is(empty()));
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

        assertThat(text.getTopWords(5), is(Arrays.asList("в", "строку", "считываю", "текст", "я")));
    }

    @Test
    public void getWordsFrequenciesForApperCaseSymbols() {
        assertThat(new Text("StrinG IntEGeR DouBlE ").getTopWords(3),
                is(Arrays.asList("double", "integer", "string")));
    }

    @Test
    public void getTopWordsReturnedCorrectResultFromTextWithDublicates() throws Exception {
        assertThat(new Text("Я считываю текст в строку, Я считываю текст").getTopWords(5)
                , is(Arrays.asList("в", "строку", "считываю", "текст", "я")));
    }

    @Test
    public void getWordsFrequenciesReturnedCorrectAmountWordsFrequency() {
        Map<String, Long> testWordFrequencies = new HashMap<>();
        testWordFrequencies.put("я", 2L);
        testWordFrequencies.put("в", 1L);
        testWordFrequencies.put("строку", 1L);
        testWordFrequencies.put("считываю", 2L);
        testWordFrequencies.put("текст", 2L);
        assertThat(textWitDublicates.getWordsFrequencies(), is(testWordFrequencies));
    }

    @Test
    public void getTopWordsProcessedMoreThanMaxLimitOfWordsAsMax() throws Exception {
        int highestLimit = 1000;
        assertThat(new Text("Я считываю текст в строку, Я считываю текст").getTopWords(highestLimit)
                , is(Arrays.asList("в", "строку", "считываю", "текст", "я")));
    }

    @Test
    public void getLengthInCharsReturnTotalEmountOfChars() {
        assertThat(text.getLengthInChars(), is(21));
    }

    @Test
    public void getLengthForEmptyTextEqualZero() {
        assertThat(new Text("").getLengthInChars(), equalTo(0));
    }
}


