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

    public void eliminarCal(Estudiante est) {
        listaEstudiantes.remove(est);
    }

    public void actualizarEstudiante(Estudiante estudiante) {
        for(Estudiante aux:listaEstudiantes){

            if(aux.getMatricula().equals(estudiante.getMatricula())){

                aux.setNombre(estudiante.getNombre());
                aux.setEdad(estudiante.getEdad());



            }

        }
    }
}

