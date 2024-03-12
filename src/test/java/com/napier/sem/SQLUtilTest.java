package com.napier.sem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLUtilTest
{
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    void validSQL() {
        boolean valid = SQLUtil.isValid("test.sql");
        assertEquals(valid, true);
    }
    @Test
    void invalidSQL() {
        boolean valid = SQLUtil.isValid("invalidTest.sql");
        assertEquals(valid, false);
    }
    @Test
    void runSQL() throws SQLException {
        Connection con = mock(Connection.class);
        Statement stmt = mock(Statement.class);
        ResultSet result = mock(ResultSet.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        String[] params = {"test"};
        SQLUtil.run(con, "test.sql", params);
        verify(stmt).executeQuery(Mockito.argThat(s -> s.contains("WHERE CountryCode = 'test';")));
    }
    @Test
    void runSQLError() throws SQLException {
        Connection con = mock(Connection.class);
        Mockito.when(con.createStatement()).thenThrow(new SQLException());
        String[] params = {"test"};
        ResultSet result = SQLUtil.run(con, "test.sql", params);
        assertEquals(null, result);
        assertTrue(outputStreamCaptor.toString().contains("Statement execution failed!"));
    }
}