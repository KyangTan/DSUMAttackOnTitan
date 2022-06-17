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
public class Marley {
    //////////////////// Marley To Paradis Useful Functions ////////////////////
    /**
     * 
     * @return dictionary that map Marley to Paradis
     */
    public static HashMap marleyToParadis(){
        HashMap<String, String> myHashMap = new HashMap<>();
        
        String[] Marley = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                            "w", "x", "y", "z", "^", "$", ",", "(", ")", "&", "{", "}"};
        String[] Paradis = {"j", "c", "t", "a", "k", "z", "s", "i", "w", "x", "o",
                            "n", "g", "b", "f", "h", "l", "d", "e", "y", "m", "v",
                            "u", "p", "q", "r", "", " ", ",", "(", ")", "", "", ""};
        
        
        for(int i = 0; i<Marley.length; i++){
            myHashMap.put(Marley[i], Paradis[i]);
        }
        
        return myHashMap;
    }
    
    /**
     * 
     * @param marley unprocessed Marley sentence
     * @return processed Marley sentence
 Note this is used to simplify all functions created to process Marley
     */
    public static String marleyToParadis(String marley){
        return inverter(marleyTranslator(caesarProcessor(marley)));
    }
    
    /**
     * 
     * @param marley is the raw Marley sentence that is not processed by any functions 
     * @return return processed Marley function that restore the meaning of sentence using caesar cipher
     */
    public static String caesarProcessor(String marley){
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<marley.length(); i++){
            if (marley.charAt(i) == '&' && Character.isDigit(marley.charAt(i+1)) && marley.charAt(i+2) == '{')
            {
              st.push(i);
            }
            else if (marley.charAt(i) == '}')
            {
              int j =st.pop();
               
              int num = Character.getNumericValue(marley.charAt(j+1));

              if(num>2){
                  System.out.println("num in &num{} should not be larger than 2 since character z will be masked. \nError Processing this code: ");
                  break;
              }
              marley = caesarCipher(num, marley,j+3 ,i);
              System.out.println("  Current decrypted marley: " + marley);
              i=0;
            }
        }
        return marley;
    }
    
        /**
     * 
     * @param n is num in &num{} this num should be less than 3 so that '}' in ASCII code won't confuse the code 
     * ['x', 'y' & 'z' has ASCII of 120, 121, 122 while '}' has ASCII of 125] 
     * @param s is the Marley code
     * @param start is the starting sentence after the first curly bracket of &num{}
     * @param end is the index of closing curly bracket of $num{}
     * @return 
     */
    public static String caesarCipher(int n, String s, int start, int end){
        String oldStr = s;
        for(int i = start; i<end; i++){
            oldStr = oldStr.substring(0, i) + (char)((int)oldStr.charAt(i)-n)
                + oldStr.substring(i + 1);
        }
        
        //To eliminate the num and & and { and } in &num{} 
        oldStr = oldStr.substring(0, end) + oldStr.substring(end+1);
        if(start == 3){
            oldStr = oldStr.substring(3);
        } else {
            oldStr = oldStr.substring(0, start-3) + oldStr.substring(start-2);
            oldStr = oldStr.substring(0, start-3) + oldStr.substring(start-2);
            oldStr = oldStr.substring(0, start-3) + oldStr.substring(start-2);
        }
        return oldStr;
    }
    
    
    /**
     * 
     * @param marley is the Marley sentence that is processed using caesarProcessor()
     * @return translated paradis sentence but keep the parentheses for inverting purposes
     */
    public static String marleyTranslator(String marley){
        String str = "";
        HashMap dictionary = marleyToParadis();
        
        for(int i=0; i<marley.length(); i++){
            if(dictionary.containsKey(Character.toString(marley.charAt(i)))){
                if(marley.charAt(i) == '^'){
                    str += (dictionary.get(Character.toString(marley.charAt(i+1))).getValue()).toString().toUpperCase();
                    i++;
                } else {
                    str += dictionary.get(Character.toString(marley.charAt(i))).getValue();
                }
            } else {
                str += marley.charAt(i);
            }
        }
        return str;
    }
    
    public static void reverse(char A[], int l, int h)
    {
      if (l < h)
      {
        char ch = A[l];
        A[l] = A[h];
        A[h] = ch;
        reverse(A, l + 1, h - 1);
      }
    }
   
    // Function to return the modified string
    public static String inverter(String str)
    {
        int len = str.length();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < len; i++)
        {

          // Push the index of the current
          // opening bracket
          if (str.charAt(i) == '(')
          {
            st.push(i);
          }

          // Reverse the substring starting
          // after the last encountered opening
          // bracket till the current character
          else if (str.charAt(i) == ')')
          {
            char[] A = str.toCharArray();
            reverse(A, st.peek() + 1, i);
            str = String.copyValueOf(A);
            st.pop();
          }
        }
        // To store the modified string
        String res = "";
        for (int i = 0; i < len; i++)
        {
          if (str.charAt(i) != ')' && str.charAt(i) != '(')
          {
            res += (str.charAt(i));
          }
        }
        return res;
    }
    
    //End/////////////// Marley To Paradis Useful Functions ////////////////////
}
