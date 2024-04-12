SELECT Language, SUM((country.Population / 100) * countrylanguage.Percentage) AS noOfSpeakers, SUM((country.Population / 100) * countrylanguage.Percentage) / SUM(population) AS percentWorldPop
FROM countrylanguage
INNER JOIN country ON countrylanguage.CountryCode = country.Code
WHERE Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic')
GROUP BY Language
ORDER BY noOfSpeakers DESC;









-- ROUND(((SUM((country.Population / 100) * countrylanguage.Percentage) / SUM(population)) * 100), 2)
-- ROUND(((noOfSpeakers) / SUM(population)) * 100), 2)