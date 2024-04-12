package com.napier.sem;
import java.math.BigDecimal;

/**
 * Contains columns to be returned from language queries
 */
public class Language {
    public String Language;
    public int noOfSpeakers;
    public double percentWorldPop;

    /**
     * Returns a string report containing all object values
     * @return concatenated string of all properties
     */
    public String ToString() {
        String result = "Language: " + Language + " noOfSpeakers: " + noOfSpeakers + " percentWorldPop: " + percentWorldPop + "%";
        return result;
    }

    public String ToRow() {
        String result = "| " + Language + " | " + noOfSpeakers + " | " + percentWorldPop + "% |\r\n";
        return result;
    }
}