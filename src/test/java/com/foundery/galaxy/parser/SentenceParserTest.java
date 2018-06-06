/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foundery.galaxy.parser;

import java.util.ArrayList;
import java.util.List;
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
public class SentenceParserTest {
    
    public SentenceParserTest() {
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
     * Test of isValid method, of class SentenceParser.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        SentenceParser instance = new SentenceParser("glob is I");
        boolean expResult = true;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
    }

    /**
     * Test of isQuery method, of class SentenceParser.
     */
    @Test
    public void testIsQuery() {
        System.out.println("isQuery");
        SentenceParser instance = new SentenceParser("glob is I");
        boolean expResult = false;
        boolean result = instance.isQuery();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQueryParser method, of class SentenceParser.
     */
    @Test
    public void testGetQueryParser() {
        System.out.println("getQueryParser");
        SentenceParser instance = new SentenceParser("how much is pish tegj glob glob ?");
        QueryParser result = instance.getQueryParser();
        assertEquals(true, result.isMuchQuery());
        List<String> expResult = new ArrayList<String>();
        expResult.add("pish");
        expResult.add("tegj");
        expResult.add("glob");
        expResult.add("glob");
        assertEquals(expResult, result.getTokens());
        
        instance = new SentenceParser("how many Credits is glob prok Silver ?");
        result = instance.getQueryParser();
        assertEquals(false, result.isMuchQuery());
    }

    /**
     * Test of getSetupParser method, of class SentenceParser.
     */
    @Test
    public void testGetSetupParser() {
        System.out.println("getSetupParser");
        SentenceParser instance = new SentenceParser("glob is I");
        SetupParser result = instance.getSetupParser();
        assertEquals("glob", result.getNumeralName());
        assertEquals("I", result.getRomanNumeral());
    }
    
    
    /**
     * Test of getSetupParser method, of class SentenceParser.
     */
    @Test
    public void testGetRatioParser() {
        System.out.println("getRatioParser");
        SentenceParser instance = new SentenceParser("glob glob Silver is 34 Credits");
        RatioParser result = instance.getRatioParser();
        assertEquals("Credits", result.getUnit());
        assertEquals(34, result.getValue());
        assertEquals("Silver", result.getType());
    }
}
