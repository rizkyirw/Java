package com.form.barang;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class CetakJual06443 extends JFrame implements ActionListener 
{

    private JPanel      pJual  = new JPanel();
    private JTextField  fKode  = new JTextField();
    private JLabel      lCetak = new JLabel("Cetak Data Jual");
    private JButton     btnAdd = new JButton(),
                        btnCetak = new JButton(),
                        btnSelesai = new JButton();
    private ResultSet rs;
    String[] header = {"No Trans", "Kode", "Nama", "Harga Beli", "Harga Jual", "Jumlah"};
    DefaultTableModel tabMode1;
    JTable tabel = new JTable();
    JScrollPane skrTabel = new JScrollPane();

    public CetakJual06443() {
        setPreferredSize(new Dimension(300, 270));
        setTitle("Cetak Laporan Penjualan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new BorderLayout();
        JDesktopPane pJual = new JDesktopPane();
        add(pJual, BorderLayout.CENTER);
        lCetak.setBounds(70, 10, 300, 60);
        lCetak.setFont(new Font("Verdana", Font.BOLD, 15));
        lCetak.setForeground(new Color(220, 10, 10));
        
        
        /* Mengatur letak objek Button di Container */
        btnAdd.setBounds(55, 90, 85, 60);
        btnAdd.setText("Cetak");
        btnAdd.setBackground(Color.BLUE);
        btnAdd.setForeground(Color.WHITE);
        btnSelesai.setBounds(150, 90, 85, 60);
        btnSelesai.setText("Selesai");
        btnSelesai.setToolTipText("Mengakhiri Program");

        /* Objek Button di Non Aktifkan dan di aktifkan */
        btnAdd.setEnabled(true);
        btnSelesai.setEnabled(true);
        
        // Mengatur objek untuk dapat berinteraksi
        btnAdd.addActionListener(this);
        btnSelesai.addActionListener(this);

        // Meletakkan seluruh kontrol pada objek panel */
        pJual.add(lCetak);
        pJual.add(fKode);
        pJual.add(btnAdd);
        pJual.add(btnSelesai);
         /* Menambahkan objek panel (pPgr) ke container frame */
        getContentPane().add(pJual).setBackground(Color.getHSBColor(180, 100, 200));
        /* Menampilkan frame ke layar monitor */
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CetakJual06443().setVisible(true);
    }

    /* Fungsi jika user melakukan action penekanan tombol Button */
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj == btnAdd) {
            CetakJual();
        }
        if (obj == btnSelesai) {
            this.dispose();
        }
    }
    
// Fungsi untuk Cetak data dari database Penjualan
    
    //Cetak Seluruh data pada database
    void CetakJual()
    {
        try {
            PrinterJob pjob = PrinterJob.getPrinterJob();
            pjob.setJobName("Graphics Demo Printout");
            pjob.setCopies(1);
            pjob.setPrintable(new Printable() {
                public int print(Graphics g1, PageFormat pf, int pageNum) {
                    if (pageNum > 0) // we only print one page
                    {
                        return Printable.NO_SUCH_PAGE; // ie., end of job
                    }
                    g1.drawString("created by Isro' Rizky Wibowo & A12.2020.06443", 50, 50);
                    //cetak data....................................
                    try {
                        //Koneksi ke table jual..................
                        KoneksiDBMS CnPenjualan = new KoneksiDBMS();
                        Connection con = CnPenjualan.BukaCn();
                        Statement stat = con.createStatement();

                        String strsql = "SELECT * FROM jual6443";
                        ResultSet rs = stat.executeQuery(strsql);
                        int i1, x1, y1;

                        //Header
                        g1.drawString("Laporan Penjualan", 50, 100);
                        g1.drawString("CV. Mekar Indah", 50, 130);
                        g1.drawLine(50, 140, 550, 140);
                        g1.drawString("No.", 50, 155);
                        g1.drawString("No Trans", 80, 155);
                        g1.drawString("Kode", 150, 155);
                        g1.drawString("Nama", 200, 155);
                        g1.drawString("Harga Beli", 350, 155);
                        g1.drawString("Harga Jual", 420, 155);
                        g1.drawString("Jumlah", 500, 155);
                        g1.drawLine(50, 165, 550, 165);// garis bawah nama kolom
                        x1 = 50;
                        y1 = 190;
                        i1 = 1;
                        
                        //Cetak Record Penjualan.................
                        while (rs.next()) {
                            g1.drawString(" " + i1 + ".", 50, y1);
                            g1.drawString(rs.getString(1), 85, y1);
                            g1.drawString(rs.getString(2), 150, y1);
                            g1.drawString(rs.getString(3), 200, y1);
                            g1.drawString(rs.getString(4), 360, y1);
                            g1.drawString(rs.getString(5), 435, y1);
                            g1.drawString(rs.getString(6), 500, y1);
                            y1 += 14;
                            i1++;

                        }

                        g1.drawLine(x1, y1, 550, y1);

                        rs.close();
                        con.close();
                    } catch (Exception e) {
                        System.out.println("Ada Kesalahan !");
                    }
                    return Printable.PAGE_EXISTS;
                }
            });
            if (pjob.printDialog() == false) // choose printer
            {
                return;
            }
            pjob.print();
        } 
        catch (PrinterException pe) 
        {
            pe.printStackTrace();
        }   
    }
}
