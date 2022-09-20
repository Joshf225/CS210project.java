package com.company2;
import java.security.MessageDigest;
import java.util.*;



public class sentenceg {

    public static void main(String[] args) {
        Random ran = new Random();
        //String[] sen1 = book.split(".");


    }
    //This method is to compare hash codes to each other
    public static Integer Compare(String str1, String str2,int count){
        for(int i = 0;i<64;i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                count++;
            }
        }

        return count;
    }
    //This is the hash code method that I got from moodle
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

   /* public static int countDupl(String input){

    }*/

}
