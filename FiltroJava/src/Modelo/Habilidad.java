package Modelo;

public class Habilidad {
    private int Id_ninja;
    private String Nombre;
    private String Descripcion;

    public int getId_ninja() {
        return Id_ninja;
    }

    public void setId_ninja(int id_ninja) {
        Id_ninja = id_ninja;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Habilidad{" +
                "Id_ninja=" + Id_ninja +
                ", Nombre='" + Nombre + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                '}';
    }
}
