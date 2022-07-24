package com.form.barang;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class FJual06443 extends JFrame implements ActionListener, MouseListener
{
    private JPanel          pBrg        = new JPanel();
    private JLabel          lNoJual     = new JLabel("No. Transaksi"),
                            lKode       = new JLabel("Kode"),
                            lNama       = new JLabel("Nama"),
                            lHarga      = new JLabel("Harga"),
                            lJumlah     = new JLabel("Jumlah"),
                            lTotal      = new JLabel("Total "),
                            lToko1      = new JLabel("Isro' Rizky Wibowo"),
                            lToko2      = new JLabel("A12.2020.06443");
    private JTextField      fNoJual     = new JTextField(),
                            fKode       = new JTextField(),
                            fNama       = new JTextField(),
                            fHarga      = new JTextField(),
                            fJumlah     = new JTextField(),
                            fStok       = new JTextField(),
                            fTotal      = new JTextField();
    private JButton         btnAdd      = new JButton(),
                            btnKoreksi  = new JButton(),
                            btnDelete   = new JButton(),
                            btnCari     = new JButton(),
                            btnRefresh  = new JButton(),
                            btnCariBar  = new JButton(),
                            btnSelesai  = new JButton();
    
    private ResultSet rs;
    String[] header = {"Kode", "Nama", "Harga", "Jumlah", "Total"}; //header tabel
    
    DefaultTableModel tabMode01;
    JTable tabel = new JTable();
    JScrollPane skrTabel = new JScrollPane();
    float total = 0;
    int xjumlah = 0;
    int xhasil = 0;
    
    public FJual06443()
    {
        setPreferredSize(new Dimension(580, 650));
        setTitle("Transaksi Penjualan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new BorderLayout();
        JDesktopPane pBrg = new JDesktopPane();
        add(pBrg, BorderLayout.CENTER);
        
        /* Mengatur letak objek Label Di container*/
        lToko1.setBounds(15, 28, 450, 40);
        lToko1.setFont(new Font("Dialog", 1, 36));
        lToko2.setBounds(15, 58, 450, 40);
        lToko2.setFont(new Font("Dialog", 1, 18));
        lToko1.setForeground(Color.BLUE);
        lNoJual.setBounds(15, 100, 120, 20);
        lKode.setBounds(15, 400, 60, 20);
        lNama.setBounds(15, 425, 60, 20);
        lHarga.setBounds(15, 450, 60, 20);
        lJumlah.setBounds(350, 400, 150, 20);
        lTotal.setBounds(350, 425, 60, 20);
        
        /* Mengatur letak objek Text Di Container */
        fNoJual.setBounds(15, 125, 100, 20);
        fKode.setBounds(75, 400, 100, 20);
        fNama.setBounds(75, 425, 205, 20);//
        fHarga.setBounds(75, 450, 100, 20);
        fJumlah.setBounds(400, 400, 150, 20);
        fTotal.setBounds(400, 425, 150, 20);
        
        /* Mengatur letak objek Button di Container */
        btnAdd.setBounds(165, 510, 85, 25);
        btnAdd.setText("Add");
        btnAdd.setBackground(Color.green);
        btnAdd.setForeground(Color.black);
        btnKoreksi.setBounds(165, 560, 85, 25);
        btnKoreksi.setText("Koreksi");
        btnDelete.setBounds(265, 510, 85, 25);
        btnDelete.setText("Hapus");
        btnCari.setBounds(365, 510, 90, 25);
        btnCari.setText("Cari Jual");
        btnRefresh.setBounds(265, 560, 85, 25);
        btnRefresh.setText("Refresh");
        btnCariBar.setBounds(365, 560, 130, 25);
        btnCariBar.setText("Cari No Barang");
        btnCari.setToolTipText("Cari No Data Barang");
        btnSelesai.setBounds(470, 510, 85, 25);
        btnSelesai.setText("Selesai");
        btnSelesai.setToolTipText("Mengakhiri Program");
        
        /* Mengatur Perataan teks di Text */
        fHarga.setHorizontalAlignment(JTextField.RIGHT);
        fJumlah.setHorizontalAlignment(JTextField.RIGHT);
        fTotal.setHorizontalAlignment(JTextField.RIGHT);
        
        /* Objek Button di Non Aktifkan dan di aktifkan */
        btnAdd.setEnabled(true);
        btnSelesai.setEnabled(true);
        
        /* Mengatur objek untuk dapat berinteraksi */
        btnAdd.addActionListener(this);
        btnKoreksi.addActionListener(this);
        btnDelete.addActionListener(this);
        btnCari.addActionListener(this);
        btnRefresh.addActionListener(this);
        btnCariBar.addActionListener(this);
        btnSelesai.addActionListener(this);
        tabel.addMouseListener(this);
        tabMode01 = new DefaultTableModel(null, header);
        tabel.setModel(tabMode01);
        skrTabel.getViewport().add(tabel);
        tabel.setEnabled(true);
        skrTabel.setBounds(15, 160, 540, 220);
        
        // Meletakkan seluruh kontrol pada objek panel */
        pBrg.add(skrTabel);
        pBrg.add(lToko1);
        pBrg.add(lToko2);
        pBrg.add(lNoJual);
        pBrg.add(fNoJual);
        pBrg.add(lKode);
        pBrg.add(fKode);
        pBrg.add(lNama);
        pBrg.add(fNama);
        pBrg.add(lHarga);
        pBrg.add(fHarga);
        pBrg.add(lJumlah);
        pBrg.add(fJumlah);
        pBrg.add(lTotal);
        pBrg.add(fTotal);
        pBrg.add(btnAdd);
        pBrg.add(btnKoreksi);
        pBrg.add(btnDelete);
        pBrg.add(btnCari);
        pBrg.add(btnRefresh);
        pBrg.add(btnCariBar);
        pBrg.add(btnSelesai);
        
        /* Menambahkan objek panel (pBrg) ke container frame */
        getContentPane().add(pBrg).setBackground(Color.getHSBColor(180, 100, 200));
        
        /* Menampilkan frame ke layar monitor */
        pack();
        setLocationRelativeTo(null);
        tampiltabel(); // agar tabel langsung muncul datanya pada tabel saat program dibuka
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new FJual06443().setVisible(true);
    }
    
    /* Fungsi untuk memeriksa kursor saat meninggalkan objek txtKode_Barang */
    public void focusGained(FocusEvent fe) {
        if (fTotal.getText().equals("")) {
        } else {
            Total();
        }
    }

    
    /* Fungsi jika user melakukan action penekanan tombol button */
    public void actionPerformed(ActionEvent ae)
    {
        Object obj = ae.getSource();
        
        if (obj == btnAdd) 
        {
            if (btnAdd.getText() == "Simpan") {
                String xnip = fKode.getText();
                if (xnip.length() != 0) {
                    SimpanJual();
                } else {
                    JOptionPane.showMessageDialog(this, "Kode Kosong !");
                }

                btnAdd.setText("Add");
                Kosong();
                settombol(1, 1, 1, 1, 1, 1);
            } else {
                Kosong();
                settombol(1, 1, 1, 1, 1, 1);
                btnAdd.setText("Simpan");
                btnAdd.setForeground(Color.getHSBColor(100, 10, 0));
                btnAdd.setBackground(Color.getHSBColor(200, 100, 100));
            }
        }
        
        if (obj == btnDelete) 
        {
            int stt = JOptionPane.showConfirmDialog(this, "Yakin dihapus ?");
            System.out.print(stt);
            if (stt == 0)
            {    
                Hapus();
                Kosong();
            }
        }
        
        if (obj == btnCari) //Cari data Jual
        {
            String xcari = JOptionPane.showInputDialog(this, "Masukkan kode !");
            if (xcari != null) 
            {
                fKode.setText(xcari);
                int xx = CariNoJual();
                if (xx == 1) {
                    settombol(1, 1, 1, 1, 1, 1);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Kode Kosong !");
            }
        }
        
        if (obj == btnCariBar) //Cari data Barang
        {
            String xcari = JOptionPane.showInputDialog(this, "Masukkan kode !");
            if (xcari != null) {
                fKode.setText(xcari);
                int xx = Cari();
                if (xx == 1) {
                    settombol(1, 1, 1, 1, 1, 1);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Kode Kosong !");
            }
        }
        
        if (obj == btnKoreksi) 
        {
            if (btnKoreksi.getText() == "Simpan") {
                if (fKode.getText() != "") {
                    Koreksi();
                }
                btnKoreksi.setText("Koreksi");
                Kosong();
                settombol(1, 1, 1, 0, 0, 1);
            } else {
                btnKoreksi.setText("Simpan");
                settombol(0, 0, 0, 1, 0, 1);
                fNama.requestFocus();
            }
        }
        
        if (obj == btnRefresh)
        {
            tampiltabel();
            Kosong();
            JOptionPane.showMessageDialog(this, "Tabel Telah Direfresh!");
        }
        
        if (obj == btnSelesai) 
        {
            this.dispose();
        }
    }
    
    private void tampil() //untuk menampilkan data pada awal membuka program
    {
        try 
        {
            String vkode = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), 0));
            String vnama = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), 1));
            String vharga = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), 2));
            String vjumlah = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), 3));
            String vtotal = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), 4));

            fKode.setText(vkode);
            fNama.setText(vnama);
            fHarga.setText(vharga);
            fJumlah.setText(vjumlah);
            fTotal.setText(vtotal);
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
            String vharga = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), 2));
            String vjumlah = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), 3));
            String vtotal = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), 4));
            
            fKode.setText(vkode);
            fNama.setText(vnama);
            fHarga.setText(vharga);
            fJumlah.setText(vjumlah);
            fTotal.setText(vtotal);
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
    
    //Simpan Data...........................
    void SimpanJual() //untuk memasukan ke tabel data jual yang ada pada data barang
    {
        try 
        {
            KoneksiDBMS CnPenjualan = new KoneksiDBMS();
            Connection con = CnPenjualan.BukaCn();
            Statement stat = con.createStatement();

            String strsqlcr = "SELECT * FROM jual6443 WHERE notransaksi ='"
                    + fNoJual.getText() + "'";
            ResultSet rs = stat.executeQuery(strsqlcr);

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Kode Sudah Ada !");
                return;
            }
            String strsql = "insert into jual6443(kode, nama, harga, jumlah, total) values "
                    + " ('" + fKode.getText() + "','" + fNama.getText() + "','" + fHarga.getText() + "','"
                    + fJumlah.getText() + "','" + fTotal.getText() + "')";
            int stsproses = stat.executeUpdate(strsql);

            if (stsproses == 1) {
                JOptionPane.showMessageDialog(this, "Sukses Di Tambahkan !");
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Penambahan Gagal!!!");
            System.err.println("Kesalahan perintah SQL : " + e.getMessage());
        }
    }
    
    //fungsi untuk cari kode_barang dari tabel jual
    int CariNoJual()
    {
        int x = 0;
        try 
        {
            KoneksiDBMS CnPenjualan = new KoneksiDBMS();
            Connection con = CnPenjualan.BukaCn();
            Statement stat = con.createStatement(); // statement mengeksekusi query
            
            String sql1 = "SELECT * FROM jual6443 WHERE kode ='"
                    + fKode.getText() + "'";
            ResultSet rs1 = stat.executeQuery(sql1); //Resultset menampung data yang ada pada query
            if (rs1.next()) 
            {
                rs1.last();
                // Jika Kode Barang Ditemukan Di Tabel Barang 
                /*int xno = Integer.parseInt(rs.getString("notransaksi"));*/
                fNoJual.setText(rs1.getString("notransaksi")); //menampilkan no transaksi
                fKode.setText(rs1.getString("kode"));
                fNama.setText(rs1.getString("nama"));
                fHarga.setText(rs1.getString("harga"));
                fJumlah.setText(rs1.getString("jumlah"));
                fTotal.setText(rs1.getString("total"));
                x = 1;
            }           
            else 
            {
                // Jika kode tidak ditemukan 
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan !");
                fKode.requestFocus();
                Kosong();
            }
            rs1.close();
            con.close();
        } 
        
        catch (SQLException e) 
        {
        }
        return x;
    }
    
    // Fungsi untuk mencari data Barang di tabel barang ........
    int Cari()
    {
        int x = 0;
        try {
            KoneksiDBMS CnPenjualan = new KoneksiDBMS();
            Connection con = CnPenjualan.BukaCn();
            Statement stat = con.createStatement(); // statement mengeksekusi query

            String sql1 = "SELECT * FROM barang6443 WHERE kode ='" + fKode.getText() + "'";
            ResultSet rs = stat.executeQuery(sql1); //Resultset menampung data yang ada pada query
            if (rs.next()) 
            {
                rs.last();
                // Jika Kode Barang Ditemukan Di Tabel Barang 
                fKode.setText(rs.getString("kode"));
                fNama.setText(rs.getString("nama"));
                fHarga.setText(rs.getString("hrgjual"));
                fJumlah.setText(rs.getString("jumlah"));
                x = 1;
            } else {
                // Jika kode tidak ditemukan 
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan !");
                fKode.requestFocus();
                Kosong();
            }
            rs.close();
            con.close();
        } 
        catch (SQLException e) 
        {
        }
        return x;
    }
    

    
    // Fungsi untuk mengedit data tabel jual
    void Koreksi() 
    {
        try {
            KoneksiDBMS CnPenjualan = new KoneksiDBMS();
            Connection con = CnPenjualan.BukaCn();
            Statement stat = con.createStatement();

            String strsql = "update jual6443 set nama='" + fNama.getText() +
                            "',harga='" + fHarga.getText() + "',jumlah='" + fJumlah.getText() + "',total='" + fTotal.getText() +
                            "' where kode='" + fKode.getText() + "' ";

            int stsproses = stat.executeUpdate(strsql);
            if (stsproses == 1) 
            {
                JOptionPane.showMessageDialog(this, "Sukses DiEdit!");
                Kosong();
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(this, "Koreksi Gagal !");
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
            String strsql = "select * from jual6443";
            rs = stat.executeQuery(strsql);
            ResultSetMetaData meta = rs.getMetaData();
            rs.beforeFirst();
            while (rs.next()) 
            {
                String kode = rs.getString("kode");
                String nama = rs.getString("nama");
                String harga = rs.getString("harga");
                String jumlah = rs.getString("jumlah");
                String total = rs.getString("total");
                String[] data = {kode, nama, harga, jumlah, total};
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
    
    void Hapus() //menghapus data pada tabel, kita ganti saja menggunakan delete pada mysql
    {
        try {
            KoneksiDBMS CnPenjualan = new KoneksiDBMS();
            Connection con = CnPenjualan.BukaCn();
            Statement stat = con.createStatement();

            String strsql = "delete from jual6443 where kode='"
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
    
    void Total() {
        try
        {
            fTotal.requestFocus();
            int xhasil = Integer.parseInt(fHarga.getText()) * Integer.parseInt(fJumlah.getText());
            fTotal.setText(Integer.toString(xhasil));
        }
        catch (Exception se){
            System.err.println("Pesan Salah : " + se.getMessage());
        }
    }
    
    void bersihtabel() 
    {
        int brs = tabMode01.getRowCount();
        for (int i = 0; i < brs; i++) {
            tabMode01.removeRow(0);
        }
    }
    
    // Fungsi untuk mengkosongkan Objek inputan 
    void Kosong() 
    {
        fNoJual.setText("");
        fKode.setText("");
        fNama.setText("");
        fHarga.setText("");
        fJumlah.setText("");
        fTotal.setText("");
        btnAdd.setEnabled(true);
        btnDelete.setEnabled(true);
        fKode.requestFocus();
    }
    
    void settombol(int a, int b, int c, int d, int e, int f) //untuk on off kan button sesuai kondisi
    {
        btnAdd.setEnabled(a >= 1 ? true : false);
        btnCari.setEnabled(b >= 1 ? true : false);
        btnCariBar.setEnabled (c >= 1 ? true : false);
        btnKoreksi.setEnabled(d >= 1 ? true : false);
        btnDelete.setEnabled(e >= 1 ? true : false);
        btnSelesai.setEnabled(f >= 1 ? true : false);
    }
}