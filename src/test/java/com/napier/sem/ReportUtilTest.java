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
    // @Test
    // void peopleDistributionCountry() throws SQLException {
    //     Connection con = mock(Connection.class);
    //     ResultSet result = mock(ResultSet.class);
    //     Statement stmt = mock(Statement.class);
    //     Mockito.when(con.createStatement()).thenReturn(stmt);
    //     Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
    //     Mockito.when(result.next()).thenReturn(true).thenReturn(false);
    //     Mockito.when(result.getString("reportName")).thenReturn("Aruba");
    //     Mockito.when(result.getInt("totalCity")).thenReturn(29034);
    //     Mockito.when(result.getInt("totalPopulation")).thenReturn(103000);
    //     Mockito.when(result.getInt("totalNotCity")).thenReturn(73966);
    //     ArrayList<Population> resultList = ReportUtil.peopleDistributionCountry(con);
    //     assertEquals(1, resultList.size());
    //     String expected = "Name: Aruba Population: 103000 City: 29034(28.19%) Not City: 73966(71.81%)";
    //     assertEquals(expected, resultList.get(0).ToString());
    // }

    @Test
    void countryContinentByPopulation() throws SQLException {
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
        ArrayList<Country> resultList = ReportUtil.countryContinentByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "Country code: BEL Country name: Belgium Continent: Europe Region: Western Europe Population: 10239000 Capital: Brussels";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void countryWorldByPopulation() throws SQLException {
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
        ArrayList<Country> resultList = ReportUtil.countryWorldByPopulation(con);
        assertEquals(1, resultList.size());
        String expected = "Country code: BEL Country name: Belgium Continent: Europe Region: Western Europe Population: 10239000 Capital: Brussels";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void countryRegionByPopulation() throws SQLException {
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
        ArrayList<Country> resultList = ReportUtil.countryRegionByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "Country code: BEL Country name: Belgium Continent: Europe Region: Western Europe Population: 10239000 Capital: Brussels";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void nCountryWorldByPopulation() throws SQLException {
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
        ArrayList<Country> resultList = ReportUtil.nCountryWorldByPopulation(con, "10");
        assertEquals(1, resultList.size());
        String expected = "Country code: BEL Country name: Belgium Continent: Europe Region: Western Europe Population: 10239000 Capital: Brussels";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void nCountryContinentByPopulation() throws SQLException {
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
        ArrayList<Country> resultList = ReportUtil.nCountryContinentByPopulation(con, "param", "11");
        assertEquals(1, resultList.size());
        String expected = "Country code: BEL Country name: Belgium Continent: Europe Region: Western Europe Population: 10239000 Capital: Brussels";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void nCountryRegionByPopulation() throws SQLException {
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
        ArrayList<Country> resultList = ReportUtil.nCountryRegionByPopulation(con, "param", "8");
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
    void nCapitalWorldByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Belgium");
        Mockito.when(result.getString("Population")).thenReturn("10239000");
        Mockito.when(result.getString("Capital")).thenReturn("Brussels");
        ArrayList<CapitalCity> resultList = ReportUtil.nCapitalWorldByPopulation(con, "13");
        assertEquals(1, resultList.size());
        String expected = "City: Brussels Country: Belgium Population: 10239000";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void nCapitalContinentByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Belgium");
        Mockito.when(result.getString("Population")).thenReturn("10239000");
        Mockito.when(result.getString("Capital")).thenReturn("Brussels");
        ArrayList<CapitalCity> resultList = ReportUtil.nCapitalContinentByPopulation(con, "param", "13");
        assertEquals(1, resultList.size());
        String expected = "City: Brussels Country: Belgium Population: 10239000";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void nCapitalRegionByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Belgium");
        Mockito.when(result.getString("Capital")).thenReturn("Brussels");
        Mockito.when(result.getString("Population")).thenReturn("10239000");
        ArrayList<CapitalCity> resultList = ReportUtil.nCapitalRegionByPopulation(con, "param", "13");
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

    @Test
    void nCitiesWorldByPopulation() throws SQLException {
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
        ArrayList<City> resultList = ReportUtil.nCitiesWorldByPopulation(con, "13");
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void nCitiesContinentByPopulation() throws SQLException {
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
        ArrayList<City> resultList = ReportUtil.nCitiesContinentByPopulation(con, "param", "12");
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void nCitiesRegionByPopulation() throws SQLException {
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
        ArrayList<City> resultList = ReportUtil.nCitiesRegionByPopulation(con, "param", "9");
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void nCitiesCountryByPopulation() throws SQLException {
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
        ArrayList<City> resultList = ReportUtil.nCitiesCountryByPopulation(con, "param", "11");
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void nCitiesDistrictByPopulation() throws SQLException {
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
        ArrayList<City> resultList = ReportUtil.nCitiesDistrictByPopulation(con, "param", "7");
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).ToString());
    }
}
