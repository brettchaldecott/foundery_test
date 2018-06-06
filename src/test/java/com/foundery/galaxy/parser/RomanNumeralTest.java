/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foundery.galaxy.parser;

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
public class RomanNumeralTest {
    
    public RomanNumeralTest() {
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

    @org.junit.Test
    public void testGetValue() {
        assertEquals(1, new RomanNumeral("I").getValue());
        assertEquals(1000, new RomanNumeral("M").getValue());
        assertEquals(1944, new RomanNumeral("MCMXLIV").getValue());
        assertEquals(2844, new RomanNumeral("MCCMMXLIV").getValue());
        assertEquals(3844, new RomanNumeral("MCCMMMXLIV").getValue());
        try {
            new RomanNumeral("MCCMMMMXLIV").getValue();
            fail("Invalid format check failed");
        } catch (InvalidRomanNumeralFormat ex) {
            
        }
        try {
            new RomanNumeral("MCCMMMIMXLIV").getValue();
            fail("Invalid format check failed");
        } catch (InvalidRomanNumeralFormat ex) {
            
        }
        assertEquals(2006, new RomanNumeral("MMVI").getValue());
    }
    
    public void testGetRomanString() {
        assertEquals("1", new RomanNumeral(1).getRomanString());
        assertEquals("C", new RomanNumeral(100).getRomanString());
        assertEquals("MCMIII", new RomanNumeral(1903).getRomanString());
    }
    
}
