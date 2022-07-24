package com.latihan04;

import java.util.Scanner;

public class latihan04a {
    public static void main(String[] args) {
        String nama;
        int anak, gaji, tanak, total;
        
        Scanner oscan01 = new Scanner(System.in);
        
        System.out.println("Hitung Tunjangan Anak ");
        System.out.println("================================");
        System.out.println("Nama        : ");
        nama = oscan01.nextLine();
        System.out.println("Anak        : ");
        anak = oscan01.nextInt();
        System.out.println("Gaji        : ");
        gaji = oscan01.nextInt();
        
        //hitung tunjangan anak......
        if (anak > 3)
            tanak = 3 * 200000;
        else
            tanak = anak * 200000;
        
        total = gaji + tanak;
        
        System.out.println("Tunjangan Anak      : " + tanak);
        System.out.println("Total               : " + total);
    }
}
