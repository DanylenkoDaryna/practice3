package ua.nure.danylenko.practice3;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    private static final String CHARSET = "Cp1251";

    public static String convert(String input) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        result.append("Min: ");
        String minWords = getAllMinWords(input);
        result.append(minWords.substring(0,minWords.length()-1));
        result.append("\n").append("Max: ");
        String maxWords;
            maxWords = getAllMaxWords(input);
            result.append(maxWords.substring(0,maxWords.length()-2));

        return result.toString();
    }

    private static String getAllMaxWords(String input) throws UnsupportedEncodingException {
        StringBuilder vault = new StringBuilder();
        int lettersCounter;
        String regex = new String("(?m)(\\b([a-zA-Zа-яА-ЯЁёйЇїІіЄє]){1,}?\\b)".
                getBytes(CHARSET),CHARSET);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        String buffer = "";
        while(m.find()){
            if(buffer.length()==0) {
                buffer=m.group(1);
                vault.append(buffer).append(", ");
            }else{

                lettersCounter=m.group(1).length();
                if(buffer.length()<lettersCounter){
                    buffer=m.group(1);
                    vault.replace(0,buffer.length(),buffer).append(", ");
                }else if(buffer.length()==lettersCounter
                        && !vault.toString().contains(m.group(1))){

                        vault.append(m.group(1)).append(", ");

                }
            }
        }
        return vault.toString();
    }

    private static String getAllMinWords(String input) throws UnsupportedEncodingException {
        StringBuilder vault = new StringBuilder();
        int n=1;

        String regex = new String("(?m)(\\b([a-zA-Zа-яА-ЯЁёйЇїІіЄє]){1}?\\b)".
                getBytes(CHARSET),CHARSET);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);

        while(!m.find()){
            n=n+1;
            String str = "(?m)(\\b([a-zA-Zа-яА-ЯЁёйЇїІіЄє]){"+n+"}?\\b)";
            regex = new String(str.getBytes(CHARSET),CHARSET);
            p = Pattern.compile(regex);
            m = p.matcher(input);
        }
        vault.append(m.group(1)).append(", ");

        while (m.find()) {
            String res =  m.group(1);
            if(!vault.toString().contains(res)) {
                vault.append(res).append(", ");
            }
        }

        return vault.toString().substring(0,vault.length()-1);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String original;
        original = new String(Util.readFile("part2.txt").getBytes(CHARSET),CHARSET);
        System.out.println(convert(original));

    }
}
