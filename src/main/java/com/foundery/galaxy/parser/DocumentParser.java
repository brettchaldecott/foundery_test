/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foundery.galaxy.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Brett Chaldecott
 */
public class DocumentParser {
    
    private final static String ERROR_MESSAGE = "I have no idea what you are talking about\n";
    private final static String MUCH_FORMAT = "%sis %d\n";
    private final static String MANY_FORMAT = "%s%s is %d %s\n";
    
    private Map<String,SetupParser> mappings = new HashMap<String,SetupParser>();
    private Map<String,RatioParser> ratios = new HashMap<String,RatioParser>();
    private StringBuilder builder = new StringBuilder();
    
    public DocumentParser(String sourceFile) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
        String line = null;
        while ((line = reader.readLine()) != null) {
            SentenceParser sentence = new SentenceParser(line);
            if (sentence.getSetupParser() != null) {
                mappings.put(sentence.getSetupParser().getNumeralName(),sentence.getSetupParser());
            } else if (sentence.getRatioParser() != null) {
                ratios.put(sentence.getRatioParser().getType(),sentence.getRatioParser());
            } else {
                QueryParser queryParser = sentence.getQueryParser();
                if (queryParser == null) {
                    builder.append(ERROR_MESSAGE);
                    continue;
                }
                StringBuilder resultTokens = new StringBuilder();
                RomanNumeral romanNumeral = 
                        getRomanNumeral(queryParser.getTokens(), resultTokens);
                
                if (romanNumeral == null) {
                    builder.append(ERROR_MESSAGE);
                    continue;
                }
                
                if (queryParser.isMuchQuery()) {
                    builder.append(String.format(MUCH_FORMAT, resultTokens.toString(),romanNumeral.getValue()));
                } else {
                    RatioParser ratioParser = this.ratios.get(queryParser.getType());
                    if (ratioParser == null) {
                        builder.append(ERROR_MESSAGE);
                        continue;
                    }
                    RomanNumeral ratioRoman = 
                        getRomanNumeral(ratioParser.getTokens());
                    
                    long howMany = ratioParser.getValue() / ratioRoman.getValue() * 
                            romanNumeral.getValue();
                    
                    builder.append(String.format(MANY_FORMAT, 
                            resultTokens.toString(),ratioParser.getType(),howMany,ratioParser.getUnit()));
                    
                    
                }
            }
                
        }

    }
    
    
    public String getResult() {
        return this.builder.toString();
    }
    
    private RomanNumeral getRomanNumeral(List<String> tokens) {
        return getRomanNumeral(tokens,new StringBuilder());
    }
    
    private RomanNumeral getRomanNumeral(List<String> tokens, StringBuilder resultTokens) {
        if (tokens == null) {
            System.out.println("The tokens are null");
            return null;
        }
        StringBuilder romanString = new StringBuilder();
        
        for (String token : tokens) {
            resultTokens.append(token).append(" ");
            if (!mappings.containsKey(token)) {
                return null;
            }
            romanString.append(mappings.get(token).getRomanNumeral());
        }
        return new RomanNumeral(romanString.toString().trim());
    }
    
}
