package com.magiconch.backend;

import static com.magiconch.backend.Cipher.myDecrypt;
import static com.magiconch.backend.Cipher.myEncrypt;
import static com.magiconch.backend.Marley.marleyToParadis;
import static com.magiconch.backend.Paradis.caesarEncrypt;
import static com.magiconch.backend.Paradis.paradisConverter;
import static com.magiconch.backend.Paradis.paradisInverter;
import static com.magiconch.backend.Paradis.paradisToMarley;
import java.util.Scanner;


public class Speech {
    private final Scanner sc = new Scanner(System.in);
    
    public void combinedScenes(){
        try{
            Scene1();
        }catch(Exception e){
            System.out.println("##################################");
            System.out.println("#Scene 1 halted due to some error#");
            System.out.println("##################################\n");
        }
        try{
            Scene2();
        }catch(Exception e){
            System.out.println("##################################");
            System.out.println("#Scene 2 halted due to some error#");
            System.out.println("##################################\n");
        }
        try{
            Scene3();
        }catch(Exception e){
            System.out.println("##################################");
            System.out.println("#Scene 3 halted due to some error#");
            System.out.println("##################################\n");
        }
    }
        
    public void Scene1(){
        System.out.println("Scene 1");
        System.out.println("//Eren faced is displayed");
        System.out.println("Eren: ");
        System.out.println("  With Wall Maria being cleared of Titans, I can finally go back to my house basement.");
        sc.nextLine();
        System.out.println("  ...After searching around the basement...");
        sc.nextLine();
        System.out.println("Eren: ");
        System.out.println("  Oh! Isn't this some an information with Marley's sentence and a Marley Dictionary?");
        sc.nextLine();
        System.out.println("  I should translate it the Paradis language to reveal the secret from my father.");
        sc.nextLine();       
    }
    
    public void Scene2(){
        System.out.println("Scene 2 - Paper scene to show information");
        String informationFromGrisha = "hello Eren";
        String marleySentence = paradisToMarley(informationFromGrisha, -1, -1, -1); 
        System.out.println("Information from Grisha: ");
        System.out.println("  " + marleySentence);
        sc.nextLine();
        System.out.println("Translating to Paradis Language...");
        System.out.println("  " + marleyToParadis(marleySentence));
        sc.nextLine();
    }
    
    public void Scene3(){
        System.out.println("Scene 3 - Wall Maria Crisis");
        System.out.println("//Captain Erwin face is displayed");
        System.out.println("Captain Erwin: ");
        System.out.println("  Eren I found an information from the enemy.");
        System.out.println("  Please decrypt this message immediately, I have a bad feeling about this");
        String a =  "Message from Reiner Braun: /n" +
                    "      By sunset, Bertholdt and I will transform into Colossal Titan and Armored Titan respectively to destroy Wall Maria.\n" +
                    "    Here is the building structure of Wall of Maria, we are going to break the weakest part where most edges of bricks align together.\n"+
                    "    Height of the wall: [input]\n" +
                    "    Width of the wall: [input]\n";
        sc.nextLine();
        System.out.println("\nSecret message in Marley: ");
        System.out.println(paradisToMarley(a,-1, -1, -1));
        sc.nextLine();
        System.out.println("//Eren face is displayed");
        System.out.println("Eren: ");
        System.out.println("  Captain Erwin, these are the secret message from Marley. We are under attack!!!");
        sc.nextLine();
        System.out.println("\nSecret message in Paradis: ");
        System.out.print(marleyToParadis(paradisToMarley(a,-1, -1, -1)));
        sc.nextLine();   
        WallMaria wall = new WallMaria();
        wall.loadWall(10, 10);
        wall.printWall();    
        sc.nextLine();
        System.out.println("Eren: ");
        System.out.println("  Captain Erwin, the weakest part of the wall is at position: " + wall.weakestPart());
        sc.nextLine();
        System.out.println("Captain Erwin: ");
        System.out.println("  Soldiers! Quick! Move to position " + wall.weakestPart() + " and protect Wall Maria.");
    }
    
    public void Bonus_Encrypt(){
        System.out.println("Eren: ");
        System.out.println("  Captain Erwin, try to convert Paradis sentence to Marley sentence.");
        System.out.println("  Use () to invert certain character. ");
        System.out.print("  Your Paradis Sentence: ");
        String sentence = sc.nextLine();
        String marley = paradisConverter(paradisInverter(sentence));//=========================1
        System.out.println("");
        System.out.println("  Important note!!! Do not insert caesar cipher that breaks this sequence: &num{");
        while(true){
            System.out.print("  Do you want the further encrypt with Caesar Cipher? [y/n]: ");
            String answer = sc.next();
            if(answer.equalsIgnoreCase("y")){
                System.out.print("  Insert 1 or 2 for Caesar Decryption. -1 to omit: ");
                int caesar = sc.nextInt();//=========================2
                if(caesar>0){
                    System.out.print("  Insert the index of starting character for Caesar Encryption: ");
                    int start = sc.nextInt();
                    System.out.print("  Insert the index of ending character for Caesar Encryption: ");
                    int end = sc.nextInt();
                    sc.nextLine();
                    marley = caesarEncrypt(marley, caesar, start, end);// 
                    System.out.println("  Current marley: " + marley);
                }else{
                    System.out.println("  Current marley: " + marley);
                    break;
                }
            }else {
                System.out.println("  Current marley: " + marley);
                break;
            }   
        }
        String paradis = marleyToParadis(marley);
        System.out.println("\nEren: ");
        System.out.println("  Captain Erwin, this is the Marley Sentence.");
        System.out.println("  " + marley);
        sc.nextLine();
        System.out.println("Eren: ");
        System.out.println("  Captain Erwin, do you want to further encrypt this code with my cipher?");
        System.out.print("  Answer [Y/n]: ");
        String answer = sc.next();
        String myEncrypted = myEncrypt(marley);
        String myDecrypted = myDecrypt(myEncrypted);
        if(answer.equalsIgnoreCase("y")){
            System.out.println("\nFurther Encrypted Sentence: ");
            System.out.println("  " + myEncrypted);
            
            sc.nextLine();
        
            System.out.println("Eren: ");
            System.out.println("  This is proof of the conversion is functional.");
            System.out.println("  The decrypted message: ");
            System.out.println("    " + marleyToParadis(myDecrypted));
        } else {
            sc.nextLine();
            System.out.println("Eren: ");
            System.out.println("  This is proof of the conversion is functional.");
            System.out.println("  The decrypted message: ");
            System.out.println("    " + paradis);
        }
        
    } 
}
