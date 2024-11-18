package application;

import Clases.Bandera;
import Clases.Estudiante;
import Clases.ListaEstudiantes;
import controllers.RegistroEstudianteController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utils.Paths;

import java.util.ArrayList;
import java.util.List;


public class App  extends Application {

    ListaEstudiantes listaEstudiantes = new ListaEstudiantes();

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Paths.ESTUDIANTES));
        AnchorPane pane  = fxmlLoader.load();
        Bandera bandera = new Bandera(true);


        RegistroEstudianteController controller = fxmlLoader.getController();
        controller.setListaEstudiantes(listaEstudiantes);
        controller.setBandera(bandera);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {

            launch();

        //launch();
    }
}
