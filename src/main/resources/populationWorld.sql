SELECT population AS totalPopulation
FROM (
    SELECT country.Code AS code, country.Name AS reportName, country.Population AS population, SUM(city.population) AS city_population
    FROM country
    LEFT JOIN city ON country.Code = city.CountryCode
    GROUP BY country.Code, country.Name, country.Population
)
GROUP BY population;