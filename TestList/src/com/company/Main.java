package com.company;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        String d1 = " 23.11.2011";
        String d2 = " 23.10.2011";
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = format.parse(d1);
            date2 = format.parse(d2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long difference = date1.getTime() - date2.getTime();
        int days = (int) (difference / (24 * 60 * 60 * 1000));
        System.out.println("days=" + days);

    }
}
