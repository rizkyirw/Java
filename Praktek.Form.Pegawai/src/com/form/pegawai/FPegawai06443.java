package com.form.pegawai;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;

import javax.swing.table.DefaultTableModel;

public class FPegawai06443 extends JFrame implements ActionListener
{
    private JPanel          pPgw        = new JPanel();
    private JLabel          lNip        = new JLabel ("N I P    "),
                            lNama       = new JLabel ("Nama     "),
                            lBagian     = new JLabel ("Bagian   "),
                            lcreate     = new JLabel ("nama");
    
    private JTextField      fNip        = new JTextField(),
                            fNama       = new JTextField(),
                            fBagian     = new JTextField();
    
    private JButton         btnAdd      = new JButton(),
                            btnCari     = new JButton(),
                            btnKoreksi  = new JButton(),
                            btnHapus    = new JButton(),
                            btnSelesai  = new JButton();
    
    //Tambah
    private ResultSet rs;
    String[] header = {"Nip", "Nama", "Bagian"};
    
    DefaultTableModel tabModel;
    JTable tabel = new JTable();
    JScrollPane skrTabel = new JScrollPane();
    
    public FPegawai06443()
    {
        setPreferredSize(new Dimension(570,410));
        setTitle("Data Pegawai");
        //setDefaultCloseOperation(KFrame.EXIT_ON_CLOSE);
        
        JDesktopPane pPgw = new JDesktopPane();
        
        //Mengatur letak objek Label di container
        lNip.setBounds(20, 20, 100, 25);
        lNama.setBounds(20, 55, 100, 25);
        lBagian.setBounds(20, 90, 100, 25);
        lcreate.setBounds(230, 225, 200, 25);
        lcreate.setText("Create by Isro' Rizky Wibowo - A12.2020.06443");
        
        //Mengatur letak objek text di container
        fNip.setBounds(115, 20, 100, 25);
        fNama.setBounds(115, 55, 205, 25);
        fBagian.setBounds(115, 90, 100, 25);
        
        fNip.setToolTipText("Isi NIP dengan angka !");
        
        //Mengatur letak objek button di container
        btnAdd.setBounds(20, 320, 85, 25);
        btnAdd.setText("Add");
        btnAdd.setBackground(Color.green);
        btnAdd.setForeground(Color.getHSBColor(250, 0, 255));
        btnCari.setBounds(120, 320, 85, 25);
        btnCari.setText("Cari");
        btnKoreksi.setBounds(220, 320, 85, 25);
        btnKoreksi.setText("Koreksi");
        btnHapus.setBounds(320, 320, 85, 25);
        btnHapus.setText("Hapus");
        btnSelesai.setBounds(435, 320, 85, 25);
        btnSelesai.setText("Selesai");
        btnSelesai.setToolTipText("Mengakhiri Program");
        
        //Membuat Tabel Hasil Output Database
        tabModel = new DefaultTableModel(null,header);
        tabel.setModel(tabModel);
        tabel.setBackground(Color.orange);
        skrTabel.getViewport().add(tabel);
        tabel.setEnabled(true);
        skrTabel.setBounds(20, 130, 500, 170);
        
        //Objek button di non-aktifkan dan di-aktifkan
        btnAdd.setEnabled(true); 
        btnSelesai.setEnabled(true);
        
        //Mengatur objek untuk dapat berinteraksi
        btnAdd.addActionListener(this);
        btnCari.addActionListener(this);
        btnKoreksi.addActionListener(this);
        btnHapus.addActionListener(this);
        btnSelesai.addActionListener(this);
        
        //Meletakkan seluruh kontrol pada objek panel
        pPgw.add (skrTabel);
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
        
        //Menambahkan objek panel (pPgr) ke container frame
        getContentPane().add(pPgw).setBackground(Color.getHSBColor(100, 150, 75));
        
        //Menampilkan frame ke layar monitor
        pack();
        setLocationRelativeTo(null);
        tampiltabel();
        Kosong();
        settombol(1, 1, 0, 0, 1);
        
    }

    public static void main(String args[]) {
        new FPegawai06443().setVisible(true);
    }
    
    //Fungsi jika user melakukan action penekanan tombol button
    public void actionPerformed (ActionEvent ae)
    {
        Object obj = ae.getSource();
        
        if (obj == btnAdd)
        {
            if (btnAdd.getText()=="Simpan")
            {
                String xnip = fNip.getText();
                if (xnip.length() != 0) Add();
                else
                JOptionPane.showMessageDialog(this, "NIP Kosong !");
                
                btnAdd.setText("Add");
                Kosong();
                tampiltabel();
                settombol(1, 1, 0, 0, 1);
            }
            else
            {
                Kosong();
                settombol(1, 1, 0, 0, 1);
                btnAdd.setText("Simpan");
                btnAdd.setForeground(Color.getHSBColor(100, 10, 0));
                btnAdd.setBackground(Color.getHSBColor(200, 100, 100));
            }
        }
        
        if (obj == btnCari)
        {
            String xcari = JOptionPane.showInputDialog(this,"Masukkan NIP !");
                if (xcari != null)
                {
                    fNip.setText(xcari);
                    int xx = Cari();
                    if (xx == 1) settombol (1, 1, 1, 1, 1);
                }
                else
                JOptionPane.showMessageDialog(this,"NIP Kosong !");
        }
        
        if (obj == btnKoreksi)
        {
            if (btnKoreksi.getText()=="Simpan")
            {
                if (fNip.getText() != "")
                    Koreksi();
                btnKoreksi.setText("Koreksi");
                tampiltabel();
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
        
        if (obj == btnHapus)
        {
            int stt = JOptionPane.showConfirmDialog(this, "Yakin Dihapus ?");
            System.out.println(stt);
            
            if (stt == 0)
            {
                Hapus();
                tampiltabel();
                Kosong();
            }
        }
        
        if (obj == btnSelesai)
        {
            //System.exit(0);
            this.dispose();
        }
    }
    
    //Fungsi untuk menambahkan data ke tabel barang
    void Add()
    {
        try {
            KoneksiDBMS CnPenjualan = new KoneksiDBMS();
            Connection con = CnPenjualan.BukaCn();
            Statement stat = con.createStatement();

            String strsqlcr = "SELECT * FROM pegawai06443 WHERE Nip ='" + fNip.getText() + "'";
            ResultSet rs = stat.executeQuery(strsqlcr);
            if (rs.next()) 
            {
                JOptionPane.showMessageDialog(this, "Nip Sudah Ada !");
                return;
            }
            String strsql = "insert into pegawai06443(Nip, nama, bagian) values "
                    + " ('" + fNip.getText() + "','" + fNama.getText() + "' "
                    + ",'" + fBagian.getText() + "')";
            int stsproses = stat.executeUpdate(strsql);

            if (stsproses == 1) 
            {
                JOptionPane.showMessageDialog(this, "Sukses Di Tambahkan!!!");
            }
            con.close();
            } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(this, "Penambahan Gagal !");
            System.err.println("Kesalahan perintah SQL : " + e.getMessage());
        }
    }
    
    //Fungsi untuk mencari Kode_Barang ke tabel barang
    int Cari()
    {
        int x = 0;
        try {
            KoneksiDBMS CnPenjualan = new KoneksiDBMS();
            Connection con = CnPenjualan.BukaCn();
            Statement stat = con.createStatement();

            String strsql = "SELECT * FROM pegawai06443 WHERE Nip ='" + fNip.getText() + "'";
            ResultSet rs = stat.executeQuery(strsql);
            if (rs.next()) 
            {
                // Jika Nip Ditemukan Di Tabel Pegawai
                fNip.setText(rs.getString("nip"));
                fNama.setText(rs.getString("nama"));
                fBagian.setText(rs.getString("bagian"));
                x = 1;
            } else 
            {
                // Jika Nip tidak ditemukan 
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan !");
                fNip.requestFocus();
            }
            rs.close();
            con.close();
            } 
        catch (SQLException e) 
        {
            
        }
        return x;
    }
    
    //Fungsi untuk menambahkan data ke tabel barang
    void Koreksi()
    {
        try
        {
            KoneksiDBMS CnPenjualan = new KoneksiDBMS();
            Connection con = CnPenjualan.BukaCn();
            Statement stat = con.createStatement();

            String strsql = "update pegawai06443 set nama='" + fNama.getText()
                    + "',bagian='" + fBagian.getText()
                    + "' where nip='" + fNip.getText() + "' ";
            int stsproses = stat.executeUpdate(strsql);

            if (stsproses == 1) {
                JOptionPane.showMessageDialog(this, "Sukses DiEdit!");
            }
            con.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,"Koreksi Gagal !");
            System.err.println("Kesalahan Perintah SQL : " + e.getMessage());
        }
    }
    
//Fungsi untuk menambahkan data ke tabel barang
    void Hapus()
    {
        try
        {
            KoneksiDBMS CnPenjualan = new KoneksiDBMS();
            Connection con = CnPenjualan.BukaCn();
            Statement stat = con.createStatement();

            String strsql = "delete from pegawai06443 where nip='" + fNip.getText() + "' ";
            int stsproses = stat.executeUpdate(strsql);

            if (stsproses == 1) {
                JOptionPane.showMessageDialog(this, "Data Terhapus !");
            }
            con.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,"Penghapusan Gagal !");
            System.err.println("Kesalahan Perintah SQL : " + e.getMessage());
        }
    }
    
    //Tambah
    void tampiltabel()
    {
        try
        {
            bersihtabel();
            KoneksiDBMS CnPenjualan = new KoneksiDBMS();
            Connection con = CnPenjualan.BukaCn();
            Statement stat = con.createStatement();
            String strsql = "select * from pegawai06443";
            rs = stat.executeQuery(strsql);
            ResultSetMetaData meta = rs.getMetaData();
            rs.beforeFirst();
            while (rs.next()) {
                String Nip = rs.getString("nip");
                String Nama = rs.getString("nama");
                String Bagian = rs.getString("bagian");
                String[] data = {Nip, Nama, Bagian};
                tabModel.addRow(data);
            }
            stat.close();
            rs.close();
            con.close();
        }
        catch(SQLException se)
        {
            System.err.println("Kesalahan Perintah SQL : " + se.getMessage());
        }
    }
    
    void bersihtabel()
    {
        int brs = tabModel.getRowCount();
        for(int i=0;i<brs;i++)
        {
            tabModel.removeRow(0);
        }
    }
    
    //Fungsi untuk mengkosongkan objek inputan
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
        btnCari.setEnabled(b >= 1 ? true : false);
        btnKoreksi.setEnabled(c >= 1 ? true : false);
        btnHapus.setEnabled(d >= 1 ? true : false);
        btnSelesai.setEnabled(e >= 1 ? true : false);
    }

}