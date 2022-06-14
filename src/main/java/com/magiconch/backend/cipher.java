/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.backend;

import java.util.Random;

/**
 *
 * @author kuckn
 */
public class cipher {
    //////////////////////// My Own Cipher Useful Functions ////////////////////
    // Encrypt
    public static String myEncrypt(String sentence){
        return spaceConverter(invertAll(numerized(sentence)));
    }
    
    // Firstly, split and store ASCII value of each character into a space separated String while adding the ASCII value with a random integer
    public static String numerized(String sentence){
        String str = "";
        Random r = new Random();
        int rand = r.nextInt(900)+100;
        str += rand;
        str += " ";
        for(int i = 0; i<sentence.length(); i++){
            str += (int)sentence.charAt(i) + rand;
            str += " ";
        }
        return str;
    }
    
    // Secondly, invert the whole encrypted sentence
    public static String invertAll(String sentence){
        String str = "";
        for(int i = sentence.length()-1; i>=0; i--){
            str += sentence.charAt(i);
        }
        return str;
    }
    
    // Thirdly, spaces in the text is substituted by anykind of symbols.
    public static String spaceConverter (String sentence) {
        Random r = new Random();
        String str = "";
        String [] symbols = {"a", "b", "c", "d", "e", "f", "g", "h", "i",
                            "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
                            "t", "u", "v", "w", "x", "y", "z", "_", "-", "+",
                            "=", "{", "}", "[", "]", "|", ":", ";", "'", "<",
                            ">", ",", ".", "?", "/", "!", "@", "#", "$", "%",
                            "^", "&", "*", "(", ")"};
        for(int i = 0; i<sentence.length(); i++){
            if(sentence.charAt(i) == ' '){
                str += symbols[r.nextInt(symbols.length)];
            } else {
                str += sentence.charAt(i);
            }
        }
        return str;
    }
    
    
    // Decrypt
    public static String myDecrypt(String encryption){
        return lastConvert(integerSplit(invertAll(symbolsConverter(encryption))));
    }
    
    // Firstly, convert symbols into space
    public static String symbolsConverter(String sentence){
        String str = "";
        for(int i = 0; i<sentence.length(); i++){
            if(Character.isDigit(sentence.charAt(i))){
                str += sentence.charAt(i);
            } else {
                str += " ";
            }
        }
        return str;        
    }
    // Secondly, invert the encrypted sentence
    // Use back the same inverter
    
    // Thirdly, split the numbers into array of Integer
    public static String[] integerSplit(String sentence){
        return sentence.split(" ");
    }
    
    // Fourthly, get the first number and subtract all values with this num before converting them to their own character
    public static String lastConvert(String[] processedSentence){
        String str = "";
        Integer rand = Integer.parseInt(processedSentence[0]);
        
        for(int i = 1; i<processedSentence.length; i++){
            str += (char)(Integer.parseInt(processedSentence[i])-rand);
        }
        return str;
    }
    
    
    //End/////////////////// My Own Cipher Useful Functions ////////////////////
}
