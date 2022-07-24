package com.Latihan03;

public class latihan03b {
    public static void main(String[] args) {
        int a = 0, hasil;
        System.out.println("============================");
        hasil = (a++ > 14) ? 10: 20;
        System.out.println("Output Satu     : " + hasil);
        
        hasil = (a <= 14) ? 30: 40;
        System.out.println("Output Dua      : " + hasil);
        
        hasil = (a>14 && a<45) ? 50: 60;
        System.out.println("Output Tiga     : " + hasil);
        
        hasil = (a<14 || a<45) ? 70: 80;
        System.out.println("Output Empat    : " + hasil);
        
        System.out.println("============================");
        System.out.println("Program : Latihan03b");
        System.out.println("NIM     : A12.2020.06443");
        System.out.println("Nama    : Isro' Rizky WIbowo");
    }
}
