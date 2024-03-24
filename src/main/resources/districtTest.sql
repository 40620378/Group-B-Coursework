SELECT city.Name AS Name, city.Population AS Population, country.Name AS Country, city.District AS District
FROM country
INNER JOIN city ON country.Capital = city.ID
WHERE city.? = ?
ORDER BY city.Population DESC