/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.backend;

import java.util.Stack;

/**
 *
 * @author kuckn
 */
public class paradis {
    //////////////////// Paradis To Marley Useful Functions ////////////////////
    
    /**
     * 
     * @return dictionary Paradis to Marley
     */
    public static HashMap paradisToMarley(){
        HashMap<String, String> myHashMap = new HashMap<>();
        
        String[] Marley = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                            "w", "x", "y", "z", "^", "$", ",", "(", ")", "&", "{", ")"};
        String[] Paradis = {"j", "c", "t", "a", "k", "z", "s", "i", "w", "x", "o",
                            "n", "g", "b", "f", "h", "l", "d", "e", "y", "m", "v",
                            "u", "p", "q", "r", "", " ", ",", "(", ")", "&", "{", ")"};
        
        
        for(int i = 0; i<Marley.length; i++){
            myHashMap.put(Paradis[i], Marley[i]);
        }
        
        return myHashMap;
    }
    
    /**
     * 
     * @param paradis is the unprocessed sentence that should be translated to Marley
     * @param num is num part in &num{} for caesar encryption, enter negative number to omit
     * @param start is the string to start caesar encrypt, enter negative number to omit
     * @param end is the end string for caesar encrypt, enter negative number to omit
     * @return Marley sentence
     */
    public static String paradisToMarley(String paradis, int num, int start, int end){
        return caesarEncrypt(paradisConverter(paradisInverter(paradis)), num, start, end);
    }
    
    /**
     * 
     * @param paradis invert the substring that is indicated by user using ()
     * @return inverted substring in () while keeping parentheses
     */
    public static String paradisInverter(String paradis){
        int len = paradis.length();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < len; i++)
        {

          // Push the index of the current
          // opening bracket
          if (paradis.charAt(i) == '(')
          {
            st.push(i);
          }

          // Reverse the substring starting
          // after the last encountered opening
          // bracket till the current character
          else if (paradis.charAt(i) == ')')
          {
              String inverted = paradis.substring(0, st.peek());
              for(int j = i; j>=st.peek(); j--){
                  switch (paradis.charAt(j)) {
                      case '(':
                          inverted+=')';
                          break;
                      case ')':
                          inverted+='(';
                          break;
                      default:
                          inverted += paradis.charAt(j);
                          break;
                  }
              }
              inverted += paradis.substring(i+1);
              paradis = inverted;
              st.pop();
          }
        }
        return paradis;
    }
    
    /**
     * 
     * @param paradis processed paradis sentence by paradisInverter()
     * @return return translated paradis sentence to Marley
     */
    public static String paradisConverter(String paradis){
        String marley = "";
        HashMap dictionary = paradisToMarley();
        
        for(int i=0; i<paradis.length(); i++){
            if(dictionary.containsKey(Character.toString(paradis.charAt(i)))){                
                
                marley += dictionary.get(Character.toString(paradis.charAt(i))).getValue();
                
            } else {
                
                //Difference between marleyConverter and ParadisConverter
                if(Character.isUpperCase(paradis.charAt(i))){
                    marley += '^' ;
                    marley += dictionary.get(Character.toString(paradis.charAt(i)).toLowerCase()).getValue(); 
                }
                else {    
                    marley += paradis.charAt(i);
                }
            }
        }
        
        return marley;
    }
    
    /**
     * 
     * @param paradis is processed paradis sentence by paradisConverter() and paradisInverter()
     * @param num is num part in &num{}
     * @param start is the start string for caesar encryption
     * @param end is the end string for caesar encryption
     * @return translated Marley sentence
     */
    public static String caesarEncrypt(String paradis, int num, int start, int end){
        String str = "";
        if(num<0){
            return paradis;
        }
        
        if(num>2){
            System.out.println("\nError: Encryption value should be less than 3 so that '}' in ASCII code won't be confused with other character"
                    + "\n  Encrypt value is corrected to: 2");
        }
        
        num = num > 2 ? 2 : num;
        
        if(start<0){
            System.out.println("\nError: Encryption start is out of bound. Minimum index of the start of this text is: 0 "
                    + "\n  Start value is corrected to: 0");
        }
        start = start <= 0 ? 0 : start;
        
        if(end>paradis.length()){
            System.out.println("\nError: Encryption end is out of bound. Maximum index of the end of this text is: " + paradis.length()
                    + "\n  End value is corrected to: " + paradis.length());
        }
        end = end>paradis.length() ? paradis.length(): end;
        
        if(end<start){
            System.out.println("\nError: Your logic got problem! You can't set the end of encrypting sentence before the start!"
                    + "\n  End value is corrected to: " + ((start+1)));
            end = start+1;
        }
        
        for(int i=0; i<paradis.length(); i++){
            if(i==start && paradis.charAt(i)!='&' && !Character.isDigit(paradis.charAt(i)) && paradis.charAt(i)!='{'){
                str += '&';
                str += num;
                str += '{';
                
                if(end<start){
                    end+=start+1;
                    System.out.println("\nError: Due to your blunder of giving start/end value, we have to correct the end value ourselve to " + start+1);
                }
                for(int j = start; j<end; j++){
                    str += (char)(paradis.charAt(j) + num);
                    i = j;
                }
                str += '}';
            } else if(i == start && paradis.charAt(i) == '&'){
                str += paradis.charAt(i);
                
                System.out.println("\nError: You should not break the pattern of &num{ of the other Caesar Cipher");
                System.out.println("\nError: start is corrected to " + (start+3));
                start = start + 3;
            } else if(i == start && Character.isDigit(paradis.charAt(i)) && paradis.charAt(i-1)=='&' && paradis.charAt(i+1)=='{'){
                str += paradis.charAt(i);
                
                System.out.println("\nError: You should not break the pattern of &num{ of the other Caesar Cipher");
                System.out.println("\nError: start is corrected to " + (start+2));
                start = start + 2;
            } else if (i == start && Character.isDigit(paradis.charAt(i-1)) && paradis.charAt(i-2)=='&' && paradis.charAt(i)=='{'){
                str += paradis.charAt(i);
                
                System.out.println("\nError: You should not break the pattern of &num{ of the other Caesar Cipher");
                System.out.println("\nError: start is corrected to " + (start+1));
                start = start + 1;
            }
            else {
                str += paradis.charAt(i);
            }
        }
        return str;
    }
    
    //End/////////////// Paradis To Marley Useful Functions ////////////////////
}
