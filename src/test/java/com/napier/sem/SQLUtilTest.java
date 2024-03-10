package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SQLUtilTest
{

    @Test
    void validSQL()
    {
        boolean valid = SQLUtil.isValid("test.sql");
        assertEquals(valid, true);
    }
    @Test
    void invalidSQL()
    {
        boolean valid = SQLUtil.isValid("invalidTest.sql");
        assertEquals(valid, false);
    }
}