/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.mochgani.javafx.aplikaslatihanekspedisipengirimanbarang.form;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import static sun.security.krb5.KrbException.errorMessage;

/**
 * FXML Controller class
 *
 * @author mochgani
 */
public class LoginController implements Initializable {
    
    @FXML
    TextField txtNik;
    @FXML
    PasswordField txtPassword;
    @FXML
    Button btnLogin;
    @FXML
    Label errorMessage;
    
    private MainForm application;
    
    public void setApp(MainForm application){
        this.application = application;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void prosesLogin(){
        if (application == null){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Error Application Null");

            alert.showAndWait();
        } else {
            if (!application.userLogging(txtNik.getText(), txtPassword.getText())){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Nik/Password is incorrect");

                alert.showAndWait();
            }
        }
    }
    
}
