package com.example.myapplication;

import java.io.*;
import java.util.ArrayList;
public class Anagrams {
    public ArrayList<String> genLetters(String word) {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        ArrayList<String> reducedLetters = new ArrayList<String>();

        int i = 0;

        while(i < letters.length)
        {
            if(!word.contains(letters[i]))
                reducedLetters.add(letters[i]);
            i++;
        }

        return reducedLetters;
    }

    public ArrayList<String> clearList(ArrayList<String> list1, ArrayList<String> list2){
        ArrayList<String> copy = new ArrayList<String>();

        copy = list2;
        for(String j: list1)
        {
            int i = 0;
            while(i < copy.size()) {
                if(copy.get(i).toLowerCase().contains(j))
                    copy.remove(i);
                else
                    i++;
            }
        }
        return copy;
    }

    public ArrayList<String> trim(ArrayList<String> list, String word)
    {
        int i = 0;
        ArrayList<String> copy = list;

        while(i < copy.size())
        {
            if(copy.get(i).length() > word.length())
                copy.remove(i);
            else
                i++;
        }

        return copy;
    }

    public ArrayList<String> readIn(){
        try{
            FileReader fr = new FileReader("assets/words.txt");
            BufferedReader br = new BufferedReader(fr);
            ArrayList<String> words = new ArrayList<String>();
            String x = br.readLine();
            while(x != null){
                words.add(x);
                x = br.readLine();
            }
            return words;
        }
        catch(Exception e){
            System.out.println("k");
        }
        return null;
    }
}