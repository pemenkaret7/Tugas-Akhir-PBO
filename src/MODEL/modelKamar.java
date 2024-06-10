package MODEL;

import ModelGson.ModelGSON;
import NODE.Kamar;
import NODE.Tamu;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class modelKamar {
    public ArrayList<Kamar> kamarList ;

    ModelGSON<Kamar> kamarModelGSON;

    public modelKamar(){
        kamarModelGSON = new ModelGSON<>("src/DATA/Kamar.json");
        kamarList = new ArrayList<>();
        loadKamar();
    }

    public void loadKamar(){
        kamarList = kamarModelGSON.readFromFile(new TypeToken<ArrayList<Kamar>>() {}.getType());
    }

    public void commit(){
        kamarModelGSON.writeToFile(kamarList);
    }

    public void Tambahkamar(Kamar kamar){
        kamarList.add(kamar);
        kamarModelGSON.writeToFile(kamarList);
    }

    public int getLasKODEKamar(){
            int kode = 0;
            if (kamarList != null) {
                for (Kamar kamar : kamarList) {
                    kode = kamar.getKodeKamar();
                }
            }
            return kode;
        }


    public Kamar getKamarr(int kode){
        for (Kamar kamar: kamarList){
            if(kamar.getKodeKamar() == kode){
                return kamar;
            }
        }
        return null;
    }

    public void viewALLkamar(){
        for (int i=0 ; i < kamarList.size(); i++){
            loadKamar();
        kamarList.get(i).viewKamar();
        System.out.println("==============");
        }
    }


}
