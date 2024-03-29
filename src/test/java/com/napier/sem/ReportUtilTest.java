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
        ArrayList<Population> resultList = ReportUtil.peopleDistributionCountry(con);
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

    @Test
    void worldByPopulation() throws SQLException {
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
        ArrayList<Country> resultList = ReportUtil.worldByPopulation(con);
        assertEquals(1, resultList.size());
        String expected = "Country code: BEL Country name: Belgium Continent: Europe Region: Western Europe Population: 10239000 Capital: Brussels";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void regionByPopulation() throws SQLException {
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
        ArrayList<Country> resultList = ReportUtil.regionByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "Country code: BEL Country name: Belgium Continent: Europe Region: Western Europe Population: 10239000 Capital: Brussels";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void capitalWorldByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Belgium");
        Mockito.when(result.getString("Population")).thenReturn("10239000");
        Mockito.when(result.getString("Capital")).thenReturn("Brussels");
        ArrayList<CapitalCity> resultList = ReportUtil.capitalWorldByPopulation(con);
        assertEquals(1, resultList.size());
        String expected = "City: Brussels Country: Belgium Population: 10239000";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void capitalContinentByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Belgium");
        Mockito.when(result.getString("Population")).thenReturn("10239000");
        Mockito.when(result.getString("Capital")).thenReturn("Brussels");
        ArrayList<CapitalCity> resultList = ReportUtil.capitalContinentByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "City: Brussels Country: Belgium Population: 10239000";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void capitalRegionByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Belgium");
        Mockito.when(result.getString("Capital")).thenReturn("Brussels");
        Mockito.when(result.getString("Population")).thenReturn("10239000");
        ArrayList<CapitalCity> resultList = ReportUtil.capitalRegionByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "City: Brussels Country: Belgium Population: 10239000";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void citiesDistrictByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Tokyo");
        Mockito.when(result.getString("Country")).thenReturn("JPN");
        Mockito.when(result.getString("District")).thenReturn("Tokyo-to");
        Mockito.when(result.getString("Population")).thenReturn("7980230");
        ArrayList<City> resultList = ReportUtil.citiesDistrictByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void citiesCountryByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Tokyo");
        Mockito.when(result.getString("Country")).thenReturn("JPN");
        Mockito.when(result.getString("District")).thenReturn("Tokyo-to");
        Mockito.when(result.getString("Population")).thenReturn("7980230");
        ArrayList<City> resultList = ReportUtil.citiesCountryByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void citiesRegionByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Tokyo");
        Mockito.when(result.getString("Country")).thenReturn("JPN");
        Mockito.when(result.getString("District")).thenReturn("Tokyo-to");
        Mockito.when(result.getString("Population")).thenReturn("7980230");
        ArrayList<City> resultList = ReportUtil.citiesRegionByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void citiesContinentByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Tokyo");
        Mockito.when(result.getString("Country")).thenReturn("JPN");
        Mockito.when(result.getString("District")).thenReturn("Tokyo-to");
        Mockito.when(result.getString("Population")).thenReturn("7980230");
        ArrayList<City> resultList = ReportUtil.citiesContinentByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void citiesWorldByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Tokyo");
        Mockito.when(result.getString("Country")).thenReturn("JPN");
        Mockito.when(result.getString("District")).thenReturn("Tokyo-to");
        Mockito.when(result.getString("Population")).thenReturn("7980230");
        ArrayList<City> resultList = ReportUtil.citiesWorldByPopulation(con);
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).ToString());
    }
}
