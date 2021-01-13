package View;

import Entity.Sabrina07239_CameraEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.*;
public class Sabrina07239_PelangganGUI {
    JFrame Pelanggan = new JFrame();
    JButton back,daftarbtn;
    JTextArea area = new JTextArea();
    JLabel datadiri,daftarcamera;
    JComboBox pilcamera = new JComboBox(Sabrina07239_CameraEntity.merk);
    int cek = Sabrina07239_Allobjctrl.Pelanggan.cekDaftarPelanggan
        (Sabrina07239_Allobjctrl.Pelanggan.getData().getId());
    
    public Sabrina07239_PelangganGUI(){
        Pelanggan.setSize(720, 600);
        Pelanggan.setLayout(null);
        Pelanggan.getContentPane().setBackground(Color.RED);
        
        datadiri = new JLabel("Data Pelanggan");
        datadiri.setFont(new Font("Timer New Roman",Font.BOLD,30));
        datadiri.setBounds(90, 30, 200, 30);
        Pelanggan.add(datadiri);
        area.setBounds(30, 90, 400, 300);
        Pelanggan.add(area);
        
        daftarcamera = new JLabel("Daftar Camera");
        daftarcamera.setBounds(450, 30, 250, 30);
        daftarcamera.setFont(new Font("Times New Roman",Font.BOLD,30));
        Pelanggan.add(daftarcamera);
        pilcamera.setBounds(450, 90, 230, 30);
        Pelanggan.add(pilcamera);
        
        daftarbtn = new JButton("Daftar");
        daftarbtn.setBounds(500, 200, 100, 30);
        daftarbtn.setBackground(Color.GRAY);
        Pelanggan.add(daftarbtn);
        
        back = new JButton("Back");
        back.setBounds(30, 500, 100, 30);
        back.setBackground(Color.GRAY);
        Pelanggan.add(back);
        
        Pelanggan.setVisible(true);
        Pelanggan.setLocationRelativeTo(null);
        Pelanggan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(cek==-1){ //cek data, apabila kita belum daftar untuk kameranya
            JOptionPane.showMessageDialog(null, "Anda Belum Daftar Camera", "Information", JOptionPane.INFORMATION_MESSAGE);        
        }else if(cek==-2){
            JOptionPane.showMessageDialog(null,"Anda Belum Daftar Camera", "Information", JOptionPane.INFORMATION_MESSAGE);
        }else{
            area.setText(datapelanggan());
        }
        daftarbtn.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae){
            int indexcamera = pilcamera.getSelectedIndex();
            Sabrina07239_Allobjctrl.Pelanggan.Sabrina07239_DaftarCamera
            (indexcamera,Sabrina07239_Allobjctrl.Pelanggan.getData(), false);
            area.setText(datapelanggan());
        }
        });
        
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Pelanggan.dispose();
                Sabrina07239_GUI men = new Sabrina07239_GUI(); //nama objek menu
            }
        });
    }
    
    String datapelanggan(){
        int cek = Sabrina07239_Allobjctrl.Pelanggan.cekDaftarPelanggan
        (Sabrina07239_Allobjctrl.Pelanggan.getData().getId());
        String cekverif; //untuk verivikasi data berdasarkan id
        if(Sabrina07239_Allobjctrl.Pelanggan.showDaftarPelanggan(cek).isIsVerified()==false){
            cekverif = "belum diverifikasi";
        }else{
            cekverif = "sudah diverifikasi";
        }
         String text = "Id = "+Sabrina07239_Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getId()+"\n"
                +"Nama = "+Sabrina07239_Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getnama()+"\n"
                +"Alamat = "+Sabrina07239_Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getalamat()+"\n"
                +"No Identitas = "+Sabrina07239_Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getnoIdentitas()+"\n"
                +"No Telp = "+Sabrina07239_Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getnotelp()+"\n"
                +"Tanggal Sewa = "+new SimpleDateFormat("dd-MM-yyyy").format
        (Sabrina07239_Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getTgl_sewa())+"\n"
                +"Tanggal Kembali = "+new SimpleDateFormat("dd-MM-yyyy").format
        (Sabrina07239_Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getTgl_kembali())+"\n"
                +"Verifikasi = "+cekverif+"\n"
                +"camera = "+Sabrina07239_CameraEntity.merk[Sabrina07239_Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getIndexCamera()];
        return text;
    }
}
