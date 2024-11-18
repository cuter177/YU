package controllers;

import Clases.Calificaciones;
import Clases.Estudiante;
import Excepciones.CampoVacioException;
import Excepciones.DatoIncorrectoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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

    private Estudiante estudiante;

    @FXML
    void CerrarCal(ActionEvent event) {

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
        }catch (CampoVacioException e){
        }catch (DatoIncorrectoException e){
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
    }

    private void ValidarEntero(String dato, String campo){
        try{
            Double.parseDouble(dato);
        }catch(NumberFormatException e){
            throw new DatoIncorrectoException("El campo" + campo +  "debe contener un numero entero valido. ");
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

    @FXML
    void initialize() {

        colCalificacion.setCellValueFactory(new PropertyValueFactory<>("calificacion"));
        colMateria.setCellValueFactory(new PropertyValueFactory<>("materia"));
    }

}