package com.Latihan;

public class praktek2i 
{
    public static void main(String[] args)
    {
        String string1 = "123";
        //String string2 = "abc123";// error, dikarenakan konversi data string ke int tidak dapat konversi huruf 'abc', harus angka semua
        
        int varstr1 = Integer.parseInt(string1);
        
        System.out.println(varstr1 + 2);
        System.out.println(string1 + varstr1);
        
        //int varstr2 = Integer.parseInt(string2);//
        //System.out.println(varstr2);//
    }
}
