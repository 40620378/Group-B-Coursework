SELECT country.Code AS code, country.Name AS reportName, country.Population AS population, SUM(city.population) AS city_population
FROM country
INNER JOIN city ON country.Code = city.CountryCode
GROUP BY country.Code;
