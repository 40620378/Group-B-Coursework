SELECT country.Name AS reportName, country.Population AS totalPopulation, SUM(city.population) AS totalCity
FROM country
INNER JOIN city ON country.Code = city.CountryCode
GROUP BY country.Name;
