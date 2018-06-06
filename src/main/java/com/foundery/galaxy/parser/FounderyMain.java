/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foundery.galaxy.parser;

/**
 *
 * @author ubuntu
 */
public class FounderyMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide the path to the input file");
            System.exit(-1);
        }
        try {
            System.out.println(new DocumentParser(args[0]).getResult());
        } catch (Exception ex) {
            System.out.println("Failed to parse the file : " + args[0]);
            ex.printStackTrace();
        }
    }
    
}
