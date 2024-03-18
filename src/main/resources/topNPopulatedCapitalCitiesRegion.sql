SELECT country.Code AS code, country.Name AS Name, country.Continent AS continent, country.Region AS Region, country.Population AS Population, city.Name AS Capital
FROM country
INNER JOIN city ON country.Capital = city.ID
WHERE country.Region = ?
ORDER BY city.population DESC
LIMIT ?;