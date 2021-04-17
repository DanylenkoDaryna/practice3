package ua.nure.danylenko.practice3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class Part4 {

        public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            digest.update(input.getBytes());
            byte[] hash = digest.digest();

            StringBuilder result = new StringBuilder();
            for(byte b: hash){
                result.append(String.format("%02x", b));
            }
            return result.toString().toUpperCase(Locale.ENGLISH);
        }

        public static void main(String[] args) throws NoSuchAlgorithmException {
            System.out.println(hash("passwort", "SHA-256"));
        }

}
