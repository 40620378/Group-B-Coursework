package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;



public class AppIntegration {

    static Connection connection;

    @BeforeAll
    static void init()
    {
        SingletonConnection connectionManager = SingletonConnection.getInstance();
        connection = connectionManager.connect("jdbc:mysql://localhost:3306/world?useSSL=false");
    }

    @Test
    void testCapitalCity()
    {
        ArrayList<CapitalCity> capitalWorldByPopulation = ReportUtil.capitalWorldByPopulation(connection);
        assertTrue(capitalWorldByPopulation.size() > 0);
        callGenerateMarkdown(capitalWorldByPopulation, "capitalWorldByPopulation");
        File file = new File("./reports/" + "capitalWorldByPopulation");
        assertTrue(file.exists());
    }
    @Test
    void testCity()
    {
        ArrayList<City> citiesWorldByPopulation = ReportUtil.citiesWorldByPopulation(connection);
        assertTrue(citiesWorldByPopulation.size() > 0);
        callGenerateMarkdown(citiesWorldByPopulation, "citiesWorldByPopulation");
        File file = new File("./reports/" + "citiesWorldByPopulation");
        assertTrue(file.exists());
    }
    @Test
    void testCountry()
    {
        ArrayList<Country> Country13WorldByPopulation = ReportUtil.nCountryWorldByPopulation(connection, "13");
        assertTrue(Country13WorldByPopulation.size() > 0);
        callGenerateMarkdown(Country13WorldByPopulation, "Country13WorldByPopulation");
        File file = new File("./reports/" + "Country13WorldByPopulation");
        assertTrue(file.exists());
    }
    @Test
    void testLanguage()
    {
        ArrayList<Language> languageSpeakers = ReportUtil.languagePercentage(connection);
        assertTrue(languageSpeakers.size() > 0);
        callGenerateMarkdown(languageSpeakers, "languageSpeakers");
        File file = new File("./reports/" + "languageSpeakers");
        assertTrue(file.exists());
    }
    @Test
    void testPopulation()
    {
        ArrayList<Population> peopleDistributionContinent = ReportUtil.peopleDistributionContinent(connection);
        assertTrue(peopleDistributionContinent.size() > 0);
        callGenerateMarkdown(peopleDistributionContinent, "peopleDistributionContinent");
        File file = new File("./reports/" + "peopleDistributionContinent");
        assertTrue(file.exists());
    }
    @Test
    void testTotalPopulation()
    {
        ArrayList<Population> totalPopulationWorld = ReportUtil.totalPopulationWorld(connection);
        assertTrue(totalPopulationWorld.size() > 0);
        callGenerateMarkdown(totalPopulationWorld, "totalPopulationWorld");
        File file = new File("./reports/" + "totalPopulationWorld");
        assertTrue(file.exists());
    }



    private static void callGenerateMarkdown(ArrayList<?> result, String name) {
        ArrayList<Object> resultObject = new ArrayList<Object>();
        for(int i = 0; i < result.size(); i++) {
            resultObject.add(result.get(i));
        }
        ReportUtil.generateMarkdown(resultObject, name);
    }

}


