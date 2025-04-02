package Controlador;

import Modelo.MisionDAO;
import Modelo.NinjaDAO;
import Vista.MisionVista;
import Vista.NinjaVista;

import java.sql.Date;
import java.util.Scanner;

public class KonohaControlador {
    private NinjaDAO ninjaDAO;
    private NinjaVista ninjaVista;
    private MisionDAO misionDAO;
    private MisionVista misionVista;
    private Scanner scanner;

    public KonohaControlador(NinjaDAO ninjaDAO, NinjaVista ninjaVista, MisionDAO misionDAO, MisionVista misionVista) {
        this.ninjaDAO = ninjaDAO;
        this.ninjaVista = ninjaVista;
        this.scanner = new Scanner(System.in);
        this.misionDAO = misionDAO;
        this.misionVista = misionVista;
    }

    public void iniciar() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("==== Menú manejo de mision de Konoha ====");
            System.out.println("1. Listar ninjas y sus habilidades");
            System.out.println("2. Mostrar misiones disponibles para un ninja en específico");
            System.out.println("3. Mostrar misiones completadas por un ninja en específico");
            System.out.println("4. Asignar mision a un ninja");
            System.out.println("5. Marcar mision como completada");
            System.out.println("6. Mostrar todas las misiones completadas");
            System.out.println("7. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ninjaVista.mostarNinjaHabilidades(ninjaDAO.ListarNinjasHabilidad());
                    break;
                case 2:
                    ninjaVista.listarNinjas(ninjaDAO.ListarNinjas());
                    System.out.println("Escoja el id del ninja del que desea ver las misiones disponibles");

                    int ninja = scanner.nextInt();
                    scanner.nextLine();
                    misionVista.mostrarMisionesNinja(misionDAO.ListarNinjaMision(ninja));
                    break;

                case 3:
                    ninjaVista.listarNinjas(ninjaDAO.ListarNinjas());
                    System.out.println("Escoja el id del ninja del que desea ver las misiones completadas");

                    int ninja2 = scanner.nextInt();
                    scanner.nextLine();
                    misionVista.mostrarMisiones(misionDAO.ListarMisionesCompletadas(ninja2));
                    break;

                case 4:
                    ninjaVista.listarNinjas(ninjaDAO.ListarNinjas());
                    System.out.println("Escoja el id del ninja al que va a asignar");
                    int ninja3 = scanner.nextInt();
                    scanner.nextLine();
                    misionVista.ListarMisiones(misionDAO.ListarMisiones());
                    System.out.println("Escoja el id de la mision que va a asignar");
                    int mision = scanner.nextInt();
                    System.out.println("Ingrese la fecha de inicio");
                    scanner.nextLine();
                    String fecha_inicio = scanner.nextLine();
                    misionVista.agregarMision(ninja3, mision, fecha_inicio);
                    break;

                case 5:
                    misionVista.ListarMisionesActivas(misionDAO.ListarMisionesActivas());
                    System.out.println("Seleccione la mision que desea finalizar");
                    int mision2 = scanner.nextInt();
                    System.out.println("ingrese la fecha de finalización");
                    String fecha_final = scanner.nextLine();
                    misionVista.FinalizarMision(mision2,fecha_final);
                    break;

                case 6:
                    break;

                case 7:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        }
    }
}
