/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.mochgani.javafx.aplikaslatihanekspedisipengirimanbarang.form;

import id.mochgani.javafx.aplikaslatihanekspedisipengirimanbarang.DataTransaksi;
import id.mochgani.javafx.aplikaslatihanekspedisipengirimanbarang.Resi;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author mochgani
 */
public class ListtransaksiController implements Initializable {
    
    @FXML
    TableView<String> tblData;
    @FXML
    TableColumn<String, String> clNo;

    @FXML
    TableColumn<String, String> clNama;
    
    @FXML
    TableColumn<String, String> clKota;
    
    @FXML
    TableColumn<String, String> clTanggal;
    
    private MainForm application;
    
    public void setApp(MainForm application,Resi resi){
        this.application = application;
        
        for (DataTransaksi element : resi.dataTransaksi) {
            clNo.setCellValueFactory(c -> new SimpleStringProperty(new String(element.nomorResi)));

            clNama.setCellValueFactory(c -> new SimpleStringProperty(new String(element.namaPengirim)));
            
            clKota.setCellValueFactory(c -> new SimpleStringProperty(new String(element.kotaPenerima)));
            
            clTanggal.setCellValueFactory(c -> new SimpleStringProperty(new String(element.tanggalPengiriman)));

            tblData.getItems().addAll("Abcd");
        }
           
        
    }   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
    public void prosesTransaksi(){
        if (application != null){
            application.userMain();
            
        }
    }
    
}
