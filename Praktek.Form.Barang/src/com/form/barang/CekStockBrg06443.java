package com.form.barang;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class CekStockBrg06443 extends JFrame implements ActionListener
{

    private JPanel          pBrg = new JPanel();
    private JLabel      lCekKode = new JLabel("Kode Barang "),
                        lJumlah  = new JLabel("Stock Tersedia ");
    private JTextField     fKode = new JTextField(),
                           fJumlah = new JTextField();
    private JButton  btnCariStok = new JButton(),
                      btnSelesai = new JButton();
    private ResultSet rs;
    
    public CekStockBrg06443()
    {
        setPreferredSize(new Dimension(300, 260));
        setTitle("Cek Stock Barang");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JDesktopPane xCekStok = new JDesktopPane();
        new BorderLayout();
        add(xCekStok, BorderLayout.CENTER);
        
        /* Mengatur letak objek Label Di container*/
        lCekKode.setBounds(20, 30, 100, 25);
        lJumlah.setBounds(20, 60, 100, 25);

        /* Mengatur letak objek Text Di Container */
        fKode.setBounds(115, 30, 140, 25);
        fJumlah.setBounds(115, 60, 140, 25);
        
        /* Mengatur letak objek Button di Container */
        btnCariStok.setBounds(55, 120, 85, 60);
        btnCariStok.setText("Cek Stok");
        btnCariStok.setBackground(Color.BLUE);
        btnCariStok.setForeground(Color.WHITE);
        btnSelesai.setBounds(150, 120, 85, 60);
        btnSelesai.setText("Selesai");
        btnSelesai.setToolTipText("Mengakhiri Program");
        
        /* Objek Button di Non Aktifkan dan di aktifkan */
        btnCariStok.setEnabled(true);
        btnSelesai.setEnabled(true);
        
        // Mengatur objek untuk dapat berinteraksi
        btnCariStok.addActionListener(this);
        btnSelesai.addActionListener(this);
        
        // Meletakkan seluruh kontrol pada objek panel */
        xCekStok.add(lCekKode);
        xCekStok.add(lJumlah);
        xCekStok.add(fKode);
        xCekStok.add(fJumlah);
        xCekStok.add(btnCariStok);
        xCekStok.add(btnSelesai);
        /* Menambahkan objek panel (pPgr) ke container frame */
        getContentPane().add(xCekStok).setBackground(Color.getHSBColor(180, 100, 200));        
        /* Menampilkan frame ke layar monitor */
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new CekStockBrg06443().setVisible(true);
    }
    
    /* Fungsi jika user melakukan action penekanan tombol Button */
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj == btnCariStok) {
            CekJumlah();
        }
        if (obj == btnSelesai) {
            this.dispose();
        }
    }
    
    // Fungsi untuk mencari Kode_Barang ke tabel barang 
    int CekJumlah() // button untuk cek jumlah barang yang ada pada tabel barang (opsi)
    {
        int x = 0;
        try {
            KoneksiDBMS CnPenjualan = new KoneksiDBMS();
            Connection con = CnPenjualan.BukaCn();
            Statement stat = con.createStatement(); // statement mengeksekusi query

            String sql1 = "SELECT * FROM barang6443 WHERE kode ='" + fKode.getText() + "'";
            ResultSet rs = stat.executeQuery(sql1); //Resultset menampung data yang ada pada query
            if (rs.next()) {
                rs.last();
                // Jika Kode Barang Ditemukan Di Tabel Barang 
                fKode.setText(rs.getString("kode"));
                fJumlah.setText(rs.getString("jumlah"));
                x = 1;
            } else {
                // Jika kode tidak ditemukan 
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan !");
                fKode.requestFocus();
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
        }
        return x;
        }
    }