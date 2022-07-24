package com.form.barang;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;

public class FLogin06443 extends JFrame implements ActionListener, FocusListener 
{

    private JPanel      pPgw        = new JPanel();
    private JLabel      lNip        = new JLabel("N I P "),
                        lNama       = new JLabel("Nama "),
                        lPassword   = new JLabel("Password "),
                        lPage       = new JLabel("Selamat Datang"),
                        lPage2      = new JLabel("Silahkan Login dengan NIP Anda !"),
                        lcreate     = new JLabel("nama");
    private JTextField  fNip        = new JTextField(),
                        fNama       = new JTextField();
    private TextField   fPassword   = new TextField();
    private JButton     btnOk       = new JButton(),
                        btnCNamaPw  = new JButton(),
                        btnBatal    = new JButton();

    public FLogin06443() 
    {
        setPreferredSize(new Dimension(350, 380));
        setTitle("LOGIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JDesktopPane dLogin = new JDesktopPane();
        lPage.setBounds(48, 20, 250, 35);
        lPage2.setBounds(35, 50, 300, 60);
        lPage.setFont(new Font("Arial", Font.BOLD, 32));
        lPage.setForeground(new Color(220, 10, 10));
        lPage2.setFont(new Font("Verdana", Font.PLAIN, 15));
        lPage2.setForeground(new Color(10, 10, 220));
        
        /* Mengatur letak objek Label Di container*/
        lNip.setBounds(15, 120, 100, 25);
        lNama.setBounds(15, 155, 100, 25);
        lPassword.setBounds(15, 190, 100, 25);

        /* Mengatur letak objek Text Di Container */
        fNip.setBounds(110, 120, 100, 25);
        fNama.setBounds(110, 155, 205, 25);
        fPassword.setBounds(105, 190, 100, 25);
        fPassword.setEchoChar('*');
        fNip.setToolTipText("Isi Nip dengan Angka !");
        
        /* Mengatur letak objek Button di Container */
        btnOk.setBounds(75, 240, 85, 25);
        btnOk.setText("Login");
        btnCNamaPw.setBounds(75, 280, 185, 25);
        btnCNamaPw.setText("Cari Nama & Password");
        btnCNamaPw.setToolTipText("Cari Nama dan Password Pegawai");
        btnBatal.setBounds(175, 240, 85, 25);
        btnBatal.setText("Batal");
        btnBatal.setToolTipText("Mengakhiri Program");

        // Mengatur objek untuk dapat berinteraksi
        btnOk.addActionListener(this);
        btnCNamaPw.addActionListener(this);
        btnBatal.addActionListener(this);
        
        // Meletakkan seluruh kontrol pada objek panel */
        dLogin.add(lNip);
        dLogin.add(fNip);
        dLogin.add(lNama);
        dLogin.add(fNama);
        dLogin.add(lPassword);
        dLogin.add(fPassword);
        dLogin.add(lPage);
        dLogin.add(lPage2);
        dLogin.add(btnOk);
        dLogin.add(btnBatal);
        dLogin.add(btnCNamaPw);
        /* Menambahkan objek panel (pPgr) ke container frame */
        getContentPane().add(dLogin).setBackground(Color.getHSBColor(180, 100, 200));
        /* Menampilkan frame ke layar monitor */
        pack();
        setLocationRelativeTo(null);
        Kosong();
    }

    public static void main(String[] args) {
        new FLogin06443().setVisible(true);
    }

    /* Fungsi untuk memeriksa kursor saat meninggalkan objek txtKode_Barang */
    public void focusGained(FocusEvent fe) 
    {
    }

    public void focusLost(FocusEvent fe) 
    {
        if (fNip.getText().equals("")) {
        } else {
            int xcari = Cari();
            if (xcari == 1) {
                fPassword.requestFocus();
            } else {
                btnBatal.requestFocus();
            }
        }
    }

    /* Fungsi jika user melakukan action penekanan tombol Button */
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj == btnOk) {
            int xcari = Cari();
            if (xcari == 1) {
                this.dispose();
                FMenu06443 xmenu = new FMenu06443();
                xmenu.setVisible(true);
            }
        }
        if (obj == btnCNamaPw)
        {
            Cari();
        }
        if (obj == btnBatal) 
        {
            this.dispose();
        }
    }

// Fungsi untuk mencari Nama dan Password berdasarkan nip dari tabel pegawai
    int Cari() 
    {
        int x = 0;
        try {
            KoneksiDBMS CnPenjualan = new KoneksiDBMS();
            Connection con = CnPenjualan.BukaCn();
            Statement stat = con.createStatement();

            String strsql = "SELECT * FROM pegawai06443 WHERE nip ='" + fNip.getText() + "'";
            ResultSet rs = stat.executeQuery(strsql);
            if (rs.next()) {
                fNama.setText(rs.getString("nama"));
                fPassword.setText(rs.getString("password"));
                x = 1;
            } else {
                // Jika Nip tidak ditemukan 
                fNip.setText("");
                fPassword.setText("");
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan !");
                fNip.requestFocus();
                fPassword.requestFocus();
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Data kosong !");
        }
        return x;
    }
    
    // Fungsi untuk mengkosongkan Objek masukan 
    void Kosong() {
        fNip.setText("");
        fNama.setText("");
        fPassword.setText("");
        fNip.requestFocus();
    }

}
