package id.mochgani.javafx.aplikaslatihanekspedisipengirimanbarang;

import java.util.ArrayList;

public class Tujuan {
    public String kotaLayanan;
    public String tipeLayanan;
    public double hargaPengiriman;
    public String estimasi;
    public ArrayList<String> listKota = new ArrayList<>();
    public ArrayList<String> listLayanan = new ArrayList<>();
    
    public Tujuan(){
        listKota.add("Jakarta");
        listKota.add("Yogyakarta");
        listKota.add("Surabaya");
        
        listLayanan.add("Oke");
        listLayanan.add("Regular");
        listLayanan.add("Yes");
    }
    
    public void pilihLayanan(String kota, String layanan){
        if(kota.equalsIgnoreCase("jakarta")){
            if(layanan.equalsIgnoreCase("yes")){
                hargaPengiriman = 25000;
                estimasi = "1 Hari";
            } else if(layanan.equalsIgnoreCase("regular")){
                hargaPengiriman = 15000;
                estimasi = "2 - 5 Hari";
            } else if(layanan.equalsIgnoreCase("oke")){
                hargaPengiriman = 10000;
                estimasi = "5 - 7 Hari";
            }
        }
        else if(kota.equalsIgnoreCase("yogyakarta")){
            if(layanan.equalsIgnoreCase("yes")){
                hargaPengiriman = 35000;
                estimasi = "1 Hari";
            } else if(layanan.equalsIgnoreCase("regular")){
                hargaPengiriman = 25000;
                estimasi = "2 - 5 Hari";
            } else if(layanan.equalsIgnoreCase("oke")){
                hargaPengiriman = 20000;
                estimasi = "5 - 7 Hari";
            }
        }
        else if(kota.equalsIgnoreCase("surabaya")){
            if(layanan.equalsIgnoreCase("yes")){
                hargaPengiriman = 45000;
                estimasi = "1 Hari";
            } else if(layanan.equalsIgnoreCase("regular")){
                hargaPengiriman = 35000;
                estimasi = "2 - 5 Hari";
            } else if(layanan.equalsIgnoreCase("oke")){
                hargaPengiriman = 30000;
                estimasi = "5 - 7 Hari";
            }
        }
    }
    
    public double kalkulasiHarga(double berat){
        double subTotal;
        
        subTotal = berat * hargaPengiriman;
        
        return subTotal;
    }
    
}
