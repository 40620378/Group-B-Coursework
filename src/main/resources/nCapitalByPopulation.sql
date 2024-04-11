SELECT city.Name AS Capital, city.Population AS Population, country.Name AS Name
FROM country
INNER JOIN city ON country.Capital = city.ID
WHERE country.? = ?
ORDER BY city.Population DESC
LIMIT ?