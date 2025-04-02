package Modelo;

import javax.swing.*;
import  java.sql.*;
import java.util.ArrayList;
import  java.util.List;

public class NinjaDAO {
    //Atributos de la conexión
    private static String URL = "jdbc:mysql://byqqq9dje1cnepsizgxe-mysql.services.clever-cloud.com:3306/byqqq9dje1cnepsizgxe";
    private static String USER = "uijamght2hbkjaik";
    private static String PASSWORD = "UjF5dJPvZQ8dJqJNc5gA";

    static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    };

    // Crear (Create)
    public void AgregarNinja(Ninja ninja) {
        String sql = "insert into ninja values(?,?,?,?)";
        try (Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)) {

            //Asignar valores a las incógnitas
            solicitud.setString(1, ninja.getNombre());
            solicitud.setString(2, ninja.getRango());
            solicitud.setString(3, ninja.getAldea());

            //Ejecución de la solicitud
            solicitud.executeUpdate();
            System.out.println("Ninja agregada con exito");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> ListarNinjasHabilidad() {
        String sql = "select  n.nombre as ninja, h.nombre as habilidad, h.descripcion from habilidad h join ninja n on h.id_ninja = n.id";
        List<String> ninjas = new ArrayList<>();
        try(Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql); ResultSet resultado = solicitud.executeQuery()) {
            while (resultado.next()) {
                ninjas.add(resultado.getString("ninja")+" - "+resultado.getString("habilidad")+": "+resultado.getString("descripcion"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return ninjas;
    }

    public List<String> ListarNinjas(){
        String sql = "select  * from ninja";
        List<String> ninjas = new ArrayList<>();
        try(Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql); ResultSet resultado = solicitud.executeQuery()) {
            while (resultado.next()) {
                ninjas.add(resultado.getString("id")+" - "+resultado.getString("nombre"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return ninjas;
    }

}
