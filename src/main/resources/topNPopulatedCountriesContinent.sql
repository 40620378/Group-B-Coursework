SELECT country.Code AS code, country.Name AS Name, country.Continent AS continent, country.Region AS Region, country.Population AS Population, city.Name AS Capital
FROM country
INNER JOIN city ON country.Code = city.CountryCode
WHERE country.Continent = ?
ORDER BY country.population DESC
LIMIT ?;