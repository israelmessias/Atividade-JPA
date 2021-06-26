package modelo.test.UmparaMuitos;
import modelo.Infra.DAO;
import modelo.UmParaMuitos.IntemPedido;
import modelo.UmParaMuitos.Pedido;
import modelo.basico.Produto;

public class NovoPedido {
    public static void main(String[] args) {
        DAO<Object> dao = new DAO<>();

        Produto produto = new Produto("Notebook", 3587.99);
        Pedido pedido = new Pedido();
        IntemPedido intem = new IntemPedido(produto, pedido, 10);

        dao.openTransi().input(produto).input(pedido).input(intem).closeTransi().close();
    }
}
