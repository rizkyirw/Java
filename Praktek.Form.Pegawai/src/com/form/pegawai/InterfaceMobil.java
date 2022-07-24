package com.form.pegawai;

import java.util.Scanner;

interface Mobil
{
    void Model();
    int TambahAkselerasi();
    int Kapasitas_Tangki();
    int Gigi_Max = 6;
            
    void Akselerasi();
    void Kopling();
    void GigiNaik();
    void GigiTurun();
    void Brake();   
}

class CarX implements Mobil
{
    int Gigi;
    int pilih;
    int pilihgigi;

    @Override
    public void Model() {
        System.out.println("Kijang Innova Venturer");
    }

    @Override
    public int TambahAkselerasi() {
        return 140;
    }

    @Override
    public int Kapasitas_Tangki() {
        return 55;
    }
    
    @Override
    public void Akselerasi() {
        System.out.println("Menginjak pedal Gas : Mobil Berjalan !");
    }

    @Override
    public void Kopling()
    {
        System.out.println("Menginjak pedal Kopling. Silahkan Pindahkan Gigi !");
    }
    
    @Override
    public void Brake() {
        System.out.println("Menginjak pedal Rem : Kecepatan Mobil Dikurangi !");
    }
    
    @Override
    public void GigiNaik() {
        Gigi += 1;
        System.out.println("Posisi Kopling : " + this.getGigi());
    }

    @Override
    public void GigiTurun() {
        if (this.Gigi == 0)
        {
            Gigi = this.Gigi + 5;
        }
        else
        {
            Gigi -= 1;
        }
        System.out.println("Posisi Kopling : " + this.getGigi());
    }
    
    public int getGigi()
    {
        return this.Gigi;
    }
}

public class InterfaceMobil {

    public static void main(String args[]) 
    {
        CarX x = new CarX();
        Scanner Omobil = new Scanner(System.in);
        
        //Tampil Output
        System.out.println("Detail Informasi Mobil");
        System.out.println("=========================================================");
        System.out.println("Merk Kendaraan      : " + "Kijang Innova Venturer");
        System.out.println("Akselerasi Maks     : " + x.TambahAkselerasi()+ "km/j");
        System.out.println("Kapasitas BBM       : " + x.Kapasitas_Tangki()+ "Liter");
        
        System.out.println("Pilih Pedal [1 (Gas), 2 (Rem), 3 (Kopling)]  : ");
        x.pilih = Omobil.nextInt();
        
        if (x.pilih == 1)
        {
            x.Akselerasi();
        }
        if (x.pilih == 2)
        {
            x.Brake();
        }
        if (x.pilih == 3)
        {
            x.Kopling();
            System.out.println("Posisi Kopling [1 (Naik)/2 (Turun)] : ");
            x.pilihgigi = Omobil.nextInt();
            
            if (x.pilihgigi == 1)
            {
                x.GigiNaik();
            }
            else if (x.pilihgigi == 2)
            {
                x.GigiTurun();
            }
        }
    }
}
