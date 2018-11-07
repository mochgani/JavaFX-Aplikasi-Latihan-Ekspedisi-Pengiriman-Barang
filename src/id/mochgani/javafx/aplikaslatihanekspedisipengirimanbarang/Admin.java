package id.mochgani.javafx.aplikaslatihanekspedisipengirimanbarang;

public class Admin {
    public String namaAdmin;
    public String nikAdmin;
    public String passwordAdmin;
    
    public Admin(){
        namaAdmin = "Admin Ekpedisi";
        nikAdmin = "123456789";
        passwordAdmin = "admin";
    }
    
    public boolean validate(String nik, String password){
        if(nikAdmin.equals(nik) && passwordAdmin.equals(password)){
            return true;
        } else {
            return false;
        }
    }
}
