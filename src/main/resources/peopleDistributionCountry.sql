SELECT sum_cities.reportName, sum_cities.population AS totalPopulation, SUM(country.Population - sum_cities.city_population) AS totalNotCity, sum_cities.city_population AS totalCity
FROM country
INNER JOIN(
    SELECT country.Code AS code, country.Name AS reportName, country.Population AS population, SUM(city.population) AS city_population
    FROM country
    INNER JOIN city ON country.Code = city.CountryCode
    GROUP BY country.Code
) AS sum_cities
ON country.Code = sum_cities.code;
