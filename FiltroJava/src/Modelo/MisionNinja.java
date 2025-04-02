package Modelo;

import java.sql.Date;

public class MisionNinja {
    private int Id_ninja;
    private int Id_mision;
    private String Estado;
    private String Fecha_inicio;
    private String Fecha_fin;

    public MisionNinja(int id_ninja, int id_mision, String fecha_inicio) {
        Id_ninja = id_ninja;
        Id_mision = id_mision;
        Fecha_inicio = fecha_inicio;
    }

    public int getId_ninja() {
        return Id_ninja;
    }

    public void setId_ninja(int id_ninja) {
        Id_ninja = id_ninja;
    }

    public int getId_mision() {
        return Id_mision;
    }

    public void setId_mision(int id_mision) {
        Id_mision = id_mision;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getFecha_inicio() {
        return Fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        Fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return Fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        Fecha_fin = fecha_fin;
    }
}
