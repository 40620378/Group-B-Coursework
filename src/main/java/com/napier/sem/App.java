package com.napier.sem;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;

/**
 * Entrypoint of program
 */
public class App
{
    /**
     * Connects to DB and gets result of a report.
     * @param args
     */
    public static void main(String[] args)
    {
        //get instance of SingletonConnection class
        SingletonConnection connectionManager = SingletonConnection.getInstance();
        Connection connection = connectionManager.connect();

        System.out.println("Countries By Population");
        ArrayList<Country> countryWorldByPopulation = ReportUtil.countryWorldByPopulation(connection);
        callGenerateMarkdown(countryWorldByPopulation, "countryWorldByPopulation");
        ArrayList<Country> countryEuropeByPopulation = ReportUtil.countryContinentByPopulation(connection, "Europe");
        callGenerateMarkdown(countryEuropeByPopulation, "countryEuropeByPopulation");
        ArrayList<Country> countryBritishIslandsByPopulation = ReportUtil.countryRegionByPopulation(connection, "British Islands");
        callGenerateMarkdown(countryBritishIslandsByPopulation, "countryBritishIslandsByPopulation");

        System.out.println("Top N Countries By Population");
        ArrayList<Country> nCountryWorldByPopulation = ReportUtil.nCountryWorldByPopulation(connection, "13");
        callGenerateMarkdown(nCountryWorldByPopulation, "nCountryWorldByPopulation");
        ArrayList<Country> country16EuropeByPopulation = ReportUtil.nCountryContinentByPopulation(connection, "Europe", "16");
        callGenerateMarkdown(country16EuropeByPopulation, "country16EuropeByPopulation");
        ArrayList<Country> Country3BritishIslandsByPopulation = ReportUtil.nCountryRegionByPopulation(connection, "British Islands", "3");
        callGenerateMarkdown(Country3BritishIslandsByPopulation, "Country3BritishIslandsByPopulation");

        System.out.println("Top Cities By Population");
        ArrayList<City> citiesWorldByPopulation = ReportUtil.citiesWorldByPopulation(connection);
        callGenerateMarkdown(citiesWorldByPopulation, "citiesWorldByPopulation");
        ArrayList<City> citiesAfricaByPopulation = ReportUtil.citiesContinentByPopulation(connection, "Africa");
        callGenerateMarkdown(citiesAfricaByPopulation, "citiesAfricaByPopulation");
        ArrayList<City> citiesEasternAfricaByPopulation = ReportUtil.citiesRegionByPopulation(connection, "Eastern Africa");
        callGenerateMarkdown(citiesEasternAfricaByPopulation, "citiesEasternAfricaByPopulation");
        ArrayList<City> citiesEthiopiaByPopulation = ReportUtil.citiesCountryByPopulation(connection, "Ethiopia");
        callGenerateMarkdown(citiesEthiopiaByPopulation, "citiesEthiopiaByPopulation");
        ArrayList<City> citiesAmharaByPopulation = ReportUtil.citiesDistrictByPopulation(connection, "Amhara");
        callGenerateMarkdown(citiesAmharaByPopulation, "citiesAmharaByPopulation");

        System.out.println("Top N Cities By Population");
        ArrayList<City> cities13WorldByPopulation = ReportUtil.nCitiesWorldByPopulation(connection, "13");
        callGenerateMarkdown(cities13WorldByPopulation, "cities13WorldByPopulation");
        ArrayList<City> cities19AfricaByPopulation = ReportUtil.nCitiesContinentByPopulation(connection, "Africa", "19");
        callGenerateMarkdown(cities19AfricaByPopulation, "cities19AfricaByPopulation");
        ArrayList<City> cities9EasternAfricaByPopulation = ReportUtil.nCitiesRegionByPopulation(connection, "Eastern Africa", "9");
        callGenerateMarkdown(cities9EasternAfricaByPopulation, "cities9EasternAfricaByPopulation");
        ArrayList<City> cities4EthiopiaByPopulation = ReportUtil.nCitiesCountryByPopulation(connection, "Ethiopia", "4");
        callGenerateMarkdown(cities4EthiopiaByPopulation, "cities4EthiopiaByPopulation");
        ArrayList<City> cities2AmharaByPopulation = ReportUtil.nCitiesDistrictByPopulation(connection, "Amhara", "2");
        callGenerateMarkdown(cities2AmharaByPopulation, "cities2AmharaByPopulation");

        System.out.println("Top Capital Cities By Population");
        ArrayList<CapitalCity> capitalWorldByPopulation = ReportUtil.capitalWorldByPopulation(connection);
        callGenerateMarkdown(capitalWorldByPopulation, "capitalWorldByPopulation");
        ArrayList<CapitalCity> capitalEuropeByPopulation = ReportUtil.capitalContinentByPopulation(connection, "Europe");
        callGenerateMarkdown(capitalEuropeByPopulation, "capitalEuropeByPopulation");
        ArrayList<CapitalCity> capitalBritishIslandsByPopulation = ReportUtil.capitalRegionByPopulation(connection, "British Islands");
        callGenerateMarkdown(capitalBritishIslandsByPopulation, "capitalBritishIslandsByPopulation");

        System.out.println("Top N Capital Cities By Population");
        ArrayList<CapitalCity> capital13WorldByPopulation = ReportUtil.nCapitalWorldByPopulation(connection, "13");
        callGenerateMarkdown(capital13WorldByPopulation, "capital13WorldByPopulation");
        ArrayList<CapitalCity> capital19EuropeByPopulation = ReportUtil.nCapitalContinentByPopulation(connection, "Europe", "19");
        callGenerateMarkdown(capital19EuropeByPopulation, "capital19EuropeByPopulation");
        ArrayList<CapitalCity> capital4BritishIslandsByPopulation = ReportUtil.nCapitalRegionByPopulation(connection, "British Islands", "4");
        callGenerateMarkdown(capital4BritishIslandsByPopulation, "capital4BritishIslandsByPopulation");

        System.out.println("People Distribution");
        ArrayList<Population> peopleDistributionContinent = ReportUtil.peopleDistributionContinent(connection);
        callGenerateMarkdown(peopleDistributionContinent, "peopleDistributionContinent");
        ArrayList<Population> peopleDistributionRegion = ReportUtil.peopleDistributionRegion(connection);
        callGenerateMarkdown(peopleDistributionRegion, "peopleDistributionRegion");
        ArrayList<Population> peopleDistributionCountry = ReportUtil.peopleDistributionCountry(connection);
        callGenerateMarkdown(peopleDistributionCountry, "peopleDistributionCountry");

        System.out.println("Total Populations");
        ArrayList<Population> totalPopulationWorld = ReportUtil.totalPopulationWorld(connection);
        callGenerateMarkdown(totalPopulationWorld, "totalPopulationWorld");
        ArrayList<Population> totalPopulationEurope = ReportUtil.totalPopulationContinent(connection, "Europe");
        callGenerateMarkdown(totalPopulationEurope, "totalPopulationEurope");
        ArrayList<Population> totalPopulationBritishIslands = ReportUtil.totalPopulationRegion(connection, "British Islands");
        callGenerateMarkdown(totalPopulationBritishIslands, "totalPopulationBritishIslands");
        ArrayList<Population> totalPopulationUnitedKingdom = ReportUtil.totalPopulationCountry(connection, "United Kingdom");
        callGenerateMarkdown(totalPopulationUnitedKingdom, "totalPopulationUnitedKingdom");
        ArrayList<Population> totalPopulationScotland = ReportUtil.totalPopulationDistrict(connection, "Scotland");
        callGenerateMarkdown(totalPopulationScotland, "totalPopulationScotland");
        ArrayList<Population> totalPopulationEdinburgh = ReportUtil.totalPopulationCity(connection, "Edinburgh");
        callGenerateMarkdown(totalPopulationEdinburgh, "totalPopulationEdinburgh");

        System.out.println("Language Speakers");
        ArrayList<Language> languageSpeakers = ReportUtil.languagePercentage(connection);
        callGenerateMarkdown(languageSpeakers, "languageSpeakers");
   
        connectionManager.disconnect();
    }

    private static void callGenerateMarkdown(ArrayList<?> result, String name) {
        ArrayList<Object> resultObject = new ArrayList<Object>();
        for(int i = 0; i < result.size(); i++) {
            resultObject.add(result.get(i));
        }
        ReportUtil.generateMarkdown(resultObject, name);
    }
}
