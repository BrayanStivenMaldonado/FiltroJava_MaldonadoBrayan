package Modelo;

public class Mision {
    private int Id;
    private String Descripcion;
    private String Rango;
    private double Recompensa;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getRango() {
        return Rango;
    }

    public void setRango(String rango) {
        Rango = rango;
    }

    public double getRecompensa() {
        return Recompensa;
    }

    public void setRecompensa(double recompensa) {
        Recompensa = recompensa;
    }

    @Override
    public String toString() {
        return "Mision{" +
                "Id=" + Id +
                ", Descripcion='" + Descripcion + '\'' +
                ", Rango='" + Rango + '\'' +
                ", Recompensa=" + Recompensa +
                '}';
    }
}
