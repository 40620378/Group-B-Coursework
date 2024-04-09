SELECT Language, SUM((country.Population / 100) * countrylanguage.Percentage) AS noOfSpeakers, ((SUM((country.Population / 100) * countrylanguage.Percentage) / SUM(population)) * 100) AS percentWorldPop
FROM countrylanguage
INNER JOIN country ON countrylanguage.CountryCode = country.Code
WHERE Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic')
GROUP BY Language;
-- ORDER BY noOfSpeakers;
-- IsOfficial, Percentage
-- AS noOfSpeakers, As percentWorldPop