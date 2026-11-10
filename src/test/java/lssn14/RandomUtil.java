package lssn14;

import java.util.Random;

public class RandomUtil {


    public static void main(String[] args) {

        System.out.println(randomString(10));
    }


    public static String randomString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();

        while (salt.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

//    public static String randomEmail(){
//        return  randomString(length) + "@mail.ru";

    }
