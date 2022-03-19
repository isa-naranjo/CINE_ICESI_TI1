package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import model.Estudiantes;
import model.Personal_BU;

public class MainController{

    @FXML
    private PasswordField ccPW;

    @FXML
    private Button ingresarBT;

    @FXML
    private BorderPane mainPane;
    
    @FXML
    private TextField idStudentTF;

    @FXML
    private TextField nameStudentTF;

    @FXML
    private Button registrarBT;

    @FXML
    private Button cuatroBT;

    @FXML
    private TextField duracionTF;

    @FXML
    private DatePicker fechaDP;

    @FXML
    private Button guardar;

    @FXML
    private Button nueveBT;

    @FXML
    private TextField peliculaTF;

    @FXML
    private RadioButton rbMiniSala;

    @FXML
    private RadioButton rbSALAMEDIA;

    @FXML
    private ToggleGroup sala;

    @FXML
    private Button seisBT;

    @FXML
    private Button unaBT;

    private Estudiantes estudiantes;
    private Personal_BU personal;



    public MainController(){
        try {
            if(!loadDataSaved("data/Estudiantes.isa", "data/Personal_BU.isa")){
                estudiantes = new Estudiantes("Base",1);
                personal = new Personal_BU(0);

            }
        } catch (ClassNotFoundException | IOException e) {
           // e.printStackTrace();
        }
    }
    

  

    @FXML
    void save(ActionEvent event) throws IOException {
            if(rbSALAMEDIA.isSelected()){
                estudiantes.saveData();
                personal.saveData();
                loadScreen("../ui/Sala_Media.fxml");
            }else{
                loadScreen("../ui/Mini_Sala.fxml");
            }
    }

    @FXML
    void registrar(ActionEvent event) {
        loadScreen("../ui/Función.fxml");
    }

    @FXML
    void ingresar(ActionEvent event) {
        loadScreen("../ui/Ingreso.fxml");

    }

    @FXML
    void verReservas(ActionEvent event) {
        loadScreen("../ui/Reservas.fxml");
    }



    public boolean loadDataSaved(String fileName1 , String finleName2) throws FileNotFoundException, IOException, ClassNotFoundException{
        File f1 = new File(fileName1);
        File f2 = new File(fileName1);
        if(f1.exists() && f2.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f1));
            ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(f2));

            estudiantes = (Estudiantes)ois.readObject();
            personal = (Personal_BU)ois2.readObject();
            
             ois.close();
             ois2.close();

             return true;
        }else{
            return false;
        }

    }



    public void loadScreen(String path){
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        loader.setController(this);
        try {
            Parent center = loader.load();
            mainPane.setCenter(center);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}