package Controller;

import Entity.Sabrina07239_PetugasEntity;
import Entity.Sabrina07239_DaftarPelangganEntity;
import Entity.Sabrina07239_PelangganEntity;
import java.util.Date;
import java.util.ArrayList;
public class Sabrina07239_PetugasController implements Sabrina07239_ControllerInterface{
    int indexLogin = 0;
    public Sabrina07239_PetugasController() {    
    }
    
    public void datapetugas(){
        String id[] = {"01","02","03"};
        String nama [] = {"astrid","sabrina","alex"};
        String alamat [] = {"mojokerto","mojokerto","sidoarjo"};
        String noIdentitas [] = {"01","02","03"};
        String notelp [] = {"01","02","03"};
              for(int i=0;i<id.length;i++){
                Sabrina07239_AllObjectModel.petugasModel.insertPetugas(new Sabrina07239_PetugasEntity(id[i],
                        nama[i],alamat[i],noIdentitas[i],notelp[i]));
            }
    }
    
    @Override
    public void login(String id, String nama) {
        indexLogin =  Sabrina07239_AllObjectModel.petugasModel.cekData(id, nama);
    }
    
    public Sabrina07239_PetugasEntity Sabrina07239_PetugasEntity() {
        return Sabrina07239_AllObjectModel.petugasModel.showDataPetugas(indexLogin);
    }
    
    public void updateIsVerified(int index,int indexCamera,Sabrina07239_PelangganEntity pelanggan ) {
        Sabrina07239_AllObjectModel.daftarPelangganmodel.updateIsVerified(index, new 
        Sabrina07239_DaftarPelangganEntity(indexCamera, pelanggan,true));
    }
    
    public ArrayList<Sabrina07239_DaftarPelangganEntity> cekDaftarPelangganModel() {
        return Sabrina07239_AllObjectModel.daftarPelangganmodel.getdaftarpelangganArrayList();
    }
}
