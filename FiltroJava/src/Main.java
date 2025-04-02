import Controlador.KonohaControlador;
import Modelo.MisionDAO;
import Modelo.NinjaDAO;
import Vista.MisionVista;
import Vista.NinjaVista;

public class Main {
    public static void main(String[] args) {
        NinjaDAO ninjaDAO = new NinjaDAO();
        NinjaVista ninjaVista = new NinjaVista();
        MisionDAO misionDAO = new MisionDAO();
        MisionVista misionVista = new MisionVista();
        KonohaControlador konohaControlador = new KonohaControlador(ninjaDAO, ninjaVista,  misionDAO, misionVista);

        konohaControlador.iniciar();

    }
}