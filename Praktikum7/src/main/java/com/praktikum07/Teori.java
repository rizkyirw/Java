package com.praktikum07;

import javax.swing.*;

public class Teori{
    public static void main(String[] args) {
        
        int pilihan = Integer.parseInt(JOptionPane.showInputDialog("Menu; 1.Lingkaran & Tabung; 2.Persegi Panjang & Balok; 3.Persegi & Kubus"));
        switch (pilihan){
                case 1:
                    double r,t, volume,luasling;
                    r = Double.parseDouble(JOptionPane.showInputDialog("Masukan jari :"));
                    t = Double.parseDouble(JOptionPane.showInputDialog("Masukan tinggi : "));
        
                    Tabung Tabung1 = new Tabung();
                    Lingkaran L = new Lingkaran();
        
                    
                    JOptionPane.showMessageDialog(null,"Luas Lingkaran adalah : "+L.VolTabung(r, t));
        
                    volume = Tabung1.VolTabung(r,t);
                    JOptionPane.showMessageDialog(null,"Volume Tabung adalah : "+volume);
                    break;
                    
                case 2:
                    double p,l,t2,luaspp,volumeb;
                    p = Double.parseDouble(JOptionPane.showInputDialog("Masukkan Panjang: "));
                    l = Double.parseDouble(JOptionPane.showInputDialog("Masukkan Lebar: "));
                    t = Double.parseDouble(JOptionPane.showInputDialog("Masukkan Tinggi: "));
                    
                    PersegiPanjang PP = new PersegiPanjang();
                    Balok B = new Balok();
                    
                    luaspp = PP.luasPersegiPanjang(p, l);
                    JOptionPane.showMessageDialog(null,"Luas Persegi Panjang adalah: "+luaspp);
                    
                    volumeb = B.VolBalok(p, l, t);
                    JOptionPane.showMessageDialog(null,"Volume Balok adalah: "+volumeb);
                    break;
                    
                case 3: 
                    double s,luasPersegi,volKubus;
                    s = Double.parseDouble(JOptionPane.showInputDialog("Masukkan Sisi: "));
                    
                    Persegi P = new Persegi();
                    Kubus K = new Kubus();
                    
                    luasPersegi = P.luasPersegi(s);
                    JOptionPane.showMessageDialog(null,"Luas Persegi adalah: "+luasPersegi);
                    
                    volKubus = K.volKubus(s);
                    JOptionPane.showMessageDialog(null,"Volume Kubus adalah: "+volKubus);
        }
    
    }
}