package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.Paths;

import java.io.IOException;

public class RegistroEstudianteController {

    @FXML
    private TableColumn<?, ?> ColPromedioG;

    @FXML
    private TableColumn<?, ?> colEdad;

    @FXML
    private TableColumn<?, ?> colMatricula;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtMatricula;

    @FXML
    private TextField txtNombre;

    @FXML
    void ActualizarEstudiante(ActionEvent event) {

    }

    @FXML
    void GuardarEstudiante(ActionEvent event) throws IOException {
        // Cargar la nueva ventana
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Paths.CALIFICACIONES));
        AnchorPane pane = fxmlLoader.load();

        // Crear una nueva escena con el contenido cargado
        Scene scene = new Scene(pane);

        // Crear una nueva ventana (Stage)
        Stage newStage = new Stage();
        newStage.setTitle("Registro de Calificaciones");
        newStage.setScene(scene);

        // Hacer que la nueva ventana sea modal
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(((Stage) ((TextField) event.getSource()).getScene().getWindow()));

        // Mostrar la nueva ventana
        newStage.show();
    }

    @FXML
    void tblEstudiantes(ActionEvent event) {

    }

}


