SELECT reportName, SUM(country_population - city_population) AS totalNotCity, city_population AS totalCity
FROM (
    SELECT country.Name AS reportName, country.Code AS code, country.Population AS country_population, SUM(city.population) AS city_population
    FROM country
    INNER JOIN city ON country.Code = city.CountryCode
    GROUP BY country.Code
) AS sum_cities
GROUP BY reportName;
