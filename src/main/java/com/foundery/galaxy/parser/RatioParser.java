/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foundery.galaxy.parser;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 *
 * @author Brett Chaldecott
 */
public class RatioParser {
    
    private List<String> tokens = new ArrayList<String>();
    private String type;
    private int value;
    private String unit;
    
    public RatioParser(String[] values) {
        boolean afterIs = false;
        for (int index = (values.length - 1); index >= 0; index--) {
            if (index == (values.length - 1)) {
                unit = values[index];
            } else if (index == (values.length - 2)) {
                value = Integer.parseInt(values[index]);
            } else if (values[index].equals(SentenceParser.IS)) {
                afterIs = true;
                continue;
            } else if (index == (values.length - 4)) {
                type = values[index];
            } else {
                tokens.add(values[index]);
            }
        }
        Collections.reverse(tokens);
        
    }

    public List<String> getTokens() {
        return tokens;
    }

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }
    
    
    
    
}
