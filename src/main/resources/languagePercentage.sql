SELECT CountryCode, Language, IsOfficial, Percentage
-- , AS noOfSpeakers, As percentWorldPop
FROM countrylanguage
WHERE Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic')
GROUP BY Language
-- ORDER BY noOfSpeakers;