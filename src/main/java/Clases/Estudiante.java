package Clases;

import java.util.ArrayList;

public class Estudiante {

    private String nombre;
    private String matricula;
    private int edad;
    private ArrayList<Calificaciones> calificaciones;

    public Estudiante(String nombre, int edad, String matricula) {
        this.nombre = nombre;
        calificaciones = new ArrayList<>();
        this.edad = edad;
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public ArrayList<Calificaciones> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(ArrayList<Calificaciones> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
