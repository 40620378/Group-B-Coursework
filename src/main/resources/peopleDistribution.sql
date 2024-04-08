SELECT country.Continent, sum_countries.totalPopulation, sum_countries.totalCity, sum_countries.totalNotCity
FROM(
    SELECT reportName, population AS totalPopulation, SUM(sum_cities.population - sum_cities.city_population) AS totalNotCity, city_population AS totalCity, code
    FROM (
        SELECT country.Code AS code, country.Name AS reportName, country.Population AS population, SUM(city.population) AS city_population, country.Continent AS cityC
        FROM country
        LEFT JOIN city ON country.Code = city.CountryCode
        GROUP BY country.Code, country.Name, country.Population
    ) AS sum_cities
    GROUP BY reportName, population, city_population, code;
) AS sum_countries
INNER JOIN country ON sum_countries.code = country.Code
GROUP BY country.Continent