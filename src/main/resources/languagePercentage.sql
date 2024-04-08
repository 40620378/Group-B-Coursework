SELECT Language
FROM countrylanguage
RIGHT JOIN city ON countrylanguage.CountryCode = city.CountryCode
WHERE Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic')
GROUP BY Language, CountryCode
-- ORDER BY noOfSpeakers;