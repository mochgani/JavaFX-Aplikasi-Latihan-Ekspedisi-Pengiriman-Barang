package id.mochgani.javafx.aplikaslatihanekspedisipengirimanbarang.form;

import id.mochgani.javafx.aplikaslatihanekspedisipengirimanbarang.Admin;
import id.mochgani.javafx.aplikaslatihanekspedisipengirimanbarang.DataTransaksi;
import id.mochgani.javafx.aplikaslatihanekspedisipengirimanbarang.Resi;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainForm extends Application {
    
    private Group root = new Group();
    private Admin loggedUser;
    public Resi dataAllResi = new Resi();
    
    public Parent createContent() {
        gotoLogin();
        return root;
    }
 
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
 
    public boolean userLogging(String nik, String password){
        loggedUser = new Admin();
        if (loggedUser.validate(nik, password)) {
            gotoMain();
            return true;
        } else {
            return false;
        }
    }
  
    void userList(){
        gotoList(dataAllResi);
    }
    
    void userLogout(){
        gotoLogin();
    }
    
    void userMain(){
        gotoMain();
    }
    
    void userResi(DataTransaksi dt){        
        gotoResi(dt);
    }
 
    private void gotoMain() {
        try {
            MainController profile =
                (MainController)replaceSceneContent("main.fxml");
            profile.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void gotoList(Resi resi) {
        try {
            ListtransaksiController profile =
                (ListtransaksiController)replaceSceneContent("listtransaksi.fxml");
            profile.setApp(this,resi);
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    private void gotoLogin() {
        try {
            LoginController login =
                (LoginController)replaceSceneContent("login.fxml");
            login.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void gotoResi(DataTransaksi dt) {
        try {
            ResiController resi =
                (ResiController)replaceSceneContent("resi.fxml");
            resi.setApp(this,dt);
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = MainForm.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MainForm.class.getResource(fxml));
        AnchorPane page;
 
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        root.getChildren().removeAll();
        root.getChildren().addAll(page);
 
        return (Initializable)loader.getController();
    }
    
}
