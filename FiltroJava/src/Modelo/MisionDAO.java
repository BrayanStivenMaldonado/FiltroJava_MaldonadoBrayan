package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MisionDAO {
    //Atributos de la conexión
    private static String URL = "jdbc:mysql://byqqq9dje1cnepsizgxe-mysql.services.clever-cloud.com:3306/byqqq9dje1cnepsizgxe";
    private static String USER = "uijamght2hbkjaik";
    private static String PASSWORD = "UjF5dJPvZQ8dJqJNc5gA";

    static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    };

    //
    public List<String> ListarNinjaMision(int id_ninja) {
        String sql = "select * from mision m join ninja n on m.rango = n.rango where n.id = ?;";
        List<String> misiones = new ArrayList<>();
        try(Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)) {
            solicitud.setInt(1, id_ninja);
            try(ResultSet resultado = solicitud.executeQuery()) {
                while (resultado.next()) {
                    misiones.add("Mision ID: "+resultado.getString(1) + " = " + resultado.getString(2));
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return misiones;
    }

    public List<String> ListarMisionesCompletadas(int id_ninja) {
        String sql = "select m.id_mision, m.estado ,m.fecha_inicio, m.fecha_fin, mi.descripcion from misionNinja m  join mision mi on m.id_mision = mi.id where m.id_ninja = ?;";
        List<String> misiones = new ArrayList<>();
        try(Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)){
            solicitud.setInt(1, id_ninja);
            try(ResultSet resultado = solicitud.executeQuery()) {
                while (resultado.next()) {
                    if (resultado.getString(2).equals("finalizada")) {
                        misiones.add("Mision ID: "+resultado.getString(1) + " Fecha Inicio: "+resultado.getString(3) + " Fecha Fin: "+resultado.getString(4) + " Descripcion: "+resultado.getString(5) );
                    }
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return misiones;
    }

    public void insertarMision(MisionNinja mision) {
        String sql = "insert into misionNinja values(?,?,?,?,?);";
        try (Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)) {

            //Asignar valores a las incógnitas
            solicitud.setInt(1, mision.getId_ninja());
            solicitud.setInt(2, mision.getId_mision());
            solicitud.setString(3, "activa");
            solicitud.setString(4, null);
            solicitud.setString(5, mision.getFecha_fin());

            //Ejecución de la solicitud
            solicitud.executeUpdate();
            System.out.println("Mision agregada con exito");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> ListarMisiones(){
        String sql = "select  * from mision";
        List<String> misiones = new ArrayList<>();
        try(Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql); ResultSet resultado = solicitud.executeQuery()) {
            while (resultado.next()) {
                misiones.add(resultado.getString("id")+" - "+resultado.getString("descripcion"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return misiones;
    }

    public void ActualizarMision(String fecha_fin, int id_mision) {
        String sql = "update misionNinja set estado = ?, fecha_fin = ? where id_mision = ?";
        try(Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)){
            solicitud.setString(1,"finalizada");
            solicitud.setString(2,fecha_fin);
            solicitud.setInt(3,id_mision);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<String> ListarMisionesActivas() {
        String sql = "select m.id_mision, m.estado ,m.fecha_inicio, m.fecha_fin, mi.descripcion from misionNinja m  join mision mi on m.id_mision = mi.id";
        List<String> misiones = new ArrayList<>();
        try(Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)){
            try(ResultSet resultado = solicitud.executeQuery()) {
                while (resultado.next()) {
                    if (resultado.getString(2).equals("activa")) {
                        misiones.add("Mision ID: "+resultado.getString(1) + " Fecha Inicio: "+resultado.getString(3) + " Fecha Fin: "+resultado.getString(4) + " Descripcion: "+resultado.getString(5) );
                    }
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return misiones;
    }
}
