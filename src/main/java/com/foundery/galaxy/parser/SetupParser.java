/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foundery.galaxy.parser;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Brett Chaldecott
 */
public class SetupParser {
    
    private String[] tokens;
    private String numeralName;
    private String romanNumeral;
    
    public SetupParser(String[] tokens) {
        this.tokens = tokens;
        this.numeralName = tokens[0];
        this.romanNumeral = tokens[2];
    }
    
    
    public String getNumeralName() {
        return numeralName;
    }
    
    public String getRomanNumeral() {
        return romanNumeral;
    }
}
