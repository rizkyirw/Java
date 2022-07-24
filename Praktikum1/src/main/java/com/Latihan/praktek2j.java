package com.Latihan;

import java.util.Scanner;

public class praktek2j 
{
    public static void main(String args[]) 
    {
        //scanner input
        Scanner u_input = new Scanner(System.in);
        System.out.println("Silahkan Masukan Nama dan Nilai Anda Dibawah");
        //deklarasi variabel
        String nama;
        int nilai1, nilai2;
        float rata2;
        //output by user
        System.out.println("=====================");
        System.out.println("Nama      :   " );
        nama = u_input.nextLine();
        System.out.println("Nilai1    :   " );
        nilai1 = u_input.nextInt();
        System.out.println("Nilai2  :   " );
        nilai2 = u_input.nextInt();
        System.out.println("=====================");
        rata2 = (nilai1 + nilai2) / 2;
        System.out.println("Rata-rata   :   " + rata2);
    }
}
