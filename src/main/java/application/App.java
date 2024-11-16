package application;

import Clases.Estudiante;
import controllers.RegistroEstudianteController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utils.Paths;

import java.util.ArrayList;


public class App  extends Application {

    ArrayList<Estudiante> estudiantes;

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Paths.ESTUDIANTES));
        AnchorPane pane  = fxmlLoader.load();

        //RegistroEstudianteController restudiante = fxmlLoader.getController();

        RegistroEstudianteController controller = fxmlLoader.getController();
        controller.setListaEstudiantes(estudiantes);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {

            launch();

        //launch();
    }
}
