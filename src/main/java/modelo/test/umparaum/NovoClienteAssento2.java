package modelo.test.umparaum;

import modelo.Infra.DAO;
import modelo.UmparaUm.Assento;
import modelo.UmparaUm.Cliente;

public class NovoClienteAssento2 {
    public static void main(String[] args) {
        Assento assento  = new Assento("8A");
        Cliente cliente = new Cliente("Samuel Tino", assento);

        DAO<Cliente> dao = new DAO<>(Cliente.class);
        dao.inputAtomic(cliente);
    }
}
