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

public class CetakBarangMin06443 extends JFrame implements ActionListener {

    private JPanel      pBrg = new JPanel();
    private JLabel      lMinim = new JLabel("Stok Minim "),
                        lCetak = new JLabel("Cetak Data Barang");
    private JTextField  fKode = new JTextField();
    private JButton     btnAdd = new JButton(),
                        btnCetak = new JButton(),
                        btnSelesai = new JButton();
    private ResultSet rs;
    String[] header = {"Kode", "Nama", "Harga Beli", "Harga Jual", "Jumlah"};
    DefaultTableModel tabMode1;
    JTable tabel = new JTable();
    JScrollPane skrTabel = new JScrollPane();
    Integer isikanjml = 5;

    public CetakBarangMin06443() {
        setPreferredSize(new Dimension(300, 320));
        setTitle("Cetak Laporan Barang");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new BorderLayout();
        JDesktopPane pBrg = new JDesktopPane();
        add(pBrg, BorderLayout.CENTER);
        lCetak.setBounds(60, 5, 300, 60);
        lCetak.setFont(new Font("Verdana", Font.BOLD, 15));
        lCetak.setForeground(new Color(220, 10, 10));
        
        /* Mengatur letak objek Label Di container*/
        lMinim.setBounds(35, 70, 100, 25);

        /* Mengatur letak objek Text Di Container */
        fKode.setBounds(115, 70, 140, 25);
        
        /* Mengatur letak objek Button di Container */
        btnAdd.setBounds(55, 110, 85, 60);
        btnAdd.setText("Cetak");
        btnAdd.setBackground(Color.BLUE);
        btnAdd.setForeground(Color.WHITE);
        btnSelesai.setBounds(150, 110, 85, 60);
        btnSelesai.setText("Selesai");
        btnSelesai.setToolTipText("Mengakhiri Program");
        btnCetak.setBounds(72, 180, 150, 60);
        btnCetak.setText("Cetak Semua Data");
        btnCetak.setToolTipText("Mencetak Seluruh Data");
        btnCetak.setBackground(Color.green);
        btnCetak.setForeground(Color.black);

        /* Objek Button di Non Aktifkan dan di aktifkan */
        btnAdd.setEnabled(true);
        btnCetak.setEnabled(true);
        btnSelesai.setEnabled(true);
        
        // Mengatur objek untuk dapat berinteraksi
        btnAdd.addActionListener(this);
        btnCetak.addActionListener(this);
        btnSelesai.addActionListener(this);

        // Meletakkan seluruh kontrol pada objek panel */
        pBrg.add(lMinim);
        pBrg.add(lCetak);
        pBrg.add(fKode);
        pBrg.add(btnAdd);
        pBrg.add(btnCetak);
        pBrg.add(btnSelesai);
         /* Menambahkan objek panel (pPgr) ke container frame */
        getContentPane().add(pBrg).setBackground(Color.getHSBColor(180, 100, 200));
        /* Menampilkan frame ke layar monitor */
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CetakBarangMin06443().setVisible(true);
    }

    /* Fungsi jika user melakukan action penekanan tombol Button */
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj == btnAdd) {
            CetakOK();
        }
        if (obj == btnCetak){
            CetakAll();
        }
        if (obj == btnSelesai) {
            this.dispose();
        }
    }
    
// Fungsi untuk cetak data ke tabel barang berdasarkan jumlah min
    void CetakOK() {
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
                    //cetak data berdasarkan stok....................................
                    try {
                        //Koneksi ke table barang..................
                        KoneksiDBMS CnPenjualan = new KoneksiDBMS();
                        Connection con = CnPenjualan.BukaCn();
                        Statement stat = con.createStatement();
                        isikanjml = Integer.parseInt(fKode.getText());
                        String strsql = "SELECT * FROM barang6443 where jumlah <= '"
                                + isikanjml + "'";

                        ResultSet rs = stat.executeQuery(strsql);
                        int i1, x1, y1;

                        //Header
                        g1.drawString("Laporan Barang", 50, 100);
                        g1.drawString("CV. Mekar Indah", 50, 130);
                        g1.drawLine(50, 140, 550, 140);
                        g1.drawString("No.", 50, 155);
                        g1.drawString("Kode", 80, 155);
                        g1.drawString("Nama", 150, 155);
                        g1.drawString("Harga Beli", 300, 155);
                        g1.drawString("Harga Jual", 390, 155);
                        g1.drawString("Jumlah", 480, 155);
                        g1.drawLine(50, 165, 550, 165);// garis bawah nama kolom
                        x1 = 50;
                        y1 = 190;
                        i1 = 1;
                        
                        //Cetak Record Barang (Letak positioning disamakan dengan atas (header) agar data rapi.................
                        while (rs.next()) {
                            g1.drawString(" " + i1 + ".", 50, y1);
                            g1.drawString(rs.getString(1), 80, y1);
                            g1.drawString(rs.getString(2), 150, y1);
                            g1.drawString(rs.getString(3), 315, y1);
                            g1.drawString(rs.getString(4), 400, y1);
                            g1.drawString(rs.getString(5), 490, y1);
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
        } catch (PrinterException pe) {
            pe.printStackTrace();
        }
    }
    
    //Cetak Seluruh data pada database barang
    void CetakAll()
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
                        //Koneksi ke table barang..................
                        KoneksiDBMS CnPenjualan = new KoneksiDBMS();
                        Connection con = CnPenjualan.BukaCn();
                        Statement stat = con.createStatement();

                        String strsql = "SELECT * FROM barang6443";
                        ResultSet rs = stat.executeQuery(strsql);
                        int i1, x1, y1;

                        //Header
                        g1.drawString("Laporan Barang", 50, 100);
                        g1.drawString("CV. Mekar Indah", 50, 130);
                        g1.drawLine(50, 140, 550, 140);
                        g1.drawString("No.", 50, 155);
                        g1.drawString("Kode", 80, 155);
                        g1.drawString("Nama", 150, 155);
                        g1.drawString("Harga Beli", 300, 155);
                        g1.drawString("Harga Jual", 390, 155);
                        g1.drawString("Jumlah", 480, 155);
                        g1.drawLine(50, 165, 550, 165);// garis bawah nama kolom
                        x1 = 50;
                        y1 = 190;
                        i1 = 1;
                        
                        //Cetak Record Barang.................
                        while (rs.next()) {
                            g1.drawString(" " + i1 + ".", 50, y1);
                            g1.drawString(rs.getString(1), 80, y1);
                            g1.drawString(rs.getString(2), 150, y1);
                            g1.drawString(rs.getString(3), 315, y1);
                            g1.drawString(rs.getString(4), 400, y1);
                            g1.drawString(rs.getString(5), 490, y1);
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
