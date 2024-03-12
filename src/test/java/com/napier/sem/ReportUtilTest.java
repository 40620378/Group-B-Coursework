package com.napier.sem;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class ReportUtilTest
{
    @Test
    void peopleDistributionCountry() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("reportName")).thenReturn("Aruba");
        Mockito.when(result.getInt("totalCity")).thenReturn(29034);
        Mockito.when(result.getInt("totalPopulation")).thenReturn(103000);
        Mockito.when(result.getInt("totalNotCity")).thenReturn(73966);
        ArrayList<Population> resultList = ReportUtil.countryCitiesPopulation(con);
        assertEquals(1, resultList.size());
        String expected = "Name: Aruba Population: 103000 City: 29034 Not City: 73966";
        assertEquals(expected, resultList.get(0).ToString());
    }
    @Test
    void continentByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Code")).thenReturn("BEL");
        Mockito.when(result.getString("Name")).thenReturn("Belgium");
        Mockito.when(result.getString("Continent")).thenReturn("Europe");
        Mockito.when(result.getString("Population")).thenReturn("10239000");
        Mockito.when(result.getString("Region")).thenReturn("Western Europe");
        Mockito.when(result.getString("Capital")).thenReturn("Brussels");
        ArrayList<Country> resultList = ReportUtil.continentByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "Country code: BEL Country name: Belgium Continent: Europe Region: Western Europe Population: 10239000 Capital: Brussels";
        assertEquals(expected, resultList.get(0).ToString());
    }
}