package com.company2;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.util.Random;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\Joshua\\IdeaProjects\\CS210project.java\\src\\com\\company2\\sentences");
        Scanner scan = new Scanner(file);
        Random ran = new Random();
        int n1 = ran.nextInt(4710);
        String fileContent = "";
        fileContent = fileContent.concat(scan.nextLine() + "\n");
        String sen1[] = new String[4710];
        System.out.println();
        while(scan.hasNextLine()) {
            for(int i=0;i<4710;i++) {
                sen1[i] = fileContent;
                System.out.println(sen1[i]);
            }
        }
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
