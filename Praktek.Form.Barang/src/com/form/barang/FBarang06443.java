package com.form.barang;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class FBarang06443 extends JFrame implements ActionListener, MouseListener
{
    private JPanel          pBrg        = new JPanel();
    private JLabel          lKode       = new JLabel("Kode      "),
                            lNama       = new JLabel("Nama Barang   "),
                            lHrgBeli    = new JLabel("Harga Beli    "),
                            lHrgJual    = new JLabel("Harga Jual    "),
                            lJumlah     = new JLabel("Jumlah        ");
    private JTextField      fKode       = new JTextField(),
                            fNama       = new JTextField(),
                            fHrgBeli    = new JTextField(),
                            fHrgJual    = new JTextField(),
                            fJumlah     = new JTextField();
    private JButton         btnAdd      = new JButton(),
                            btnCari     = new JButton(),
                            btnKoreksi  = new JButton(),
                            btnHapus    = new JButton(),
                            btnRefresh  = new JButton(),
                            btnSelesai  = new JButton();
    
    private ResultSet rs;
    String[] header = {"Kode", "Nama", "Harga Beli", "Harga Jual" ,"Jumlah"};
    //Integer[] lebarklm = {30, 85, 42, 42, 42};
    Integer[] lebarklm = {75, 200, 100, 100, 100};
    
    DefaultTableModel tabMode01;
    JTable tabel = new JTable();
    JScrollPane skrTabel = new JScrollPane();
    
    public FBarang06443() 
    {
        setPreferredSize(new Dimension(800, 500));
        setTitle("Data Barang");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new BorderLayout();
        JDesktopPane pBrg = new JDesktopPane();
        add(pBrg, BorderLayout.CENTER);
        
        /* Mengatur letak objek Label Di container(setBound(kiri, atas bawah, panjang kolom, letak horizontal))*/
        lKode.setBounds(20, 10, 100, 25);
        lNama.setBounds(20, 40, 100, 25);
        lHrgBeli.setBounds(20, 70, 100, 25);
        lHrgJual.setBounds(20, 100, 100, 25);
        lJumlah.setBounds(20, 130, 100, 25);

        /* Mengatur letak objek Text Di Container */
        fKode.setBounds(115, 10, 100, 25);
        fNama.setBounds(115, 40, 205, 25);
        fHrgBeli.setBounds(115, 70, 100, 25);
        fHrgJual.setBounds(115, 100, 100, 25);
        fJumlah.setBounds(115, 130, 100, 25);
        
        /* Mengatur letak objek Button di Container */
        btnAdd.setBounds(260, 350, 85, 25);
        btnAdd.setText("Add");
        btnAdd.setBackground(Color.green);
        btnAdd.setForeground(Color.getHSBColor(250, 0, 255));
        btnCari.setBounds(360, 350, 85, 25);
        btnCari.setText("Cari");
        btnKoreksi.setBounds(460, 350, 85, 25);
        btnKoreksi.setText("Koreksi");
        btnHapus.setBounds(560, 350, 85, 25);
        btnHapus.setText("Hapus");
        btnRefresh.setBounds(560, 390, 85, 25);
        btnRefresh.setText("Refresh");
        btnSelesai.setBounds(675, 350, 85, 25);
        btnSelesai.setText("Selesai");
        btnSelesai.setToolTipText("Mengakhiri Program");

        /* Objek Button di Non Aktifkan dan di aktifkan */
        btnAdd.setEnabled(true);
        btnSelesai.setEnabled(true);
        
        // Mengatur objek untuk dapat berinteraksi
        btnAdd.addActionListener(this);
        btnCari.addActionListener(this);
        btnKoreksi.addActionListener(this);
        btnHapus.addActionListener(this);
        btnRefresh.addActionListener(this);
        btnSelesai.addActionListener(this);
        tabel.addMouseListener(this);
        tabMode01 = new DefaultTableModel(null, header);
        tabel.setModel(tabMode01);
        skrTabel.getViewport().add(tabel);
        tabel.setEnabled(true);
        skrTabel.setBounds(20, 165, 750, 150);
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabel.getColumnModel().getColumn(0).setPreferredWidth(120);
        tabel.getColumnModel().getColumn(1).setPreferredWidth(350);
        tabel.getColumnModel().getColumn(2).setPreferredWidth(150);
        tabel.getColumnModel().getColumn(3).setPreferredWidth(150);
        
        /* Mengatur Perataan teks di Text */
        fHrgBeli.setHorizontalAlignment(JTextField.RIGHT);
        fHrgJual.setHorizontalAlignment(JTextField.RIGHT);
        fJumlah.setHorizontalAlignment(JTextField.RIGHT);

        // Meletakkan seluruh kontrol pada objek panel */
        pBrg.add(skrTabel);
        pBrg.add(lKode);
        pBrg.add(fKode);
        pBrg.add(lNama);
        pBrg.add(fNama);
        pBrg.add(lHrgBeli);
        pBrg.add(fHrgBeli);
        pBrg.add(lHrgJual);
        pBrg.add(fHrgJual);
        pBrg.add(lJumlah);
        pBrg.add(fJumlah);
        pBrg.add(btnAdd);
        pBrg.add(btnKoreksi);
        pBrg.add(btnHapus);
        pBrg.add(btnRefresh);
        pBrg.add(btnCari);
        pBrg.add(btnSelesai);
        
        //Menambahkan objek panel (pBrg) ke container frame
        getContentPane().add(pBrg).setBackground(Color.getHSBColor(180, 100, 200));
        
        //Menampilkan frame ke layar monitor
        pack();
        setLocationRelativeTo(null);
        tampiltabel();
        setVisible(true);
}

    public static void main(String args[])
    {
        new FBarang06443().setVisible(true);
    }
    
    //Fungsi jika user melakukan action penekanan tombol button
    public void actionPerformed (ActionEvent ae)
    {
        Object obj = ae.getSource();
        
        if (obj == btnAdd)
        {
            if (btnAdd.getText()=="Simpan")
            {
                String xnip = fKode.getText();
                if (xnip.length() != 0) Add();
                else
                    JOptionPane.showMessageDialog(this, "Kode Kosong !");
                
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
                btnAdd.setBackground(Color.getHSBColor(200, 100, 100));
            }
        }
        
        if (obj == btnCari) {
            String xcari = JOptionPane.showInputDialog(this, "Masukkan kode !");
            if (xcari != null) 
            {
                fKode.setText(xcari);
                int xx = Cari();
                if (xx == 1) {
                    settombol(1, 1, 1, 1, 1);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Kode Kosong !");
            }
        }
        
        if (obj == btnKoreksi) {
            if (btnKoreksi.getText() == "Simpan") {
                if (fKode.getText() != "") {
                    Koreksi();
                }
                btnKoreksi.setText("Koreksi");
                Kosong();
                settombol(1, 1, 0, 0, 1);
            } else {
                btnKoreksi.setText("Simpan");
                settombol(0, 0, 1, 0, 1);
                fNama.requestFocus();
            }
        }

        if (obj == btnHapus) 
        {
            int stt = JOptionPane.showConfirmDialog(this, "Yakin dihapus ?");
            System.out.print(stt);
            if (stt == 0) 
            {
                Hapus();
                Kosong();
            }
        }
        
        if (obj == btnRefresh)
        {
            tampiltabel();
            JOptionPane.showMessageDialog(this, "Tabel Telah Direfresh!");
        }
        
        if (obj == btnSelesai) 
        {
            this.dispose();
        }
    }
    
    private void tampil()
    {
        try
        {
            String vkode = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), 0));
            String vnama = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), 1));
            String vhrgbeli = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), 2));
            String vhrgjual = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), 3));
            String vjumlah = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), 4));
            
            fKode.setText(vkode);
            fNama.setText(vnama);
            fHrgBeli.setText(vhrgbeli);
            fHrgJual.setText(vhrgjual);
            fJumlah.setText(vjumlah);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ada Kesalahan !");
        }
    }
    
    //Pendefinisian method dari interface mouselistener......
    public void mouseClicked(MouseEvent me)
    {
        try
        {
            String vkode = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), 0));
            String vnama = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), 1));
            String vhrgbeli = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), 2));
            String vhrgjual = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), 3));
            String vjumlah = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), 4));
            
            fKode.setText(vkode);
            fNama.setText(vnama);
            fHrgBeli.setText(vhrgbeli);
            fHrgJual.setText(vhrgjual);
            fJumlah.setText(vjumlah);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ada Kesalahan !");
        }
    }
    
    public void mouseExited(MouseEvent me){}
    public void mouseEntered(MouseEvent me){}
    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}
    
    //Fungsi untuk menambahkan data ke tabel barang
    void Add()
    {
        try
        {
            KoneksiDBMS CnPenjualan = new KoneksiDBMS();
            Connection con = CnPenjualan.BukaCn();
            Statement stat = con.createStatement();

            String strsqlcr = "SELECT * FROM barang6443 WHERE kode ='"
                    + fKode.getText() + "'";
            ResultSet rs = stat.executeQuery(strsqlcr);
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Kode Sudah Ada !");
                return;
            }
            String strsql = "insert into barang6443(kode, nama, hrgbeli, hrgjual, jumlah) values "
                    + " ('" + fKode.getText() + "','" + fNama.getText() + "','" + fHrgBeli.getText() + "','" 
                    + fHrgJual.getText() + "','" + fJumlah.getText() + "')";
            int stsproses = stat.executeUpdate(strsql);
            
            
            if (stsproses == 1)
            JOptionPane.showMessageDialog(this, "Sukses Di Tambahkan !");
            con.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this, "Penambahan Gagal!!!");
            System.err.println("Kesalahan perintah SQL : " + e.getMessage());
        }
    }
    
    // Fungsi untuk mencari Kode_Barang ke tabel barang 
    int Cari() 
    {
        int x = 0;
        try 
        {
            KoneksiDBMS CnPenjualan = new KoneksiDBMS();
            Connection con = CnPenjualan.BukaCn();
            Statement stat = con.createStatement();

            String strsql = "SELECT * FROM barang6443 WHERE kode ='"
                    + fKode.getText() + "'";
            ResultSet rs = stat.executeQuery(strsql);
            if (rs.next()) 
            {
                // Jika kode Ditemukan Di Tabel barang6443
                fKode.setText(rs.getString("kode"));
                fNama.setText(rs.getString("nama"));
                fHrgBeli.setText(rs.getString("hrgbeli"));
                fHrgJual.setText(rs.getString("hrgjual"));
                fJumlah.setText(rs.getString("jumlah"));
                x = 1;
            } 
            else 
            {
                // Jika kode tidak ditemukan 
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan !");
                fKode.requestFocus();
            }
            rs.close();
            con.close();
        }
        catch(SQLException e)
        {   
        }
        return x;
    }
    
    // Fungsi untuk mengedit data tabel barang
    void Koreksi() 
    {
        try {
            KoneksiDBMS CnPenjualan = new KoneksiDBMS();
            Connection con = CnPenjualan.BukaCn();
            Statement stat = con.createStatement();

            String strsql = "update barang6443 set nama='" + fNama.getText() +
                            "',hrgbeli='" + fHrgBeli.getText() + "',hrgjual='" + fHrgJual.getText() + "',jumlah='" + fJumlah.getText() +
                            "' where kode='" + fKode.getText() + "' ";

            int stsproses = stat.executeUpdate(strsql);
            if (stsproses == 1) 
            {
                JOptionPane.showMessageDialog(this, "Sukses DiEdit!");
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(this, "Koreksi Gagal !");
            System.err.println("Kesalahan perintah SQL : " + e.getMessage());
        }
    }
    
    // Fungsi untuk menaghapus data ke tabel barang
    void Hapus() 
    {
        try {
            KoneksiDBMS CnPenjualan = new KoneksiDBMS();
            Connection con = CnPenjualan.BukaCn();
            Statement stat = con.createStatement();

            String strsql = "delete from barang6443 where kode='"
                    + fKode.getText() + "' ";
            int stsproses = stat.executeUpdate(strsql);

            if (stsproses == 1) 
            {
                JOptionPane.showMessageDialog(this, "Data Terhapus !");
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(this, "Penghapusan Gagal!!!");
            System.err.println("Kesalahan perintah SQL : " + e.getMessage());
        }
    }
    
    void tampiltabel()
    {
        try {
            bersihtabel();
            KoneksiDBMS CnPenjualan = new KoneksiDBMS();
            Connection con = CnPenjualan.BukaCn();
            Statement stat = con.createStatement();
            String strsql = "select * from barang6443";
            rs = stat.executeQuery(strsql);
            ResultSetMetaData meta = rs.getMetaData();
            rs.beforeFirst();
            while (rs.next()) 
            {
                String Kode = rs.getString("kode");
                String Nama = rs.getString("nama");
                String hargaBeli = rs.getString("hrgbeli");
                String hargaJual = rs.getString("hrgjual");
                String Jumlah = rs.getString("jumlah");
                String[] data = {Kode, Nama, hargaBeli, hargaJual, Jumlah};
                tabMode01.addRow(data);
            }
            stat.close();
            rs.close();
            con.close();
        } 
        catch (SQLException se) 
        {
            System.err.println("Kesalahan perintah SQL : " + se.getMessage());
        }
    }
    
    void bersihtabel() 
    {
        int brs = tabMode01.getRowCount();
        for (int i = 0; i < brs; i++) {
            tabMode01.removeRow(0);
        }
    }
    
    // Fungsi untuk mengkosongkan Objek masukan 
    void Kosong() {
        fKode.setText("");
        fNama.setText("");
        fHrgBeli.setText("");
        fHrgJual.setText ("");
        fJumlah.setText("");
        fKode.requestFocus();
    }

    void settombol(int a, int b, int c, int d, int e) 
    {
        btnAdd.setEnabled(a >= 1 ? true : false);
        btnCari.setEnabled(b >= 1 ? true : false);
        btnKoreksi.setEnabled(c >= 1 ? true : false);
        btnHapus.setEnabled(d >= 1 ? true : false);
        btnSelesai.setEnabled(e >= 1 ? true : false);
    }
}

