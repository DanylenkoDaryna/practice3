package ua.nure.danylenko.practice3;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    private static final int LEFT_BORDER = 1000;
    private static final int RIGHT_BORDER = 9999;

    public static String convert1(String input) {

        String regex = "(?m)^(.+?);(.+?);(.+?)$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        m.find();
        StringBuilder result = new StringBuilder();
        while (m.find()) {
            result.append(m.group(1)).append(": ").append(m.group(3))
            .append("\n");
        }
        return result.toString();
    }

    public static String convert2(String input) {
        String regex2 = "(?mu)^(\\S+?);(\\S+?)\\s(\\S+?);(\\S+?)$";
        Pattern p2 = Pattern.compile(regex2);
        Matcher m2 = p2.matcher(input);

        StringBuilder result = new StringBuilder();
        while (m2.find()) {
            result.append(m2.group(3)).append(" ").append(m2.group(2)).
                            append(" (email: ").append(m2.group(4)).append(")").
                                    append("\n");
        }
        return result.toString();
    }

    public static String convert3(String input) {

        String regex = "(?m)^(.+?);(.+?);(.+?)@(.+?)$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);

        StringBuilder voult = new StringBuilder();
        StringBuilder result = new StringBuilder();

            while (m.find()) {

                if(!voult.toString().contains(m.group(4))) {

                    String currentDomain = m.group(4);
                    voult.append(m.group(4));

                    StringBuilder sameDomain = new StringBuilder();
                    Matcher m2 = p.matcher(input);

                    while (m2.find()) {
                        if(m2.group(4).contains(currentDomain)) {
                            sameDomain.append(m2.group(1)).append(", ");
                        }
                    }
                    String temp = sameDomain.toString().substring(0,sameDomain.length()-2);
                    result.append(currentDomain).append(" ==> ").append(temp).append("\n");
                }
            }

        return result.toString();
    }

    public static String convert4(String input) {

        String regex = "(?m)^(.+?);(.+?);(.+?)$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        m.find();
        StringBuilder result = new StringBuilder();
        result.append("Login;Name;Email;Password\n");
        while (m.find()) {
            result.append(m.group(1)).append(";")
                    .append(m.group(2)).append(";")
                    .append(m.group(3)).append(";")
                   .append(randomNums()).append("\n");

        }

        return result.toString();
    }

    private static int randomNums(){
        int diff = RIGHT_BORDER - LEFT_BORDER;
        SecureRandom random = new SecureRandom();
        int i = random.nextInt(diff + 1);
        i += LEFT_BORDER;
        return i;
    }


    public static void main(String[] args){
        String original=Util.readFile("part1.txt");
        System.out.println(convert1(original));
        System.out.println(convert2(original));
        System.out.println(convert3(original));
        System.out.println(convert4(original));
    }
}
