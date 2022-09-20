package com.company2;

import java.io.*;
import java.security.MessageDigest;
import java.util.Random;
import java.util.Scanner;

public class CS210project {
    public static void main(String[] args) throws  FileNotFoundException {
        File file = new File("C:\\Users\\Joshua\\IdeaProjects\\CS210project.java\\src\\com\\company2\\sentences");
        Scanner scan = new Scanner(file);
        Random ran = new Random();
        //If you add more sentences to the sentence file make sure you change the size of the array to the amount in the file
        String sent1[] = new String[14022];
        //store each line in file into array
        System.out.println("Searching...");
        while (scan.hasNextLine()) {
            for (int n = 0; n < 14022; n++) {
                sent1[n] = scan.nextLine();
            }
        }

        //System.out.println(sent1[382]);
            int temp = 0;
            int count = 0;
                //loop i many times just to make sure it compares every possible sentence
                //MORE SENTENCES YOU HAVE IN THE FILE YOU HAVE THE BETTER OUTCOME YOU GET
                    for(int i = 0; i < sent1.length; i++) {
                        for(int j = i+1; j < sent1.length; j++) {
                                temp = Compare(sha256(sent1[i]), sha256(sent1[j]), count);
                                //print if sentences aren't the same
                                //and I did temp>12 just as a base cause itll just look from 12 above which takes less time
                                //If nothing prints just run again
                                if (temp > 1 && temp < 64 && sent1[i] != sent1[j]) {
                                    System.out.print(sent1[i] + "\n" + sha256(sent1[i]) + "\n" + sent1[j] + "\n" + sha256(sent1[j]) + "\n" + temp + "\n");
                                    break;

                            }
                        }while(i == sent1.length-1){
                            System.out.print("Done!");
                            break;

                        }
                    }


        //System.out.println(sent2[n2]+"\n"+sent1[n1]);
    }
    public static Integer Compare(String str1, String str2,int count){
        for(int i = 0;i<64;i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                count++;
            }
        }

        return count;
    }
    public static String sha256(String input){
        try{
            MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
            byte[] salt = "CS210+".getBytes("UTF-8");
            mDigest.update(salt);
            byte[] data = mDigest.digest(input.getBytes("UTF-8"));
            StringBuffer sb = new StringBuffer();
            for (int i=0;i<data.length;i++){
                sb.append(Integer.toString((data[i]&0xff)+0x100,16).substring(1));
            }
            return sb.toString();
        }catch(Exception e){
            return(e.toString());
        }
    }

}

