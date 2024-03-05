SELECT SUM(country.population - city.population)
FROM country
INNER JOIN city ON country.Code = city.CountryCode
WHERE country.Code =