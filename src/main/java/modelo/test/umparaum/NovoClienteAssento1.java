package modelo.test.umparaum;
import modelo.Infra.DAO;
import modelo.UmparaUm.Assento;
import modelo.UmparaUm.Cliente;

public class NovoClienteAssento1 {
    public static void main(String[] args) {
        Assento assento = new Assento("7b");
        Cliente cliente = new Cliente("Sandra", assento);

        DAO<Object> dao = new DAO<>();
        dao.openTransi().input(assento).input(cliente).closeTransi().close();
    }
}
