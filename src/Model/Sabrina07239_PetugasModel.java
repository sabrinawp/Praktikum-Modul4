package Model;
import Entity.Sabrina07239_PetugasEntity;
import java.util.ArrayList;
public class Sabrina07239_PetugasModel implements Sabrina07239_ModeIinterfaces{ 
    private  ArrayList <Sabrina07239_PetugasEntity> PetugasEntityArrayList;
    
    public Sabrina07239_PetugasModel(){
    PetugasEntityArrayList = new ArrayList<Sabrina07239_PetugasEntity>();
    }
    public void insertPetugas(Sabrina07239_PetugasEntity petugas){
        PetugasEntityArrayList.add(petugas);
    }
    @Override
    public int cekData(String id, String nama){
        int loop = 0;
        for(Sabrina07239_PetugasEntity petugasEntity : PetugasEntityArrayList){
            if(petugasEntity.getId().equals(id) && petugasEntity.getnama().equals(nama)){
            break;
            }else{
                loop++;
            }
        }
        return loop;
   }
    public Sabrina07239_PetugasEntity showDataPetugas(int index){
        return PetugasEntityArrayList.get(index);
    }
}
