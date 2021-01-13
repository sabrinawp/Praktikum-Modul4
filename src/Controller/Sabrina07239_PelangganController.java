package Controller;

import Entity.Sabrina07239_DaftarPelangganEntity;
import Entity.Sabrina07239_PelangganEntity;
import Model.Sabrina07239_PelangganModel;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Sabrina07239_PelangganController implements Sabrina07239_ControllerInterface{
    int indexLogin = 0;
    public Sabrina07239_PelangganController() {
    }
    
    public Sabrina07239_PelangganEntity getData() {
        return Sabrina07239_AllObjectModel.pelangganModel.getpelangganEntityArrayList(indexLogin);
    }
    
    public void Sabrina07239_DaftarCamera(int indexCamera,  Sabrina07239_PelangganEntity pelanggan,
            boolean isVerified) {
        Sabrina07239_AllObjectModel.daftarPelangganmodel.insertDataPelanggan(new 
        Sabrina07239_DaftarPelangganEntity (indexCamera,pelanggan, isVerified));
    }
    
    @Override
    public void login(String id, String nama) {
        indexLogin = Sabrina07239_AllObjectModel.pelangganModel.cekData(id, nama);
    }
    
    public void insert(String id,String nama,String alamat, String noIdentitas,String notelp,Date tgl_sewa,Date tgl_kembali) {
        Sabrina07239_PelangganEntity pelangganModel = new Sabrina07239_PelangganEntity();
        pelangganModel.setid(id);
        pelangganModel.setnama(nama);
        pelangganModel.setalamat(alamat);
        pelangganModel.setnoIdentitas(noIdentitas);
        pelangganModel.setnotelp(notelp);
        pelangganModel.setTgl_sewa(tgl_sewa);
        pelangganModel.setTgl_kembali(tgl_kembali);
        Sabrina07239_AllObjectModel.pelangganModel.insert(pelangganModel);
    }
    
    public int cekDaftarPelanggan(String id) {
        int cek = Sabrina07239_AllObjectModel.daftarPelangganmodel.cekData(id, null);
        return cek;
    }
    
    public Sabrina07239_DaftarPelangganEntity showDaftarPelanggan(int index) {
        return Sabrina07239_AllObjectModel.daftarPelangganmodel.showDaftarPelanggan(index);
    }
    
    public void deleteDataPelanggan(int index) {
        Sabrina07239_AllObjectModel.daftarPelangganmodel.hapusPelangganModel(index);
    }
    public ArrayList<Sabrina07239_DaftarPelangganEntity> cekDaftarPelangganModel() {
        return Sabrina07239_AllObjectModel.daftarPelangganmodel.getdaftarpelangganArrayList();
    }
    public DefaultTableModel daftarpel(){
        DefaultTableModel dtmdaftarpel = new DefaultTableModel();
        Object[] kolom ={"Id","Nama","Alamat","No Identitas","No Telp","Tgl Sewa","Tgl Kembali","camera","Verified"};
        dtmdaftarpel.setColumnIdentifiers(kolom);
        int size = Sabrina07239_AllObjectModel.daftarPelangganmodel.alldatapelanggan().size();
        String verif = null;
        for(int i=0;i<size;i++){
            if(Sabrina07239_AllObjectModel.daftarPelangganmodel.alldatapelanggan().get(i).isIsVerified()==false){
                verif = "no";
            }else{
                verif = "yes";
            }
            Object [] data = new Object[9];
            data[0] = Sabrina07239_AllObjectModel.daftarPelangganmodel.alldatapelanggan().get(i).getPelanggan().getId();
            data[1] = Sabrina07239_AllObjectModel.daftarPelangganmodel.alldatapelanggan().get(i).getPelanggan().getnama();
            data[2] = Sabrina07239_AllObjectModel.daftarPelangganmodel.alldatapelanggan().get(i).getPelanggan().getalamat();
            data[3] = Sabrina07239_AllObjectModel.daftarPelangganmodel.alldatapelanggan().get(i).getPelanggan().getnoIdentitas();
            data[4] = Sabrina07239_AllObjectModel.daftarPelangganmodel.alldatapelanggan().get(i).getPelanggan().getnotelp();
            data[5] = Sabrina07239_AllObjectModel.daftarPelangganmodel.alldatapelanggan().get(i).getPelanggan().getTgl_sewa();
            data[6] = Sabrina07239_AllObjectModel.daftarPelangganmodel.alldatapelanggan().get(i).getPelanggan().getTgl_kembali();
            data[7] = Sabrina07239_AllObjectModel.daftarPelangganmodel.alldatapelanggan().get(i).getIndexCamera();
            data[8] = verif;
            dtmdaftarpel.addRow(data);
    }
        return dtmdaftarpel;
    }
}
