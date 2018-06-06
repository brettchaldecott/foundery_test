/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foundery.galaxy.parser;

import java.util.List;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Brett Chaldecott
 */
public class QueryParserTest {
    
    public QueryParserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isMuchQuery method, of class QueryParser.
     */
    @Test
    public void testIsMuchQuery() {
        System.out.println("isMuchQuery");
        QueryParser instance = new QueryParser(new String[]
            {"how","much","is","pish","tegj","glob","glob","?"});
        boolean expResult = true;
        boolean result = instance.isMuchQuery();
        assertEquals(expResult, result);
        
        instance = new QueryParser(new String[]
            {"how","many","Credits","is","glob","prok","Silver","?"});
        expResult = false;
        result = instance.isMuchQuery();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTokens method, of class QueryParser.
     */
    @Test
    public void testGetTokens() {
        System.out.println("getTokens");
        QueryParser instance = new QueryParser(new String[]
            {"how","much","is","pish","tegj","glob","glob","?"});
        List<String> expResult = new ArrayList<String>();
        expResult.add("pish");
        expResult.add("tegj");
        expResult.add("glob");
        expResult.add("glob");
        List<String> result = instance.getTokens();
        assertEquals(expResult, result);
        
        instance = new QueryParser(new String[]
            {"how","many","Credits","is","glob","prok","Silver","?"});
        expResult = new ArrayList<String>();
        expResult.add("glob");
        expResult.add("prok");
        result = instance.getTokens();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUnit method, of class QueryParser.
     */
    @Test
    public void testGetUnit() {
        System.out.println("getUnit");
        QueryParser instance = new QueryParser(new String[]
            {"how","many","Credits","is","glob","prok","Silver","?"});
        String expResult = "Credits";
        String result = instance.getUnit();
        assertEquals(expResult, result);
    }

    /**
     * Test of getType method, of class QueryParser.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        QueryParser instance = new QueryParser(new String[]
            {"how","many","Credits","is","glob","prok","Silver","?"});
        String expResult = "Silver";
        String result = instance.getType();
        assertEquals(expResult, result);
    }

}
