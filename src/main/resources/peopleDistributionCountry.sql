SELECT country.Code AS code, SUM(city.population) AS totalCity
FROM country
INNER JOIN city ON country.Code = city.CountryCode
GROUP BY country.Code;
