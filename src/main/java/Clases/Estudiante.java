package Clases;

import java.util.ArrayList;

public class Estudiante {

    private String nombre;
    private String matricula;
    private int edad;
    private ArrayList<Calificaciones> calificaciones;
    private double promedioG;

    public Estudiante(String nombre, int edad, String matricula) {
        this.nombre = nombre;
        this.edad = edad;
        this.matricula = matricula;
        this.calificaciones = new ArrayList<>();
    }

    public Estudiante() {
        this.calificaciones = new ArrayList<>();
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

    public void agregarCalificacion(Calificaciones calificacion) {
        calificaciones.add(calificacion);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCalificaciones(ArrayList<Calificaciones> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public void eliminarCal(Calificaciones calificacion) {
        calificaciones.remove(calificacion);
    }

    public double getPromedioG() {
        return promedioG;
    }

    public void setPromedioG(double promedioG) {
        this.promedioG = promedioG;
    }

    public void calcularPromedio() {
        if (calificaciones == null || calificaciones.isEmpty()) {
            this.promedioG = 0;
        } else {
            double suma = 0;
            for (Calificaciones calificacion : calificaciones) {
                suma += calificacion.getCalificacion();
            }
            this.promedioG = suma / calificaciones.size();
        }
        System.out.println("Promedio actualizado a: " + this.promedioG);
    }
}
