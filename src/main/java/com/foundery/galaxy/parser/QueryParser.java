/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foundery.galaxy.parser;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brett Chaldecott
 */
public class QueryParser {
    
    private boolean muchQuery = false;
    private List<String> tokens = new ArrayList<String>();
    private String unit;
    private String type;
    
    public QueryParser(String[] values) {
        int index = 0;
        int endPos = values.length;
        if (values[1].equals(SentenceParser.MUCH)) {
            muchQuery = true;
            index = 3;
            endPos = values.length - 1;
        } else {
            index = 4;
            endPos = values.length - 2;
        }
        
        for (; index < endPos; index++) {
            tokens.add(values[index]);
        }
        
        if (!muchQuery) {
            unit = values[2];
            type = values[values.length - 2];
        }
    }

    public boolean isMuchQuery() {
        return muchQuery;
    }

    public List<String> getTokens() {
        return tokens;
    }

    public String getUnit() {
        return unit;
    }

    public String getType() {
        return type;
    }

    
    
    
}
