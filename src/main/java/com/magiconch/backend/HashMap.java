/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.backend;

import java.util.List;
import java.util.Random;

/**
 *
 * @author kuckn
 */
public class HashMap<K, V>{
    // for better re-sizing is taken as 2^5
    private static final int SIZE = 32;
    
    private Entry table[] = new Entry[SIZE];
    
    /**
     * To store the Map data in key and value pair.
     * Used linked list approach to avoid the collisions
     */
    
    class Entry <K, V>{
        final K key;
        V value;
        Entry next;
        
        Entry(K k, V v){
            key = k;
            value = v;
        }
        
        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }
    }
    
    ///////////////////// Start of HashMap Useful Functions ////////////////////
    
    /**
     * Returns the entry mapped to key in HashMap
     * @param k
     * @return the Entry Bucket
     * Note: use .getValue() to get value of the key
     */
    public Entry get(K k){
        /**
        * Returns a hash code for this string. The hash code for a
        * {@code String} object is computed as
        * <blockquote><pre>
        * s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
        * </pre></blockquote>
        * using {@code int} arithmetic, where {@code s[i]} is the
        * <i>i</i>th character of the string, {@code n} is the length of
        * the string, and {@code ^} indicates exponentiation.
        * (The hash value of the empty string is zero.)
        *
        * @return  a hash code value for this object.
        */
        int hash = k.hashCode() % SIZE;
        Entry e = table[hash];
        
        // Bucket is identified by hashCode and traversed the bucket
        // till element is not found
        while(e != null){
            if(e.key.equals(k)){
                return e;
            }
            e = e.next;
        }
        return null;
    }
    
    public void put(K k, V v){
        if (k == null){
            System.out.println("##Error inserting " + k + ". Null value");
            return;
        }
        
        int hash = k.hashCode() % SIZE;
        Entry e = table[hash];
        
        if(e != null){
            // If we will insert duplicate key-value pair,
            // Old value will be replaced by new one.
            if(e.key.equals(k)){
                e.value = v;
            } else {
                // Collision: insert new element at the end of list
                // in the same bucket
                while(e.next != null) {
                    e = e.next;
                }
                Entry entryInOldBucket = new Entry(k, v);
                e.next = entryInOldBucket;
            }
        } else {
            // create new bucket for new element in the map.
            Entry entryInNewBucket = new Entry(k, v);
            table[hash] = entryInNewBucket;
        }
    }
    
    public boolean remove(K deleteKey){
        int hash = deleteKey.hashCode() % SIZE ;
        Entry e = table[hash];
        
        if(e == null){
            return false;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = e;
            
            while(current != null){
                if(current.key.equals(deleteKey)) {
                    if(previous == null) {
                        table[hash] = e.next;
                        return true;
                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }
    }
    
    public boolean containsKey(K key){
        return get(key) != null;
    } 
    
    /////////////////////// End of HashMap Useful Functions ////////////////////
    
    
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
     * @param marley unprocessed marley sentence
     * @return processed marley sentence
     * Note this is used to simplify all functions created to process Marley
     */
    public static String marleyToParadis(String marley){
        return inverter(marleyTranslator(caesarProcessor(marley)));
    }
    
    /**
     * 
     * @param marley is the raw marley sentence that is not processed by any functions 
     * @return return processed marley function that restore the meaning of sentence using caesar cipher
     */
    public static String caesarProcessor(String marley){
        for(int i=0; i<marley.length(); i++){
            if(marley.charAt(i) == '&' && Character.isDigit(marley.charAt(i+1)) && marley.charAt(i+2) == '{') {
                int num = Character.getNumericValue(marley.charAt(i+1));
                
                if(num>2){
                    System.out.println("num in &num{} should not be larger than 2 since character z will be masked. \nError Processing this code: ");
                    break;
                }

                // Find its respective closing curly
                int j  = i+3;
                while(true){
                    if(marley.charAt(j) == '}') {
                        break;
                    } 
                    j++;
                }
                marley = caesarCipher(num, marley, i+3, j);
            }
        }
        return marley;
    }
    
        /**
     * 
     * @param n is num in &num{} this num should be less than 3 so that '}' in ASCII code won't confuse the code 
     * ['x', 'y' & 'z' has ASCII of 120, 121, 122 while '}' has ASCII of 125] 
     * @param s is the marley code
     * @param start is the starting sentence after the first curly bracket of &num{}
     * @param end is the index of closing curly bracket of $num{}
     * @return 
     */
    public static String caesarCipher(int n, String s, int start, int end){
        String oldStr = s;
        for(int i = start; i<end; i++){
//            if(oldStr.charAt(i) == '(' || oldStr.charAt(i) == ')'
//                    || oldStr.charAt(i) == '&' || oldStr.charAt(i) == '{'
//                    || oldStr.charAt(i) == '}' || oldStr.charAt(i) == '$' 
//                    || oldStr.charAt(i) == ',' || oldStr.charAt(i) == '^'){
//                continue;
//            } else {
                oldStr = oldStr.substring(0, i) + (char)((int)oldStr.charAt(i)-n)
                  + oldStr.substring(i + 1);
//            }
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
     * @param marley is the marley sentence that is processed using caesarProcessor()
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
    
    /**
     * 
     * @param marley is the processed sentence using caesarProcessor() & marleyTranslator()
     * @return corrected sentence in parentheses and eliminate parentheses
     */
    public static String inverter(String marley){
        int start = 0;
        int end = 0;
        String str = "";
        
        for(int i=0; i<marley.length(); i++){
            if(marley.charAt(i) == '('){
                start  = i;
                int j = i+1;
                while(true){
                    if(marley.charAt(j) == ')') {
                        break;
                    } 
                    j++;
                }
                end = j;
                
                for (int k = end-1; k>start; k--){
                    str += marley.charAt(k);
                }
                
                i = end;
                
            } else {
                str += marley.charAt(i);
            }
        }
        
        return str;
    }
    //End/////////////// Marley To Paradis Useful Functions ////////////////////
    
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
        int start = 0;
        int end = 0;
        String str = "";
        
        for(int i=0; i<paradis.length(); i++){
            if(paradis.charAt(i) == '('){
                start  = i;
                int j = i+1;
                while(true){
                    if(paradis.charAt(j) == ')') {
                        break;
                    } 
                    j++;
                }
                end = j;
                
                // Difference between Marley Inverter and this Inverter (Keep the parentheses)
                str += paradis.charAt(start);
                for (int k = end-1; k>start; k--){
                    str += paradis.charAt(k);
                }
                // Difference between Marley Inverter and this Inverter (Keep the parentheses)
                str += paradis.charAt(end);
                
                i = end;
                
            } else {
                str += paradis.charAt(i);
            }
        }
        
        return str;
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
        start = start < 0 ? 0 : num;
        
        if(end>paradis.length()){
            System.out.println("\nError: Encryption end is out of bound. Maximum index of the end of this text is: " + paradis.length()
                    + "\n  End value is corrected to: " + paradis.length());
        }
        end = end>paradis.length() ? paradis.length(): end;
        
        for(int i=0; i<paradis.length(); i++){
            if(i==start){
                str += '&';
                str += num;
                str += '{';
                for(int j = start; j<end; j++){
                    str += (char)(paradis.charAt(j) + num);
                    i = j;
                }
                str += '}';
            } else {
                str += paradis.charAt(i);
            }
        }
        return str;
    }
    
    //End/////////////// Paradis To Marley Useful Functions ////////////////////

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
//    public static void main(String[] args) {
//        String x = "^&4{hello}";
//        System.out.println(caesarCipher(4, x, 4, 9));
//    }
//    public static void main(String[] args) {
//        String x = "Hello, my name is Kuck Swee Nien. Nice to meet you!!! 1234567890{}()&$^";
//        String num = numerized(x);
//        System.out.println(num);
//        System.out.println(invertAll(num));
//        String space = spaceConverter(invertAll(num));
//        System.out.println(space);
//        System.out.println(symbolsConverter(space));
//        System.out.println(invertAll(symbolsConverter(space)));
//        System.out.println(lastConvert(integerSplit(invertAll(symbolsConverter(space)))));
//        
//        String e = myEncrypt(x);
//        System.out.println(e);
//        System.out.println(myDecrypt(e));
//    }
//    public static void main(String[] args) {
//        myHashMap<String, String> myHashMap = new myHashMap<>();
//        
//        myHashMap.put("l", "l");
//        myHashMap.put(",", ",");
//        myHashMap.put("Hel", "Nothing");
//        myHashMap.put("He", "SE");
//        
//        String e = (String)myHashMap.get(",").getValue();
//        System.out.println("" + e);
//        
//        myHashMap.put("Hello", "Sad");
//        e = (String)myHashMap.get("l").getValue();
//        System.out.println("" + e);
//        
//        System.out.println(myHashMap.remove(","));
//        e = (String)myHashMap.get("l").getValue();
//        System.out.println("" + e);
//        e = (myHashMap.get(",") != null) ? (String)myHashMap.get(",").getValue() : null;
//        System.out.println("" + e);
//        
//        System.out.println(myHashMap.containsKey("d"));
//        Character x = '(';
//        String y = "&3{acnskw()&$l}";
//        String z = "";
//        for(int i = 0; i<y.length(); i++){
//            z += (char)(((int)y.charAt(i))-3);
//        }
//        System.out.println(z);
//        System.out.println(caesarCipher(3, y, 3, 14));
//        System.out.println(caesarProcessor("hello&2{cefghijklmnopqrstuvwxyz{|}hello"));
//        System.out.println(inverter(marleyTranslator(caesarProcessor("^oh(&1{medi_d%fcedd_e%sm})"))));
//        System.out.println(inverter(marleyTranslator(caesarProcessor("rsgc(qqd^i$tkz)$ko$^udzhd,(rld$sgk^z$)$^gpssld"))));
//        System.out.println(inverter(marleyTranslator(caesarProcessor("&2{t}s&1{h}c(qqd^i$tkz)$ko$^udzh&1{e},(rld$sgk^z$)$^gpssld"))));
//        System.out.println(inverter(marleyTranslator(caesarProcessor("^ukgc$rd(vsq$gh$zshrqkg$gwkzsml)h$dbeszudl"))));
//        System.out.println(marleyToParadis("^ukgc$rd(vsq$gh$zshrqkg$gwkzsml)h$dbeszudl"));
//        System.out.println(caesarEncrypt(paradisConverter(paradisInverter("fi(nd attack titan)")), -1, -1, -1));
//        System.out.println(marleyToParadis("(k&1{rrt_q*%-mi-qei%)heq*}"));
//        
//        
//       }
}


