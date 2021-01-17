package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
public class Sabrina07239_GUI extends Sabrina07239_KomponenGUI{
    private boolean ceklogin = false;
    public Sabrina07239_GUI(){ //komponen
        setSize(700, 700); //ukuran 
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.CYAN); //warna background
        
        judulGui.setBounds(150, 10, 600, 50); 
        judulGui.setFont(font);
        add(judulGui);
        
        labellogin.setBounds(100, 50, 100, 100);
        labellogin.setFont(font);
        add(labellogin);
        
        radioPetugas.setBounds(30, 150, 100, 30);
        radioPetugas.setBackground(Color.GRAY);
        add(radioPetugas);
        
        radiopelanggan.setBounds(140, 150, 100, 30);
        radiopelanggan.setBackground(Color.GRAY);
        add(radiopelanggan);
        
        labelidlogin.setBounds(30, 180, 30, 30);
        add(labelidlogin);   
        textidlogin.setBounds(30, 210, 200, 30);
        add(textidlogin);
        
        labelnamalogin.setBounds(30, 240, 100, 30);
        add(labelnamalogin);
        textnamalogin.setBounds(30, 270, 200, 30);
        add(textnamalogin);
        
        btnlogin.setBounds(90, 320, 100, 40);
        btnlogin.setBackground(Color.GRAY);
        add(btnlogin);
        
        daftar.setFont(font);
        daftar.setBounds(440, 50, 150, 100);
        add(daftar);
        
        labeliddaftar.setBounds(400, 150, 30, 30);
        add(labeliddaftar);
        textiddaftar.setBounds(400, 180, 200, 30);
        add(textiddaftar);
        
        labelnamadaftar.setBounds(400, 210, 100, 30);
        add(labelnamadaftar);
        textnamadaftar.setBounds(400, 240, 200, 30);
        add(textnamadaftar);
        
        labelalamat.setBounds(400, 270, 100, 30);
        add(labelalamat);
        textalamat.setBounds(400, 300, 200, 30);
        add(textalamat);
        
        labelnoidentitas.setBounds(400, 330, 100, 30);
        add(labelnoidentitas);
        textnoidentitas.setBounds(400, 360, 200, 30);
        add(textnoidentitas);
        
        labelnotelp.setBounds(400, 390, 200, 30);
        add(labelnotelp);
        textnotelp.setBounds(400, 420, 200, 30);
        add(textnotelp);
        
        labeltglsewa.setBounds(400, 450, 200, 30);
        add(labeltglsewa);
        texttglsewa.setBounds(400, 480, 200, 30);
        add(texttglsewa);
        
        labeltglkembali.setBounds(400, 510, 200, 30);
        add(labeltglkembali);
        texttglkembali.setBounds(400, 540, 200, 30);
        add(texttglkembali);
        
        reg.setBounds(460, 580, 100, 40);
        reg.setBackground(Color.GRAY);
        add(reg);
        radioPetugas.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){ //untuk petugas
                if(radioPetugas.isSelected()){
                    radiopelanggan.setSelected(false);
                    ceklogin=true;
                }
            }
        });
        
        radiopelanggan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){ //untuk pelanggan
                if(radiopelanggan.isSelected()){
                    radioPetugas.setSelected(false);//untuk petugas false
                    ceklogin=false;
                }
            }
        });
        
        btnlogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){ //method
                if(ceklogin==true){
                    try{ 
                        Sabrina07239_Allobjctrl.Petugas.datapetugas(); // login untuk petugas
                        Sabrina07239_Allobjctrl.Petugas.login(textidlogin.getText(), textnamalogin.getText());
                        String nama = Sabrina07239_Allobjctrl.Petugas.Sabrina07239_PetugasEntity().getnama(); //memasukkan id,nama, jika benar 
                        JOptionPane.showMessageDialog(null, "Selamat datang "+nama,"information", JOptionPane.INFORMATION_MESSAGE);
                        Sabrina07239_PetugasGUI petugas = new Sabrina07239_PetugasGUI();
                        dispose();
                    }catch(Exception exception){ //jika id/nama salah makan akan muncul pesan
                        JOptionPane.showMessageDialog(null, "id atau nama salah", "information", JOptionPane.INFORMATION_MESSAGE);
                        kosong();//method kosong, jika datanya kosong                    
                    }
                }else{
                    try{ //login untuk pelanggan
                       Sabrina07239_Allobjctrl.Pelanggan.login(textidlogin.getText(),textnamalogin.getText());
                       String nama = Sabrina07239_Allobjctrl.Pelanggan.getData().getnama(); //memasukkan id,nama, jika benar 
                       JOptionPane.showMessageDialog(null, "Selamat datang "+nama,"information", JOptionPane.INFORMATION_MESSAGE);
                       Sabrina07239_PelangganGUI  pel = new Sabrina07239_PelangganGUI();
                       dispose();
                    }catch(Exception eception){ //jika id/nama salah makan akan muncul pesan
                        JOptionPane.showMessageDialog(null, "id atau nama salah", "information", JOptionPane.INFORMATION_MESSAGE);
                       kosong(); //method kosong, jika datanya kosong
                    }
                }
            }
        });
        
        reg.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                try{
                    String id = textiddaftar.getText(); //registrasi
                    String nama = textnamadaftar.getText();
                    String alamat = textalamat.getText();
                    String noidentitas = textnoidentitas.getText();
                    String notelp = textnotelp.getText();
                    Date tglsewa = new Date(texttglsewa.getText());
                    Date tglkembali = new Date(texttglkembali.getText());
                    Sabrina07239_Allobjctrl.Pelanggan.insert(id, nama, alamat, noidentitas, notelp, tglsewa, tglkembali); //jika sukses
                    JOptionPane.showMessageDialog(null, "Registrasi sukses", "information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(null, "Format Penulisan Salah", "Registrasi Gagal", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                }
            }
        });
    }
       void kosong(){
        textiddaftar.setText(null);//settext null semua
        textnamadaftar.setText(null);
        textalamat.setText(null);
        textnoidentitas.setText(null);
        textnotelp.setText(null);
        texttglsewa.setText(null);
        texttglkembali.setText(null);
        textidlogin.setText(null);
        textnamalogin.setText(null);
    }
}
