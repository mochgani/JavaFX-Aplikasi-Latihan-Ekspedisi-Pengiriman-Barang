/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.mochgani.javafx.aplikaslatihanekspedisipengirimanbarang.form;

import id.mochgani.javafx.aplikaslatihanekspedisipengirimanbarang.Admin;
import id.mochgani.javafx.aplikaslatihanekspedisipengirimanbarang.DataTransaksi;
import id.mochgani.javafx.aplikaslatihanekspedisipengirimanbarang.Resi;
import id.mochgani.javafx.aplikaslatihanekspedisipengirimanbarang.Tujuan;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author mochgani
 */
public class ResiController implements Initializable {
    
    @FXML
    Label txtNamaPengirim;
    @FXML
    Label txtNoTeleponPengirim;
    @FXML
    Label txtAlamatPengirim;
    @FXML
    Label txtNamaPenerima;
    @FXML
    Label txtNoTeleponPenerima;
    @FXML
    Label txtAlamatPenerima;
    @FXML
    Label txtKota;
    @FXML
    Label txtJenisBarang;
    @FXML
    Label txtBerat;
    @FXML
    Label txtKeterangan;
    @FXML
    Label txtTipeLayanan;
    @FXML
    Label txtEstimasi;
    @FXML
    Label txtNamaPetugas;
    @FXML
    Label txtTotal;
    @FXML
    Label txtTanggal;
    @FXML
    Label txtNoResi;
    
    private MainForm application;
    
    public void setApp(MainForm application, DataTransaksi dt){
        this.application = application;
        
        tampilData(dt);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void tampilData(DataTransaksi dt){
        Tujuan tujuan = new Tujuan();
        Admin admin = new Admin();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        
        tujuan.kotaLayanan = dt.kotaPenerima;
        tujuan.tipeLayanan = dt.layanan;
        tujuan.pilihLayanan(dt.kotaPenerima,dt.layanan);
        
        txtNamaPengirim.setText(dt.namaPengirim);
        txtNoTeleponPengirim.setText(dt.noTeleponPengirim);
        txtAlamatPengirim.setText(dt.alamatPengirim);
        txtNamaPenerima.setText(dt.namaPenerima);
        txtNoTeleponPenerima.setText(dt.noTeleponPenerima);
        txtAlamatPenerima.setText(dt.alamatPenerima);
        txtKota.setText(dt.kotaPenerima);
        txtJenisBarang.setText(dt.jenisBarang);
        txtBerat.setText(dt.berat + " Kg");
        txtKeterangan.setText(dt.keterangan);
        txtTipeLayanan.setText(dt.layanan);
        txtEstimasi.setText(tujuan.estimasi);
        txtNamaPetugas.setText(admin.namaAdmin);
        txtTotal.setText(formatter.format(tujuan.kalkulasiHarga(dt.berat)));
        txtNoResi.setText(dt.nomorResi);
        txtTanggal.setText(dt.tanggalPengiriman);
    }
    
    public void prosesLogout(){
        if (application != null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                application.userLogout();
            } else {
                alert.close();
            }
            
            
        }
    }
    
    public void prosesBack(){
        if (application != null){
            application.userMain();
            
        }
    }
    
}
