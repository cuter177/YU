package Clases;

import java.util.ArrayList;

public class ListaEstudiantes {

    private ArrayList<Estudiante> listaEstudiantes;

    public ListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        this.listaEstudiantes.add(estudiante);
    }
}
