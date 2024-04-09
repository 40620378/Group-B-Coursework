SELECT Language
FROM countrylanguage
INNER JOIN country ON countrylanguage.CountryCode = country.Code
WHERE Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic')
GROUP BY Language;
-- ORDER BY noOfSpeakers;
-- IsOfficial, Percentage
-- AS noOfSpeakers, As percentWorldPop