ALTER TABLE country ALTER COLUMN population bigint;

SELECT SUM(population) AS totalPopulation
FROM country;