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
public class InvalidRomanNumeralFormat extends java.lang.RuntimeException {

    /**
     * Creates a new instance of <code>InvalidRomanNumeralFormat</code> without
     * detail message.
     */
    public InvalidRomanNumeralFormat() {
    }

    /**
     * Constructs an instance of <code>InvalidRomanNumeralFormat</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidRomanNumeralFormat(String msg) {
        super(msg);
    }
}
