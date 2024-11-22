package Clases;

import java.util.ArrayList;

public class Estudiante {

    private String nombre;
    private String matricula;
    private int edad;
    private ArrayList<Calificaciones> calificaciones;
    private double promedioG;
    private double mediana;
    private double desviacionE;

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

    public double getMediana() {
        return mediana;
    }

    public void setMediana(double mediana) {
        this.mediana = mediana;
    }

    public double getDesviacionE() {
        return desviacionE;
    }

    public void setDesviacionE(double desviacionE) {
        this.desviacionE = desviacionE;
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

    public ArrayList<Calificaciones> ordenarCalficaciones() {
        if (calificaciones == null || calificaciones.isEmpty()) {
            return null;
        }
       ArrayList<Calificaciones> calificacionesOrdenadas = new ArrayList<>();
       calificacionesOrdenadas = calificaciones;
       quickSort(calificacionesOrdenadas, 0, calificaciones.size() - 1);
        return calificacionesOrdenadas;
    }

    public void quickSort(ArrayList<Calificaciones> calificaciones, int izquierda, int derecha) {
        if(izquierda < derecha) {
            int particion = paticion(calificaciones, izquierda, derecha);
            quickSort(calificaciones, izquierda, particion-1);
            quickSort(calificaciones, particion+1, derecha);
        }
    }

    private int paticion(ArrayList<Calificaciones> calificaciones, int izquierda, int derecha) {
        double pivote  =  calificaciones.get(derecha).getCalificacion();
        int i = izquierda - 1;
        for (int j = izquierda; j < derecha; j++) {
            if(pivote > calificaciones.get(j).getCalificacion()) {
                i = i + 1;
                Calificaciones temp = calificaciones.get(i);
                calificaciones.set(i, calificaciones.get(j));
                calificaciones.set(j, temp);
            }
        }
        Calificaciones temp = calificaciones.get(i + 1);
        calificaciones.set(i + 1, calificaciones.get(derecha));
        return i + 1;
    }

    public void calcularMediana() {
        ArrayList<Calificaciones> calificacionesOrdenadas = ordenarCalficaciones();

        int n = calificacionesOrdenadas.size();
        if (n % 2 == 1) {
            this.mediana = calificacionesOrdenadas.get(n/2).getCalificacion();
        } else {
            this.mediana = (calificacionesOrdenadas.get((n/2) - 1).getCalificacion() + calificacionesOrdenadas.get(n/2).getCalificacion()) / 2;
        }
    }

    public void calcularDesviacionE() {
        double suma = 0;
        for(int i = 0; i < calificaciones.size(); i++){
            suma = suma + Math.pow(calificaciones.get(i).getCalificacion() - promedioG, 2);
        }
        this.desviacionE = Math.sqrt(suma / calificaciones.size());
    }


}
