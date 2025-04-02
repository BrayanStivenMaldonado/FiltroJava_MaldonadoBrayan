package Vista;

import Modelo.MisionNinja;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MisionVista {
    Scanner sc = new Scanner(System.in);

    public void mostrarMisionesNinja(List<String> misiones) {
        System.out.println("========================================== Lista de misiones ==========================================");
        for (String mision : misiones) {
            System.out.println(mision);
        }
        System.out.println("\n\n");
    }

    public void mostrarMisiones(List<String> misiones) {
        System.out.println("===== Misiones Completadas =====");
        for (String mision : misiones) {
            System.out.println(mision);
        }
        System.out.println("\n\n");
    }

    public void ListarMisiones(List<String> misiones) {
        System.out.println("==== Misiones Disponibles =====");
        for (String mision : misiones) {
            System.out.println(mision);
        }
    }

    public void agregarMision(int id_ninja, int id_mision, String fecha_inicio) {
        MisionNinja misionNinja = new MisionNinja(
                id_ninja,
                id_mision,
                fecha_inicio
        );
    }

    public void ListarMisionesActivas(List<String> misiones) {
        System.out.println("==== Misiones Activas =====");
        for (String mision : misiones) {
            System.out.println(mision);
        }
    }

    public void FinalizarMision(int id_mision, String fecha_fin) {
    }
}
