package Clases;

import java.util.ArrayList;
import java.util.List;

public class ListaEstudiantes {
    private List<Estudiante> listaEstudiantes;

    public ListaEstudiantes() {
        listaEstudiantes = new ArrayList<>();
    }

    public void setListaEstudiantes(List<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        listaEstudiantes.add(estudiante);
    }

    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }
}

