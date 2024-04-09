SELECT Language, SUM((country.Population / 100) * countrylanguage.Percentage) AS noOfSpeakers
FROM countrylanguage
INNER JOIN country ON countrylanguage.CountryCode = country.Code
WHERE Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic')
GROUP BY Language;
-- ORDER BY noOfSpeakers;
-- IsOfficial, Percentage
-- AS noOfSpeakers, As percentWorldPop