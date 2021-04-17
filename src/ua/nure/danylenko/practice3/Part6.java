package ua.nure.danylenko.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    public static String convert(String input) {

        StringBuilder vault = new StringBuilder();
        String regex = "(?m)(\\b[a-zA-Zа-яА-Яы]++\\b)([\\s\\r\\n]*)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);

        String buffer;
        while(m.find()){
            buffer=m.group(1);
            int counter = 0;
            String regex2 = "\\b"+buffer+"\\b";
            Pattern p2 = Pattern.compile(regex2);
            Matcher m2 = p2.matcher(input);
            while(m2.find()){
                counter++;
            }

            if(counter>=2) {
                vault.append("_").append(buffer).append(m.group(2));
            }else {
                vault.append(buffer).append(m.group(2));
            }
        }

        return vault.toString();
    }

    public static void main(String[] args){
        String original=Util.readFile("part6.txt");
        System.out.println(convert(original));

    }
}
