SELECT Language, SUM((country.Population / 100) * countrylanguage.Percentage) AS noOfSpeakers, ROUND(((SUM((country.Population / 100) * countrylanguage.Percentage) / SUM(population)) * 100), 2) AS percentWorldPop
FROM countrylanguage
INNER JOIN country ON countrylanguage.CountryCode = country.Code
WHERE Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic')
GROUP BY Language
ORDER BY noOfSpeakers DESC;