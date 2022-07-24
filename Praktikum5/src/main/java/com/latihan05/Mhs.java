package com.latihan05;

public class Mhs 
{
    //property...................
    private String nama;
    private float ipk;
    
    //behavior...................
    public void setNama(String nama)
    {
        this.nama = nama;
    }
    public void setIpk(int ipk)
    {
        this.ipk = ipk;
    }
    public String getNama()
    {
        return this.nama;
    }
    
    public static void main(String args[]) {
        Mhs mhsAdi = new Mhs();
        mhsAdi.setNama("Adi Sanjaya");
        System.out.println("Nama mhs : " + mhsAdi.getNama());
    }
}
