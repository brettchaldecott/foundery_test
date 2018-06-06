/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foundery.galaxy.parser;

import java.lang.StringBuilder;

/**
 *
 * @author Brett Chaldecott
 */
public class RomanNumeral {
    
    final static int I_VALUE = 1;
    final static int I = 'I';
    final static int V_VALUE = 5;
    final static int V = 'V';
    final static int X_VALUE = 10;
    final static int X = 'X';
    final static int L_VALUE = 50;
    final static int L = 'L';
    final static int C_VALUE = 100;
    final static int C = 'C';
    final static int D_VALUE = 500;
    final static int D = 'D';
    final static int M_VALUE = 1000;
    final static int M = 'M';
    
    
    private int value = 0;
    private int parsePos;
    private String romanString;
    
    public RomanNumeral(String romanString) {
        parsePos = romanString.length() - 1;
        value = parseString(romanString, 0);
        this.romanString = romanString;
    }
    
    public RomanNumeral(int value) {
        this.value = value;
        this.romanString = buildRomanString(value, 1000);
    }
    
    public int getValue() {
        return value;
    }
    
    public String getRomanString() {
        return romanString;
    }
    
    public String toString() {
        return this.romanString;
    }
    
    private int parseString(String romanString, int bigNumber) {
        int previousValue = 0;
        int result = 0;
        int validationCharCount = 0;
        for (int currentPos = parsePos; currentPos >= 0; currentPos--) {
            int currentValue = 0;
            switch(romanString.charAt(currentPos)) {
                case I:
                    currentValue = I_VALUE;
                    break;
                case V:
                    currentValue = V_VALUE;
                    break;
                case X:
                    currentValue = X_VALUE;
                    break;
                case L:
                    currentValue = L_VALUE;
                    break;
                case C:
                    currentValue = C_VALUE;
                    break;
                case D:
                    currentValue = D_VALUE;
                    break;
                case M:
                    currentValue = M_VALUE;
                    break;
            }
            // validation of duplicates
            if (currentValue == previousValue) {
                validationCharCount++;
                if ((currentValue == D_VALUE || currentValue == L_VALUE || 
                    currentValue == V_VALUE) && 
                        validationCharCount >= 1) {
                    throw new InvalidRomanNumeralFormat("To many [" + currentValue + "] cannot be repeated");
                } else if ((currentValue == I_VALUE || currentValue == X_VALUE || 
                    currentValue == C_VALUE || currentValue == M_VALUE) && 
                        validationCharCount >= 3) {
                    throw new InvalidRomanNumeralFormat("To many [" + currentValue + "] in a row");
                } 
            } else {
                validationCharCount = 0;
            }
            // check if characters 
            if (bigNumber != 0 && currentValue >= bigNumber) {
                return result;
            } else if (currentValue != V_VALUE && currentValue != L_VALUE && currentValue != D_VALUE && currentValue < previousValue) {
                // check if subtraction is allowed
                if (((previousValue == V_VALUE || previousValue == X_VALUE) && currentValue != I_VALUE) || 
                    ((previousValue == L_VALUE || previousValue == C_VALUE) && currentValue != X_VALUE) ||
                    ((previousValue == D_VALUE || previousValue == M_VALUE) && currentValue != C_VALUE)) {
                    throw new InvalidRomanNumeralFormat("Subtraction from [" + bigNumber + "] by [" + currentValue + "] not supported");
                }
                
                parsePos = currentPos;
                result -= parseString(romanString,previousValue);
                currentPos = parsePos;
            } else {
                previousValue = currentValue;
                result += currentValue;
                parsePos = currentPos;
            }
            
            
        }
        return result;
    }
    
    private String buildRomanString(int value, int mod) {
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < (value / mod); index++) {
            switch(mod) {
                case I_VALUE:
                    result.append(I);
                    break;
                case V_VALUE:
                    result.append(V);
                    break;
                case X_VALUE:
                    result.append(X);
                    break;
                case L_VALUE:
                    result.append(L);
                    break;
                case C_VALUE:
                    result.append(C);
                    break;
                case D_VALUE:
                    result.append(D);
                    break;
                case M_VALUE:
                    result.append(M);
                    break;
            }
        }
        
        int subValue = value % mod;
        mod = mod / 10;
        if (subValue == 0 || mod == 0) {
            return result.toString();
        }
        if (subValue >= 500) {
            if (subValue >= 900) {
                subValue -= 900;
                result.append(C).append(M);
            } else {
                result.append(D);
                subValue -= 500;
            }
        } else if (subValue >= 100) {
            if (subValue >= 400) {
                subValue -= 400;
                result.append(C).append(D);
            }
        } else if (subValue >= 50) {
            if (subValue >= 90) {
                subValue -= 90;
                result.append(X).append(C);
            } else {
                result.append(L);
                subValue -= 50;
            }
        } else if (subValue >= 10) {
            if (subValue >= 40) {
                subValue -= 40;
                result.append(X).append(L);
            }
        } else if (subValue >= 5) {
            if (subValue == 9) {
                subValue -= 9;
                return result.append(I).append(X).toString();
            } else {
                result.append(X);
                subValue -= 5;
            }
        } else if (subValue >= 1) {
            if (subValue >= 4) {
                subValue -= 4;
                return result.append(I).append(V).toString();
            }
        } 
        
        result.append(buildRomanString(value,mod));
        
        return result.toString();
    }
    
}
