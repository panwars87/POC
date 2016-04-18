package com.testing.pdev.utils;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.testing.pdev.exceptions.GoogleApiUtilException;

public class DBConnectionTest {

	Connection connection;
	
	@Before
    public void before() {
        try {
			connection = DBConnection.getConnection();
        }catch (GoogleApiUtilException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        assertNotNull(connection);
    }

    @After
    public void after() throws GoogleApiUtilException {
        DBConnection.closeConnection();
    }

    @Test
    public void closeStatementShouldCloseStatement() throws SQLException {
        Statement statement = connection.createStatement();
        assertNotNull(statement);
    }

}
