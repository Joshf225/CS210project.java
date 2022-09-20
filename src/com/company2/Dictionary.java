package com.company2;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Dictionary{

    public static void main(String[] args) throws FileNotFoundException{

        File file = new File("C:\\Users\\Joshua\\IdeaProjects\\CS210project.java\\src\\com\\company2\\book");
        Scanner scan = new Scanner(file);
        Random ran = new Random();
        String fileContent = "";
        fileContent = fileContent.concat(scan.nextLine() + "\n");
        String word[] = fileContent.split("(?<=[.!?]) ");
        int length = word.length;
        //int n1 = ran.nextInt(length);
        //int n2 = ran.nextInt(length);
        int count = 0;
        String p[] = new String[count];
        for(int i = 0;i< length;i++){
            if (countsSpace(word[i]) <= 9 && countsSpace(word[i]) >= 2){
                System.out.println(word[i]);
                count++;
            }
            //int n1 = ran.nextInt(count);
        }
        //System.out.println(count);
        String valsent[] = new String[count];
        for(int i = 0; i <= length;i++){
            for(int j = 0; i <= length; j++) {
                if (countsSpace(word[i]) <= 9 && countsSpace(word[i]) >= 2) {
                    valsent[j] = word[i];
                }
            }

        }

    }

    public static int countsSpace(String input){
        int spaces = 0;
        for(int i = 0;i<input.length();i++){
            spaces += (Character.isWhitespace(input.charAt(i))) ? 1 : 0;
        }
        return spaces;
    }

    /*
    String authsent[] = new String[len2];
        System.out.println(authsent.length);
        for(int i = 0;i < len2; i++)
        {
            authsent[i] = arr[i];
            System.out.println(authsent[i]);
        }
     */
}





