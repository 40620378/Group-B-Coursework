SELECT country.Name AS Name, country.Continent AS Continent, country.Population AS Population, country.Code AS Code, country.Region AS Region, city.Name AS Capital
FROM country
INNER JOIN city ON country.Code = city.CountryCode
WHERE Region = ?
ORDER BY Population DESC;

