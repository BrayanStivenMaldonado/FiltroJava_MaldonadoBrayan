package Vista;

import java.util.List;
import java.util.Scanner;

public class NinjaVista {
    Scanner sc = new Scanner(System.in);

    public void mostarNinjaHabilidades(List<String> ninjas) {
        System.out.println("========================================== Lista de ninjas ==========================================");
        for (String ninja : ninjas) {
            System.out.println(ninja);
        }
        System.out.println("\n\n");
    }

    public void listarNinjas(List<String> ninjas) {
        System.out.println("==== Ninjas Registrados ====");
        for (String ninja : ninjas) {
            System.out.println(ninja);
        }
    }
}
