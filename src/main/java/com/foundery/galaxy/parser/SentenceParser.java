/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foundery.galaxy.parser;

/**
 *
 * @author Brett Chaldecott
 */
public class SentenceParser {
    // key words
    public final static String QUESTION_MARK = "?";
    public final static String IS = "is";
    public final static String HOW = "how";
    public final static String MANY = "many";
    public final static String MUCH = "much";
    
    private String valueArray[];
    private boolean valid = true;
    private boolean query = false;
    private QueryParser queryParser;
    private SetupParser setupParser;
    private RatioParser ratioParser;
    
    public SentenceParser(String value) {
        valueArray = value.trim().split(" ");
        if (valueArray.length < 3) {
            valid = false;
        }
        if (valueArray[valueArray.length - 1].equals(QUESTION_MARK)) {
            query = true;
            this.queryParser = new QueryParser(valueArray);
        } else if (valueArray[0].equals(HOW)) {
            valid = false;
        } else if (valueArray.length == 3) {
            this.setupParser = new SetupParser(valueArray);
        } else {
            this.ratioParser = new RatioParser(valueArray);
        }
    }
    
    public boolean isValid() {
        return valid;
    }
    
    public boolean isQuery() {
        return query;
    }
    
    public QueryParser getQueryParser() {
        return queryParser;
    }
    
    public SetupParser getSetupParser() {
        return setupParser;
    }

    public RatioParser getRatioParser() {
        return ratioParser;
    }
    
    
    
}
