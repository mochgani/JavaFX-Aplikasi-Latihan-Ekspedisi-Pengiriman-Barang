/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.mochgani.javafx.aplikaslatihanekspedisipengirimanbarang.form;

import id.mochgani.javafx.aplikaslatihanekspedisipengirimanbarang.DataTransaksi;
import id.mochgani.javafx.aplikaslatihanekspedisipengirimanbarang.Resi;
import id.mochgani.javafx.aplikaslatihanekspedisipengirimanbarang.Tujuan;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mochgani
 */
public class MainController implements Initializable {
    
    @FXML
    TextField txtNamaPengirim;
    @FXML
    TextField txtNoTeleponPengirim;
    @FXML
    TextArea txtAlamatPengirim;
    @FXML
    TextField txtNamaPenerima;
    @FXML
    TextField txtNoTeleponPenerima;
    @FXML
    TextArea txtAlamatPenerima;
    @FXML
    ComboBox cmdKota;
    @FXML
    ComboBox cmdTipeLayanan;
    @FXML
    TextField txtJenisBarang;
    @FXML
    TextField txtBeratBarang;
    @FXML
    TextArea txtKeterangan;
    @FXML
    TextField txtTotal;
    @FXML
    TextField txtBiayaPerkilo;
    @FXML
    Button btnProses;
    @FXML
    Button btnCetak;
    @FXML
    Button btnList;
    
    private MainForm application;
    
    DataTransaksi dt = new DataTransaksi();
    
    public void setApp(MainForm application){
        this.application = application;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Tujuan tujuan = new Tujuan();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        
        tujuan.listKota.add(0, "Pilih Kota");
        tujuan.listLayanan.add(0, "Pilih Layanan");
        
        cmdKota.getItems().addAll(
            tujuan.listKota
        ); 
        
        cmdTipeLayanan.getItems().addAll(
            tujuan.listLayanan
        );
        
        txtTotal.setEditable(false);
        txtBiayaPerkilo.setEditable(false);
        btnCetak.setDisable(true);
        cmdKota.getSelectionModel().selectFirst();
        cmdTipeLayanan.getSelectionModel().selectFirst();
        
        // force the field to be numeric only
        txtBeratBarang.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, 
                String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    txtBeratBarang.setText(oldValue);
                }
            }

        });
        
        cmdTipeLayanan.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(cmdKota.getSelectionModel().getSelectedIndex() != 0){
                    tujuan.pilihLayanan(cmdKota.getSelectionModel().getSelectedItem().toString(),cmdTipeLayanan.getSelectionModel().getSelectedItem().toString());
                    txtBiayaPerkilo.setText(formatter.format(tujuan.hargaPengiriman));
                }
            }
        });
        
        cmdKota.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(cmdTipeLayanan.getSelectionModel().getSelectedIndex() != 0){
                    tujuan.pilihLayanan(cmdKota.getSelectionModel().getSelectedItem().toString(),cmdTipeLayanan.getSelectionModel().getSelectedItem().toString());
                    txtBiayaPerkilo.setText(formatter.format(tujuan.hargaPengiriman));
                }
            }
        });
        
    }    
    
    public void prosesLogout(){
        if (application != null){
            Alert alert = new Alert(AlertType.CONFIRMATION);
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
    
    public void prosesTransaksi(){
        if (application != null){
            String notif = "";
            
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to process?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                
                if("".equals(txtBeratBarang.getText())) notif = notif + "Berat Barang,";
                else if(Double.parseDouble(txtBeratBarang.getText()) > 20) notif = notif + "Berat tidak boleh melebihi 20Kg dan ";
                if("".equals(txtNamaPengirim.getText())) notif = notif + "Nama Pengirim,";
                if("".equals(txtAlamatPengirim.getText())) notif = notif + "Alamat Pengirim,";
                if("".equals(txtNoTeleponPengirim.getText())) notif = notif + "No Telepon Pengirim,";
                if("".equals(txtNamaPenerima.getText())) notif = notif + "Nama Penerima,";
                if("".equals(txtAlamatPenerima.getText())) notif = notif + "Alamat Penerima,";
                if("".equals(txtNoTeleponPenerima.getText())) notif = notif + "No Telepon Penerima,";
                if(cmdKota.getSelectionModel().getSelectedIndex() == 0) notif = notif + "Kota Penerima,";
                if(cmdTipeLayanan.getSelectionModel().getSelectedIndex() == 0) notif = notif + "Layanan,";
                if("".equals(txtJenisBarang.getText())) notif = notif + "Jenis Barang,";
                if("".equals(txtBeratBarang.getText())) notif = notif + "Berat Barang,";
                if("".equals(txtKeterangan.getText())) notif = notif + "Keterangan,";
                
                if(!notif.equals("")){
                    Alert alert2 = new Alert(AlertType.WARNING);
                    alert2.setTitle("Warning Dialog");
                    alert2.setHeaderText(null);
                    alert2.setContentText(notif + " Tidak Boleh Kosong!");

                    alert2.showAndWait();
                } else {
                    NumberFormat formatter = NumberFormat.getCurrencyInstance();
                    
                    dt.inputDataPengirim(txtNamaPengirim.getText(),txtAlamatPengirim.getText(),txtNoTeleponPengirim.getText());
                    dt.inputDataPenerima(txtNamaPenerima.getText(),txtAlamatPenerima.getText(),txtNoTeleponPenerima.getText());
                    double total = dt.inputDataBarang(cmdKota.getSelectionModel().getSelectedItem().toString(),
                                                        cmdTipeLayanan.getSelectionModel().getSelectedItem().toString(),
                                                        txtJenisBarang.getText(),Double.parseDouble(txtBeratBarang.getText()),
                                                        txtKeterangan.getText());
                    txtTotal.setText(formatter.format(total));
                    btnCetak.setDisable(false);
                    btnProses.setDisable(true);
                    
                    application.dataAllResi.dataTransaksi.add(dt);
                }
                
            } else {
                alert.close();
            }
            
        }
    }
    
    public void prosesCetak(){
        if (application != null){
            application.userResi(dt);
        }
    }
    
    public void prosesList(){
        if (application != null){
            application.userList();
        }
    }
    
}
