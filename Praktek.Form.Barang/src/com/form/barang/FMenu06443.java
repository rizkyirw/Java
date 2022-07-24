package com.form.barang;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

//Program Menu.................................................
class FMenu06443 extends JFrame
{
    //Property fields..........................................
    private JTextArea   m_editArea  = new JTextArea(20,50);
    private JPanel      JPMenu      = new JPanel();
    private JPopupMenu  m_popup     = new JPopupMenu();
    private JLabel      lNama       = new JLabel("Homepage Penjualan"),
                        lAlamat2    = new JLabel("Silahkan Memilih Layanan Yang Ada Dibawah Ini"),
                        lAlamat     = new JLabel("Isro' Rizky Wibowo - A12.2020.06443");
    private JButton     btnPgw      = new JButton(),
                        btnLogin    = new JButton(),
                        btnQuit     = new JButton(),
                        btnBrg      = new JButton(),
                        btnCekStok  = new JButton(),
                        btnJual     = new JButton(),
                        btnCetak    = new JButton(),
                        btnCetak2   = new JButton();
    
    //Constructor...............................................
    public FMenu06443()
    {
        setPreferredSize(new Dimension(600, 400));
        setTitle("MENU PENJUALAN");
        JDesktopPane JDPMenu = new JDesktopPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lNama.setBounds(140, 35, 450, 50);
        lAlamat.setBounds(320, 330, 400, 25);// credit
        lAlamat2.setBounds(108, 75, 400, 25);
        lNama.setFont(new Font("Arial", Font.BOLD, 32));
        lNama.setForeground(new Color(220, 10, 10));
        lAlamat.setFont(new Font("Verdana", Font.PLAIN, 13));
        lAlamat.setForeground(new Color(10, 10, 220));
        lAlamat2.setFont(new Font("Verdana", Font.PLAIN, 15));
        lAlamat2.setForeground(new Color(10, 10, 220));
        
        btnPgw.addActionListener(new BukaPegawai());
        btnLogin.addActionListener(new Login());
        btnBrg.addActionListener(new BukaBarang());
        btnCekStok.addActionListener(new CekStok());
        btnJual.addActionListener(new BukaJual());
        btnCetak.addActionListener(new CetakMin());
        btnCetak2.addActionListener(new CetakJual());
        btnQuit.addActionListener(new QuitAction());
        
        // Add the (unused) text area to the content pane............
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(m_editArea, BorderLayout.CENTER);
        
        /* Mengatur letak objek Button di Container */
        btnPgw.setBounds(100, 150, 85, 50);
        btnPgw.setText("Pegawai");
        btnPgw.setToolTipText("Program Pegawai");
        btnLogin.setBounds(100, 225, 85, 50);
        btnLogin.setText("Login Akun");
        btnLogin.setToolTipText("Program Login");
        btnBrg.setBounds(200, 150, 85, 50); 
        btnBrg.setText("Barang"); 
        btnBrg.setToolTipText("Program Barang");
        btnCekStok.setBounds(200, 225, 85, 50); 
        btnCekStok.setText("Cek Stok Barang"); 
        btnCekStok.setToolTipText("Cek Stok Pada Program Barang");
        btnJual.setBounds(300, 150, 85, 50); 
        btnJual.setText("Penjualan"); 
        btnJual.setToolTipText("Program Penjualan");
        btnCetak.setBounds(300, 225, 85, 50);
        btnCetak.setText("Cetak Barang");
        btnCetak.setToolTipText("Program Cetak Data Barang");
        btnQuit.setBounds(400, 150, 85, 50);
        btnQuit.setText("Quit");
        btnQuit.setToolTipText("Keluar Program");
        btnCetak2.setBounds(400, 225, 85, 50);
        btnCetak2.setText("Cetak Jual");
        btnCetak2.setToolTipText("Program Cetak Data Penjualan");
        
        //... Set the JFrame's content pane and menu bar.
        setContentPane(content);
        JDPMenu.add(lNama);
        JDPMenu.add(lAlamat);
        JDPMenu.add(lAlamat2);
        JDPMenu.add(btnPgw);
        JDPMenu.add(btnLogin);
        JDPMenu.add(btnBrg);
        JDPMenu.add(btnCekStok);
        JDPMenu.add(btnJual);
        JDPMenu.add(btnCetak);
        JDPMenu.add(btnCetak2);
        JDPMenu.add(btnQuit);
        
        getContentPane().add(JDPMenu).setBackground(Color.getHSBColor(180, 100, 200));
        pack();
        setLocationRelativeTo(null);
    }

    class OpenAction implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            JOptionPane.showMessageDialog(FMenu06443.this, "Can't Open.");
        }
    }
    
    class Login implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            FLogin06443 xLogin = new FLogin06443();
            xLogin.setVisible(true);
        }
    }

    class BukaPegawai implements ActionListener 
    {

        public void actionPerformed(ActionEvent e) 
        {
            FPegawai06443 xPegawai = new FPegawai06443();
            xPegawai.setVisible(true);

            // System.exit(0); menjadi this.dispose();
        }
    }

    class BukaBarang implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            FBarang06443 xBarang = new FBarang06443();
            xBarang.setVisible(true);
        }
    }

    class CekStok implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            CekStockBrg06443 xCekStok = new CekStockBrg06443();
            xCekStok.setVisible(true);
        }
    }
    
    class BukaJual implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            FJual06443 xJual = new FJual06443();
            xJual.setVisible(true);
        }
    }
    
    class CetakMin implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            CetakBarangMin06443 xCetakMin = new CetakBarangMin06443();
            xCetakMin.setVisible(true);
        }
    }
    
    class CetakAll implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            CetakBarangMin06443 xCetakAll = new CetakBarangMin06443();
            xCetakAll.setVisible(true);
        }
    }

    class CetakJual implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            CetakJual06443 xCetakJual = new CetakJual06443();
            xCetakJual.setVisible(true);
        }
    }
    
    class QuitAction implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            System.exit(0); // Terminate the program..........
        }
    }
    
    // main method................................................
    public static void main(String[] args) 
    {
        JFrame win = new FMenu06443();
        win.setVisible(true);
    }
}