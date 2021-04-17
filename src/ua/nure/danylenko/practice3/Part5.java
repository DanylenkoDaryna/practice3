package ua.nure.danylenko.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part5 {
    private static final int MAX_INT = 100;

    public static String decimal2Roman(int x) {
        StringBuilder result = new StringBuilder();
        if(x<=10){
            result.append(getSimpleRoman(x));
        }else if(x < MAX_INT){
            result.append(getHardRoman(x));
        }else if(x==MAX_INT){
            result.append("C");
        }
       return result.toString();
    }

    private static String getHardRoman(int x) {
        final String container = "1-X;2-XX;3-XXX;4-XL;5-L;6-LX;7-LXX;8-LXXX;9-XC;";
        StringBuilder res = new StringBuilder();

        int firstNumOfX=x/10;

        String regex = firstNumOfX+"-(.+?);";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(container);
        while(m.find()){
            res.append(m.group(1));
        }
        int seckondNumOfX=x%10;
        if(seckondNumOfX!=0) {
            res.append(getSimpleRoman(seckondNumOfX));
        }
        return res.toString();
    }

    private static String getSimpleRoman(int x) {
        final String container = "1-I;2-II;3-III;4-IV;5-V;6-VI;7-VII;8-VIII;9-IX;10-X;";
        String res = "";

        String regex = x+"-(.+?);";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(container);
            while(m.find()){
                res=m.group(1);
            }

        return res;
    }

    public static int roman2Decimal(String s) {
       int index =s.length()-1;
       int sum = 0;

       if(index>0) {
           while (index != 0 && index != -1) {
               int current = getDecimalFromChar(s.charAt(index));
               int prev = getDecimalFromChar(s.charAt(index - 1));

               if (current > prev) {
                   sum = sum + (current - prev);
                   index = index - 2;
               } else {
                   sum = sum + current;
                   index = index - 1;
               }
           }
           if(index==0){
               sum = sum + getDecimalFromChar(s.charAt(index));
           }

       }else{
           sum = sum + getDecimalFromChar(s.charAt(index));
       }
        return sum;
    }


    private static int getDecimalFromChar(char s) {
        final String container = ";1-I;2-II;3-III;4-IV;5-V;6-VI;7-VII" +
                ";8-VIII;9-IX;10-X;50-L;100-C;";
        int res = 0;

        String regex = "(\\d{1,3})-" + s + ";";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(container);
        while (m.find()) {
            res = res + Integer.parseInt(m.group(1));
        }
        return res;
    }

    public static void main(String[] args) {
        for(int i=1; i<=MAX_INT; i++){
            String roman = decimal2Roman(i);
            System.out.println(i+" --> "+roman+" --> "+roman2Decimal(roman));
        }
    }
}
