package com.Latihan;

public class praktek2g 
{
    public static void main(String[] args) 
    {
        double[] array = {1.1, 2, 3, 4, 5};
        int sum = 0;
        
        for(double num : array)
        {
            sum = (int) (sum + num);
        }
            System.out.println("Jumlah dari semua elemen array adalah : " + sum);
    }
}
