package controllers;

import Clases.Bandera;
import Clases.Calificaciones;
import Clases.Estudiante;
import Excepciones.CampoVacioException;
import Excepciones.DatoIncorrectoException;
import Excepciones.DatoInvalidoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

public class RegistroCalificacionesController {

    @FXML
    private TableColumn<Calificaciones, Double> colCalificacion;

    @FXML
    private TableColumn<Calificaciones, String> colMateria;

    @FXML
    private TextField txtCalificacion;

    @FXML
    private TextField txtMateria;

    @FXML
    private TableView<Calificaciones> tblCalificaciones;

    @FXML
    private Label lblError;

    private Estudiante estudiante;
    private Bandera bandera = new Bandera(true);

    @FXML
    void CerrarCal(ActionEvent event) {
        Stage stage = (Stage) tblCalificaciones.getScene().getWindow();
        // Cierra la ventana
        stage.close();

        bandera.setEstado(true);


    }

    @FXML
    void EliminarCal(ActionEvent event) {
        EliminaCal();
    }

    private void EliminaCal() {
        Calificaciones cal = tblCalificaciones.getSelectionModel().getSelectedItem();
        estudiante.eliminarCal(cal);
        actualizarTabla();
    }

    @FXML
    void GuardarCal(ActionEvent event) {
        GuardarCal();
    }

    private void GuardarCal(){
        try {
            validarCampos();
            Calificaciones calificaciones = new Calificaciones();
            calificaciones.setMateria(txtMateria.getText());
            calificaciones.setCalificacion(Double.parseDouble(txtCalificacion.getText()));

            estudiante.agregarCalificacion(calificaciones);
            actualizarTabla();
            limpiarCampos();
        }
        catch (CampoVacioException e){
            lblError.setText(e.getMessage());
        }
        catch (DatoIncorrectoException e){
            lblError.setText(e.getMessage());
        }
        catch (DatoInvalidoException e){
            lblError.setText(e.getMessage());
        }
    }

    private void actualizarTabla() {
        tblCalificaciones.getItems().clear();
        tblCalificaciones.getItems().addAll(estudiante.getCalificaciones());
        tblCalificaciones.refresh();
    }

    private void validarCampos() throws CampoVacioException {
        if (txtMateria.getText().isEmpty() || txtCalificacion.getText().isEmpty()) {
            throw new CampoVacioException("Todos los campos deben estar llenos antes de guardar.");
        }
        try{
            double dato = Double.parseDouble(txtCalificacion.getText());
            //nergacion, devuelve un true si dato es mayor que 10 y menor que 0
            if (!(dato <= 10 && dato >= 0)){
                throw new DatoInvalidoException("Numero debe ser mayor que 0 y menor o igual a 10 ");
            }
        }catch(NumberFormatException e) {
            throw new DatoIncorrectoException("Ingrese una calificación valida :) ");
        }
    }


    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
        if (this.estudiante.getCalificaciones() == null) {
            this.estudiante.setCalificaciones(new ArrayList<>());
        }
    }

    private void limpiarCampos(){
        txtCalificacion.setText("");
        txtMateria.setText("");
    }

    public void setBandera(Bandera bandera) {
        if (bandera == null) {
            bandera.setEstado(true);
        }
        this.bandera = bandera;
    }

    @FXML
    void initialize() {
        colCalificacion.setCellValueFactory(new PropertyValueFactory<>("calificacion"));
        colMateria.setCellValueFactory(new PropertyValueFactory<>("materia"));
    }

}