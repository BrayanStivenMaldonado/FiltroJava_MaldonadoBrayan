package Modelo;

public class Ninja {
    private int Id;
    private String Nombre;
    private String Rango;
    private String Aldea;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getRango() {
        return Rango;
    }

    public void setRango(String rango) {
        Rango = rango;
    }

    public String getAldea() {
        return Aldea;
    }

    public void setAldea(String aldea) {
        Aldea = aldea;
    }

    @Override
    public String toString() {
        return "Ninja{" +
                "Id=" + Id +
                ", Nombre='" + Nombre + '\'' +
                ", Rango='" + Rango + '\'' +
                ", Aldea='" + Aldea + '\'' +
                '}';
    }
}
