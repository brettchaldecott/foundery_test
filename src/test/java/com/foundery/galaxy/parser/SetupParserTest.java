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
public class SetupParserTest {
    
    public SetupParserTest() {
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
     * Test of getSetTokens method, of class SetupParser.
     */
    @Test
    public void testGetNumeralName() {
        System.out.println("getNumeralName");
        SetupParser instance = new SetupParser(new String[] {"glob","is","I"});
        String result = instance.getNumeralName();
        assertEquals("glob", result);
    }

    /**
     * Test of getValue method, of class SetupParser.
     */
    @Test
    public void getRomanNumeral() {
        System.out.println("getRomanNumeral");
        SetupParser instance = new SetupParser(new String[] {"glob","is","I"});
        String expResult = "I";
        String result = instance.getRomanNumeral();
        assertEquals(expResult, result);
    }
}
