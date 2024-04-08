package com.napier.sem;
import java.math.BigDecimal;

/**
 * Contains columns to be returned from language queries
 */
public class Language {
    public String countryCode;
    public String Language;
    public String IsOfficial;
    public BigDecimal percentageCountry;
    /**
     * Returns a string report containing all object values
     * @return concatenated string of all properties
     */
    public String ToString() {
        String result = "Country code: " + countryCode + " Language: " + Language + " IsOfficial: " + IsOfficial + " Percentage: " + percentageCountry;
        return result;
    }
}