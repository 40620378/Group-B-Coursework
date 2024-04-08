package com.napier.sem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.math.BigDecimal;

/**
 * Contains methods to generate reports based on queries located in the resources directory.
 */
public class ReportUtil {
    /**
     * Generates a report for the overall population as well as those that live in a city and don't within a country.
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<Population> peopleDistributionCountry(Connection connection){
        ArrayList<Population> result = new ArrayList<Population>();
        try {
            String[] params = {};
            ResultSet resultSet = SQLUtil.run(connection, "peopleDistributionCountry.sql", params);
            while (resultSet.next()) {
                Population pop = new Population();
                pop.reportName = resultSet.getString("reportName");
                pop.totalCity = resultSet.getInt("totalCity");
                pop.totalPopulation = resultSet.getInt("totalPopulation");
                pop.totalNotCity = resultSet.getInt("totalNotCity");
                pop.percentageCity = roundedPercentage(pop.totalCity, pop.totalPopulation);
                pop.percentageNotCity = roundedPercentage(pop.totalNotCity, pop.totalPopulation);
                result.add(pop);
            }
            resultSet.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
        return result;
    }

    /**
     * Generates a report for the countries in a continent sorted from largest population to smallest.
     * @param connection the connection to the database
     * @param continent the specified continent
     * @return
     */
    public static ArrayList<Country> continentByPopulation(Connection connection, String continent){
        ArrayList<Country> result = new ArrayList<Country>();
        try {
            String[] params = {continent};
            ResultSet resultSet = SQLUtil.run(connection, "continentByPopulation.sql", params);
            while (resultSet.next()) {
                Country country = new Country();
                country.code = resultSet.getString("Code");
                country.name = resultSet.getString("Name");
                country.continent = resultSet.getString("Continent");
                country.population = resultSet.getString("Population");
                country.region = resultSet.getString("Region");
                country.capital = resultSet.getString("Capital");
                result.add(country);
            }
            resultSet.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
        return result;
    }

    /**
     * Generates a report for the countries in the world sorted from largest population to smallest.
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<Country> worldByPopulation(Connection connection){
        ArrayList<Country> result = new ArrayList<Country>();
        try {
            String[] params = {};
            ResultSet resultSet = SQLUtil.run(connection, "worldByPopulation.sql", params);
            while (resultSet.next()) {
                Country country = new Country();
                country.code = resultSet.getString("Code");
                country.name = resultSet.getString("Name");
                country.continent = resultSet.getString("Continent");
                country.population = resultSet.getString("Population");
                country.region = resultSet.getString("Region");
                country.capital = resultSet.getString("Capital");
                result.add(country);
            }
            resultSet.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
        return result;
    }
    /**
     * Generates a report for the countries in a region sorted from largest population to smallest.
     * @param connection the connection to the database
     * @param region the specified region
     * @return
     */
    public static ArrayList<Country> regionByPopulation(Connection connection, String region){
        ArrayList<Country> result = new ArrayList<Country>();
        try {
            String[] params = {region};
            ResultSet resultSet = SQLUtil.run(connection, "regionByPopulation.sql", params);
            while (resultSet.next()) {
                Country country = new Country();
                country.code = resultSet.getString("Code");
                country.name = resultSet.getString("Name");
                country.continent = resultSet.getString("Continent");
                country.population = resultSet.getString("Population");
                country.region = resultSet.getString("Region");
                country.capital = resultSet.getString("Capital");
                result.add(country);
            }
            resultSet.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
        return result;
    }

    /**
     * Generates a report for the capital cities in the world sorted from largest population to smallest.
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<CapitalCity> capitalWorldByPopulation(Connection connection){
        ArrayList<CapitalCity> result = new ArrayList<CapitalCity>();
        try {
            String[] params = {};
            ResultSet resultSet = SQLUtil.run(connection, "capitalWorldByPopulation.sql", params);
            while (resultSet.next()) {
                CapitalCity capitalCity = new CapitalCity();
                capitalCity.country = resultSet.getString("Name");
                capitalCity.population = resultSet.getString("Population");
                capitalCity.name = resultSet.getString("Capital");
                result.add(capitalCity);
            }
            resultSet.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
        return result;
    }

    /**
     * Generates a report for the capital cities in a continent sorted from largest population to smallest.
     * @param connection the connection to the database
     * @param continent the specified continent
     * @return
     */
    public static ArrayList<CapitalCity> capitalContinentByPopulation(Connection connection, String continent){
        ArrayList<CapitalCity> result = new ArrayList<CapitalCity>();
        try {
            String[] params = {"#Continent", continent};
            ResultSet resultSet = SQLUtil.run(connection, "capitalByPopulation.sql", params);
            while (resultSet.next()) {
                CapitalCity capitalCity = new CapitalCity();
                capitalCity.country = resultSet.getString("Name");
                capitalCity.population = resultSet.getString("Population");
                capitalCity.name = resultSet.getString("Capital");
                result.add(capitalCity);
            }
            resultSet.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
        return result;
    }

    /**
     * Generates a report for the capital cities in a region sorted from largest population to smallest.
     * @param connection the connection to the database
     * @param region the specified region
     * @return
     */
    public static ArrayList<CapitalCity> capitalRegionByPopulation(Connection connection, String region){
        ArrayList<CapitalCity> result = new ArrayList<CapitalCity>();
        try {
            String[] params = {"#Region", region};
            ResultSet resultSet = SQLUtil.run(connection, "capitalByPopulation.sql", params);
            while (resultSet.next()) {
                CapitalCity capitalCity = new CapitalCity();
                capitalCity.country = resultSet.getString("Name");
                capitalCity.population = resultSet.getString("Population");
                capitalCity.name = resultSet.getString("Capital");
                result.add(capitalCity);
            }
            resultSet.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
        return result;
    }

    /**
     * Generates a report for the N populated capital cities in the world where N is provided by the user.
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<CapitalCity> nCapitalWorldByPopulation(Connection connection, String N){
        ArrayList<CapitalCity> result = new ArrayList<CapitalCity>();
        try {
            String[] params = {N};
            ResultSet resultSet = SQLUtil.run(connection, "nCapitalWorldByPopulation.sql", params);
            while (resultSet.next()) {
                CapitalCity capitalCity = new CapitalCity();
                capitalCity.country = resultSet.getString("Name");
                capitalCity.population = resultSet.getString("Population");
                capitalCity.name = resultSet.getString("Capital");
                result.add(capitalCity);
            }
            resultSet.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
        return result;
    }

    /**
     * Generates a report for the N populated capital cities in a continent where N is provided by the user.
     * @param connection the connection to the database
     * @param continent the specified continent
     * @return
     */
    public static ArrayList<CapitalCity> nCapitalContinentByPopulation(Connection connection, String continent, String N){
        ArrayList<CapitalCity> result = new ArrayList<CapitalCity>();
        try {
            String[] params = {"#Continent", continent, N};
            ResultSet resultSet = SQLUtil.run(connection, "nCapitalByPopulation.sql", params);
            while (resultSet.next()) {
                CapitalCity capitalCity = new CapitalCity();
                capitalCity.country = resultSet.getString("Name");
                capitalCity.population = resultSet.getString("Population");
                capitalCity.name = resultSet.getString("Capital");
                result.add(capitalCity);
            }
            resultSet.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
        return result;
    }

    /**
     * Generates a report for the N populated capital cities in a region where N is provided by the user.
     * @param connection the connection to the database
     * @param region the specified region
     * @return
     */
    public static ArrayList<CapitalCity> nCapitalRegionByPopulation(Connection connection, String region, String N){
        ArrayList<CapitalCity> result = new ArrayList<CapitalCity>();
        try {
            String[] params = {"#Region", region, N};
            ResultSet resultSet = SQLUtil.run(connection, "nCapitalByPopulation.sql", params);
            while (resultSet.next()) {
                CapitalCity capitalCity = new CapitalCity();
                capitalCity.country = resultSet.getString("Name");
                capitalCity.population = resultSet.getString("Population");
                capitalCity.name = resultSet.getString("Capital");
                result.add(capitalCity);
            }
            resultSet.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
        return result;
    }

    /**
     * Generates a report for the cities in the world sorted from largest population to smallest.
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<City> citiesWorldByPopulation(Connection connection){
        ArrayList<City> result = new ArrayList<City>();
        try {
            String[] params = {};
            ResultSet resultSet = SQLUtil.run(connection, "citiesWorldByPopulation.sql", params);
            while (resultSet.next()) {
                City city = new City();
                city.country = resultSet.getString("Country");
                city.population = resultSet.getString("Population");
                city.name = resultSet.getString("Name");
                city.district = resultSet.getString("District");
                result.add(city);
            }
            resultSet.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
        return result;
    }

    /**
     * Generates a report for the cities in a continent sorted from largest population to smallest.
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<City> citiesContinentByPopulation(Connection connection, String continent){
        ArrayList<City> result = new ArrayList<City>();
        try {
            String[] params = {"#country", "#Continent", continent};
            ResultSet resultSet = SQLUtil.run(connection, "citiesByPopulation.sql", params);
            while (resultSet.next()) {
                City city = new City();
                city.country = resultSet.getString("Country");
                city.population = resultSet.getString("Population");
                city.name = resultSet.getString("Name");
                city.district = resultSet.getString("District");
                result.add(city);
            }
            resultSet.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
        return result;
    }

    /**
     * Generates a report for the cities in a region sorted from largest population to smallest.
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<City> citiesRegionByPopulation(Connection connection, String region){
        ArrayList<City> result = new ArrayList<City>();
        try {
            String[] params = {"#country", "#Region", region};
            ResultSet resultSet = SQLUtil.run(connection, "citiesByPopulation.sql", params);
            while (resultSet.next()) {
                City city = new City();
                city.country = resultSet.getString("Country");
                city.population = resultSet.getString("Population");
                city.name = resultSet.getString("Name");
                city.district = resultSet.getString("District");
                result.add(city);
            }
            resultSet.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
        return result;
    }

    /**
     * Generates a report for the cities in a country sorted from largest population to smallest.
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<City> citiesCountryByPopulation(Connection connection, String country){
        ArrayList<City> result = new ArrayList<City>();
        try {
            String[] params = {"#country", "#Name", country};
            ResultSet resultSet = SQLUtil.run(connection, "citiesByPopulation.sql", params);
            while (resultSet.next()) {
                City city = new City();
                city.country = resultSet.getString("Country");
                city.population = resultSet.getString("Population");
                city.name = resultSet.getString("Name");
                city.district = resultSet.getString("District");
                result.add(city);
            }
            resultSet.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
        return result;
    }

    /**
     * Generates a report for the cities in a district sorted from largest population to smallest.
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<City> citiesDistrictByPopulation(Connection connection, String district){
        ArrayList<City> result = new ArrayList<City>();
        try {
            String[] params = {"#city", "#District", district};
            ResultSet resultSet = SQLUtil.run(connection, "citiesByPopulation.sql", params);
            while (resultSet.next()) {
                City city = new City();
                city.country = resultSet.getString("Country");
                city.population = resultSet.getString("Population");
                city.name = resultSet.getString("Name");
                city.district = resultSet.getString("District");
                result.add(city);
            }
            resultSet.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
        return result;
    }

    /**
     * Generates a report for the N populated cities in the world where N is provided by the user.
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<City> nCitiesWorldByPopulation(Connection connection, String N){
        ArrayList<City> result = new ArrayList<City>();
        try {
            String[] params = {N};
            ResultSet resultSet = SQLUtil.run(connection, "nCitiesWorldByPopulation.sql", params);
            while (resultSet.next()) {
                City city = new City();
                city.country = resultSet.getString("Country");
                city.population = resultSet.getString("Population");
                city.name = resultSet.getString("Name");
                city.district = resultSet.getString("District");
                result.add(city);
            }
            resultSet.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
        return result;
    }

    /**
     * Generates a report for the N populated cities in a continent where N is provided by the user.
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<City> nCitiesContinentByPopulation(Connection connection, String continent, String N){
        ArrayList<City> result = new ArrayList<City>();
        try {
            String[] params = {"#country", "#Continent", continent, N};
            ResultSet resultSet = SQLUtil.run(connection, "nCitiesByPopulation.sql", params);
            while (resultSet.next()) {
                City city = new City();
                city.country = resultSet.getString("Country");
                city.population = resultSet.getString("Population");
                city.name = resultSet.getString("Name");
                city.district = resultSet.getString("District");
                result.add(city);
            }
            resultSet.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
        return result;
    }

     /**
     * Generates a report for the N populated cities in a region where N is provided by the user.
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<City> nCitiesRegionByPopulation(Connection connection, String region, String N){
        ArrayList<City> result = new ArrayList<City>();
        try {
            String[] params = {"#country", "#Region", region, N};
            ResultSet resultSet = SQLUtil.run(connection, "nCitiesByPopulation.sql", params);
            while (resultSet.next()) {
                City city = new City();
                city.country = resultSet.getString("Country");
                city.population = resultSet.getString("Population");
                city.name = resultSet.getString("Name");
                city.district = resultSet.getString("District");
                result.add(city);
            }
            resultSet.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
        return result;
    }

    /**
     * Generates a report for the N populated cities in a district where N is provided by the user.
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<City> nCitiesDistrictByPopulation(Connection connection, String district, String N){
        ArrayList<City> result = new ArrayList<City>();
        try {
            String[] params = {"#city", "#District", district, N};
            ResultSet resultSet = SQLUtil.run(connection, "nCitiesByPopulation.sql", params);
            while (resultSet.next()) {
                City city = new City();
                city.country = resultSet.getString("Country");
                city.population = resultSet.getString("Population");
                city.name = resultSet.getString("Name");
                city.district = resultSet.getString("District");
                result.add(city);
            }
            resultSet.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
        return result;
    }

    private static float roundedPercentage(int value, int total){
        float result = ((float)value) / total * 100;
        result = ((float)Math.round(result * 100)) / 100;
        return result;
    }

    /**
     * Generates a report for the number of people who speak each language
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<City> nCitiesCountryByPopulation(Connection connection, String country, String N){
        ArrayList<City> result = new ArrayList<City>();
        try {
            String[] params = {"#country", "#Name", country, N};
            ResultSet resultSet = SQLUtil.run(connection, "nCitiesByPopulation.sql", params);
            while (resultSet.next()) {
                City city = new City();
                city.country = resultSet.getString("Country");
                city.population = resultSet.getString("Population");
                city.name = resultSet.getString("Name");
                city.district = resultSet.getString("District");
                result.add(city);
            }
            resultSet.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
        return result;
    }
    /**
     * Generates a report for the nuber of people who speak a language
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<Language> languagePercentage(Connection connection){
        ArrayList<Language> result = new ArrayList<Language>();
        try {
            String[] params = {};
            ResultSet resultSet = SQLUtil.run(connection, "languagePercentage.sql", params);
            while (resultSet.next()) {
                Language lan = new Language();
                lan.countryCode = resultSet.getString("countryCode");
                lan.Language = resultSet.getString("Language");
                lan.IsOfficial = resultSet.getString("IsOfficial");
                lan.Percentage = resultSet.getBigDecimal("Percentage");
                result.add(lan);
            }
            resultSet.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
        return result;
    }
}
