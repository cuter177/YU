package controllers;

import Clases.Bandera;
import Clases.Calificaciones;
import Clases.Estudiante;
import Clases.ListaEstudiantes;
import Excepciones.CampoVacioException;
import Excepciones.DatoIncorrectoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import utils.Paths;

import java.util.ArrayList;
import java.util.List;


public class RegistroEstudianteController {

    @FXML
    private TableColumn<Estudiante, Double> ColPromedioG;

    @FXML
    private TableColumn<Estudiante, Integer> colEdad;

    @FXML
    private TableColumn<Estudiante, String> colMatricula;

    @FXML
    private TableColumn<Estudiante, String> colNombre;

    @FXML
    private TableView<Estudiante> tblEstudiantes;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtMatricula;

    @FXML
    private TextField txtNombre;

    @FXML
    private Label lblError;


    private ListaEstudiantes listaEstudiantes;
    private Bandera bandera;

    @FXML
    void ActualizarEstudiante(ActionEvent event) {

    }

    @FXML
    void GuardarEstudiante(ActionEvent event) {

        try {

            validarCampos();
            ValidarEntero(txtEdad.getText());
            Estudiante estudiante = new Estudiante();
            estudiante.setMatricula(txtMatricula.getText());
            estudiante.setNombre(txtNombre.getText());
            estudiante.setEdad(Integer.parseInt(txtEdad.getText()));
            lblError.setText("");
            abrirVentana(estudiante);
            //bandera = falso significa que la ventana ya se ha cerrado
            //if(!bandera.isEstado()){
                actualizarTabla();
            //}

        } catch (CampoVacioException e) {
            lblError.setText(e.getMessage());
        } catch (DatoIncorrectoException e) {
            lblError.setText(e.getMessage());
        }

    }

    private void validarCampos() throws CampoVacioException {
        if (txtNombre.getText().isEmpty() || txtMatricula.getText().isEmpty() || txtEdad.getText().isEmpty()) {
            throw new CampoVacioException("Todos los campos deben estar llenos antes de guardar.");
        }
    }

    private void ValidarEntero(String dato){
        try{
            Integer.parseInt(dato);
        }catch(NumberFormatException e){
            throw new DatoIncorrectoException("Error. Favor de colocar una edad válida. ");
        }
    }

    private void abrirVentana(Estudiante estudiante){
        try {
            // Cargar la ventana de registro de calificaciones
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Paths.CALIFICACIONES));
            Parent root = loader.load();

            // Crear una nueva ventana
            Stage stage = new Stage();
            stage.setTitle("Registro de Calificaciones");
            RegistroCalificacionesController controller = loader.getController();
            controller.setEstudiante(estudiante);
            stage.setScene(new Scene(root));
            stage.show();
            //stage.onCloseRequestProperty()
            // Detectar cierre de la ventana para apagar la bandera
            stage.setOnCloseRequest(e -> bandera.setEstado(false));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void actualizarTabla() {
        tblEstudiantes.getItems().clear();
        tblEstudiantes.getItems().addAll(listaEstudiantes.getListaEstudiantes());
        tblEstudiantes.refresh();
    }


    @FXML
    void initialize() {
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        ColPromedioG.setCellValueFactory(new PropertyValueFactory<>("promedioG"));
    }

    public ListaEstudiantes getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ListaEstudiantes listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public void setBandera(Bandera bandera) {
        if (bandera == null) {
            bandera.setEstado(true);
        }
        this.bandera = bandera;
    }
}


