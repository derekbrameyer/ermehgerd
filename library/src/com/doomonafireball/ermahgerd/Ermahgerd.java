package com.doomonafireball.ermahgerd;

import com.google.common.collect.ImmutableMap;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;

/**
 * User: derek Date: 9/30/13 Time: 6:55 PM
 *
 * Ported from http://ermahgerd.jmillerdesign.com/js/filters.js
 */
public class Ermahgerd {

    public static String translate(String text) {
        if (text == null || text.length() == 0) {
            return "STERT TERPIN...";
        }

        text = text.toUpperCase();

        String[] lines = text.split("\\r?\\n");
        ArrayList<String> translatedLines = new ArrayList<String>();

        for (String line : lines) {
            String[] words = line.split(" ");
            ArrayList<String> translatedWords = new ArrayList<String>();

            for (String word : words) {
                // TODO Break each word up into prefix punctuation, word, and suffix punctuation

                translatedWords.add(Ermahgerd.translateWord(word));
            }
            translatedLines.add(StringUtils.join(translatedWords, " "));
        }

        return StringUtils.join(translatedLines, "\n");
    }

    private static String translateWord(String word) {
        // Don't translate short words
        if (word.length() == 1) {
            return word;
        }

        // Handle specific words
        if (SPECIFIC_WORDS_MAP.containsKey(word)) {
            return SPECIFIC_WORDS_MAP.get(word);
        }

        // Before translating, keep a reference of the original word
        String originalWord = word;

        // Drop vowels from ends of words
        if (originalWord.length() > 2) {
            // Keep it for short words, like "WE"
            word = word.replaceAll("[AEIOU]$", "");
        }

        // Reduce duplicate letters
        word = word.replaceAll("[^\\w\\s]|(.)(?=\\1)", "");

        // Reduce adjacent vowels to one
        word = word.replaceAll("[AEIOUY]{2,}", "E"); // TODO: Keep Y as first letter

        // DOWN --> DERN
        word = word.replace("OW", "ER");

        // PANCAKES --> PERNCERKS
        word = word.replaceAll("AKES", "ERKS");

        // The meat and potatoes: replace vowels with ER
        word = word.replaceAll("[AEIOUY]", "ER"); // TODO: Keep Y as first letter

        // OH --> ER
        word = word.replace("ERH", "ER");

        // MY --> MAH
        word = word.replace("MER", "MAH");

        // FALLING --> FALERNG --> FERLIN
        word = word.replace("ERNG", "IN");

        // POOPED --> PERPERD --> PERPED
        word = word.replace("ERPERD", "ERPED");

        // MEME --> MAHM --> MERM
        word = word.replace("MAHM", "MERM");

        // Keep Y as first character
        // YES --> ERS --> YERS
        if (originalWord.charAt(0) == 'Y') {
            word = 'Y' + word;
        }

        // Reduce duplicate letters
        word = word.replaceAll("[^\\w\\s]|(.)(?=\\1)", "");

        // YELLOW --> YERLER --> YERLO
        if (originalWord.endsWith("LOW") && word.endsWith("LER")) {
            word = word.substring(0, word.length() - 3) + "LO";
        }

        return word;
    }

    private static final ImmutableMap<String, String> SPECIFIC_WORDS_MAP = ImmutableMap.<String, String>builder()
            .put("AWESOME", "ERSUM")
            .put("BANANA", "BERNERNER")
            .put("BAYOU", "BERU")
            .put("FAVORITE", "FRAVRIT")
            .put("FAVOURITE", "FRAVRIT")
            .put("GOOSEBUMPS", "GERSBERMS")
            .put("LONG", "LERNG")
            .put("MY", "MAH")
            .put("THE", "DA")
            .put("THEY", "DEY")
            .put("WE\'RE", "WER")
            .put("YOU", "U")
            .put("YOU\'RE", "YER")
            .build();
}
