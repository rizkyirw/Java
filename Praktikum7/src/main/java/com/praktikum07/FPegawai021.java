package com.praktikum07;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class FPegawai021 extends JFrame implements ActionListener
{
    private JPanel          pPgw        = new JPanel();
    private JLabel          lNip        = new JLabel("N I P       "),
                            lNama       = new JLabel("Nama        "),
                            lBagian     = new JLabel("Bagian      "),
                            lcreate     = new JLabel("nama");
    private JTextField      fNip        = new JTextField(),
                            fNama       = new JTextField(),
                            fBagian     = new JTextField();
    private JButton         btnAdd      = new JButton(),
                            btnCari     = new JButton(),
                            btnKoreksi  = new JButton(),
                            btnHapus    = new JButton(),
                            btnSelesai  = new JButton();
    
    public FPegawai021()
    {
        setPreferredSize(new Dimension(450,300));
        setTitle("Data Pegawai");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JDesktopPane pPgw = new JDesktopPane();
        
        //mengatur letak objek di kontainer//
        lNip.setBounds(15, 20, 100, 25);
        lNama.setBounds(15, 55, 100, 25);
        lBagian.setBounds(15, 90, 100, 25);
        lcreate.setBounds(230, 225, 200, 25);
        lcreate.setText("Create by Isro' Rizky W. - 06443");
        
        //mengatur letak objek text di kontainer//
        fNip.setBounds(115, 20, 100, 25);
        fNama.setBounds(115, 55, 205, 25);
        fBagian.setBounds(115, 90, 92, 25);
        fNip.setToolTipText("Isi NIP dengan Angka !");
        
        //mengatur letak button di container//
        btnAdd.setBounds(20, 150, 85, 25);
        btnAdd.setText("Add");
        btnAdd.setBackground(Color.BLUE);
        btnAdd.setForeground(Color.getHSBColor(250, 0, 255));
        btnCari.setBounds(120, 150, 85, 25);
        btnCari.setText("Cari");
        btnKoreksi.setBounds(220, 150, 85, 25);
        btnKoreksi.setText("Koreksi");
        btnHapus.setBounds(220, 185, 85, 25);
        btnHapus.setText("Hapus");
        btnSelesai.setBounds(320, 150, 85, 60);
        btnSelesai.setText("Selesai");
        btnSelesai.setToolTipText("Mengakhiri Program");
        
        //objek button di nonaktifkan dan di aktifkan
        btnAdd.setEnabled(true);
        btnSelesai.setEnabled(true);
        
        //mengatur objek untuk dapat berinteraksi
        btnAdd.addActionListener(this);
        btnCari.addActionListener(this);
        btnKoreksi.addActionListener(this);
        btnHapus.addActionListener(this);
        btnSelesai.addActionListener(this);
        
        //meletakkan seluruh kontrol pada objek panel
        pPgw.add (lNip);
        pPgw.add (fNip);
        pPgw.add (lNama);
        pPgw.add (fNama);
        pPgw.add (lBagian);
        pPgw.add (fBagian);
        pPgw.add (lcreate);
        pPgw.add (btnAdd);
        pPgw.add (btnCari);
        pPgw.add (btnKoreksi);
        pPgw.add (btnHapus);
        pPgw.add (btnSelesai);
        
        //menambahkan objek panel (pPgw) ke container frame
        getContentPane().add(pPgw).setBackground(Color.getHSBColor(100, 150, 75));
        
        //menampilkan frame ke layar monitor
        pack();
        Kosong();
        settombol(1, 1, 0, 0, 1);
    }
   
    public static void main(String args[]) 
    {
        new FPegawai021().setVisible(true);
    }
    
    //fungsi jika user melakukan aksi tekan tombol button
    public void actionPerformed(ActionEvent ae)
    {
        Object obj = ae.getSource();
        
        //saat dipilih add
        if (obj == btnAdd)
        {
            if (btnAdd.getText()=="Simpan")
            {
                String xnip = fNip.getText();
                if (xnip.length() !=0)
                    Add();
                else
                    JOptionPane.showMessageDialog(this, "Nip kosong !");
                
                btnAdd.setText("Add");
                Kosong();
                settombol(1, 1, 0, 0, 1);
            }
            else 
            {
                Kosong();
                settombol(1, 0, 0, 0, 1);
                btnAdd.setText("Simpan");
                btnAdd.setForeground(Color.getHSBColor(100, 10, 0));
                btnAdd.setForeground(Color.getHSBColor(200, 100, 100));
            }
        }
        
        // saat pilih cari
        if (obj == btnCari)
        {
            String xcari = JOptionPane.showInputDialog(this,"Masukkan NIP !");
            if (xcari != null)
            {
                fNip.setText(xcari);
                int Cari = 0;
                int xx = Cari;
                if (xx == 1) settombol(1, 1, 1, 1, 1);
            }
            else
                JOptionPane.showMessageDialog(this, "NIP Kosong !");
        }
        
        //saat dipilih koreksi
        if (obj == btnKoreksi)
        {
            if (btnKoreksi.getText()== "Simpan");
            {
                if (fNip.getText() != "") Koreksi();
                btnKoreksi.setText("Koreksi");
                Kosong();
                settombol(1, 1, 0, 0, 1);
            }
            else
            {
                    btnKoreksi.setText("Simpan");
                    settombol(0, 0, 1, 0, 1);
                    fNama.requestFocus();
            }
        }
        
        //saat pilih hapus
        if (obj == btnHapus)
        {
            int stt = JOptionPane.showConfirmDialog(this, "Yakin Dihapus ?");
            System.out.print(stt);
            
            if (stt == 0)
            {
                Hapus();
                Kosong();
            }
        }
        
        // saat pilih selesai
        if (obj == btnSelesai)
        {
            System.exit(0);
        }
    }
    
    //fungsi menambahkan data ke tabel barang
    void Add()
    {
        try
        {
            JOptionPane.showMessageDialog(this, "Proses untuk Add !");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Penambahan Gagal !");
        }
    }
    
    //fungsi untuk cari kode_barang ke tabel barang
    int Cari()
    {
        int x = 0;
        return x;
    }
    
    //fungsi nambahkan data ke tabel barang
    void Koreksi()
    {}
    
    //fungsi nambahkan data ke tabel barang
    void Hapus()
    {}
    
    //fungsi kosongkan objek masukan
    void Kosong()
    {
        fNip.setText("");
        fNama.setText("");
        fBagian.setText("");
        fNip.requestFocus();
    }
    
    void settombol(int a, int b, int c, int d, int e)
    {
        btnAdd.setEnabled(a>=1 ? true: false);
        btnCari.setEnabled(a>=1 ? true: false);
        btnKoreksi.setEnabled(c>=1 ? true: false);
        btnHapus.setEnabled(d>=1 ? true: false);
        btnSelesai.setEnabled(e>=1 ? true: false);
    }
}
