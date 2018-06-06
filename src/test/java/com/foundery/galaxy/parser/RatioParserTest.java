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
public class RatioParserTest {
    
    public RatioParserTest() {
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
     * Test of getTokens method, of class RatioParser.
     */
    @Test
    public void testGetTokens() {
        System.out.println("getTokens");
        RatioParser instance = new RatioParser(new String[]
            {"glob","glob","Silver","is","34","Credits"});
        List<String> expResult = new ArrayList<String>();
        expResult.add("glob");
        expResult.add("glob");
        List<String> result = instance.getTokens();
        assertEquals(expResult, result);
    }

    /**
     * Test of getType method, of class RatioParser.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        RatioParser instance = new RatioParser(new String[]
            {"glob","glob","Silver","is","34","Credits"});
        String expResult = "Silver";
        String result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValue method, of class RatioParser.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        RatioParser instance = new RatioParser(new String[]
            {"glob","glob","Silver","is","34","Credits"});
        int expResult = 34;
        int result = instance.getValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUnit method, of class RatioParser.
     */
    @Test
    public void testGetUnit() {
        System.out.println("getUnit");
        RatioParser instance = new RatioParser(new String[]
            {"glob","glob","Silver","is","34","Credits"});
        String expResult = "Credits";
        String result = instance.getUnit();
        assertEquals(expResult, result);
    }
    
}
