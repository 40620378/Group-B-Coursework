package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;



public class AppIntegrationTest {

    static Connection connection;

    @BeforeAll
    static void init()
    {
        SingletonConnection connectionManager = SingletonConnection.getInstance();
        connection = connectionManager.connect();

    }

    @Test
    void testCapitalCity()
    {
        ArrayList<CapitalCity> capitalWorldByPopulation = ReportUtil.capitalWorldByPopulation(connection);
        assertTrue(capitalWorldByPopulation.size() > 0);
        callGenerateMarkdown(capitalWorldByPopulation, "capitalWorldByPopulation");
        File file = new File("./reports/" + "capitalWorldByPopulation");
        assertTrue(file.exists());
    }



    private static void callGenerateMarkdown(ArrayList<?> result, String name) {
        ArrayList<Object> resultObject = new ArrayList<Object>();
        for(int i = 0; i < result.size(); i++) {
            resultObject.add(result.get(i));
        }
        ReportUtil.generateMarkdown(resultObject, name);
    }

}


