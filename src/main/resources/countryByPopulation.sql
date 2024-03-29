SELECT country.Name AS Name, country.Continent AS Continent, country.Population AS Population, country.Code AS Code, country.Region AS Region, country.Capital AS Capital
FROM country
WHERE country.? = ?
ORDER BY country.Population DESC;