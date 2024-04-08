SELECT reportName, population AS totalPopulation, SUM(sum_cities.population - sum_cities.city_population) AS totalNotCity, city_population AS totalCity
FROM (
    SELECT country.Continent AS reportName, country.Population AS population, SUM(city.population) AS city_population
    FROM country
    LEFT JOIN city ON country.Code = city.CountryCode
    GROUP BY reportName, population, city_population
) AS sum_cities
GROUP BY reportName, population, city_population;