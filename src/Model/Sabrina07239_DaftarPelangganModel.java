package Model; 
import Entity.Sabrina07239_DaftarPelangganEntity;
import Entity.Sabrina07239_CameraEntity;
import Entity.Sabrina07239_PetugasEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class Sabrina07239_DaftarPelangganModel implements Sabrina07239_ModeIinterfaces { 
    private ArrayList<Sabrina07239_DaftarPelangganEntity> daftarpelangganArrayList;
    public Sabrina07239_DaftarPelangganModel(){
    daftarpelangganArrayList = new ArrayList<Sabrina07239_DaftarPelangganEntity>();
        }
    public void insertDataPelanggan(Sabrina07239_DaftarPelangganEntity daftarpelanggan){
        daftarpelangganArrayList.add(daftarpelanggan);
    }
    public ArrayList<Sabrina07239_DaftarPelangganEntity> getdaftarpelangganArrayList(){
        return daftarpelangganArrayList;
    }
    @Override
    public int cekData(String id, String nama){
        int loop = 0;
        if(daftarpelangganArrayList.size() ==0){
            loop = -1;//data kosong
        }else{
            for(int i = 0; i <daftarpelangganArrayList.size(); i++){
            if(daftarpelangganArrayList.get(i).getPelanggan().getId().equals(id)){
                loop = i;
                break;
            }else{
                loop = -2;
                }
            }
        }   return loop;
    }
    public Sabrina07239_DaftarPelangganEntity showDaftarPelanggan(int index){
        return daftarpelangganArrayList.get(index);//menampilkan data pelanggan
    }
    public void hapusPelangganModel(int index) {
        daftarpelangganArrayList.remove(daftarpelangganArrayList.get(index)); //mengapus data pelanggan
    }
    public void updateIsVerified(int index,Sabrina07239_DaftarPelangganEntity daftarpelanggan){
    daftarpelangganArrayList.set(index, daftarpelanggan);
    }
    public ArrayList <Sabrina07239_DaftarPelangganEntity> alldatapelanggan(){
        return  daftarpelangganArrayList;
    }
}
