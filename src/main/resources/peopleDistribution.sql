SELECT country.Continent AS reportName, sum_countries.totalPopulation AS totalPopulation, SUM(sum_countries.totalCity) AS totalCity, SUM(sum_countries.totalNotCity) AS totalNotCity
FROM(
    SELECT sum_cities.countryName, sum_cities.population AS totalPopulation, SUM(sum_cities.population - sum_cities.city_population) AS totalNotCity, city_population AS totalCity, code
    FROM (
        SELECT country.Code AS code, country.Name AS countryName, country.Population AS population, SUM(city.population) AS city_population, country.Continent AS cityC
        FROM country
        LEFT JOIN city ON country.Code = city.CountryCode
        GROUP BY country.Code, country.Name, country.Population
    ) AS sum_cities
    GROUP BY countryName, population, city_population, code
) AS sum_countries
INNER JOIN country ON sum_countries.code = country.Code
GROUP BY country.Continent, totalPopulation, totalCity, totalNotCity;