package com.latihan06;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener
{
    private JPanel      jpCalculator    = new JPanel ();
    private JTextField  fLayar          = new JTextField();
    private JLabel      labelmhs        = new JLabel("NIM: A12.2020.06443 Nama: Isro' Rizky W.");
    
    private JButton     btnTambah       = new JButton("+"),
                        btnKurang       = new JButton("-"),
                        btnKali         = new JButton("*"),
                        btnBagi         = new JButton("/"),
                        btnKoma         = new JButton("."),
                        btnC            = new JButton("C"),
                        btn1            = new JButton("1"),
                        btn2            = new JButton("2"),
                        btn3            = new JButton("3"),
                        btn4            = new JButton("4"),
                        btn5            = new JButton("5"),
                        btn6            = new JButton("6"),
                        btn7            = new JButton("7"),
                        btn8            = new JButton("8"),
                        btn9            = new JButton("9"),
                        btn0            = new JButton("0"),
                        btnSama         = new JButton("=");
    
    private String isiLayar = "";
    private String snilai1, snilai2, tombol;
    private int hasil;
    Font font1 = new Font("SansSerif", Font.BOLD, 24);
    
    public Calculator()
    {
        setPreferredSize(new Dimension(500,600));
        setTitle("Kalkulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        new BorderLayout();
        JDesktopPane jpCalculator = new JDesktopPane();
        add(jpCalculator, BorderLayout.CENTER);
        
        //mengatur letak objek text di container//
        //(50, 90, 385, 50); : (kolom, baris, panjang, tinggi);//
        fLayar.setBounds(50, 90, 385, 50);
        fLayar.setFont(font1);
        labelmhs.setBounds(50, 480, 300, 50);
        
        //mengatur letak objek button di container//
        btnC.setBounds(350, 160, 85, 50);
        btnTambah.setBounds(350, 230, 85, 50);
        btnKurang.setBounds(350, 300, 85, 50);
        btnKali.setBounds(350, 370, 85, 50);
        btnBagi.setBounds(350, 440, 85, 50);
        btnKoma.setBounds(150, 440, 85, 50);
        btnSama.setBounds(250, 440, 85, 50);
        //btnSama.setLabel("="); bisa juga diatur disini//
        
        //btnAdd.setToolTipText("Tombol tambah data");//
        btn1.setBounds(50, 230, 85, 50);
        btn2.setBounds(150, 230, 85, 50);
        btn3.setBounds(250, 230, 85, 50);
        btn4.setBounds(50, 300, 85, 50);
        btn5.setBounds(150, 300, 85, 50);
        btn6.setBounds(250, 300, 85, 50);
        btn7.setBounds(50, 370, 85, 50);
        btn8.setBounds(150, 370, 85, 50);
        btn9.setBounds(250, 370, 85, 50);
        btn0.setBounds(50, 440, 85, 50);
        
        fLayar.setHorizontalAlignment(JTextField.RIGHT);
        
        // objek button di nonaktifkan dan diaktifkan//
        btnTambah.setEnabled(true);
        
        //mengatur objek untuk dapat berinteraksi//
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btn0.addActionListener(this);
        btnKoma.addActionListener(this);
        btnC.addActionListener(this);
        btnSama.addActionListener(this);
        btnTambah.addActionListener(this);
        btnKurang.addActionListener(this);
        btnKali.addActionListener(this);
        btnBagi.addActionListener(this);
        
        //meletakkan seluruh kontrol pada objek panel//
        jpCalculator.add (fLayar);
        jpCalculator.add (labelmhs);
        jpCalculator.add (btn1);
        jpCalculator.add (btn2);
        jpCalculator.add (btn3);
        jpCalculator.add (btn4);
        jpCalculator.add (btn5);
        jpCalculator.add (btn6);
        jpCalculator.add (btn7);
        jpCalculator.add (btn8);
        jpCalculator.add (btn9);
        jpCalculator.add (btn0);
        jpCalculator.add (btnKoma);
        jpCalculator.add (btnTambah);
        jpCalculator.add (btnKurang);
        jpCalculator.add (btnBagi);
        jpCalculator.add (btnKali);
        jpCalculator.add (btnC);
        jpCalculator.add (btnSama);
        
        //menambahkn objek panel (jpCalculator) ke container frame//
        getContentPane().add(jpCalculator).setBackground(Color.getHSBColor(15,151,203));
        //pada color angka 0 diganti 0 s/d 255//
        
        //menampilkan frame ke layar monitor//
        pack();
        setVisible(true);
    }
    
        public static void main(String args[]) 
        {
            new Calculator().setVisible(true);
        }
        //fungsi jika user melakukan aksi penekanan tombol button//
        
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            Object obj = ae.getSource();
                    
            if (obj == btnC)
            {
                tombol = ""; snilai1 = ""; snilai2 = "";
                isiLayar = "";
                fLayar.setText(isiLayar);
            }
            if (obj == btn1)
            {
                isiLayar = isiLayar + "1";
                fLayar.setText(isiLayar);
            }
            if (obj == btn2)
            {
                isiLayar = isiLayar + "2";
                fLayar.setText(isiLayar);
            }
            if (obj == btn3)
            {
                isiLayar = isiLayar + "3";
                fLayar.setText(isiLayar);
            }
            if (obj == btn4)
            {
                isiLayar = isiLayar + "4";
                fLayar.setText(isiLayar);
            }
            if (obj == btn5)
            {
                isiLayar = isiLayar + "5";
                fLayar.setText(isiLayar);
            }
            if (obj == btn6)
            {
                isiLayar = isiLayar + "6";
                fLayar.setText(isiLayar);
            }
            if (obj == btn7)
            {
                isiLayar = isiLayar + "7";
                fLayar.setText(isiLayar);
            }
            if (obj == btn8)
            {
                isiLayar = isiLayar + "8";
                fLayar.setText(isiLayar);
            }
            if (obj == btn9)
            {
                isiLayar = isiLayar + "9";
                fLayar.setText(isiLayar);
            }
            if (obj == btn0)
            {
                isiLayar = isiLayar + "0";
                fLayar.setText(isiLayar);
            }
            if (obj == btnTambah)
            {
                tombol = "+";
                snilai1 = fLayar.getText();
                isiLayar = "";
                fLayar.setText(isiLayar);
            }
            if (obj == btnKurang)
            {
                tombol = "-";
                snilai1 = fLayar.getText();
                isiLayar = "";
                fLayar.setText(isiLayar);
            }
            if (obj == btnKali)
            {
                tombol = "*";
                snilai1 = fLayar.getText();
                isiLayar = "";
                fLayar.setText(isiLayar);
            }
            if (obj == btnKoma)
            {
                tombol = ".";
                snilai1 = fLayar.getText();
                isiLayar = "";
                fLayar.setText(isiLayar);
            }
            if (obj == btnBagi)
            {
                tombol = "/";
                snilai1 = fLayar.getText();
                isiLayar = "";
                fLayar.setText(isiLayar);
            }
            if (obj == btnSama)
            {
                snilai2 = fLayar.getText();
                //saat ditekan tombol sama dengan....
                // (misal sblmnya digunakan operator tambah...
                
                switch(tombol)
                {
                    case "+" :
                        hasil = Integer.parseInt(snilai1) + Integer.parseInt(snilai2);
                        break;
                    case "-" :
                        hasil = Integer.parseInt(snilai1) - Integer.parseInt(snilai2);
                        break;
                    case "*" :
                        hasil = Integer.parseInt(snilai1) * Integer.parseInt(snilai2);
                        break;
                    case "/" :
                        hasil = Integer.parseInt(snilai1) / Integer.parseInt(snilai2);
                        break;
                    default :
                        break;
                }
                String shasil = "" + hasil;
                fLayar.setText(shasil);
            }
        }
        void Kosong()
        {
            fLayar.setText("");
            fLayar.requestFocus();
        }
}