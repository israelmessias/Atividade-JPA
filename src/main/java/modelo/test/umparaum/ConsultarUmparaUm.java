package modelo.test.umparaum;
import modelo.Infra.DAO;
import modelo.UmparaUm.Assento;
import modelo.UmparaUm.Cliente;

public class ConsultarUmparaUm {
    public static void main(String[] args) {
        DAO<Cliente> dao = new DAO<>(Cliente.class);
        Cliente cliente = dao.ConsultId(1L);
        System.out.println(cliente.getAssento().getNome());

        dao.close();

        DAO<Assento> assentoDAO = new DAO<>(Assento.class);
         Assento assento = assentoDAO.ConsultId(2L);
        System.out.println(assento.getCliente().getNome());
    }
}
