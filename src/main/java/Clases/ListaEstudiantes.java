package Clases;

import java.util.ArrayList;

public class ListaEstudiantes {

    private ArrayList<Estudiante> listaEstudiantes;

    public ListaEstudiantes() {
        listaEstudiantes = new ArrayList();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        this.listaEstudiantes.add(estudiante);
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }
}
