package Clases;

public class Bandera {
    private boolean estado = true;

    public Bandera(boolean estado) {
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
