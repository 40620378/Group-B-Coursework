SELECT sum_cities.reportName, sum_cities.population AS totalPopulation, SUM(sum_cities.population - sum_cities.city_population) AS totalNotCity, sum_cities.city_population AS totalCity
FROM (
    SELECT country.Code AS code, country.Name AS reportName, country.Population AS population, SUM(city.population) AS city_population
    FROM country
    LEFT JOIN city ON country.Code = city.CountryCode
    GROUP BY country.Code, country.Name, country.Population
) AS sum_cities;
