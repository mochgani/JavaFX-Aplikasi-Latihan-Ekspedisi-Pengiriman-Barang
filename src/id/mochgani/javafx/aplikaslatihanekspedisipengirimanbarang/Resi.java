package id.mochgani.javafx.aplikaslatihanekspedisipengirimanbarang;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Resi{
    public String tanggalPengiriman;
    public String nomorResi;
    public ArrayList<DataTransaksi> dataTransaksi = new ArrayList<>();
    
    public Resi(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        tanggalPengiriman = dateFormat.format(cal.getTime());
        nomorResi = generateNomorResi();
    }
    
    public String generateNomorResi(){
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
        Calendar cal = Calendar.getInstance();
        
        return "RES" + dateFormat.format(cal.getTime());
    }
    
}
