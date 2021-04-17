package ua.nure.danylenko.practice3;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class Demo {

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String original=Util.readFile("part1.txt");
        Part1.convert1(original);
        Part1.convert2(original);
        Part1.convert3(original);
        Part1.convert4(original);
        Part1.convert4(original);
        Part2.convert(Util.readFile("part2.txt"));
        Part3.convert(Util.readFile("part3.txt"));
        Part4.hash("password", "SHA-256");
        Part4.hash("passwort", "SHA-256");
        Part5.decimal2Roman(98);
        Part5.roman2Decimal("II");
        Part6.convert(Util.readFile("part6.txt"));
    }
}
