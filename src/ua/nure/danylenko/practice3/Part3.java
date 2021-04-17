package ua.nure.danylenko.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    public static String convert(String input) {
        StringBuilder result = new StringBuilder();
        int lettersCounter;
        String regex = "\\b([a-zA-Zа-яА-ЯёЁйЙєЄЇїІі]++\\b?)([',-.?]?(\\s|—|(\r\n))*)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        while(m.find()){
                lettersCounter=m.group(1).length();
                if(lettersCounter>=3){

                    if(Character.isLowerCase(m.group(1).charAt(0))){
                        result.append(Character.toUpperCase(m.group(1).charAt(0)));
                    }else if(Character.isUpperCase(m.group(1).charAt(0))){
                        result.append(Character.toLowerCase(m.group(1).charAt(0)));
                    }
                    result.append(m.group(1).substring(1,lettersCounter)).append(m.group(2));
                }else {
                    result.append(m.group(1)).append(m.group(2));
                }
        }
        return result.toString();
    }

    public static void main(String[] args){
        String original=Util.readFile("part3.txt");
        System.out.println(convert(original));
    }
}
