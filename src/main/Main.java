package main;

import control.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    private MainController gui;


    public Main(){
        gui = new MainController();
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Ingreso.fxml"));
        loader.setController(gui);
        Parent root = loader.load();
  
        Scene scene = new Scene(root);
  
        arg0.setScene(scene);
        arg0.setTitle("Cine ICESI");
        arg0.show();
          
        
    }

}
