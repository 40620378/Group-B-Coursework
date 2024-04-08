package com.napier.sem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.math.BigInteger;
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
                BigDecimal decTotalPop = resultSet.getBigDecimal("totalPopulation");
                pop.totalPopulation = (decTotalPop == null ? null : decTotalPop.toBigInteger());
                int intTotalPopulation = decTotalPop.intValue();
                pop.totalNotCity = resultSet.getInt("totalNotCity");
                pop.percentageCity = roundedPercentage(pop.totalCity, intTotalPopulation);
                pop.percentageNotCity = roundedPercentage(pop.totalNotCity, intTotalPopulation);
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
     * Generates a report for the overall population as well as those that live in a city and don't within a continent.
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<Population> peopleDistributionContinent(Connection connection){
        ArrayList<Population> result = new ArrayList<Population>();
        try {
            String[] params = {};
            ResultSet resultSet = SQLUtil.run(connection, "peopleDistribution.sql", params);
            while (resultSet.next()) {
                Population pop = new Population();
                pop.reportName = resultSet.getString("reportName");
                pop.totalCity = resultSet.getInt("totalCity");
                BigDecimal decTotalPop = resultSet.getBigDecimal("totalPopulation");
                pop.totalPopulation = (decTotalPop == null ? null : decTotalPop.toBigInteger());
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
    public static ArrayList<Country> countryContinentByPopulation(Connection connection, String continent){
        ArrayList<Country> result = new ArrayList<Country>();
        try {
            String[] params = {"#Continent", continent};
            ResultSet resultSet = SQLUtil.run(connection, "countryByPopulation.sql", params);
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
    public static ArrayList<Country> countryWorldByPopulation(Connection connection){
        ArrayList<Country> result = new ArrayList<Country>();
        try {
            String[] params = {};
            ResultSet resultSet = SQLUtil.run(connection, "countryWorldByPopulation.sql", params);
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
    public static ArrayList<Country> countryRegionByPopulation(Connection connection, String region){
        ArrayList<Country> result = new ArrayList<Country>();
        try {
            String[] params = {"#Region", region};
            ResultSet resultSet = SQLUtil.run(connection, "countryByPopulation.sql", params);
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
     * Generates a report for the N populated countries in the world where N is provided by the user.
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<Country> nCountryWorldByPopulation(Connection connection, String N){
        ArrayList<Country> result = new ArrayList<Country>();
        try {
            String[] params = {N};
            ResultSet resultSet = SQLUtil.run(connection, "nCountryWorldByPopulation.sql", params);
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
     * Generates a report for the N populated countries in a continent where N is provided by the user.
     * @param connection the connection to the database
     * @param continent the specified continent
     * @return
     */
    public static ArrayList<Country> nCountryContinentByPopulation(Connection connection, String continent, String N){
        ArrayList<Country> result = new ArrayList<Country>();
        try {
            String[] params = {"#Continent", continent, N};
            ResultSet resultSet = SQLUtil.run(connection, "nCountryByPopulation.sql", params);
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
     * Generates a report for the N populated countries in a region where N is provided by the user.
     * @param connection the connection to the database
     * @param region the specified region
     * @return
     */
    public static ArrayList<Country> nCountryRegionByPopulation(Connection connection, String region, String N){
        ArrayList<Country> result = new ArrayList<Country>();
        try {
            String[] params = {"#Region", region, N};
            ResultSet resultSet = SQLUtil.run(connection, "nCountryByPopulation.sql", params);
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
     * Generates a report for the N populated cities in a country where N is provided by the user.
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
     * Generates a report for the total population of the world
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<Population> totalPopulationWorld(Connection connection){
        ArrayList<Population> result = new ArrayList<Population>();
        try {
            String[] params = {};
            ResultSet resultSet = SQLUtil.run(connection, "totalPopulationWorld.sql", params);
            while (resultSet.next()) {
                Population pop = new Population();
                BigDecimal decTotalPop = resultSet.getBigDecimal("totalPopulation");
                pop.totalPopulation = (decTotalPop == null ? null : decTotalPop.toBigInteger());
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
     * Generates a report for the total population of a continent
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<Population> totalPopulationContinent(Connection connection, String continent){
        ArrayList<Population> result = new ArrayList<Population>();
        try {
            String[] params = {"#Continent", continent};
            ResultSet resultSet = SQLUtil.run(connection, "totalPopulationConRegCou.sql", params);
            while (resultSet.next()) {
                Population pop = new Population();
                BigDecimal decTotalPop = resultSet.getBigDecimal("totalPopulation");
                pop.totalPopulation = (decTotalPop == null ? null : decTotalPop.toBigInteger());
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
     * Generates a report for the total population of a region
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<Population> totalPopulationRegion(Connection connection, String region){
        ArrayList<Population> result = new ArrayList<Population>();
        try {
            String[] params = {"#Region", region};
            ResultSet resultSet = SQLUtil.run(connection, "totalPopulationConRegCou.sql", params);
            while (resultSet.next()) {
                Population pop = new Population();
                BigDecimal decTotalPop = resultSet.getBigDecimal("totalPopulation");
                pop.totalPopulation = (decTotalPop == null ? null : decTotalPop.toBigInteger());
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
     * Generates a report for the total population of a country
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<Population> totalPopulationCountry(Connection connection, String country){
        ArrayList<Population> result = new ArrayList<Population>();
        try {
            String[] params = {"#Name", country};
            ResultSet resultSet = SQLUtil.run(connection, "totalPopulationConRegCou.sql", params);
            while (resultSet.next()) {
                Population pop = new Population();
                BigDecimal decTotalPop = resultSet.getBigDecimal("totalPopulation");
                pop.totalPopulation = (decTotalPop == null ? null : decTotalPop.toBigInteger());
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
     * Generates a report for the total population of a district
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<Population> totalPopulationDistrict(Connection connection, String district){
        ArrayList<Population> result = new ArrayList<Population>();
        try {
            String[] params = {"#District", district};
            ResultSet resultSet = SQLUtil.run(connection, "totalPopulationDisCit.sql", params);
            while (resultSet.next()) {
                Population pop = new Population();
                BigDecimal decTotalPop = resultSet.getBigDecimal("totalPopulation");
                pop.totalPopulation = (decTotalPop == null ? null : decTotalPop.toBigInteger());
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
     * Generates a report for the total population of a city
     * @param connection the connection to the database
     * @return
     */
    public static ArrayList<Population> totalPopulationCity(Connection connection, String city){
        ArrayList<Population> result = new ArrayList<Population>();
        try {
            String[] params = {"#Name", city};
            ResultSet resultSet = SQLUtil.run(connection, "totalPopulationDisCit.sql", params);
            while (resultSet.next()) {
                Population pop = new Population();
                BigDecimal decTotalPop = resultSet.getBigDecimal("totalPopulation");
                pop.totalPopulation = (decTotalPop == null ? null : decTotalPop.toBigInteger());
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
}
