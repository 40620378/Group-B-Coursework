SELECT reportName, population AS totalPopulation, SUM(sum_cities.population - sum_cities.city_population) AS totalNotCity, city_population AS totalCity
FROM (
    SELECT country.Code AS code, country.Region AS reportName, country.Population AS population, SUM(city.population) AS city_population
    FROM country
    LEFT JOIN city ON country.Code = city.CountryCode
    GROUP BY country.Code, country.Region, country.Population
) AS sum_cities
GROUP BY reportName, population, city_population;