package View;

import Controller.Sabrina07239_AllObjectModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
public class Sabrina07239_PetugasGUI extends JFrame{
    Font font = new Font("Times New Roman",Font.BOLD,30);
    JLabel admin = new JLabel("Petugas");
    JTable tabelpelanggan = new JTable();
    JScrollPane scrollpetugas = new JScrollPane(tabelpelanggan);
    JLabel idlabel = new JLabel("Id");
    JLabel namalabel = new JLabel("Nama");
    JTextField idtext = new JTextField();
    JTextField namatext = new JTextField();
    JButton verif = new JButton("Verif");
    JButton hapus = new JButton("Hapus");
    JButton back = new JButton("Back");
    public Sabrina07239_PetugasGUI(){
        setSize(1500,700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.CYAN);
        
        admin.setBounds(600, 30, 800, 50);
        admin.setFont(font);
        add(admin);
        
        scrollpetugas.setBounds(50, 100, 1200, 200);
        tabelpelanggan.setModel(Sabrina07239_Allobjctrl.Pelanggan.daftarpel());
        add(scrollpetugas);
        
        idlabel.setBounds(450, 320, 100, 30);
        add(idlabel);
        idtext.setBounds(450, 350, 100, 30);
        add(idtext);
        
        namalabel.setBounds(600, 320, 100, 30);
        add(namalabel);
        namatext.setBounds(600, 350, 100, 30);
        add(namatext);
        
        verif.setBounds(750, 350, 100, 30);
        verif.setBackground(Color.GRAY);
        add(verif);
        
        back.setBounds(450, 410, 100, 30);
        back.setBackground(Color.GRAY);
        add(back);
        
        hapus.setBounds(750, 410, 100, 30);
        hapus.setBackground(Color.GRAY);
        add(hapus);
        
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                dispose();
                Sabrina07239_GUI men = new Sabrina07239_GUI();//nama objek menu
            }
        });
        
        verif.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){ //untuk verifikasi id, dan nama
                String id = idtext.getText();
                String nama = namatext.getText();
                int index = Sabrina07239_AllObjectModel.daftarPelangganmodel.cekData(id, nama); //dicek
                Sabrina07239_Allobjctrl.Petugas.updateIsVerified(index, Sabrina07239_Allobjctrl.Pelanggan.showDaftarPelanggan(index)
                        .getIndexCamera(),Sabrina07239_Allobjctrl.Pelanggan.showDaftarPelanggan(index).getPelanggan());
                tabelpelanggan.setModel(Sabrina07239_Allobjctrl.Pelanggan.daftarpel());
            }
        });
        
        hapus.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){ //untuk verifikasi id, dan nama
                String id = idtext.getText();
                String nama = namatext.getText();
                int index=Sabrina07239_AllObjectModel.daftarPelangganmodel.cekData(id, nama);
                Sabrina07239_AllObjectModel.daftarPelangganmodel.hapusPelangganModel(index); //dicek
                tabelpelanggan.setModel(Sabrina07239_Allobjctrl.Pelanggan.daftarpel());
            }
        });
        
        tabelpelanggan.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){  //method
                int i = tabelpelanggan.getSelectedRow();
                idtext.setText(Sabrina07239_Allobjctrl.Pelanggan.daftarpel().getValueAt(i, 0).toString());
                namatext.setText(Sabrina07239_Allobjctrl.Pelanggan.daftarpel().getValueAt(i, 1).toString());
            }
        });
     }
}
